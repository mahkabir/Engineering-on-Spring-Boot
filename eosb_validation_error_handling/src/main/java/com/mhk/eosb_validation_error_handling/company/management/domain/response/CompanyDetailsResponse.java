package com.mhk.eosb_validation_error_handling.company.management.domain.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@RequiredArgsConstructor
public class CompanyDetailsResponse {

    private String companyName;
    private String address;
    private String contactPerson;
    private String contactMobile;
    private String emailAddress;
    private String billingNumber;
    private BigDecimal billingAmount;
    private BigDecimal dailyAmount;
    private Boolean isEnableCharging;
    private String logo;
    private String remarks;

}
