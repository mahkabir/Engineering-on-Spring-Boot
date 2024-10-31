package com.mhk.eosb_validation_error_handling.company.management.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "LBS_TBL_COMPANY")
public class Company extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CONTACT_MOBILE")
    private String contactMobile;

    @Column(name = "BILLING_MOBILE")
    private String billingNumber;

    @Column(name = "CONTACT_EMAIL")
    private String emailAddress;

    @Column(name = "LBS_ADMIN_ID")
    private Long lbsAdminId;

    @Column(name = "LBS_ADMIN_NAME")
    private String lbsAdminName;

    @Column(name = "LBS_ADMIN_PASSWORD")
    private  String lbsAdminPassword;

    @Column(name = "BILLING_AMOUNT")
    private BigDecimal billingAmount;

    @Column(name = "DAILY_AMT")
    private BigDecimal dailyAmount;

    @Column(name = "MONTHLY_AMT")
    private BigDecimal monthlyAmount;

    @Column(name = "IS_ENABLE_CHARGING")
    private Boolean isEnableCharging;

    @Column(name = "LOGO_URL_LARGE")
    private String logoUrlLarge;

    @Column(name = "LOGO_URL_SMALL")
    private String logoUrlSmall;

    @Column(name = "TRACKER_TNAME")
    private String trackerTName;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

}
