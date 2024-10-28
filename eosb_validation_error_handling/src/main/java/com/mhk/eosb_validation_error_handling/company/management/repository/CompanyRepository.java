package com.mhk.eosb_validation_error_handling.company.management.repository;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(String companyName);

    @Query("select new com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse(" +
            "c.companyName, " +
            "c.address, " +
            "c.contactPerson, " +
            "c.contactMobile, " +
            "c.emailAddress, " +
            "c.billingNumber, " +
            "c.billingAmount, " +
            "c.dailyAmount, " +
            "c.isEnableCharging, " +
            "c.logo, " +
            "c.remarks) " +
            "from Company c " +
            "where (:companyName is null or c.companyName = :companyName) and " +
            "(:contactMobile is null or c.contactMobile = :contactMobile)" )
    Page<CompanyDetailsResponse> findAllByParam(String companyName,
                                                String contactMobile,
                                                Pageable pageable);

}
