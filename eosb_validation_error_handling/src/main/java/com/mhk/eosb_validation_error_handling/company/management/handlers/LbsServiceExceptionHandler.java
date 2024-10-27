package com.mhk.eosb_validation_error_handling.company.management.handlers;


import com.mhk.eosb_validation_error_handling.company.management.domain.common.ApiResponse;
import com.mhk.eosb_validation_error_handling.company.management.enums.ResponseMessage;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.CustomRootException;
import com.mhk.eosb_validation_error_handling.company.management.exceptions.PreValidationException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@RestControllerAdvice
public class LbsServiceExceptionHandler extends BaseExceptionHandler {

    //private final ChargeConfigServiceLogger logger;

   /* @ExceptionHandler({FeignException.class})
    public ResponseEntity<ApiResponse<Void>> handleFeignException(FeignException ex) {
        logger.error(ex.getLocalizedMessage(), ex);
        String message = processFeignExceptionMessage(ex.status(), ex.contentUTF8());
        ApiResponse<Void> apiResponse = buildApiResponse(ResponseMessage.INTER_SERVICE_COMMUNICATION_ERROR.getResponseCode(), message);
        HttpStatus httpStatus = ex.status() == HttpStatus.BAD_REQUEST.value() ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
*/
    @ExceptionHandler(PreValidationException.class)
    public final ResponseEntity<ApiResponse<Void>> handlePreValidationException(PreValidationException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        ApiResponse<Void> apiResponse = buildApiResponse(ex.getMessageCode(), getMessage(ex.getMessage()));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    public final ResponseEntity<ApiResponse<Void>> handleDBException(DataAccessException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        String rootCause = Objects.nonNull(ex.getRootCause()) ? ex.getRootCause().toString() : "";
        errorLogger.error("Root Cause: " + rootCause);
        ApiResponse<Void> apiResponse = buildApiResponse(ResponseMessage.DATABASE_EXCEPTION.getResponseCode(), getMessage(ResponseMessage.DATABASE_EXCEPTION.getResponseMessage()));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(CustomRootException.class)
    public final ResponseEntity<ApiResponse<Void>> handleCustomException(CustomRootException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        ApiResponse<Void> apiResponse = buildApiResponse(ex.getMessageCode(), getMessage(ex.getMessage()));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse<Void>> commonException(Exception ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        ApiResponse<Void> apiResponse = buildApiResponse(ResponseMessage.INTERNAL_SERVICE_EXCEPTION.getResponseCode(), getMessage(ResponseMessage.INTERNAL_SERVICE_EXCEPTION.getResponseMessage()));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> collect = ex.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (oldValue, newValue) -> newValue));

        final String message = getMessage(ResponseMessage.INVALID_REQUEST_DATA.getResponseMessage());
        ApiResponse<Object> apiResponse = buildApiResponse(ResponseMessage.INVALID_REQUEST_DATA.getResponseCode(), message, collect);

        dropErrorLogForArgumentNotValid(ex.getParameter().getDeclaringClass().getName(),
                Objects.isNull(ex.getParameter().getMethod()) ? "" : ex.getParameter().getMethod().getName(),
                message,
                collect);

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

/*    @ExceptionHandler(FeignClientException.class)
    public final ResponseEntity<ApiResponse<Void>> handleFeignClientException(FeignClientException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        ApiResponse<Void> apiResponse = buildApiResponse(ex.getMessageCode(), ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }*/

    private String getMessage(String messageKey) {
        String message = "";

      /*  try {
            message = localeMessageService.getLocalMessage(messageKey);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage(), ex);
        }*/

        return StringUtils.isNotBlank(message) ? message : messageKey;
    }

    private void dropErrorLogForArgumentNotValid(final String className, final String methodName, final String message, final Object data) {

        errorLogger.error(String.format("****Custom Jakarta Validation Error**** " +
                "\nClassName: %s | MethodName: %s | Message: %s"+
                "\nerrorData: %s", className, methodName, message, data));
    }

}
