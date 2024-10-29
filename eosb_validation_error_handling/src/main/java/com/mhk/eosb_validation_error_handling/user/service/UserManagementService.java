package com.mhk.eosb_validation_error_handling.user.service;

import com.mhk.eosb_validation_error_handling.company.management.domain.common.DateTimeUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.common.PageUtils;
import com.mhk.eosb_validation_error_handling.company.management.domain.request.PaginationRequest;
import com.mhk.eosb_validation_error_handling.company.management.domain.response.PaginationResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.InvalidRequestDataException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordAlreadyExistsException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.RecordNotFoundException;
import com.mhk.eosb_validation_error_handling.company.management.mapper.CompanyMapper;
import com.mhk.eosb_validation_error_handling.company.management.repository.CompanyRepository;
import com.mhk.eosb_validation_error_handling.department.mapper.DepartmentMapper;
import com.mhk.eosb_validation_error_handling.department.repo.DepartmentRepository;
import com.mhk.eosb_validation_error_handling.user.entity.User;
import com.mhk.eosb_validation_error_handling.user.mapper.UserMapper;
import com.mhk.eosb_validation_error_handling.user.repo.UserRepository;
import com.mhk.eosb_validation_error_handling.user.request.UserDetailsRequest;
import com.mhk.eosb_validation_error_handling.user.response.UserDetailsResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagementService implements IUserManagementService {
private final CompanyRepository companyRepository;
private final DepartmentRepository departmentRepository;
private static final String PHONE_NUMBER_VALID_REGEX = "[0-9]+";
private final DepartmentMapper departmentMapper;
private final CompanyMapper companyMapper;
private final UserMapper userMapper;
private final UserRepository userRepository;

    @Override
    public UserDetailsResponse saveUserDetails(final UserDetailsRequest userDetailsRequest) {
        validateRequest(userDetailsRequest);
        Optional<User> userOptional =
                userRepository.findByDepartmentName(userDetailsRequest.getDepartmentName());
        if (userOptional.isPresent()) {
            throw new RecordAlreadyExistsException(ResponseMessage.RECORD_ALREADY_EXIST);
        }
        final User user = userMapper.mapDtoToEntity(userDetailsRequest);

        saveUser(user);
        final UserDetailsResponse UserDetailsResponse = userMapper.mapEntityToResponse(user);

        return UserDetailsResponse;
    }

    private <T> void validateRequest(final T request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestDataException(ResponseMessage.INVALID_REQUEST_DATA);
        }
    }

    public boolean isValidPhoneNumber(final String phoneNo, final String mobileRegex) {
        return phoneNo.matches(mobileRegex) && phoneNo.length() > 8 && phoneNo.length() <= 14;
    }

    @Transactional
    public void saveUser(final User user) {
        user.setCreatedBy("Abc");
        user.setCreatedDate(getCurrentDate());
        userRepository.save(user);
    }

    @Override
    public UserDetailsResponse editUserDetails(UserDetailsRequest userDetailsRequest) {

        Optional<User> userOptional =
                userRepository.findByDepartmentName(userDetailsRequest.getDepartmentName());
        if (userOptional.isEmpty())
            throw new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND);

        final User user = userOptional.get();

        editUser(user,userDetailsRequest);
        final UserDetailsResponse userDetailsResponse = userMapper.mapEntityToResponse(user);
        return userDetailsResponse;
    }

    @Transactional
    public void editUser(User user, UserDetailsRequest userDetailsRequest) {
        user.setDepartmentName(userDetailsRequest.getDepartmentName());
        user.setCompanyId(userDetailsRequest.getCompanyId());
        user.setCompanyName(userDetailsRequest.getCompanyName());
        user.setParentId(userDetailsRequest.getParentId());
        user.setDeptHeadUserId(userDetailsRequest.getDeptHeadUserId());
        user.setDeptHeadEmployeeId(userDetailsRequest.getDeptHeadEmployeeId());
        user.setDeptHeadCategoryId(userDetailsRequest.getDeptHeadCategoryId());
        user.setDeptHeadCategoryName(userDetailsRequest.getDeptHeadCategoryName());
        user.setRemarks(userDetailsRequest.getRemarks());
        user.setUpdatedBy("Def");
        user.setUpdatedDate(getCurrentDate());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public PaginationResponse<UserDetailsResponse> getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String departmentName, String companyName, Date fromDate, Date toDate) {

        return getUserDetailsPaginationResponse(pageNumber, pageSize, sortBy, sortOrder,departmentName, companyName, fromDate, toDate);

    }

    private PaginationResponse<UserDetailsResponse> getUserDetailsPaginationResponse(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String departmentName, String companyName, Date fromDate, Date toDate) {

        PaginationRequest paginationRequest = PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder);
        Pageable pageable = PageUtils.getPageable(paginationRequest);

        String startDate = Objects.isNull(fromDate) ? null : DateTimeUtils.formatDate(fromDate, "yyyy-MM-dd");
        String endDate = Objects.isNull(toDate) ? null : DateTimeUtils.formatDate(DateTimeUtils.addDay(toDate, 1),
                "yyyy-MM-dd");

        Page<UserDetailsResponse> page = userRepository.findAllByParam(departmentName, companyName, pageable);

        //List<CompanyDetailsResponse> transactionHistoryList = page.getContent();

        return page.getContent().isEmpty() ? PageUtils.mapToPaginationResponseDto(Page.empty(), paginationRequest) :
                PageUtils.mapToPaginationResponseDto(page, paginationRequest);

    }
    @Override
    public UserDetailsResponse getUserDetails(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow( ()-> new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND) );
        return userMapper.mapEntityToResponse(user);
    }

    public Date getCurrentDate() {
        return new Date();
    }

}
