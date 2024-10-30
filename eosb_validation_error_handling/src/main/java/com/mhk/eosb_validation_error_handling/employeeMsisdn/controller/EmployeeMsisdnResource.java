package com.mhk.eosb_validation_error_handling.employeeMsisdn.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.request.EmployeeMsisdnDetailsRequest;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.service.IEmployeeMsisdnManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping( "/msisdn-management")
@RequiredArgsConstructor
public class EmployeeMsisdnResource {
    private final IEmployeeMsisdnManagementService iEmployeeMsisdnManagementService;

    @PostMapping("/save-msisdn")
    public ApiResponse<EmployeeMsisdnDetailsResponse> saveMsisdn(@Valid @RequestBody EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest) {
        final EmployeeMsisdnDetailsResponse response = iEmployeeMsisdnManagementService.saveMsisdnDetails(employeeMsisdnDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @PostMapping("/edit-msisdn")
    public ApiResponse<EmployeeMsisdnDetailsResponse> editMsisdn(@Valid @RequestBody EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest) {
        final EmployeeMsisdnDetailsResponse response = iEmployeeMsisdnManagementService.editMsisdnDetails(employeeMsisdnDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/msisdn-details/all")
    public ApiResponse<PaginationResponse<EmployeeMsisdnDetailsResponse>> getAllMsisdnDetails(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                             @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                                             @RequestParam(required = false, defaultValue = "desc") String sortOrder,
                                                                                             @RequestParam(required = false) String userName,
                                                                                             @RequestParam(required = false) String companyName,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

        final PaginationResponse<EmployeeMsisdnDetailsResponse> response =
                iEmployeeMsisdnManagementService.getAllMsisdns(pageNumber, pageSize, sortBy, sortOrder, userName, companyName, fromDate, toDate);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/msisdn-details/{id}")
    public ApiResponse<EmployeeMsisdnDetailsResponse> getUserDetailsById(@PathVariable Long id) {
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL),
                iEmployeeMsisdnManagementService.getMsisdnDetails(id));
    }

   /* @GetMapping("/msisdn-details/{msisdn}")
    public ApiResponse<EmployeeMsisdnDetailsResponse> getUserDetailsById(@PathVariable String msisdn) {
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL),
                iEmployeeMsisdnManagementService.getUserDetails(msisdn));
    }*/


}
