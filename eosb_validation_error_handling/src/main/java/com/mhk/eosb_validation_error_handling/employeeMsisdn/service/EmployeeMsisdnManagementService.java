package com.mhk.eosb_validation_error_handling.employeeMsisdn.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.DateTimeUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.PageUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.PaginationRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.InvalidRequestDataException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordAlreadyExistsException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordNotFoundException;
import com.mhk.eosb_validation_error_handling.company.management.mapper.CompanyMapper;
import com.mhk.eosb_validation_error_handling.company.management.repository.CompanyRepository;
import com.mhk.eosb_validation_error_handling.department.mapper.DepartmentMapper;
import com.mhk.eosb_validation_error_handling.department.repo.DepartmentRepository;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.entity.EmployeeMsisdn;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.mapper.EmployeeMsisdnMapper;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.repo.EmployeeMsisdnRepository;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.request.EmployeeMsisdnDetailsRequest;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.mapper.UserMapper;
import com.mhk.eosb_validation_error_handling.user.repo.UserRepository;
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
public class EmployeeMsisdnManagementService implements IEmployeeMsisdnManagementService {
private final CompanyRepository companyRepository;
private final DepartmentRepository departmentRepository;
private static final String PHONE_NUMBER_VALID_REGEX = "[0-9]+";
private final DepartmentMapper departmentMapper;
private final CompanyMapper companyMapper;
private final UserMapper userMapper;
private final UserRepository userRepository;
private final EmployeeMsisdnRepository employeeMsisdnRepository;
    private final EmployeeMsisdnMapper employeeMsisdnMapper;

    @Override
    public EmployeeMsisdnDetailsResponse saveMsisdnDetails(final EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest) {
        validateRequest(employeeMsisdnDetailsRequest);
        Optional<EmployeeMsisdn> employeeMsisdnOptional =
                employeeMsisdnRepository.findByuserName(employeeMsisdnDetailsRequest.getUserName());
        if (employeeMsisdnOptional.isPresent()) {
            throw new RecordAlreadyExistsException(ResponseMessage.RECORD_ALREADY_EXIST);
        }
        final EmployeeMsisdn employeeMsisdn = employeeMsisdnMapper.mapDtoToEntity(employeeMsisdnDetailsRequest);

        saveMsisdn(employeeMsisdn);
        final EmployeeMsisdnDetailsResponse employeeMsisdnDetailsResponse = employeeMsisdnMapper.mapEntityToResponse(employeeMsisdn);

        return employeeMsisdnDetailsResponse;
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
    public void saveMsisdn(final EmployeeMsisdn employeeMsisdn) {
        employeeMsisdn.setCreatedBy("Abc");
        employeeMsisdn.setCreatedDate(getCurrentDate());
        employeeMsisdnRepository.save(employeeMsisdn);
    }

    @Override
    public EmployeeMsisdnDetailsResponse editMsisdnDetails(EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest) {

        Optional<EmployeeMsisdn> employeeMsisdnOptional =
                employeeMsisdnRepository.findByuserName(employeeMsisdnDetailsRequest.getUserName());
        if (employeeMsisdnOptional.isEmpty())
            throw new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND);

        final EmployeeMsisdn employeeMsisdn = employeeMsisdnOptional.get();

        editUser(employeeMsisdn,employeeMsisdnDetailsRequest);
        final EmployeeMsisdnDetailsResponse employeeMsisdnDetailsResponse = employeeMsisdnMapper.mapEntityToResponse(employeeMsisdn);
        return employeeMsisdnDetailsResponse;
    }

