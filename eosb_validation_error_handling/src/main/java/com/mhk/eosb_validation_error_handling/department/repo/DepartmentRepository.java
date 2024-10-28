package com.mhk.eosb_validation_error_handling.department.repo;

import com.mhk.eosb_validation_error_handling.company.management.domain.entity.Company;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.CompanyDetailsResponse;
import com.mhk.eosb_validation_error_handling.department.entity.Department;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentName(String departmentName);

    @Query("select new com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse(" +
            "d.departmentName, " +
            "d.companyId, " +
            "d.companyName, " +
            "d.remarks, " +
            "d.parentId, " +
            "d.deptHeadUserId, " +
            "d.deptHeadEmployeeId, " +
            "d.deptHeadCategoryId, " +
            "d.deptHeadCategoryName) " +
            "from Department d " +
            "where (:departmentName is null or d.departmentName = :departmentName) and " +
            "(:companyName is null or d.companyName = :companyName)" )
    Page<DepartmentDetailsResponse> findAllByParam(String departmentName,
                                                   String companyName,
                                                   Pageable pageable);

}
