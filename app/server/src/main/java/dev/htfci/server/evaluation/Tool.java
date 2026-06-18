package dev.htfci.server.evaluation;

/*
•	name: unique identifier for the tool (e.g., calculate_tax or search_database).
•	description: clear explanation of what the tool does. The LLM uses this to decide when to call the tool.
•	arguments: input arguments the tool expects, usually defined as a schema object. (Often a JSON Schema representation)
 */

import java.util.Map;

public record Tool(String name, String description, Map<String, String> arguments, StatusType status) {

    public enum StatusType {
        SUCCESS,
        FAILURE,
        TIMEOUT
    }
}
