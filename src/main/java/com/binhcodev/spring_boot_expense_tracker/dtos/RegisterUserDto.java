package com.binhcodev.spring_boot_expense_tracker.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserDto {
    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;
    @NotBlank(message = "Full name is required")
    private String fullName;
    @NotBlank(message = "Password is required")
    private String password;
}
