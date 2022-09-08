package com.phpimentel.sistemafinanceiroapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.enums.UserStatus;
import com.phpimentel.sistemafinanceiroapi.enums.UserType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private UUID id;

    @Size(min = 4, max = 50)
    @NotBlank
    private String username;

    @Size(min = 11, max = 11)
    @NotBlank
    private String cpf;

    @Email
    @NotBlank
    private String email;

    @Size(min = 6, max = 20)
    @NotBlank
    private String password;

    @Size(min = 6, max = 20)
    @NotBlank
    private String oldPassword;

    private String fullName;
    private String phoneNumber;
    private UserStatus userStatus;
    private UserType userType;
    private String imageUrl;
}
