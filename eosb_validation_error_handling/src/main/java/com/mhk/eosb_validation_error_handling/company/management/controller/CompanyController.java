package com.mhk.eosb_validation_error_handling.company.management.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.service.ICompanyManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @GetMapping("/company-details/all")
    public ApiResponse<PaginationResponse<CompanyDetailsResponse>> getAllCompanyDetails(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                             @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                                             @RequestParam(required = false, defaultValue = "desc") String sortOrder,
                                                                                             @RequestParam(required = false) String companyName,
                                                                                             @RequestParam(required = false) String contactMobile,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

        final PaginationResponse<CompanyDetailsResponse> response =
                iCompanyManagementService.getAllCompanies(pageNumber, pageSize, sortBy, sortOrder, companyName, contactMobile, fromDate, toDate);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

}
