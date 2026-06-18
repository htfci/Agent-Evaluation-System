package dev.htfci.server.evaluation;

/*
    todo: Include TokenUsage record type as a third parameter in RunOutput
 */

import jakarta.validation.constraints.NotNull;

public record RunOutput(@NotNull String response) {}

