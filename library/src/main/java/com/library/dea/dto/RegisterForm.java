package com.library.dea.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterForm {
    @NotBlank
    @Size(min = 4, max = 50)
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$",
            message = "Username может содержать только буквы, цифры и '_'."
    )
    private String username;
    @NotBlank
    @Size(min = 8, max = 50)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$",
            message = "Password слишком слабый! Нужны цифры, разные регистры спецзначения."
    )
    private String password;

    @NotBlank(message = "Подтвердите пароль!")
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
