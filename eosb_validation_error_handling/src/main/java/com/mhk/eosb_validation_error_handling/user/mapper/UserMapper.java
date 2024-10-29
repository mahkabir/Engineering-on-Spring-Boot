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
        userDetailsResponse.setDepartmentName(user.getDepartmentName());
        userDetailsResponse.setCompanyId(user.getCompanyId());
        userDetailsResponse.setCompanyName(user.getCompanyName());
        userDetailsResponse.setParentId(user.getParentId());
        userDetailsResponse.setDeptHeadUserId(user.getDeptHeadUserId());
        userDetailsResponse.setDeptHeadEmployeeId(user.getDeptHeadEmployeeId());
        userDetailsResponse.setDeptHeadCategoryId(user.getDeptHeadCategoryId());
        userDetailsResponse.setDeptHeadCategoryName(user.getDeptHeadCategoryName());
        userDetailsResponse.setRemarks(user.getRemarks());
        return userDetailsResponse;
    }

    User mapDtoToEntity(final UserDetailsRequest userDetailsRequest);

}
