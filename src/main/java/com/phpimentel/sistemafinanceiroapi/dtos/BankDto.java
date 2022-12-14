package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankDto {

    private UUID id;

    @NotBlank
    private String name;

    private OffsetDateTime creationDate;
    private OffsetDateTime lastUpdateDate;
}
