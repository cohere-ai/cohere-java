/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatStreamRequestCitationQuality {
    FAST("fast"),

    ACCURATE("accurate");

    private final String value;

    ChatStreamRequestCitationQuality(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
