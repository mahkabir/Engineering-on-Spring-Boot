package com.mhk.eosb_validation_error_handling.designation.repo;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.department.entity.Department;
import com.mhk.eosb_validation_error_handling.designation.entity.Designation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

    Optional<Designation> findByDesignationName(String designationName);

  /*  @Query("select tf from Department tf where (:Department is null or tf.companyName like %:Department%) and " +
            "(:companyNmae is null or tf.companyName like %:companyName%) and " +
            "(:contactMobile is null or tf.contactMobile like %:contactMobile%)")
    Page<Department> findAllByParam(String companyName,
                                 String contactMobile,
                                 Pageable pageable);*/

}
