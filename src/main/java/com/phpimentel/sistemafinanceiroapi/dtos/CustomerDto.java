package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.enums.CustomerStatus;
import com.phpimentel.sistemafinanceiroapi.enums.Person;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private Person person;

    @NotBlank
    private String document;

    @NotBlank
    private String telephone;

    @NotBlank
    private String address;

    @NotBlank
    private CustomerStatus customerStatus;

    @NotBlank
    private String bank;

    @NotBlank
    private String agency;

    @NotBlank
    private String account;

    @NotBlank
    private String observation;
}
