package com.mhk.eosb_validation_error_handling.designation.mapper;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.CompanyDetailsRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.designation.entity.Designation;
import com.mhk.eosb_validation_error_handling.designation.request.DesignationDetailsRequest;
import com.mhk.eosb_validation_error_handling.designation.response.DesignationDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DesignationMapper {

    default DesignationDetailsResponse mapEntityToResponse(final Designation designation) {
        DesignationDetailsResponse designationDetailsResponse = new DesignationDetailsResponse();
        designationDetailsResponse.setDesignationName(designation.getDesignationName());
        designationDetailsResponse.setCompanyId(designation.getCompanyId());
        designationDetailsResponse.setCompanyName(designation.getCompanyName());
        designationDetailsResponse.setRemarks(designation.getRemarks());
        return designationDetailsResponse;
    }

    Designation mapDtoToEntity(final DesignationDetailsRequest designationDetailsRequest);

}
