/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatRequestSafetyMode {
    CONTEXTUAL("CONTEXTUAL"),

    STRICT("STRICT"),

    NONE("NONE");

    private final String value;

    ChatRequestSafetyMode(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}