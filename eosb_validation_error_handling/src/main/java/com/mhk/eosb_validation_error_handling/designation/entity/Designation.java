package com.mhk.eosb_validation_error_handling.designation.entity;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LBS_TBL_DESIGNATION")
public class Designation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "DESIGNATION_NAME", nullable = false)
    private String designationName;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "REMARKS", length = 400)
    private String remarks;
}
