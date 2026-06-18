package dev.htfci.server.evaluation;

import jakarta.validation.constraints.NotNull;

public record RunInput(@NotNull String query, @NotNull String context) {}
