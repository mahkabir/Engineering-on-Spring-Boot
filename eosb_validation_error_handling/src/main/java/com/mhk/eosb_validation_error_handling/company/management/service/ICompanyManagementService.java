package com.mhk.eosb_validation_error_handling.company.management.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;

public interface ICompanyManagementService {

    CompanyDetailsResponse saveCompanyDetails(CompanyDetailsRequest companyDetailsRequest);
    CompanyDetailsResponse editCompanyDetails(CompanyDetailsRequest companyDetailsRequest);


}
