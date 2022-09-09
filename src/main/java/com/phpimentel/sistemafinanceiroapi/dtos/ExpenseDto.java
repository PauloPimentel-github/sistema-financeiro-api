package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpenseDto {

    private UUID id;

    @NotBlank
    private String name;
}
