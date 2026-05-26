package dev.htfci.server.entities;

import java.util.List;

public record RunOutput(String response, List<ToolCall> toolCallList) {}
