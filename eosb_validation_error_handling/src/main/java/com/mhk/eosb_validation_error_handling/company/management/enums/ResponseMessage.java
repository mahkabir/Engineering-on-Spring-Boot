package com.mhk.eosb_validation_error_handling.company.management.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseMessage {

    OPERATION_SUCCESSFUL(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode(), "operation.success"),
    RECORD_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "record.not.found"),
    CURRENT_CONTEXT_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "current.context.not.found"),
    FEATURE_CODE_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "feature.code.not.found"),
    RECORD_ALREADY_EXIST(ApiResponseCode.RECORD_ALREADY_EXISTS.getResponseCode(), "record.already.exist"),
    LOCALE_RECORD_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "locale.record.not.found"),
    SERVICE_UNAVAILABLE(ApiResponseCode.SERVICE_UNAVAILABLE.getResponseCode(), "service.unavailable"),
    INVALID_REQUEST_DATA(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "invalid.request.data"),
    INTER_SERVICE_COMMUNICATION_ERROR(ApiResponseCode.INTER_SERVICE_COMMUNICATION_ERROR.getResponseCode(), "inter.service.communication.exception"),
    INTERNAL_SERVICE_EXCEPTION(ApiResponseCode.REQUEST_PROCESSING_FAILED.getResponseCode(), "internal.service.exception"),
    DATABASE_EXCEPTION(ApiResponseCode.DB_OPERATION_FAILED.getResponseCode(), "database.exception"),
    PER_TRANSACTION_MIN_LIMIT(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "per.transaction.min.limit.exception"),
    PER_TRANSACTION_MAX_LIMIT(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "per.transaction.max.limit.exception"),
    DAILY_TRANSACTION_USAGE_COUNT_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "daily.transaction.usage.count.limit.exceed"),
    DAILY_TRANSACTION_USAGE_AMOUNT_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "daily.transaction.usage.amount.limit.exceed"),
    MONTHLY_TRANSACTION_COUNT_USAGE_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "monthly.transaction.usage.count.limit.exceed"),
    MONTHLY_TRANSACTION_AMOUNT_USAGE_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "monthly.transaction.usage.amount.limit.exceed"),
    DAILY_TRANSACTION_CATEGORY_MIN_AMOUNT_LIMIT(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "daily.transaction.category.min.amount.limit"),
    DAILY_TRANSACTION_CATEGORY_MAX_AMOUNT_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "daily.transaction.category.max.amount.limit.exceed"),
    DAILY_TRANSACTION_CATEGORY_MAX_COUNT_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "daily.transaction.category.max.count.limit.exceed"),
    MONTHLY_TRANSACTION_CATEGORY_MAX_AMOUNT_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "monthly.transaction.category.max.limit.exceed"),
    MONTHLY_TRANSACTION_CATEGORY_MAX_COUNT_LIMIT_EXCEED(ApiResponseCode.LIMIT_FAILED.getResponseCode(), "monthly.transaction.category.count.limit.exceed"),
    FEIGN_CLIENT_REQUEST_EXCEPTION(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "feign.client.request.exception"),
    CATEGORY_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "category.not.found"),
    FEATURE_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "feature.not.found"),
    CONFIG_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "config.not.found"),
    CONFIG_SELECTOR_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "config.selector.not.found"),
    MONTHLY_CHARGE_SLAB_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "monthly.charge.slab.not.found"),
    CHARGE_AMOUNT_SLAB_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "charge.amount.slab.not.found"),
    PER_TRANSACTION_MIN_MAX_INVALID_EXCEPTION(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "per.transaction.min.max.invalid"),
    DAILY_MONTHLY_AMOUNT_INVALID_EXCEPTION(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "daily.monthly.amount.invalid.exception"),
    DAILY_MONTHLY_COUNT_INVALID_EXCEPTION(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "daily.monthly.count.invalid.exception"),
    GROUP_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "group.not.found"),
    GROUP_NOT_FOUND_REDIS(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "group.not.found.redis"),
    CHARGE_AMOUNT_SLAB_NOT_FOUND_REDIS(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "charge.amount.slab.not.found.redis"),
    DAILY_MONTHLY_TRANSACTION_CATEGORY_MAX_AMOUNT_LIMIT(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "daily.monthly.transaction.category.max.amount.limit"),
    CATEGORY_NOT_FOUND_REDIS(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "category.not.found.redis"),
    CHANNEL_TYPE_INVALID(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "channel.type.invalid"),
    FEATURE_NOT_FOUND_REDIS(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "feature.not.found.redis"),
    MONTHLY_CHARGE_SLAB_NOT_FOUND_REDIS(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "monthly.charge.slab.not.found.redis"),
    CHARGE_DEDUCTION_TYPE_INVALID(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "charge.deduction.type.invalid"),
    USER_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "user.not.found"),
    JSON_PARSE_ERROR(ApiResponseCode.REQUEST_PROCESSING_FAILED.getResponseCode(), "json.parse.error"),
    CHARGE_CALCULATION_EXCEPTION(ApiResponseCode.REQUEST_PROCESSING_FAILED.getResponseCode(), "charge.calculate.exception"),
    RATE_CARD_ID_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "rate.card.id.not.found"),
    SLAB_OVERLAP_EXCEPTION(ApiResponseCode.UNIQUE_CONSTRAINT_VIOLATION.getResponseCode(), "slab.over.lap.exception"),
    CHARGE_SELECTOR_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "charge.selector.not.found"),
    YOU_ARE_NOT_ALLOWED_TO_PERFORM_THE_TRANSACTION(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "you.are.not.allowed.to.perform.the.transaction"),
    RECEIVER_ARE_NOT_ALLOWED_TO_RECEIVE_THE_TRANSACTION(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "receiver.are.not.allowed.to.receive.the.transaction"),
    APPLICATION_SETTINGS_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "application.settings.not.found"),
    INSUFFICIENT_BALANCE_EXCEPTION(ApiResponseCode.INSUFFICIENT_BALANCE.getResponseCode(), "insufficient.balance"),
    WALLET_ID_CAN_NOT_BE_NULL(ApiResponseCode.INSUFFICIENT_BALANCE.getResponseCode(), "multi.wallet.id.can.not.be.null"),
    CHARGE_VALUE_CAN_NOT_BE_NULL(ApiResponseCode.INSUFFICIENT_BALANCE.getResponseCode(), "multi.wallet.charge.value.in.percent.can.not.be.null"),
    WALLET_PRIORITY_CAN_NOT_BE_NULL(ApiResponseCode.INSUFFICIENT_BALANCE.getResponseCode(), "multi.wallet.priority.can.not.be.null"),
    WALLET_PRIORITY_CAN_NOT_BE_SAME(ApiResponseCode.INSUFFICIENT_BALANCE.getResponseCode(), "multi.wallet.priority.can.not.be.same"),
    INVALID_PHONE_NUMBER(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "invalid.phone.number"),
    ;

    private String responseCode;
    private String responseMessage;

}
