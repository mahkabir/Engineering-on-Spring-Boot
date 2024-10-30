package com.mhk.eosb_validation_error_handling.employeeMsisdn.entity;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "LBS_TBL_MSISDN")
public class EmployeeMsisdn extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERID")
    private Long userId;

    @Column(name = "USERNAME", nullable = false)
    private String userName;

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "USERFULLNAME", length = 500)
    private String userFullName;

    @Column(name = "MSISDN", nullable = false, length = 50, unique = true)
    private String msisdn;

    @Column(name = "CONTACTNO", length = 50)
    private String contactNo;

    @Column(name = "MAILID", length = 250)
    private String mailId;

    @Column(name = "PASSWORD", length = 500)
    private String password;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "DEPARTMENT_NAME", length = 300)
    private String departmentName;

    @Column(name = "DESIGNATION_ID")
    private Long designationId;

    @Column(name = "DESIGNATION_NAME")
    private String designationName;

    @Column(name = "USER_IS_LOCK")
    private Short userIsLock;

    @Column(name = "USER_IS_ACTIVE")
    private Short userIsActive;

    @Column(name = "IS_ROBI_EMPLOYEE")
    private Short isRobiEmployee;

    @Column(name = "USER_CREATED_BY_NAME", length = 500)
    private String userCreatedByName;

    @Column(name = "USER_CREATED_BY_ID")
    private Long userCreatedById;

    @Column(name = "USER_CREATED_DATE")
    private Date userCreatedDate;

    @Column(name = "IS_NEW", columnDefinition = "smallint default 1")
    private Short isNew;

    @Column(name = "LOGIN_COUNT", columnDefinition = "integer default 0")
    private Integer loginCount;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @Column(name = "USER_EDITED_BY_ID")
    private Long userEditedById;

    @Column(name = "USER_EDITED_BY_NAME", length = 300)
    private String userEditedByName;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "COMPANY_NAME", length = 500)
    private String companyName;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @Column(name = "COMMENTS", length = 500)
    private String comments;

    @Column(name = "CAN_LOGIN", columnDefinition = "smallint default 0")
    private Short canLogin;

    @Column(name = "TRACKING_ENABLE")
    private Short trackingEnable;

    @Column(name = "AREA_ID")
    private Long areaId;

    @Column(name = "AREA_NAME", length = 300)
    private String areaName;

    @Column(name = "GROUP_NAME", length = 400)
    private String groupName;

    @Column(name = "IS_ENABLE_CHARGING", columnDefinition = "smallint default 0")
    private Short isEnableCharging;

    @Column(name = "DISABLED_TRACKING_DT")
    private Date disabledTrackingDt;

    @Column(name = "MSISDN_PROFILE", length = 50)
    private String msisdnProfile;

    @Column(name = "CONFIG_TIME_MINUTE")
    private Integer configTimeMinute;

    @Column(name = "LAST_LOCATION_UPDATE_TIME")
    private Date lastLocationUpdateTime;
}
