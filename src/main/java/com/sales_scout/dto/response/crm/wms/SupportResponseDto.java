package com.sales_scout.dto.response.crm.wms;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter @Setter
public class SupportResponseDto {
    private Long id;
    private String name;
    private String ref;
}
