package com.mhk.eosb_validation_error_handling.company.management.domain.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
