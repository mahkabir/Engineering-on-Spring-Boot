package com.mhk.eosb_validation_error_handling.user.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.request.UserDetailsRequest;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;

import java.util.Date;

public interface IUserManagementService {

    UserDetailsResponse saveUserDetails(UserDetailsRequest userDetailsRequest);
    UserDetailsResponse editUserDetails(UserDetailsRequest userDetailsRequest);
    PaginationResponse<UserDetailsResponse> getAllUsers(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String userName,
                                                                      String companyName,
                                                                      Date fromDate,
                                                                      Date toDate);
    UserDetailsResponse getUserDetails(Long userId);



}
