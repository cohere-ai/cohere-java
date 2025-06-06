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
@JsonDeserialize(builder = UsageTokens.Builder.class)
public final class UsageTokens {
    private final Optional<Double> inputTokens;

    private final Optional<Double> outputTokens;

    private final Map<String, Object> additionalProperties;

    private UsageTokens(
            Optional<Double> inputTokens, Optional<Double> outputTokens, Map<String, Object> additionalProperties) {
        this.inputTokens = inputTokens;
        this.outputTokens = outputTokens;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The number of tokens used as input to the model.
     */
    @JsonProperty("input_tokens")
    public Optional<Double> getInputTokens() {
        return inputTokens;
    }

    /**
     * @return The number of tokens produced by the model.
     */
    @JsonProperty("output_tokens")
    public Optional<Double> getOutputTokens() {
        return outputTokens;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsageTokens && equalTo((UsageTokens) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UsageTokens other) {
        return inputTokens.equals(other.inputTokens) && outputTokens.equals(other.outputTokens);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.inputTokens, this.outputTokens);
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
        private Optional<Double> inputTokens = Optional.empty();

        private Optional<Double> outputTokens = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UsageTokens other) {
            inputTokens(other.getInputTokens());
            outputTokens(other.getOutputTokens());
            return this;
        }

        @JsonSetter(value = "input_tokens", nulls = Nulls.SKIP)
        public Builder inputTokens(Optional<Double> inputTokens) {
            this.inputTokens = inputTokens;
            return this;
        }

        public Builder inputTokens(Double inputTokens) {
            this.inputTokens = Optional.ofNullable(inputTokens);
            return this;
        }

        @JsonSetter(value = "output_tokens", nulls = Nulls.SKIP)
        public Builder outputTokens(Optional<Double> outputTokens) {
            this.outputTokens = outputTokens;
            return this;
        }

        public Builder outputTokens(Double outputTokens) {
            this.outputTokens = Optional.ofNullable(outputTokens);
            return this;
        }

        public UsageTokens build() {
            return new UsageTokens(inputTokens, outputTokens, additionalProperties);
        }
    }
}
