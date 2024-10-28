package com.mhk.eosb_validation_error_handling.designation.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class DesignationDetailsResponse {

    private String designationName;
    private Long companyId;
    private String companyName;
    private String remarks;

}
