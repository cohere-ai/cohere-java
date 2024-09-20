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
@JsonDeserialize(builder = ChatToolCallStartEvent.Builder.class)
public final class ChatToolCallStartEvent implements IChatStreamEventType {
    private final Optional<Integer> index;

    private final Optional<ChatToolCallStartEventDelta> delta;

    private final Map<String, Object> additionalProperties;

    private ChatToolCallStartEvent(
            Optional<Integer> index,
            Optional<ChatToolCallStartEventDelta> delta,
            Map<String, Object> additionalProperties) {
        this.index = index;
        this.delta = delta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("index")
    public Optional<Integer> getIndex() {
        return index;
    }

    @JsonProperty("delta")
    public Optional<ChatToolCallStartEventDelta> getDelta() {
        return delta;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatToolCallStartEvent && equalTo((ChatToolCallStartEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatToolCallStartEvent other) {
        return index.equals(other.index) && delta.equals(other.delta);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.index, this.delta);
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
        private Optional<Integer> index = Optional.empty();

        private Optional<ChatToolCallStartEventDelta> delta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatToolCallStartEvent other) {
            index(other.getIndex());
            delta(other.getDelta());
            return this;
        }

        @JsonSetter(value = "index", nulls = Nulls.SKIP)
        public Builder index(Optional<Integer> index) {
            this.index = index;
            return this;
        }

        public Builder index(Integer index) {
            this.index = Optional.of(index);
            return this;
        }

        @JsonSetter(value = "delta", nulls = Nulls.SKIP)
        public Builder delta(Optional<ChatToolCallStartEventDelta> delta) {
            this.delta = delta;
            return this;
        }

        public Builder delta(ChatToolCallStartEventDelta delta) {
            this.delta = Optional.of(delta);
            return this;
        }

        public ChatToolCallStartEvent build() {
            return new ChatToolCallStartEvent(index, delta, additionalProperties);
        }
    }
}