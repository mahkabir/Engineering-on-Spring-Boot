package com.mhk.eosb_validation_error_handling.employeeMsisdn.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.request.EmployeeMsisdnDetailsRequest;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;

import java.util.Date;

public interface IEmployeeMsisdnManagementService {

    EmployeeMsisdnDetailsResponse saveMsisdnDetails(EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest);
    EmployeeMsisdnDetailsResponse editMsisdnDetails(EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest);
    PaginationResponse<EmployeeMsisdnDetailsResponse> getAllMsisdns(Integer pageNumber,
                                                                      Integer pageSize,
                                                                      String sortBy,
                                                                      String sortOrder,
                                                                      String userName,
                                                                      String companyName,
                                                                      Date fromDate,
                                                                      Date toDate);
    EmployeeMsisdnDetailsResponse getMsisdnDetails(Long userId);



}
