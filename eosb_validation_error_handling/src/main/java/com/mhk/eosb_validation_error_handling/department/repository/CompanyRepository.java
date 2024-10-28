package com.mhk.eosb_validation_error_handling.department.repository;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(String companyName);

    @Query("select tf from Company tf where (:companyName is null or tf.companyName like %:companyName%) and " +
            "(:companyNmae is null or tf.companyName like %:companyName%) and " +
            "(:contactMobile is null or tf.contactMobile like %:contactMobile%)")
    Page<Company> findAllByParam(String companyName,
                                 String contactMobile,
                                 Pageable pageable);

}
