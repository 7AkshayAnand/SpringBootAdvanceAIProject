package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotNull(message = "Email is required")
    @Email(message="Invalid email format")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min=3,message="Password must have at least 3 characters")
    private String password;
    private String firstName;
    private String lastName;
}
