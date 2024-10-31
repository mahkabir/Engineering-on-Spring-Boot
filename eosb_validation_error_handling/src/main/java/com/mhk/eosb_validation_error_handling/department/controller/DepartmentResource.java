package com.mhk.eosb_validation_error_handling.department.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import com.mhk.eosb_validation_error_handling.department.service.IDepartmentManagementService;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/department-management")
@RequiredArgsConstructor
public class DepartmentResource {
    private final IDepartmentManagementService iDepartmentManagementService;

    @PostMapping("/save-department")
    public ApiResponse<DepartmentDetailsResponse> saveDepartment(@Valid @RequestBody DepartmentDetailsRequest departmentDetailsRequest) {
        final DepartmentDetailsResponse response = iDepartmentManagementService.saveDepartmentDetails(departmentDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @PostMapping("/edit-department")
    public ApiResponse<DepartmentDetailsResponse> editDepartment(@Valid @RequestBody DepartmentDetailsRequest departmentDetailsRequest) {
        final DepartmentDetailsResponse response = iDepartmentManagementService.editDepartmentDetails(departmentDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/department-details/all")
    public ApiResponse<PaginationResponse<DepartmentDetailsResponse>> getAllDepartmentDetails(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                             @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                                             @RequestParam(required = false, defaultValue = "desc") String sortOrder,
                                                                                             @RequestParam(required = false) String departmentName,
                                                                                             @RequestParam(required = false) String companyName,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

        final PaginationResponse<DepartmentDetailsResponse> response =
                iDepartmentManagementService.getAllDepartments(pageNumber, pageSize, sortBy, sortOrder, departmentName, companyName, fromDate, toDate);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/department-details/{departmentId}")
    public ApiResponse<DepartmentDetailsResponse> getDepartmentDetailsById(@PathVariable Long departmentId) {
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL),
                iDepartmentManagementService.getDepartmentDetails(departmentId));
    }

    @PostMapping(value = "/save-department/bulk", consumes = "multipart/form-data")
    public ApiResponse<List<EmployeeMsisdnDetailsResponse>> saveDepartmentBulk(@RequestParam("file") MultipartFile file) {
        List<EmployeeMsisdnDetailsResponse> responses = iDepartmentManagementService.saveDepartmentDetailsBulk(file);
        return ResponseUtils.createResponseObject(ResponseMessage.OPERATION_SUCCESSFUL,responses);
    }

}
