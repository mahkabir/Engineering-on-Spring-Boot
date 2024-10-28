package com.mhk.eosb_validation_error_handling.company.management.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;

import java.util.Date;

public interface ICompanyManagementService {

    CompanyDetailsResponse saveCompanyDetails(CompanyDetailsRequest companyDetailsRequest);
    CompanyDetailsResponse editCompanyDetails(CompanyDetailsRequest companyDetailsRequest);
    PaginationResponse<CompanyDetailsResponse> getAllCompanies(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String companyName,
                                                                      String contactMobile,
                                                                      Date fromDate,
                                                                      Date toDate );



}
