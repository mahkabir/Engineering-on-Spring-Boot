package com.mhk.eosb_validation_error_handling.department.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

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
    List<EmployeeMsisdnDetailsResponse> saveDepartmentDetailsBulk(MultipartFile file);




}
