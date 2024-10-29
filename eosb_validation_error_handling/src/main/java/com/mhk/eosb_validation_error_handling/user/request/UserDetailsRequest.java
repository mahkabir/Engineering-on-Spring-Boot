package com.mhk.eosb_validation_error_handling.user.request;

import com.mhk.eosb_validation_error_handling.company.management.annotations.BDPhoneNumber;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserDetailsRequest {

    @NotBlank(message = "Username is required")
    private String userName;

    private String employeeId;

    @NotBlank(message = "Full name is required")
    @Size(max = 500, message = "Full name can have a maximum of 500 characters")
    private String userFullName;

    @NotBlank(message = "MSISDN is required")
    private String msisdn;

    @BDPhoneNumber
    private String contactNo;

    @Email(message = "Invalid email format")
    private String mailId;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 500, message = "Password must be between 8 and 500 characters")
    private String password;

    private Long departmentId;

    @Size(max = 300, message = "Department name can have a maximum of 300 characters")
    private String departmentName;

    private Long designationId;

    private String designationName;
    private Boolean userIsLock;
    private Boolean isRobiEmployee;
    private Long userCreatedById;
    private Boolean isNew;

    @Min(value = 0, message = "Login count cannot be negative")
    private Integer loginCount;

    private Long userEditedById;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    @Size(max = 500, message = "Company name can have a maximum of 500 characters")
    private String companyName;

    @Size(max = 500, message = "Address can have a maximum of 500 characters")
    private String address;

    @Size(max = 500, message = "Comments can have a maximum of 500 characters")
    private String comments;

    private Boolean canLogin;
    private Boolean trackingEnable;
    private Boolean isSuperAdmin;

    private String fkSessionId;

    private Date fkLoginTime;
    private Date lastPasswordChangeTime;

    private Long areaId;

    @Size(max = 300, message = "Area name can have a maximum of 300 characters")
    private String areaName;

    @Size(max = 400, message = "Group name can have a maximum of 400 characters")
    private String groupName;

    private Boolean isEnableCharging;
    private Date disabledTrackingDate;

}
