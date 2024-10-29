package com.mhk.eosb_validation_error_handling.user.repo;

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

    Optional<User> findByuserName(String userName);

    @Query("select new com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse(" +
            "d.userName, " +
            "d.employeeId, " +
            "d.userFullName, " +
            "d.msisdn, " +
            "d.contactNo, " +
            "d.mailId, " +
            "d.departmentId, " +
            "d.departmentName, " +
            "d.designationId, " +
            "d.designationName, " +
            "d.userIsLock, " +
            "d.isRobiEmployee, " +
            "d.userCreatedById, " +
            "d.isNew, " +
            "d.loginCount, " +
            "d.userEditedById, " +
            "d.companyId, " +
            "d.companyName, " +
            "d.address, " +
            "d.comments, " +
            "d.canLogin, " +
            "d.trackingEnable, " +
            "d.isSuperAdmin, " +
            "d.fkSessionId, " +
            "d.fkLoginTime, " +
            "d.lastPasswordChangeTime, " +
            "d.areaId, " +
            "d.areaName, " +
            "d.groupName, " +
            "d.isEnableCharging, " +
            "d.disabledTrackingDate) " +
            "from User d " +
            "where (:username is null or d.userName = :username) and " +
            "(:companyName is null or d.companyName = :companyName)")
    Page<UserDetailsResponse> findAllByParam(String username,
                                             String companyName,
                                             Pageable pageable);


}
