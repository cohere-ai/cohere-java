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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ChatToolPlanDeltaEventDelta.Builder.class)
public final class ChatToolPlanDeltaEventDelta {
    private final Optional<ChatToolPlanDeltaEventDeltaMessage> message;

    private final Map<String, Object> additionalProperties;

    private ChatToolPlanDeltaEventDelta(
            Optional<ChatToolPlanDeltaEventDeltaMessage> message, Map<String, Object> additionalProperties) {
        this.message = message;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("message")
    public Optional<ChatToolPlanDeltaEventDeltaMessage> getMessage() {
        return message;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolPlanDeltaEventDelta && equalTo((ChatToolPlanDeltaEventDelta) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolPlanDeltaEventDelta other) {
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
        private Optional<ChatToolPlanDeltaEventDeltaMessage> message = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolPlanDeltaEventDelta other) {
            message(other.getMessage());
            return this;
        }

        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public Builder message(Optional<ChatToolPlanDeltaEventDeltaMessage> message) {
            this.message = message;
            return this;
        }

        public Builder message(ChatToolPlanDeltaEventDeltaMessage message) {
            this.message = Optional.ofNullable(message);
            return this;
        }

        public ChatToolPlanDeltaEventDelta build() {
            return new ChatToolPlanDeltaEventDelta(message, additionalProperties);
        }
    }
}
