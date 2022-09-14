package com.phpimentel.sistemafinanceiroapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phpimentel.sistemafinanceiroapi.dtos.ProductDto;
import com.phpimentel.sistemafinanceiroapi.enums.ProductStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "products")
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "inventory", nullable = false)
    private Integer inventory;

    @Column(name = "purchase_value", nullable = false)
    private BigDecimal purchaseValue;

    @Column(name = "sale_value", nullable = false)
    private BigDecimal saleValue;

    @Column(name = "photo", length = 250)
    private String photo;

    @Column(name = "product_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProviderModel provider;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoryProductModel categoryProduct;

    @CreationTimestamp
    @Column(name="creation_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private OffsetDateTime creationDate;

    @UpdateTimestamp
    @Column(name="last_update_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private OffsetDateTime lastUpdateDate;

    public ProductDto convertToProductDto() {
        var productDto = new ProductDto();
        BeanUtils.copyProperties(this, productDto);
        return productDto;
    }
}
