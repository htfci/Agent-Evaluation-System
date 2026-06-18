package dev.htfci.server.evaluation;

/*
promptTokens      -> input tokens
completionTokens  -> output tokens from model
 */


public record TokenUsage(int promptTokens, int completionTokens, int totalTokens) {}
