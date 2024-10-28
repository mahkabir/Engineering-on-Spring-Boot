package com.mhk.eosb_validation_error_handling.department.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.department.service.IDepartmentManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/Department-management")
@RequiredArgsConstructor
public class DepartmentResource {
    private final IDepartmentManagementService iDepartmentManagementService;

    @PostMapping("/save-Department")
    public ApiResponse<CompanyDetailsResponse> saveDepartment(@Valid @RequestBody CompanyDetailsRequest companyDetailsRequest) {
        final CompanyDetailsResponse response = iDepartmentManagementService.saveDepartmentDetails(companyDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @PostMapping("/edit-Department")
    public ApiResponse<CompanyDetailsResponse> editDepartmenty(@Valid @RequestBody CompanyDetailsRequest companyDetailsRequest) {
        final CompanyDetailsResponse response = iDepartmentManagementService.editDepartmentDetails(companyDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/Department-details/all")
    public ApiResponse<PaginationResponse<CompanyDetailsResponse>> getAllDepartmentDetails(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                             @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                                             @RequestParam(required = false, defaultValue = "desc") String sortOrder,
                                                                                             @RequestParam(required = false) String companyName,
                                                                                             @RequestParam(required = false) String contactMobile) {

        final PaginationResponse<CompanyDetailsResponse> response =
                iDepartmentManagementService.getAllDepartments(pageNumber, pageSize, sortBy, sortOrder, companyName, contactMobile);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

}
