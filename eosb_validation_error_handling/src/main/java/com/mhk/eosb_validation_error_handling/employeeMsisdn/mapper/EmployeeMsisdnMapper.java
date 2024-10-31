package com.mhk.eosb_validation_error_handling.employeeMsisdn.mapper;

import com.mhk.eosb_validation_error_handling.employeeMsisdn.entity.EmployeeMsisdn;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.request.EmployeeMsisdnDetailsRequest;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.entity.User;
import com.mhk.eosb_validation_error_handling.user.request.UserDetailsRequest;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMsisdnMapper {

    default EmployeeMsisdnDetailsResponse mapEntityToResponse(final EmployeeMsisdn employeeMsisdn) {
        EmployeeMsisdnDetailsResponse employeeMsisdnDetailsResponse = new EmployeeMsisdnDetailsResponse();
        employeeMsisdnDetailsResponse.setUserName(employeeMsisdn.getUserName());
        employeeMsisdnDetailsResponse.setEmployeeId(employeeMsisdn.getEmployeeId());
        employeeMsisdnDetailsResponse.setUserFullName(employeeMsisdn.getUserFullName());
        employeeMsisdnDetailsResponse.setMsisdn(employeeMsisdn.getMsisdn());
        employeeMsisdnDetailsResponse.setContactNo(employeeMsisdn.getContactNo());
        employeeMsisdnDetailsResponse.setMailId(employeeMsisdn.getMailId());
        employeeMsisdnDetailsResponse.setDepartmentId(employeeMsisdn.getDepartmentId());
        employeeMsisdnDetailsResponse.setDepartmentName(employeeMsisdn.getDepartmentName());
        employeeMsisdnDetailsResponse.setDesignationId(employeeMsisdn.getDesignationId());
        employeeMsisdnDetailsResponse.setDesignationName(employeeMsisdn.getDesignationName());
        employeeMsisdnDetailsResponse.setUserIsLock(employeeMsisdn.getUserIsLock());
        employeeMsisdnDetailsResponse.setIsRobiEmployee(employeeMsisdn.getIsRobiEmployee());
        employeeMsisdnDetailsResponse.setUserCreatedById(employeeMsisdn.getUserCreatedById());
        employeeMsisdnDetailsResponse.setIsNew(employeeMsisdn.getIsNew());
        employeeMsisdnDetailsResponse.setLoginCount(employeeMsisdn.getLoginCount());
        employeeMsisdnDetailsResponse.setUserEditedById(employeeMsisdn.getUserEditedById());
        employeeMsisdnDetailsResponse.setCompanyId(employeeMsisdn.getCompanyId());
        employeeMsisdnDetailsResponse.setCompanyName(employeeMsisdn.getCompanyName());
        employeeMsisdnDetailsResponse.setAddress(employeeMsisdn.getAddress());
        employeeMsisdnDetailsResponse.setComments(employeeMsisdn.getComments());
        employeeMsisdnDetailsResponse.setCanLogin(employeeMsisdn.getCanLogin());
        employeeMsisdnDetailsResponse.setTrackingEnable(employeeMsisdn.getTrackingEnable());
       /* employeeMsisdnDetailsResponse.setIsSuperAdmin(employeeMsisdn.getIsSuperAdmin());
        employeeMsisdnDetailsResponse.setFkSessionId(employeeMsisdn.getFkSessionId());
        employeeMsisdnDetailsResponse.setFkLoginTime(employeeMsisdn.getFkLoginTime());
        employeeMsisdnDetailsResponse.setLastPasswordChangeTime(employeeMsisdn.getLastPasswordChangeTime());*/
        employeeMsisdnDetailsResponse.setAreaId(employeeMsisdn.getAreaId());
        employeeMsisdnDetailsResponse.setAreaName(employeeMsisdn.getAreaName());
        employeeMsisdnDetailsResponse.setGroupName(employeeMsisdn.getGroupName());
        employeeMsisdnDetailsResponse.setIsEnableCharging(employeeMsisdn.getIsEnableCharging());
        employeeMsisdnDetailsResponse.setDisabledTrackingDate(employeeMsisdn.getDisabledTrackingDate());
        return employeeMsisdnDetailsResponse;
    }

    EmployeeMsisdn mapDtoToEntity(final EmployeeMsisdnDetailsRequest employeeMsisdnDetailsRequest);

}
