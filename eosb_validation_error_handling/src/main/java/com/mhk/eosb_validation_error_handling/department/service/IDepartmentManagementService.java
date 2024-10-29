package com.mhk.eosb_validation_error_handling.department.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;

import java.util.Date;

public interface IDepartmentManagementService {

    DepartmentDetailsResponse saveDepartmentDetails(DepartmentDetailsRequest departmentDetailsRequest);
    DepartmentDetailsResponse editDepartmentDetails(DepartmentDetailsRequest departmentDetailsRequest);
    PaginationResponse<DepartmentDetailsResponse> getAllDepartments(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String departmentName,
                                                                      String companyName,
                                                                      Date fromDate,
                                                                      Date toDate);
    DepartmentDetailsResponse getDepartmentDetails(Long departmentId);



}
