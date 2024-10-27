package com.mhk.eosb_validation_error_handling.company.management.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.InvalidRequestDataException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordAlreadyExistsException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordNotFoundException;
import com.mhk.eosb_validation_error_handling.company.management.mapper.CompanyMapper;
import com.mhk.eosb_validation_error_handling.company.management.repository.CompanyRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyManagementService implements ICompanyManagementService {
private final CompanyRepository companyRepository;
private static final String PHONE_NUMBER_VALID_REGEX = "[0-9]+";
private final CompanyMapper companyMapper;

    @Override
    public CompanyDetailsResponse saveCompanyDetails(final CompanyDetailsRequest companyDetailsRequest) {
        validateRequest(companyDetailsRequest);
        if (StringUtils.isNotEmpty(companyDetailsRequest.getContactMobile()) &&
                !isValidPhoneNumber(companyDetailsRequest.getContactMobile(), PHONE_NUMBER_VALID_REGEX)) {
            throw new InvalidRequestDataException(ResponseMessage.INVALID_PHONE_NUMBER);
        }
        Optional<Company> company =
                companyRepository.findByCompanyName(companyDetailsRequest.getCompanyName());
        if (company.isPresent()) {
            throw new RecordAlreadyExistsException(ResponseMessage.RECORD_ALREADY_EXIST);
        }
        final Company company1 = companyMapper.mapDtoToEntity(companyDetailsRequest);

        saveCompany(company1);
        final CompanyDetailsResponse companyDetailsResponse = companyMapper.mapEntityToResponse(company1);

        return companyDetailsResponse;
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
    public void saveCompany(final Company company) {
        companyRepository.save(company);
    }

    @Override
    public CompanyDetailsResponse editCompanyDetails(CompanyDetailsRequest companyDetailsRequest) {

        Optional<Company> company =
                companyRepository.findByCompanyName(companyDetailsRequest.getCompanyName());
        if (company.isEmpty())
            throw new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND);

        final Company company1 = company.get();

        editCompany(company1,companyDetailsRequest);
        final CompanyDetailsResponse companyDetailsResponse = companyMapper.mapEntityToResponse(company1);
        return companyDetailsResponse;
    }

    @Transactional
    public void editCompany(Company company, CompanyDetailsRequest companyDetailsRequest) {
        company.setCompanyName(companyDetailsRequest.getCompanyName());
        company.setAddress(companyDetailsRequest.getAddress());
        company.setContactPerson(companyDetailsRequest.getContactPerson());
        company.setContactMobile(companyDetailsRequest.getContactMobile());
        company.setEmailAddress(companyDetailsRequest.getEmailAddress());
        company.setBillingNumber(companyDetailsRequest.getBillingNumber());
        company.setBillingAmount(companyDetailsRequest.getBillingAmount());
        company.setDailyAmount(companyDetailsRequest.getDailyAmount());
        company.setIsEnableCharging(companyDetailsRequest.getIsEnableCharging());
        company.setLogo(companyDetailsRequest.getLogo());
        company.setRemarks(companyDetailsRequest.getRemarks());
        companyRepository.save(company);
    }
}
