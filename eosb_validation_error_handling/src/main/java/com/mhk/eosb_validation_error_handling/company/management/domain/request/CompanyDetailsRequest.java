package com.mhk.eosb_validation_error_handling.company.management.domain.request;

import com.mhk.eosb_validation_error_handling.company.management.annotations.BdPhoneNumber;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CompanyDetailsRequest {

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Contact person is required")
    private String contactPerson;

    @NotBlank(message = "Contact mobile is required")
  //  @Pattern(regexp = "(\\+88)?01[3-9]\\d{8}", message = "Found invalid phone number")
    @BdPhoneNumber(message = "Found invalid phone number")
    private String contactMobile;

    @Email(message = "Email address is invalid")
    private String emailAddress;

    @NotBlank(message = "Billing number is required")
    private String billingNumber;

    @NotNull(message = "Billing amount is required")
    private BigDecimal billingAmount;

    @NotNull(message = "Daily amount is required")
    private BigDecimal dailyAmount;

    @NotNull(message = "Enable charging status is required")
    private Boolean isEnableCharging;

    private String logo;

    private String remarks;

}
