package dev.htfci.server.evaluation;

/*
    todo: Add:
        * Instant timestamp
        * executionTimeMs -> How long does LLM call took? This helps to identify slow models
        * TokenUsage record
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RunMetadata(@NotBlank String modelName, @NotNull Tool[] tools, @NotNull String systemPrompt) {}
