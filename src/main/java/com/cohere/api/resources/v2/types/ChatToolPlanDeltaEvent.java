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
@JsonDeserialize(builder = ChatToolPlanDeltaEvent.Builder.class)
public final class ChatToolPlanDeltaEvent implements IChatStreamEventType {
    private final Optional<ChatToolPlanDeltaEventDelta> delta;

    private final Map<String, Object> additionalProperties;

    private ChatToolPlanDeltaEvent(
            Optional<ChatToolPlanDeltaEventDelta> delta, Map<String, Object> additionalProperties) {
        this.delta = delta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("delta")
    public Optional<ChatToolPlanDeltaEventDelta> getDelta() {
        return delta;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolPlanDeltaEvent && equalTo((ChatToolPlanDeltaEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolPlanDeltaEvent other) {
        return delta.equals(other.delta);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.delta);
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
        private Optional<ChatToolPlanDeltaEventDelta> delta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolPlanDeltaEvent other) {
            delta(other.getDelta());
            return this;
        }

        @JsonSetter(value = "delta", nulls = Nulls.SKIP)
        public Builder delta(Optional<ChatToolPlanDeltaEventDelta> delta) {
            this.delta = delta;
            return this;
        }

        public Builder delta(ChatToolPlanDeltaEventDelta delta) {
            this.delta = Optional.of(delta);
            return this;
        }

        public ChatToolPlanDeltaEvent build() {
            return new ChatToolPlanDeltaEvent(delta, additionalProperties);
        }
    }
}
