package com.mhk.eosb_validation_error_handling.designation.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.designation.request.DesignationDetailsRequest;
import com.mhk.eosb_validation_error_handling.designation.response.DesignationDetailsResponse;
import com.mhk.eosb_validation_error_handling.designation.service.IDesignationManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/designation-management")
@RequiredArgsConstructor
public class DesignationResource {
    private final IDesignationManagementService iDesignationManagementService;

    @PostMapping("/save-designation")
    public ApiResponse<DesignationDetailsResponse> saveDesignation(@Valid @RequestBody DesignationDetailsRequest designationDetailsRequest) {
        final DesignationDetailsResponse response = iDesignationManagementService.saveDesignationDetails(designationDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @PostMapping("/edit-designation")
    public ApiResponse<DesignationDetailsResponse> editDesignation(@Valid @RequestBody DesignationDetailsRequest designationDetailsRequest) {
        final DesignationDetailsResponse response = iDesignationManagementService.editDesignationDetails(designationDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/designation-details/all")
    public ApiResponse<PaginationResponse<CompanyDetailsResponse>> getAllDesignationDetails(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                             @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                                             @RequestParam(required = false, defaultValue = "desc") String sortOrder,
                                                                                             @RequestParam(required = false) String companyName,
                                                                                             @RequestParam(required = false) String contactMobile) {

        final PaginationResponse<CompanyDetailsResponse> response =
                iDesignationManagementService.getAllDesignations(pageNumber, pageSize, sortBy, sortOrder, companyName, contactMobile);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

}
