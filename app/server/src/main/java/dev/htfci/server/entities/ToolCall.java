package dev.htfci.server.entities;

public record ToolCall(String toolName, String args, ToolCallStatus status) {}
