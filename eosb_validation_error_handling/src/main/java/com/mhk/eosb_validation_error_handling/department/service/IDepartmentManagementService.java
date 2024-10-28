package com.mhk.eosb_validation_error_handling.department.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;

public interface IDepartmentManagementService {

    DepartmentDetailsResponse saveDepartmentDetails(DepartmentDetailsRequest departmentDetailsRequest);
    DepartmentDetailsResponse editDepartmentDetails(DepartmentDetailsRequest departmentDetailsRequest);
    PaginationResponse<CompanyDetailsResponse> getAllDepartments(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String companyName,
                                                                      String contactMobile);



}
