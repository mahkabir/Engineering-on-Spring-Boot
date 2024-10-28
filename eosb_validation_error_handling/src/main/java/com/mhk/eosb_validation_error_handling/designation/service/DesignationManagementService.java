package com.mhk.eosb_validation_error_handling.designation.service;

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
import com.mhk.eosb_validation_error_handling.designation.entity.Designation;
import com.mhk.eosb_validation_error_handling.designation.mapper.DesignationMapper;
import com.mhk.eosb_validation_error_handling.designation.repo.DesignationRepository;
import com.mhk.eosb_validation_error_handling.designation.request.DesignationDetailsRequest;
import com.mhk.eosb_validation_error_handling.designation.response.DesignationDetailsResponse;
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
public class DesignationManagementService implements IDesignationManagementService {
private final CompanyRepository companyRepository;
private final DesignationRepository designationRepository;
private static final String PHONE_NUMBER_VALID_REGEX = "[0-9]+";
private final CompanyMapper companyMapper;
private final DesignationMapper designationMapper;

    @Override
    public DesignationDetailsResponse saveDesignationDetails(final DesignationDetailsRequest designationDetailsRequest) {
        validateRequest(designationDetailsRequest);
        Optional<Designation> designationOptional =
                designationRepository.findByDesignationName(designationDetailsRequest.getDesignationName());
        if (designationOptional.isPresent()) {
            throw new RecordAlreadyExistsException(ResponseMessage.RECORD_ALREADY_EXIST);
        }
        final Designation designation = designationMapper.mapDtoToEntity(designationDetailsRequest);

        saveDesignation(designation);
        final DesignationDetailsResponse designationDetailsResponse = designationMapper.mapEntityToResponse(designation);

        return designationDetailsResponse;
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
    public void saveDesignation(final Designation designation) {
        designation.setCreatedBy("Abc");
        designation.setCreatedDate(getCurrentDate());
        designationRepository.save(designation);
    }

    @Override
    public DesignationDetailsResponse editDesignationDetails(DesignationDetailsRequest designationDetailsRequest) {

        Optional<Designation> designationOptional =
                designationRepository.findByDesignationName(designationDetailsRequest.getDesignationName());
        if (designationOptional.isEmpty())
            throw new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND);

        final Designation designation = designationOptional.get();

        editDesignation(designation,designationDetailsRequest);
        final DesignationDetailsResponse designationDetailsResponse = designationMapper.mapEntityToResponse(designation);
        return designationDetailsResponse;
    }

    @Transactional
    public void editDesignation(Designation designation, DesignationDetailsRequest designationDetailsRequest) {
        designation.setDesignationName(designationDetailsRequest.getDesignationName());
        designation.setCompanyId(designationDetailsRequest.getCompanyId());
        designation.setCompanyName(designationDetailsRequest.getCompanyName());
        designation.setRemarks(designationDetailsRequest.getRemarks());
        designation.setUpdatedBy("Def");
        designation.setUpdatedDate(getCurrentDate());
        designationRepository.save(designation);
    }

    @Override
    @Transactional
    public PaginationResponse<CompanyDetailsResponse> getAllDesignations(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String companyName, String contactMobile) {
        final PaginationRequest paginationRequest = PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder);
        final Pageable pageable = PageUtils.getPageable(paginationRequest);

        /*final String startDate = Objects.isNull(fromDate) ? null :
                DateTimeUtils.formatDate(fromDate, "yyyy-MM-dd");
        final String endDate = Objects.isNull(toDate) ? null :
                DateTimeUtils.formatDate(DateTimeUtils.addDay(toDate, 1), "yyyy-MM-dd");*/

        /*final Page<CompanyDetailsResponse> page = companyRepository.findAllByParam(
                        StringUtils.isEmpty(companyName) ? null : companyName,
                        StringUtils.isEmpty(contactMobile) ? null : contactMobile,
                        pageable
                )
                .map(companyDetails -> {
                    final CompanyDetailsResponse companyDetailsResponse = companyMapper.mapEntityToResponse(companyDetails);
                   *//* final String iconPath = fileServerService.getImageFullPathWithoutTimeToken(transactionFeatureResponse.getTransactionFeatureIcon());
                    transactionFeatureResponse.setTransactionFeatureIcon(iconPath);*//*
                    return companyDetailsResponse;
                });

        return page.getContent().isEmpty() ?
                PageUtils.mapToPaginationResponseDto(Page.empty(), paginationRequest) :
                PageUtils.mapToPaginationResponseDto(page, paginationRequest);*/
        return null;
    }

    public Date getCurrentDate() {
        return new Date();
    }
}
