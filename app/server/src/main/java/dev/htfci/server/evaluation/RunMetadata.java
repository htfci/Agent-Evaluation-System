package dev.htfci.server.evaluation;

/*
Add:
Instant timestamp
executionTimeMs -> How long the LLM call took. This helps to identify slow models.
TokenUsage record
 */



public record RunMetadata(String modelName) {}
