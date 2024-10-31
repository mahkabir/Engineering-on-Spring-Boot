package com.mhk.eosb_validation_error_handling.employeeMsisdn.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class EmployeeMsisdnDetailsRequestExcelData {
    @Column(name = "SL")
    private String sl;

    @Column(name = "MSISDN")
    private String msisdn;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "DEPARTMENT")
    private String departement;

    @Column(name = "DESIGNATION")
    private String Designation;

}
