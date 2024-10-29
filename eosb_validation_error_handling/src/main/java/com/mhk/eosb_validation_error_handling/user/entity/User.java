package com.mhk.eosb_validation_error_handling.user.entity;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "LBS_TBL_USER")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String userName;

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "USER_FULL_NAME", length = 500)
    private String userFullName;

    @Column(name = "MSISDN", nullable = false)
    private String msisdn;

    @Column(name = "CONTACT_NO")
    private String contactNo;

    @Column(name = "MAIL_ID")
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
    private Boolean userIsLock;

    @Column(name = "IS_ROBI_EMPLOYEE")
    private Boolean isRobiEmployee;

    @Column(name = "USER_CREATED_BY_ID")
    private Long userCreatedById;

    @Column(name = "IS_NEW")
    private Boolean isNew;

    @Column(name = "LOGIN_COUNT")
    private Integer loginCount;

    @Column(name = "USER_EDITED_BY_ID")
    private Long userEditedById;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "COMPANY_NAME", length = 500)
    private String companyName;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @Column(name = "COMMENTS", length = 500)
    private String comments;

    @Column(name = "CAN_LOGIN")
    private Boolean canLogin;

    @Column(name = "TRACKING_ENABLE")
    private Boolean trackingEnable;

    @Column(name = "IS_SUPER_ADMIN")
    private Boolean isSuperAdmin;

    @Column(name = "FK_SEESION_ID")
    private String fkSessionId;

    @Column(name = "FK_LOGIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fkLoginTime;

    @Column(name = "LAST_PASSWORD_CHANGE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChangeTime;

    @Column(name = "AREA_ID")
    private Long areaId;

    @Column(name = "AREA_NAME", length = 300)
    private String areaName;

    @Column(name = "GROUP_NAME", length = 400)
    private String groupName;

    @Column(name = "IS_ENABLE_CHARGING")
    private Boolean isEnableCharging;

    @Column(name = "DISABLED_TRACKING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date disabledTrackingDate;
}
