package com.mhk.eosb_validation_error_handling.designation.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;

public interface IDesignationManagementService {

    CompanyDetailsResponse saveDesignationDetails(CompanyDetailsRequest companyDetailsRequest);
    CompanyDetailsResponse editDesignationDetails(CompanyDetailsRequest companyDetailsRequest);
    PaginationResponse<CompanyDetailsResponse> getAllDesignations(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String companyName,
                                                                      String contactMobile);



}
