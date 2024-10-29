package com.mhk.eosb_validation_error_handling.user.repo;

import com.mhk.eosb_validation_error_handling.department.entity.Department;
import com.mhk.eosb_validation_error_handling.department.response.DepartmentDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.entity.User;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDepartmentName(String departmentName);

    @Query("select new com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse(" +
            "d.departmentName, " +
            "d.companyId, " +
            "d.companyName, " +
            "d.remarks, " +
            "d.parentId, " +
            "d.deptHeadUserId, " +
            "d.deptHeadEmployeeId, " +
            "d.deptHeadCategoryId, " +
            "d.deptHeadCategoryName) " +
            "from User d " +
            "where (:departmentName is null or d.departmentName = :departmentName) and " +
            "(:companyName is null or d.companyName = :companyName)" )
    Page<UserDetailsResponse> findAllByParam(String departmentName,
                                             String companyName,
                                             Pageable pageable);

}
