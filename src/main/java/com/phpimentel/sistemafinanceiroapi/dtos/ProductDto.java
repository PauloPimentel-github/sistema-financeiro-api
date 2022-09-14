package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private UUID id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private Integer inventory;

    @NotBlank
    private BigDecimal purchaseValue;

    @NotBlank
    private BigDecimal saleValue;

    private String photo;
}
