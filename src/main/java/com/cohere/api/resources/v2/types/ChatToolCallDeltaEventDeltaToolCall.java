/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.types;

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
@JsonDeserialize(builder = ChatToolCallDeltaEventDeltaToolCall.Builder.class)
public final class ChatToolCallDeltaEventDeltaToolCall {
    private final Optional<ChatToolCallDeltaEventDeltaToolCallFunction> function;

    private final Map<String, Object> additionalProperties;

    private ChatToolCallDeltaEventDeltaToolCall(
            Optional<ChatToolCallDeltaEventDeltaToolCallFunction> function, Map<String, Object> additionalProperties) {
        this.function = function;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("function")
    public Optional<ChatToolCallDeltaEventDeltaToolCallFunction> getFunction() {
        return function;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolCallDeltaEventDeltaToolCall
                && equalTo((ChatToolCallDeltaEventDeltaToolCall) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolCallDeltaEventDeltaToolCall other) {
        return function.equals(other.function);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.function);
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
        private Optional<ChatToolCallDeltaEventDeltaToolCallFunction> function = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolCallDeltaEventDeltaToolCall other) {
            function(other.getFunction());
            return this;
        }

        @JsonSetter(value = "function", nulls = Nulls.SKIP)
        public Builder function(Optional<ChatToolCallDeltaEventDeltaToolCallFunction> function) {
            this.function = function;
            return this;
        }

        public Builder function(ChatToolCallDeltaEventDeltaToolCallFunction function) {
            this.function = Optional.of(function);
            return this;
        }

        public ChatToolCallDeltaEventDeltaToolCall build() {
            return new ChatToolCallDeltaEventDeltaToolCall(function, additionalProperties);
        }
    }
}
