package com.mhk.eosb_validation_error_handling.company.management.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private String responseCode;
    private String responseMessage;
    private T data;
}