package com.mhk.eosb_validation_error_handling.department.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;

public interface IDepartmentManagementService {

    CompanyDetailsResponse saveDepartmentDetails(CompanyDetailsRequest companyDetailsRequest);
    CompanyDetailsResponse editDepartmentDetails(CompanyDetailsRequest companyDetailsRequest);
    PaginationResponse<CompanyDetailsResponse> getAllDepartments(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String companyName,
                                                                      String contactMobile);



}
