package com.example.springbootstarter.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignInDTO {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
