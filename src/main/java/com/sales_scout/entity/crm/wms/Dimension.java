package com.sales_scout.entity.crm.wms;

import com.sales_scout.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dimensions")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Dimension extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lang;

    private Double large;

    private Double height;

    private Double weight;

    private Double volume;

    @OneToMany(mappedBy = "dimension", cascade = CascadeType.ALL)
    private Set<StockedItem> stockedItems;
}
