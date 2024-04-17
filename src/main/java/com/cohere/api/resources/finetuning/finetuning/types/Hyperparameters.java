/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.finetuning.finetuning.types;

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
@JsonDeserialize(builder = Hyperparameters.Builder.class)
public final class Hyperparameters {
    private final Optional<Integer> earlyStoppingPatience;

    private final Optional<Double> earlyStoppingThreshold;

    private final Optional<Integer> trainBatchSize;

    private final Optional<Integer> trainEpochs;

    private final Optional<Double> learningRate;

    private final Map<String, Object> additionalProperties;

    private Hyperparameters(
            Optional<Integer> earlyStoppingPatience,
            Optional<Double> earlyStoppingThreshold,
            Optional<Integer> trainBatchSize,
            Optional<Integer> trainEpochs,
            Optional<Double> learningRate,
            Map<String, Object> additionalProperties) {
        this.earlyStoppingPatience = earlyStoppingPatience;
        this.earlyStoppingThreshold = earlyStoppingThreshold;
        this.trainBatchSize = trainBatchSize;
        this.trainEpochs = trainEpochs;
        this.learningRate = learningRate;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Stops training if the loss metric does not improve beyond the value of
     * <code>early_stopping_threshold</code> after this many times of evaluation.
     */
    @JsonProperty("early_stopping_patience")
    public Optional<Integer> getEarlyStoppingPatience() {
        return earlyStoppingPatience;
    }

    /**
     * @return How much the loss must improve to prevent early stopping.
     */
    @JsonProperty("early_stopping_threshold")
    public Optional<Double> getEarlyStoppingThreshold() {
        return earlyStoppingThreshold;
    }

    /**
     * @return The batch size is the number of training examples included in a single
     * training pass.
     */
    @JsonProperty("train_batch_size")
    public Optional<Integer> getTrainBatchSize() {
        return trainBatchSize;
    }

    /**
     * @return The number of epochs to train for.
     */
    @JsonProperty("train_epochs")
    public Optional<Integer> getTrainEpochs() {
        return trainEpochs;
    }

    /**
     * @return The learning rate to be used during training.
     */
    @JsonProperty("learning_rate")
    public Optional<Double> getLearningRate() {
        return learningRate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Hyperparameters && equalTo((Hyperparameters) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Hyperparameters other) {
        return earlyStoppingPatience.equals(other.earlyStoppingPatience)
                && earlyStoppingThreshold.equals(other.earlyStoppingThreshold)
                && trainBatchSize.equals(other.trainBatchSize)
                && trainEpochs.equals(other.trainEpochs)
                && learningRate.equals(other.learningRate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.earlyStoppingPatience,
                this.earlyStoppingThreshold,
                this.trainBatchSize,
                this.trainEpochs,
                this.learningRate);
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
        private Optional<Integer> earlyStoppingPatience = Optional.empty();

        private Optional<Double> earlyStoppingThreshold = Optional.empty();

        private Optional<Integer> trainBatchSize = Optional.empty();

        private Optional<Integer> trainEpochs = Optional.empty();

        private Optional<Double> learningRate = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Hyperparameters other) {
            earlyStoppingPatience(other.getEarlyStoppingPatience());
            earlyStoppingThreshold(other.getEarlyStoppingThreshold());
            trainBatchSize(other.getTrainBatchSize());
            trainEpochs(other.getTrainEpochs());
            learningRate(other.getLearningRate());
            return this;
        }

        @JsonSetter(value = "early_stopping_patience", nulls = Nulls.SKIP)
        public Builder earlyStoppingPatience(Optional<Integer> earlyStoppingPatience) {
            this.earlyStoppingPatience = earlyStoppingPatience;
            return this;
        }

        public Builder earlyStoppingPatience(Integer earlyStoppingPatience) {
            this.earlyStoppingPatience = Optional.of(earlyStoppingPatience);
            return this;
        }

        @JsonSetter(value = "early_stopping_threshold", nulls = Nulls.SKIP)
        public Builder earlyStoppingThreshold(Optional<Double> earlyStoppingThreshold) {
            this.earlyStoppingThreshold = earlyStoppingThreshold;
            return this;
        }

        public Builder earlyStoppingThreshold(Double earlyStoppingThreshold) {
            this.earlyStoppingThreshold = Optional.of(earlyStoppingThreshold);
            return this;
        }

        @JsonSetter(value = "train_batch_size", nulls = Nulls.SKIP)
        public Builder trainBatchSize(Optional<Integer> trainBatchSize) {
            this.trainBatchSize = trainBatchSize;
            return this;
        }

        public Builder trainBatchSize(Integer trainBatchSize) {
            this.trainBatchSize = Optional.of(trainBatchSize);
            return this;
        }

        @JsonSetter(value = "train_epochs", nulls = Nulls.SKIP)
        public Builder trainEpochs(Optional<Integer> trainEpochs) {
            this.trainEpochs = trainEpochs;
            return this;
        }

        public Builder trainEpochs(Integer trainEpochs) {
            this.trainEpochs = Optional.of(trainEpochs);
            return this;
        }

        @JsonSetter(value = "learning_rate", nulls = Nulls.SKIP)
        public Builder learningRate(Optional<Double> learningRate) {
            this.learningRate = learningRate;
            return this;
        }

        public Builder learningRate(Double learningRate) {
            this.learningRate = Optional.of(learningRate);
            return this;
        }

        public Hyperparameters build() {
            return new Hyperparameters(
                    earlyStoppingPatience,
                    earlyStoppingThreshold,
                    trainBatchSize,
                    trainEpochs,
                    learningRate,
                    additionalProperties);
        }
    }
}