    @Transactional
    public void editUser(EmployeeMsisdn employeeMsisdn, EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest) {
        employeeMsisdn.setUserName(employeeMsisdnDetailsRequest.getUserName());
        employeeMsisdn.setEmployeeId(employeeMsisdnDetailsRequest.getEmployeeId());
        employeeMsisdn.setUserFullName(employeeMsisdnDetailsRequest.getUserFullName());
        employeeMsisdn.setMsisdn(employeeMsisdnDetailsRequest.getMsisdn());
        employeeMsisdn.setContactNo(employeeMsisdnDetailsRequest.getContactNo());
        employeeMsisdn.setMailId(employeeMsisdnDetailsRequest.getMailId());
        employeeMsisdn.setDepartmentId(employeeMsisdnDetailsRequest.getDepartmentId());
        employeeMsisdn.setDepartmentName(employeeMsisdnDetailsRequest.getDepartmentName());
        employeeMsisdn.setDesignationId(employeeMsisdnDetailsRequest.getDesignationId());
        employeeMsisdn.setDesignationName(employeeMsisdnDetailsRequest.getDesignationName());
        employeeMsisdn.setUserIsLock(employeeMsisdnDetailsRequest.getUserIsLock());
        employeeMsisdn.setIsRobiEmployee(employeeMsisdnDetailsRequest.getIsRobiEmployee());
        employeeMsisdn.setUserCreatedById(employeeMsisdnDetailsRequest.getUserCreatedById());
        employeeMsisdn.setIsNew(employeeMsisdnDetailsRequest.getIsNew());
        employeeMsisdn.setLoginCount(employeeMsisdnDetailsRequest.getLoginCount());
        employeeMsisdn.setUserEditedById(employeeMsisdnDetailsRequest.getUserEditedById());
        employeeMsisdn.setCompanyId(employeeMsisdnDetailsRequest.getCompanyId());
        employeeMsisdn.setCompanyName(employeeMsisdnDetailsRequest.getCompanyName());
        employeeMsisdn.setAddress(employeeMsisdnDetailsRequest.getAddress());
        employeeMsisdn.setComments(employeeMsisdnDetailsRequest.getComments());
        employeeMsisdn.setCanLogin(employeeMsisdnDetailsRequest.getCanLogin());
        employeeMsisdn.setTrackingEnable(employeeMsisdnDetailsRequest.getTrackingEnable());
        employeeMsisdn.setIsSuperAdmin(employeeMsisdnDetailsRequest.getIsSuperAdmin());
        employeeMsisdn.setFkSessionId(employeeMsisdnDetailsRequest.getFkSessionId());
        employeeMsisdn.setFkLoginTime(employeeMsisdnDetailsRequest.getFkLoginTime());
        employeeMsisdn.setLastPasswordChangeTime(employeeMsisdnDetailsRequest.getLastPasswordChangeTime());
        employeeMsisdn.setAreaId(employeeMsisdnDetailsRequest.getAreaId());
        employeeMsisdn.setAreaName(employeeMsisdnDetailsRequest.getAreaName());
        employeeMsisdn.setGroupName(employeeMsisdnDetailsRequest.getGroupName());
        employeeMsisdn.setIsEnableCharging(employeeMsisdnDetailsRequest.getIsEnableCharging());
        employeeMsisdn.setDisabledTrackingDate(employeeMsisdnDetailsRequest.getDisabledTrackingDate());
        employeeMsisdn.setUpdatedBy("Def");
        employeeMsisdn.setUpdatedDate(getCurrentDate());
        employeeMsisdnRepository.save(employeeMsisdn);
    }

    @Override
    @Transactional
    public PaginationResponse<EmployeeMsisdnDetailsResponse> getAllMsisdns(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String userName, String companyName, Date fromDate, Date toDate) {

        return getMsisdnDetailsPaginationResponse(pageNumber, pageSize, sortBy, sortOrder,userName, companyName, fromDate, toDate);

    }

    private PaginationResponse<EmployeeMsisdnDetailsResponse> getMsisdnDetailsPaginationResponse(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String userName, String companyName, Date fromDate, Date toDate) {

        PaginationRequest paginationRequest = PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder);
        Pageable pageable = PageUtils.getPageable(paginationRequest);

        String startDate = Objects.isNull(fromDate) ? null : DateTimeUtils.formatDate(fromDate, "yyyy-MM-dd");
        String endDate = Objects.isNull(toDate) ? null : DateTimeUtils.formatDate(DateTimeUtils.addDay(toDate, 1),
                "yyyy-MM-dd");

        Page<EmployeeMsisdnDetailsResponse> page = employeeMsisdnRepository.findAllByParam(userName, companyName, pageable);

        //List<CompanyDetailsResponse> transactionHistoryList = page.getContent();

        return page.getContent().isEmpty() ? PageUtils.mapToPaginationResponseDto(Page.empty(), paginationRequest) :
                PageUtils.mapToPaginationResponseDto(page, paginationRequest);

    }
    @Override
    public EmployeeMsisdnDetailsResponse getMsisdnDetails(Long Id) {
        EmployeeMsisdn employeeMsisdn = employeeMsisdnRepository.findById(Id)
                .orElseThrow( ()-> new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND) );
        return employeeMsisdnMapper.mapEntityToResponse(employeeMsisdn);
    }

    public Date getCurrentDate() {
        return new Date();
    }

}
