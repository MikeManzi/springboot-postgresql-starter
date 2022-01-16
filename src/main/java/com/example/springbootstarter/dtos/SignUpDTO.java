package com.example.springbootstarter.dtos;

import com.example.springbootstarter.enums.EGender;
import com.example.springbootstarter.enums.ERole;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class SignUpDTO {
    @Email
    private  String email;

    @NotBlank
    private  String firstName;

    @NotBlank
    private  String lastName;

    @NotBlank
    private  String mobile;

    private EGender gender;

    private ERole role;

    private  String password;
}
