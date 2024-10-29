package com.mhk.eosb_validation_error_handling.user.controller;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.ResponseUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import com.mhk.eosb_validation_error_handling.department.service.IDepartmentManagementService;
import com.mhk.eosb_validation_error_handling.user.request.UserDetailsRequest;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.service.IUserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping( "/user-management")
@RequiredArgsConstructor
public class UserResource {
    private final IUserManagementService iUserManagementService;

    @PostMapping("/save-user")
    public ApiResponse<UserDetailsResponse> saveUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
        final UserDetailsResponse response = iUserManagementService.saveUserDetails(userDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @PostMapping("/edit-user")
    public ApiResponse<UserDetailsResponse> editUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
        final UserDetailsResponse response = iUserManagementService.editUserDetails(userDetailsRequest);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/user-details/all")
    public ApiResponse<PaginationResponse<UserDetailsResponse>> getAllUserDetails(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                             @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                                             @RequestParam(required = false, defaultValue = "desc") String sortOrder,
                                                                                             @RequestParam(required = false) String departmentName,
                                                                                             @RequestParam(required = false) String companyName,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                                                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

        final PaginationResponse<UserDetailsResponse> response =
                iUserManagementService.getAllUsers(pageNumber, pageSize, sortBy, sortOrder, departmentName, companyName, fromDate, toDate);
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL), response);
    }

    @GetMapping("/user-details/{userId}")
    public ApiResponse<UserDetailsResponse> getUserDetailsById(@PathVariable Long userId) {
        return ResponseUtils.createResponseObject((ResponseMessage.OPERATION_SUCCESSFUL),
                iUserManagementService.getUserDetails(userId));
    }

}
