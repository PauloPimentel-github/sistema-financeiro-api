package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.enums.Person;
import com.phpimentel.sistemafinanceiroapi.enums.ProviderStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderDto {

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
    private ProviderStatus providerStatus;

    @NotBlank
    private String bank;

    @NotBlank
    private String agency;

    @NotBlank
    private String account;

    @NotBlank
    private String observation;
}
