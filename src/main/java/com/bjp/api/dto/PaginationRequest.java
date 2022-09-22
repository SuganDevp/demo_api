package com.bjp.api.dto;

import lombok.*;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PaginationRequest {
    private int pageSize;
    private int dataSize;
    private Sort.Direction sort;
}
