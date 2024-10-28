package com.mhk.eosb_validation_error_handling.department.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.PageUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.PaginationRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.InvalidRequestDataException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordAlreadyExistsException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordNotFoundException;
import com.mhk.eosb_validation_error_handling.company.management.mapper.CompanyMapper;
import com.mhk.eosb_validation_error_handling.company.management.repository.CompanyRepository;
import com.mhk.eosb_validation_error_handling.department.entity.Department;
import com.mhk.eosb_validation_error_handling.department.mapper.DepartmentMapper;
import com.mhk.eosb_validation_error_handling.department.repo.DepartmentRepository;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentManagementService implements IDepartmentManagementService {
private final CompanyRepository companyRepository;
private final DepartmentRepository departmentRepository;
private static final String PHONE_NUMBER_VALID_REGEX = "[0-9]+";
private final DepartmentMapper departmentMapper;
private final CompanyMapper companyMapper;

    @Override
    public DepartmentDetailsResponse saveDepartmentDetails(final DepartmentDetailsRequest departmentDetailsRequest) {
        validateRequest(departmentDetailsRequest);
        Optional<Department> departmentOptional =
                departmentRepository.findByDepartmentName(departmentDetailsRequest.getDepartmentName());
        if (departmentOptional.isPresent()) {
            throw new RecordAlreadyExistsException(ResponseMessage.RECORD_ALREADY_EXIST);
        }
        final Department department = departmentMapper.mapDtoToEntity(departmentDetailsRequest);

        saveDepartment(department);
        final DepartmentDetailsResponse departmentDetailsResponse = departmentMapper.mapEntityToResponse(department);

        return departmentDetailsResponse;
    }

    private <T> void validateRequest(final T request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestDataException(ResponseMessage.INVALID_REQUEST_DATA);
        }
    }

    public boolean isValidPhoneNumber(final String phoneNo, final String mobileRegex) {
        return phoneNo.matches(mobileRegex) && phoneNo.length() > 8 && phoneNo.length() <= 14;
    }

    @Transactional
    public void saveDepartment(final Department department) {
        department.setCreatedBy("Abc");
        department.setCreatedDate(getCurrentDate());
        departmentRepository.save(department);
    }

    @Override
    public DepartmentDetailsResponse editDepartmentDetails(DepartmentDetailsRequest departmentDetailsRequest) {

        Optional<Department> departmentOptional =
                departmentRepository.findByDepartmentName(departmentDetailsRequest.getDepartmentName());
        if (departmentOptional.isEmpty())
            throw new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND);

        final Department department = departmentOptional.get();

        editDepartment(department,departmentDetailsRequest);
        final DepartmentDetailsResponse departmentDetailsResponse = departmentMapper.mapEntityToResponse(department);
        return departmentDetailsResponse;
    }

    @Transactional
    public void editDepartment(Department department, DepartmentDetailsRequest departmentDetailsRequest) {
        department.setDepartmentName(departmentDetailsRequest.getDepartmentName());
        department.setCompanyId(departmentDetailsRequest.getCompanyId());
        department.setCompanyName(departmentDetailsRequest.getCompanyName());
        department.setParentId(departmentDetailsRequest.getParentId());
        department.setDeptHeadUserId(departmentDetailsRequest.getDeptHeadUserId());
        department.setDeptHeadEmployeeId(departmentDetailsRequest.getDeptHeadEmployeeId());
        department.setDeptHeadCategoryId(departmentDetailsRequest.getDeptHeadCategoryId());
        department.setDeptHeadCategoryName(departmentDetailsRequest.getDeptHeadCategoryName());
        department.setRemarks(departmentDetailsRequest.getRemarks());
        department.setUpdatedBy("Def");
        department.setUpdatedDate(getCurrentDate());
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public PaginationResponse<CompanyDetailsResponse> getAllDepartments(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String companyName, String contactMobile) {
        final PaginationRequest paginationRequest = PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder);
        final Pageable pageable = PageUtils.getPageable(paginationRequest);

        /*final String startDate = Objects.isNull(fromDate) ? null :
                DateTimeUtils.formatDate(fromDate, "yyyy-MM-dd");
        final String endDate = Objects.isNull(toDate) ? null :
                DateTimeUtils.formatDate(DateTimeUtils.addDay(toDate, 1), "yyyy-MM-dd");*/

        final Page<CompanyDetailsResponse> page = companyRepository.findAllByParam(
                        StringUtils.isEmpty(companyName) ? null : companyName,
                        StringUtils.isEmpty(contactMobile) ? null : contactMobile,
                        pageable
                )
                .map(companyDetails -> {
                    final CompanyDetailsResponse companyDetailsResponse = companyMapper.mapEntityToResponse(companyDetails);
                   /* final String iconPath = fileServerService.getImageFullPathWithoutTimeToken(transactionFeatureResponse.getTransactionFeatureIcon());
                    transactionFeatureResponse.setTransactionFeatureIcon(iconPath);*/
                    return companyDetailsResponse;
                });

        return page.getContent().isEmpty() ?
                PageUtils.mapToPaginationResponseDto(Page.empty(), paginationRequest) :
                PageUtils.mapToPaginationResponseDto(page, paginationRequest);
    }
    public Date getCurrentDate() {
        return new Date();
    }
}
