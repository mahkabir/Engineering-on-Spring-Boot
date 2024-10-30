package com.mhk.eosb_validation_error_handling.employeeMsisdn.repo;

import com.mhk.eosb_validation_error_handling.employeeMsisdn.entity.EmployeeMsisdn;
import com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse;
import com.mhk.eosb_validation_error_handling.user.entity.User;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeMsisdnRepository extends JpaRepository<EmployeeMsisdn, Long> {

    Optional<EmployeeMsisdn> findByuserName(String userName);

    @Query("select new com.mhk.eosb_validation_error_handling.employeeMsisdn.response.EmployeeMsisdnDetailsResponse(" +
            "em.userName, " +
            "em.employeeId, " +
            "em.userFullName, " +
            "em.msisdn, " +
            "em.contactNo, " +
            "em.mailId, " +
            "em.departmentId, " +
            "em.departmentName, " +
            "em.designationId, " +
            "em.designationName, " +
            "em.userIsLock, " +
            "em.isRobiEmployee, " +
            "em.userCreatedById, " +
            "em.isNew, " +
            "em.loginCount, " +
            "em.userEditedById, " +
            "em.companyId, " +
            "em.companyName, " +
            "em.address, " +
            "em.comments, " +
            "em.canLogin, " +
            "em.trackingEnable, " +
            "em.isSuperAdmin, " +
            "em.fkSessionId, " +
            "em.fkLoginTime, " +
            "em.lastPasswordChangeTime, " +
            "em.areaId, " +
            "em.areaName, " +
            "em.groupName, " +
            "em.isEnableCharging, " +
            "em.disabledTrackingDate) " +
            "from EmployeeMsisdn em " +
            "where (:username is null or em.userName = :username) and " +
            "(:companyName is null or em.companyName = :companyName)")
    Page<EmployeeMsisdnDetailsResponse> findAllByParam(String username,
                                                       String companyName,
                                                       Pageable pageable);


}
