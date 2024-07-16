/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatStreamRequestResponseFormatType {
    TEXT("text"),

    JSON_OBJECT("json_object");

    private final String value;

    ChatStreamRequestResponseFormatType(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
