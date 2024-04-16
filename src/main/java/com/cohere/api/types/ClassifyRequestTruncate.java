/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClassifyRequestTruncate {
    NONE("NONE"),

    START("START"),

    END("END");

    private final String value;

    ClassifyRequestTruncate(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
