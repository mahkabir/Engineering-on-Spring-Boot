package com.mhk.eosb_validation_error_handling.company.management.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.service.ICompanyManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/company-management")
@RequiredArgsConstructor
public class CompanyController {
    private final ICompanyManagementService iCompanyManagementService;

    @PostMapping("/save-company")
    public ApiResponse<CompanyDetailsResponse> saveCompany(@Valid @RequestBody CompanyDetailsRequest companyDetailsRequest) {
        final CompanyDetailsResponse response = iCompanyManagementService.saveCompanyDetails(companyDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @PostMapping("/edit-company")
    public ApiResponse<CompanyDetailsResponse> editCompany(@Valid @RequestBody CompanyDetailsRequest companyDetailsRequest) {
        final CompanyDetailsResponse response = iCompanyManagementService.editCompanyDetails(companyDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

}
