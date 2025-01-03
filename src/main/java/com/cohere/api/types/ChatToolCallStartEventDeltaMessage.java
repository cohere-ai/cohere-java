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
@JsonDeserialize(builder = ChatToolCallStartEventDeltaMessage.Builder.class)
public final class ChatToolCallStartEventDeltaMessage {
    private final Optional<ToolCallV2> toolCalls;

    private final Map<String, Object> additionalProperties;

    private ChatToolCallStartEventDeltaMessage(
            Optional<ToolCallV2> toolCalls, Map<String, Object> additionalProperties) {
        this.toolCalls = toolCalls;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("tool_calls")
    public Optional<ToolCallV2> getToolCalls() {
        return toolCalls;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolCallStartEventDeltaMessage
                && equalTo((ChatToolCallStartEventDeltaMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolCallStartEventDeltaMessage other) {
        return toolCalls.equals(other.toolCalls);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.toolCalls);
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
        private Optional<ToolCallV2> toolCalls = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolCallStartEventDeltaMessage other) {
            toolCalls(other.getToolCalls());
            return this;
        }

        @JsonSetter(value = "tool_calls", nulls = Nulls.SKIP)
        public Builder toolCalls(Optional<ToolCallV2> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }

        public Builder toolCalls(ToolCallV2 toolCalls) {
            this.toolCalls = Optional.of(toolCalls);
            return this;
        }

        public ChatToolCallStartEventDeltaMessage build() {
            return new ChatToolCallStartEventDeltaMessage(toolCalls, additionalProperties);
        }
    }
}
