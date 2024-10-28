package com.mhk.eosb_validation_error_handling.designation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class DesignationDetailsRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    private String companyName;

    @Size(max = 400, message = "Remarks can be up to 400 characters long")
    private String remarks;

}
