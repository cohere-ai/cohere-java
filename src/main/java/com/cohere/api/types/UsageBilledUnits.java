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
@JsonDeserialize(builder = UsageBilledUnits.Builder.class)
public final class UsageBilledUnits {
    private final Optional<Double> inputTokens;

    private final Optional<Double> outputTokens;

    private final Optional<Double> searchUnits;

    private final Optional<Double> classifications;

    private final Map<String, Object> additionalProperties;

    private UsageBilledUnits(
            Optional<Double> inputTokens,
            Optional<Double> outputTokens,
            Optional<Double> searchUnits,
            Optional<Double> classifications,
            Map<String, Object> additionalProperties) {
        this.inputTokens = inputTokens;
        this.outputTokens = outputTokens;
        this.searchUnits = searchUnits;
        this.classifications = classifications;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The number of billed input tokens.
     */
    @JsonProperty("input_tokens")
    public Optional<Double> getInputTokens() {
        return inputTokens;
    }

    /**
     * @return The number of billed output tokens.
     */
    @JsonProperty("output_tokens")
    public Optional<Double> getOutputTokens() {
        return outputTokens;
    }

    /**
     * @return The number of billed search units.
     */
    @JsonProperty("search_units")
    public Optional<Double> getSearchUnits() {
        return searchUnits;
    }

    /**
     * @return The number of billed classifications units.
     */
    @JsonProperty("classifications")
    public Optional<Double> getClassifications() {
        return classifications;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsageBilledUnits && equalTo((UsageBilledUnits) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UsageBilledUnits other) {
        return inputTokens.equals(other.inputTokens)
                && outputTokens.equals(other.outputTokens)
                && searchUnits.equals(other.searchUnits)
                && classifications.equals(other.classifications);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.inputTokens, this.outputTokens, this.searchUnits, this.classifications);
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

        private Optional<Double> searchUnits = Optional.empty();

        private Optional<Double> classifications = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UsageBilledUnits other) {
            inputTokens(other.getInputTokens());
            outputTokens(other.getOutputTokens());
            searchUnits(other.getSearchUnits());
            classifications(other.getClassifications());
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

        @JsonSetter(value = "search_units", nulls = Nulls.SKIP)
        public Builder searchUnits(Optional<Double> searchUnits) {
            this.searchUnits = searchUnits;
            return this;
        }

        public Builder searchUnits(Double searchUnits) {
            this.searchUnits = Optional.ofNullable(searchUnits);
            return this;
        }

        @JsonSetter(value = "classifications", nulls = Nulls.SKIP)
        public Builder classifications(Optional<Double> classifications) {
            this.classifications = classifications;
            return this;
        }

        public Builder classifications(Double classifications) {
            this.classifications = Optional.ofNullable(classifications);
            return this;
        }

        public UsageBilledUnits build() {
            return new UsageBilledUnits(inputTokens, outputTokens, searchUnits, classifications, additionalProperties);
        }
    }
}
