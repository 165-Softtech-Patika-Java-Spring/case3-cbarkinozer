package com.softtech.softtechspringboot.prd.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="PRD_PRODUCT")
@Data
public class PrdProduct {
    @Id
    @SequenceGenerator(name ="PrdProduct" , sequenceName = "PRD_PRODUCT_ID_SEQ")
    @GeneratedValue(generator ="PrdProduct")
    private Long id;

    @Column(name = "NAME",length=100,nullable = false)
    private String name;

    @Column(name = "PRICE",precision = 15, scale=2,nullable = false)
    private BigDecimal price;
}
