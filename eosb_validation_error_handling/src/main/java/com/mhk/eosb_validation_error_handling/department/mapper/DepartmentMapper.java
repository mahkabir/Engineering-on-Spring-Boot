package com.mhk.eosb_validation_error_handling.department.mapper;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.department.entity.Department;
import com.mhk.eosb_validation_error_handling.department.request.DepartmentDetailsRequest;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    default DepartmentDetailsResponse mapEntityToResponse(final Department department) {
        DepartmentDetailsResponse departmentDetailsResponse = new DepartmentDetailsResponse();
        departmentDetailsResponse.setDepartmentName(department.getDepartmentName());
        departmentDetailsResponse.setCompanyId(department.getCompanyId());
        departmentDetailsResponse.setCompanyName(department.getCompanyName());
        departmentDetailsResponse.setParentId(department.getParentId());
        departmentDetailsResponse.setDeptHeadUserId(department.getDeptHeadUserId());
        departmentDetailsResponse.setDeptHeadEmployeeId(department.getDeptHeadEmployeeId());
        departmentDetailsResponse.setDeptHeadCategoryId(department.getDeptHeadCategoryId());
        departmentDetailsResponse.setDeptHeadCategoryName(department.getDeptHeadCategoryName());
        departmentDetailsResponse.setRemarks(department.getRemarks());
        return departmentDetailsResponse;
    }

    Department mapDtoToEntity(final DepartmentDetailsRequest departmentDetailsRequest);

}
