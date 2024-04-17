/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmbeddingType {
    FLOAT("float"),

    INT_8("int8"),

    UINT_8("uint8"),

    BINARY("binary"),

    UBINARY("ubinary");

    private final String value;

    EmbeddingType(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
