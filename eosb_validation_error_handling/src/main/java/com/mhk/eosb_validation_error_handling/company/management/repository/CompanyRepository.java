package com.mhk.eosb_validation_error_handling.company.management.repository;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(String companyName);

}
