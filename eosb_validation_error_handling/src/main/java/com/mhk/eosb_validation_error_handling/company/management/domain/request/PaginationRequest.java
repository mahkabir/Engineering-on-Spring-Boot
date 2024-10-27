package com.mhk.eosb_validation_error_handling.company.management.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaginationRequest implements Serializable{
    private Integer pageNumber = 0;
    private Integer pageSize = 10;
    private String sortBy = "id";
    private String sortOrder = "desc";
}
