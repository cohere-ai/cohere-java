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
@JsonDeserialize(builder = ChatDebugEvent.Builder.class)
public final class ChatDebugEvent implements IChatStreamEvent {
    private final Optional<String> prompt;

    private final Map<String, Object> additionalProperties;

    private ChatDebugEvent(Optional<String> prompt, Map<String, Object> additionalProperties) {
        this.prompt = prompt;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("prompt")
    public Optional<String> getPrompt() {
        return prompt;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatDebugEvent && equalTo((ChatDebugEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatDebugEvent other) {
        return prompt.equals(other.prompt);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.prompt);
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
        private Optional<String> prompt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatDebugEvent other) {
            prompt(other.getPrompt());
            return this;
        }

        @JsonSetter(value = "prompt", nulls = Nulls.SKIP)
        public Builder prompt(Optional<String> prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder prompt(String prompt) {
            this.prompt = Optional.of(prompt);
            return this;
        }

        public ChatDebugEvent build() {
            return new ChatDebugEvent(prompt, additionalProperties);
        }
    }
}