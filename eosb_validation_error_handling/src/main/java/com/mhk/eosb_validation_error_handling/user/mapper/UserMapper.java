package com.mhk.eosb_validation_error_handling.user.mapper;

import com.mhk.eosb_validation_error_handling.department.entity.Department;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.entity.User;
import com.mhk.eosb_validation_error_handling.user.request.UserDetailsRequest;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default UserDetailsResponse mapEntityToResponse(final User user) {
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        userDetailsResponse.setUserName(user.getUserName());
        userDetailsResponse.setEmployeeId(user.getEmployeeId());
        userDetailsResponse.setUserFullName(user.getUserFullName());
        userDetailsResponse.setMsisdn(user.getMsisdn());
        userDetailsResponse.setContactNo(user.getContactNo());
        userDetailsResponse.setMailId(user.getMailId());
        userDetailsResponse.setDepartmentId(user.getDepartmentId());
        userDetailsResponse.setDepartmentName(user.getDepartmentName());
        userDetailsResponse.setDesignationId(user.getDesignationId());
        userDetailsResponse.setDesignationName(user.getDesignationName());
        userDetailsResponse.setUserIsLock(user.getUserIsLock());
        userDetailsResponse.setIsRobiEmployee(user.getIsRobiEmployee());
        userDetailsResponse.setUserCreatedById(user.getUserCreatedById());
        userDetailsResponse.setIsNew(user.getIsNew());
        userDetailsResponse.setLoginCount(user.getLoginCount());
        userDetailsResponse.setUserEditedById(user.getUserEditedById());
        userDetailsResponse.setCompanyId(user.getCompanyId());
        userDetailsResponse.setCompanyName(user.getCompanyName());
        userDetailsResponse.setAddress(user.getAddress());
        userDetailsResponse.setComments(user.getComments());
        userDetailsResponse.setCanLogin(user.getCanLogin());
        userDetailsResponse.setTrackingEnable(user.getTrackingEnable());
        userDetailsResponse.setIsSuperAdmin(user.getIsSuperAdmin());
        userDetailsResponse.setFkSessionId(user.getFkSessionId());
        userDetailsResponse.setFkLoginTime(user.getFkLoginTime());
        userDetailsResponse.setLastPasswordChangeTime(user.getLastPasswordChangeTime());
        userDetailsResponse.setAreaId(user.getAreaId());
        userDetailsResponse.setAreaName(user.getAreaName());
        userDetailsResponse.setGroupName(user.getGroupName());
        userDetailsResponse.setIsEnableCharging(user.getIsEnableCharging());
        userDetailsResponse.setDisabledTrackingDate(user.getDisabledTrackingDate());
        return userDetailsResponse;
    }

    User mapDtoToEntity(final UserDetailsRequest userDetailsRequest);

}
