package com.mhk.eosb_validation_error_handling.department.entity;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LBS_TBL_DEPARTMENT")
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String departmentName;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "REMARKS", length = 400)
    private String remarks;

    @Column(name = "PARENT_ID", nullable = false)
    private Long parentId = 0L;

    @Column(name = "DEPT_HEAD_USER_ID")
    private Long deptHeadUserId;

    @Column(name = "DEPT_HEAD_EMPLOYEE_ID")
    private String deptHeadEmployeeId;

    @Column(name = "DEPT_HEAD_CATEGORY_ID")
    private Long deptHeadCategoryId;

    @Column(name = "DEPT_HEAD_CATEGORY_NAME")
    private String deptHeadCategoryName;
}
