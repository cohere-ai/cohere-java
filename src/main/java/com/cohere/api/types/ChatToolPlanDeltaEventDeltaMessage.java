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
@JsonDeserialize(builder = ChatToolPlanDeltaEventDeltaMessage.Builder.class)
public final class ChatToolPlanDeltaEventDeltaMessage {
    private final Optional<String> toolPlan;

    private final Map<String, Object> additionalProperties;

    private ChatToolPlanDeltaEventDeltaMessage(Optional<String> toolPlan, Map<String, Object> additionalProperties) {
        this.toolPlan = toolPlan;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("tool_plan")
    public Optional<String> getToolPlan() {
        return toolPlan;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolPlanDeltaEventDeltaMessage
                && equalTo((ChatToolPlanDeltaEventDeltaMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolPlanDeltaEventDeltaMessage other) {
        return toolPlan.equals(other.toolPlan);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.toolPlan);
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
        private Optional<String> toolPlan = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolPlanDeltaEventDeltaMessage other) {
            toolPlan(other.getToolPlan());
            return this;
        }

        @JsonSetter(value = "tool_plan", nulls = Nulls.SKIP)
        public Builder toolPlan(Optional<String> toolPlan) {
            this.toolPlan = toolPlan;
            return this;
        }

        public Builder toolPlan(String toolPlan) {
            this.toolPlan = Optional.of(toolPlan);
            return this;
        }

        public ChatToolPlanDeltaEventDeltaMessage build() {
            return new ChatToolPlanDeltaEventDeltaMessage(toolPlan, additionalProperties);
        }
    }
}
