package com.sales_scout.dto.request.create.wms;

import com.sales_scout.enums.crm.DiscountTypeEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
@Builder
public class ProvisionRequestDto {
    private Long id;
    private String name;
    private String ref;
    private Double initPrice;
    private DiscountTypeEnum discountType;
    private Double discountValue;
    private Double salesPrice;
    private String unitOfMeasurement;
    private String notes;
    private Long companyId;
}
