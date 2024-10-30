package com.mhk.eosb_validation_error_handling.employeeMsisdn.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMsisdnDetailsResponse {

    private String userName;
    private String employeeId;
    private String userFullName;
    private String msisdn;
    private String contactNo;
    private String mailId;
    private Long departmentId;
    private String departmentName;
    private Long designationId;
    private String designationName;
    private Boolean userIsLock;
    private Boolean isRobiEmployee;
    private Long userCreatedById;
    private Boolean isNew;
    private Integer loginCount;
    private Long userEditedById;
    private Long companyId;
    private String companyName;
    private String address;
    private String comments;
    private Boolean canLogin;
    private Boolean trackingEnable;
    private Boolean isSuperAdmin;
    private String fkSessionId;
    private Date fkLoginTime;
    private Date lastPasswordChangeTime;
    private Long areaId;
    private String areaName;
    private String groupName;
    private Boolean isEnableCharging;
    private Date disabledTrackingDate;

}
