package com.mhk.eosb_validation_error_handling.company.management.mapper;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    default CompanyDetailsResponse mapEntityToResponse(final Company company) {
        CompanyDetailsResponse companyDetailsResponse = new CompanyDetailsResponse();
        companyDetailsResponse.setCompanyName(company.getCompanyName());
        companyDetailsResponse.setAddress(company.getAddress());
        companyDetailsResponse.setContactPerson(company.getContactPerson());
        companyDetailsResponse.setContactMobile(company.getContactMobile());
        companyDetailsResponse.setEmailAddress(company.getEmailAddress());
        companyDetailsResponse.setBillingNumber(company.getBillingNumber());
        companyDetailsResponse.setBillingAmount(company.getBillingAmount());
        companyDetailsResponse.setDailyAmount(company.getDailyAmount());
        companyDetailsResponse.setIsEnableCharging(company.getIsEnableCharging());
        companyDetailsResponse.setLogo(company.getLogo());
        companyDetailsResponse.setRemarks(company.getRemarks());
        return companyDetailsResponse;
    }

    Company mapDtoToEntity(final CompanyDetailsRequest companyDetailsRequest);

}
