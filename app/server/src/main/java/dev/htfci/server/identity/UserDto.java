package dev.htfci.server.identity;

import jakarta.validation.constraints.*;

record UserDto(
        @NotBlank @Size(min = 2, max = 32) String userName,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8, max = 64) String rawPassword) {}
