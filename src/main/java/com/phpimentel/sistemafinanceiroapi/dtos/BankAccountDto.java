package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.enums.AccountType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankAccountDto {

    private UUID id;

    @NotBlank
    private String bank;

    @NotBlank
    private String agency;

    @NotBlank
    private String account;

    @NotBlank
    private AccountType accountType;

    private String document;
}
