package com.phpimentel.sistemafinanceiroapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phpimentel.sistemafinanceiroapi.dtos.ProviderDto;
import com.phpimentel.sistemafinanceiroapi.enums.Person;
import com.phpimentel.sistemafinanceiroapi.enums.ProviderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "providers")
public class ProviderModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "person", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Person person;

    @Column(name = "document", nullable = false, length = 20)
    private String document;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "provider_status", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ProviderStatus providerStatus;

    @Column(name = "bank", nullable = false, length = 50)
    private String bank;

    @Column(name = "agency", nullable = false, length = 20)
    private String agency;

    @Column(name = "account", nullable = false, length = 25)
    private String account;

    @Column(name = "observation", nullable = false, length = 100)
    private String observation;

    @CreationTimestamp
    @Column(name="creation_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private OffsetDateTime creationDate;

    @UpdateTimestamp
    @Column(name="last_update_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private OffsetDateTime lastUpdateDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<ProductModel> products;

    public ProviderDto convertToCustomerDto() {
        var providerDto = new ProviderDto();
        BeanUtils.copyProperties(this, providerDto);
        return providerDto;
    }
}
