package com.softtech.softtechspringboot.prd.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PrdProductDto {
    private String name;
    private BigDecimal price;
}
