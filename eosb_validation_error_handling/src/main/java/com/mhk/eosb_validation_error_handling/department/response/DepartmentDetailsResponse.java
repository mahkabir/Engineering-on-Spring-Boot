package com.mhk.eosb_validation_error_handling.department.response;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDetailsResponse {

    private String departmentName;
    private Long companyId;
    private String companyName;
    private String remarks;
    private Long parentId;
    private Long deptHeadUserId;
    private String deptHeadEmployeeId;
    private Long deptHeadCategoryId;
    private String deptHeadCategoryName;

}
