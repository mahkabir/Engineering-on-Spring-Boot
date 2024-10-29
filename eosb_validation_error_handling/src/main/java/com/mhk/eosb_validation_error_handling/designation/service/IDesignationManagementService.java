package com.mhk.eosb_validation_error_handling.designation.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.designation.request.DesignationDetailsRequest;
import com.mhk.eosb_validation_error_handling.designation.response.DesignationDetailsResponse;

public interface IDesignationManagementService {

    DesignationDetailsResponse saveDesignationDetails(DesignationDetailsRequest designationDetailsRequest);
    DesignationDetailsResponse editDesignationDetails(DesignationDetailsRequest designationDetailsRequest);
    PaginationResponse<CompanyDetailsResponse> getAllDesignations(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String companyName,
                                                                      String contactMobile);
    DesignationDetailsResponse getDesignationDetails(Long designationId);



}
