/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

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
@JsonDeserialize(builder = ChatToolCallStartEventDelta.Builder.class)
public final class ChatToolCallStartEventDelta {
    private final Optional<ChatToolCallStartEventDeltaToolCall> toolCall;

    private final Map<String, Object> additionalProperties;

    private ChatToolCallStartEventDelta(
            Optional<ChatToolCallStartEventDeltaToolCall> toolCall, Map<String, Object> additionalProperties) {
        this.toolCall = toolCall;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("tool_call")
    public Optional<ChatToolCallStartEventDeltaToolCall> getToolCall() {
        return toolCall;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolCallStartEventDelta && equalTo((ChatToolCallStartEventDelta) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolCallStartEventDelta other) {
        return toolCall.equals(other.toolCall);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.toolCall);
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
        private Optional<ChatToolCallStartEventDeltaToolCall> toolCall = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolCallStartEventDelta other) {
            toolCall(other.getToolCall());
            return this;
        }

        @JsonSetter(value = "tool_call", nulls = Nulls.SKIP)
        public Builder toolCall(Optional<ChatToolCallStartEventDeltaToolCall> toolCall) {
            this.toolCall = toolCall;
            return this;
        }

        public Builder toolCall(ChatToolCallStartEventDeltaToolCall toolCall) {
            this.toolCall = Optional.of(toolCall);
            return this;
        }

        public ChatToolCallStartEventDelta build() {
            return new ChatToolCallStartEventDelta(toolCall, additionalProperties);
        }
    }
}