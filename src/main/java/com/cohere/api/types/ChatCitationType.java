/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatCitationType {
    TEXT_CONTENT("TEXT_CONTENT"),

    PLAN("PLAN");

    private final String value;

    ChatCitationType(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
