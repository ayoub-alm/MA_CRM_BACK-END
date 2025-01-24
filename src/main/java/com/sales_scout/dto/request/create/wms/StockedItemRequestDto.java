package com.sales_scout.dto.request.create.wms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockedItemRequestDto {

    private Long supportId;
    private Long structureId;
    private Long stackedLevel;
    private Long temperatureId;
//    private Boolean isFragile;
    private Integer uvc;
    private Integer uc;
    private Integer numberOfPackages;
    private double height;
    private double larger;
    private double weight;
    private double length;
    private Double price;
    private List<ProvisionRequestDto> provisions;
}