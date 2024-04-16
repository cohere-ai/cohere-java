/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatRequestPromptTruncation {
    OFF("OFF"),

    AUTO("AUTO"),

    AUTO_PRESERVE_ORDER("AUTO_PRESERVE_ORDER");

    private final String value;

    ChatRequestPromptTruncation(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
