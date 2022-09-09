package com.phpimentel.sistemafinanceiroapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.dtos.CustomerDto;
import com.phpimentel.sistemafinanceiroapi.enums.CustomerStatus;
import com.phpimentel.sistemafinanceiroapi.enums.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "users")
public class CustomerModel implements Serializable {

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

    @Column(name = "customer_status", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name = "bank", nullable = false, length = 50)
    private String bank;

    @Column(name = "agency", nullable = false, length = 10)
    private String agency;

    @Column(name = "account", nullable = false, length = 15)
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

    public CustomerDto convertToCustomerDto() {
        var customerDto = new CustomerDto();
        BeanUtils.copyProperties(this, customerDto);
        return customerDto;
    }
}
