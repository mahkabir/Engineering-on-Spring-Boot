package com.mhk.eosb_validation_error_handling.company.management.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "COMPANY_DETAILS")
public class Company {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CONTACT_PERSON")
    private String contactPerson;

    @Column(name = "CONTACT_MOBILE")
    private String contactMobile;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "BILLING_NUMBER")
    private String billingNumber;

    @Column(name = "BILLING_AMOUNT")
    private BigDecimal billingAmount;

    @Column(name = "DAILY_AMOUNT")
    private BigDecimal dailyAmount;

    @Column(name = "IS_ENABLE_CHARGING")
    private Boolean isEnableCharging;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "REMARKS")
    private String remarks;

}
