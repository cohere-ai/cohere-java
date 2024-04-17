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
@JsonDeserialize(builder = RerankerDataMetrics.Builder.class)
public final class RerankerDataMetrics {
    private final Optional<String> numTrainQueries;

    private final Optional<String> numTrainRelevantPassages;

    private final Optional<String> numTrainHardNegatives;

    private final Optional<String> numEvalQueries;

    private final Optional<String> numEvalRelevantPassages;

    private final Optional<String> numEvalHardNegatives;

    private final Map<String, Object> additionalProperties;

    private RerankerDataMetrics(
            Optional<String> numTrainQueries,
            Optional<String> numTrainRelevantPassages,
            Optional<String> numTrainHardNegatives,
            Optional<String> numEvalQueries,
            Optional<String> numEvalRelevantPassages,
            Optional<String> numEvalHardNegatives,
            Map<String, Object> additionalProperties) {
        this.numTrainQueries = numTrainQueries;
        this.numTrainRelevantPassages = numTrainRelevantPassages;
        this.numTrainHardNegatives = numTrainHardNegatives;
        this.numEvalQueries = numEvalQueries;
        this.numEvalRelevantPassages = numEvalRelevantPassages;
        this.numEvalHardNegatives = numEvalHardNegatives;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The number of training queries.
     */
    @JsonProperty("num_train_queries")
    public Optional<String> getNumTrainQueries() {
        return numTrainQueries;
    }

    /**
     * @return The sum of all relevant passages of valid training examples.
     */
    @JsonProperty("num_train_relevant_passages")
    public Optional<String> getNumTrainRelevantPassages() {
        return numTrainRelevantPassages;
    }

    /**
     * @return The sum of all hard negatives of valid training examples.
     */
    @JsonProperty("num_train_hard_negatives")
    public Optional<String> getNumTrainHardNegatives() {
        return numTrainHardNegatives;
    }

    /**
     * @return The number of evaluation queries.
     */
    @JsonProperty("num_eval_queries")
    public Optional<String> getNumEvalQueries() {
        return numEvalQueries;
    }

    /**
     * @return The sum of all relevant passages of valid eval examples.
     */
    @JsonProperty("num_eval_relevant_passages")
    public Optional<String> getNumEvalRelevantPassages() {
        return numEvalRelevantPassages;
    }

    /**
     * @return The sum of all hard negatives of valid eval examples.
     */
    @JsonProperty("num_eval_hard_negatives")
    public Optional<String> getNumEvalHardNegatives() {
        return numEvalHardNegatives;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RerankerDataMetrics && equalTo((RerankerDataMetrics) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RerankerDataMetrics other) {
        return numTrainQueries.equals(other.numTrainQueries)
                && numTrainRelevantPassages.equals(other.numTrainRelevantPassages)
                && numTrainHardNegatives.equals(other.numTrainHardNegatives)
                && numEvalQueries.equals(other.numEvalQueries)
                && numEvalRelevantPassages.equals(other.numEvalRelevantPassages)
                && numEvalHardNegatives.equals(other.numEvalHardNegatives);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.numTrainQueries,
                this.numTrainRelevantPassages,
                this.numTrainHardNegatives,
                this.numEvalQueries,
                this.numEvalRelevantPassages,
                this.numEvalHardNegatives);
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
        private Optional<String> numTrainQueries = Optional.empty();

        private Optional<String> numTrainRelevantPassages = Optional.empty();

        private Optional<String> numTrainHardNegatives = Optional.empty();

        private Optional<String> numEvalQueries = Optional.empty();

        private Optional<String> numEvalRelevantPassages = Optional.empty();

        private Optional<String> numEvalHardNegatives = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RerankerDataMetrics other) {
            numTrainQueries(other.getNumTrainQueries());
            numTrainRelevantPassages(other.getNumTrainRelevantPassages());
            numTrainHardNegatives(other.getNumTrainHardNegatives());
            numEvalQueries(other.getNumEvalQueries());
            numEvalRelevantPassages(other.getNumEvalRelevantPassages());
            numEvalHardNegatives(other.getNumEvalHardNegatives());
            return this;
        }

        @JsonSetter(value = "num_train_queries", nulls = Nulls.SKIP)
        public Builder numTrainQueries(Optional<String> numTrainQueries) {
            this.numTrainQueries = numTrainQueries;
            return this;
        }

        public Builder numTrainQueries(String numTrainQueries) {
            this.numTrainQueries = Optional.of(numTrainQueries);
            return this;
        }

        @JsonSetter(value = "num_train_relevant_passages", nulls = Nulls.SKIP)
        public Builder numTrainRelevantPassages(Optional<String> numTrainRelevantPassages) {
            this.numTrainRelevantPassages = numTrainRelevantPassages;
            return this;
        }

        public Builder numTrainRelevantPassages(String numTrainRelevantPassages) {
            this.numTrainRelevantPassages = Optional.of(numTrainRelevantPassages);
            return this;
        }

        @JsonSetter(value = "num_train_hard_negatives", nulls = Nulls.SKIP)
        public Builder numTrainHardNegatives(Optional<String> numTrainHardNegatives) {
            this.numTrainHardNegatives = numTrainHardNegatives;
            return this;
        }

        public Builder numTrainHardNegatives(String numTrainHardNegatives) {
            this.numTrainHardNegatives = Optional.of(numTrainHardNegatives);
            return this;
        }

        @JsonSetter(value = "num_eval_queries", nulls = Nulls.SKIP)
        public Builder numEvalQueries(Optional<String> numEvalQueries) {
            this.numEvalQueries = numEvalQueries;
            return this;
        }

        public Builder numEvalQueries(String numEvalQueries) {
            this.numEvalQueries = Optional.of(numEvalQueries);
            return this;
        }

        @JsonSetter(value = "num_eval_relevant_passages", nulls = Nulls.SKIP)
        public Builder numEvalRelevantPassages(Optional<String> numEvalRelevantPassages) {
            this.numEvalRelevantPassages = numEvalRelevantPassages;
            return this;
        }

        public Builder numEvalRelevantPassages(String numEvalRelevantPassages) {
            this.numEvalRelevantPassages = Optional.of(numEvalRelevantPassages);
            return this;
        }

        @JsonSetter(value = "num_eval_hard_negatives", nulls = Nulls.SKIP)
        public Builder numEvalHardNegatives(Optional<String> numEvalHardNegatives) {
            this.numEvalHardNegatives = numEvalHardNegatives;
            return this;
        }

        public Builder numEvalHardNegatives(String numEvalHardNegatives) {
            this.numEvalHardNegatives = Optional.of(numEvalHardNegatives);
            return this;
        }

        public RerankerDataMetrics build() {
            return new RerankerDataMetrics(
                    numTrainQueries,
                    numTrainRelevantPassages,
                    numTrainHardNegatives,
                    numEvalQueries,
                    numEvalRelevantPassages,
                    numEvalHardNegatives,
                    additionalProperties);
        }
    }
}
