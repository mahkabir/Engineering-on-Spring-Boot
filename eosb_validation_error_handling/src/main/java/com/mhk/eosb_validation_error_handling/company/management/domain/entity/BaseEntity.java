package com.mhk.eosb_validation_error_handling.company.management.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Column(nullable = false, name = "CREATED_BY", columnDefinition = "varchar(100) default ''")
    private String createdBy;

    @Column(name = "UPDATED_BY", columnDefinition = "varchar(100) default ''")
    private String updatedBy;

    @Column(name = "APPROVED_BY", columnDefinition = "varchar(100) default ''")
    private String approvedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "CREATED_DATE")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPROVED_DATE")
    private Date approvedDate;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive = Boolean.TRUE;

    @Version
    private Long version;

    @Column(name = "ddl_version")
    private Integer ddlVersion;

}
