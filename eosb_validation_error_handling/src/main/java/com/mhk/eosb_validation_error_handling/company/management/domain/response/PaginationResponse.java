package com.mhk.eosb_validation_error_handling.company.management.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponse<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Long totalItems;
    private Integer totalPages;
    private List<T> data;
}
