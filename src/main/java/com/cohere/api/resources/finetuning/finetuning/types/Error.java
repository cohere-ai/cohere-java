/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.finetuning.finetuning.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Error.Builder.class)
public final class Error {
    private final Optional<String> message;

    private final Map<String, Object> additionalProperties;

    private Error(Optional<String> message, Map<String, Object> additionalProperties) {
        this.message = message;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A developer-facing error message.
     */
    @JsonProperty("message")
    public Optional<String> getMessage() {
        return message;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Error && equalTo((Error) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Error other) {
        return message.equals(other.message);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.message);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> message = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Error other) {
            message(other.getMessage());
            return this;
        }

        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public Builder message(Optional<String> message) {
            this.message = message;
            return this;
        }

        public Builder message(String message) {
            this.message = Optional.of(message);
            return this;
        }

        public Error build() {
            return new Error(message, additionalProperties);
        }
    }
}