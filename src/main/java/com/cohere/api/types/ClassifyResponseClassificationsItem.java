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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ClassifyResponseClassificationsItem.Builder.class)
public final class ClassifyResponseClassificationsItem {
    private final String id;

    private final Optional<String> input;

    private final Optional<String> prediction;

    private final List<String> predictions;

    private final Optional<Float> confidence;

    private final List<Float> confidences;

    private final Map<String, ClassifyResponseClassificationsItemLabelsValue> labels;

    private final ClassifyResponseClassificationsItemClassificationType classificationType;

    private final Map<String, Object> additionalProperties;

    private ClassifyResponseClassificationsItem(
            String id,
            Optional<String> input,
            Optional<String> prediction,
            List<String> predictions,
            Optional<Float> confidence,
            List<Float> confidences,
            Map<String, ClassifyResponseClassificationsItemLabelsValue> labels,
            ClassifyResponseClassificationsItemClassificationType classificationType,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.input = input;
        this.prediction = prediction;
        this.predictions = predictions;
        this.confidence = confidence;
        this.confidences = confidences;
        this.labels = labels;
        this.classificationType = classificationType;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The input text that was classified
     */
    @JsonProperty("input")
    public Optional<String> getInput() {
        return input;
    }

    /**
     * @return The predicted label for the associated query (only filled for single-label models)
     */
    @JsonProperty("prediction")
    public Optional<String> getPrediction() {
        return prediction;
    }

    /**
     * @return An array containing the predicted labels for the associated query (only filled for single-label classification)
     */
    @JsonProperty("predictions")
    public List<String> getPredictions() {
        return predictions;
    }

    /**
     * @return The confidence score for the top predicted class (only filled for single-label classification)
     */
    @JsonProperty("confidence")
    public Optional<Float> getConfidence() {
        return confidence;
    }

    /**
     * @return An array containing the confidence scores of all the predictions in the same order
     */
    @JsonProperty("confidences")
    public List<Float> getConfidences() {
        return confidences;
    }

    /**
     * @return A map containing each label and its confidence score according to the classifier. All the confidence scores add up to 1 for single-label classification. For multi-label classification the label confidences are independent of each other, so they don't have to sum up to 1.
     */
    @JsonProperty("labels")
    public Map<String, ClassifyResponseClassificationsItemLabelsValue> getLabels() {
        return labels;
    }

    /**
     * @return The type of classification performed
     */
    @JsonProperty("classification_type")
    public ClassifyResponseClassificationsItemClassificationType getClassificationType() {
        return classificationType;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassifyResponseClassificationsItem
                && equalTo((ClassifyResponseClassificationsItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ClassifyResponseClassificationsItem other) {
        return id.equals(other.id)
                && input.equals(other.input)
                && prediction.equals(other.prediction)
                && predictions.equals(other.predictions)
                && confidence.equals(other.confidence)
                && confidences.equals(other.confidences)
                && labels.equals(other.labels)
                && classificationType.equals(other.classificationType);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.input,
                this.prediction,
                this.predictions,
                this.confidence,
                this.confidences,
                this.labels,
                this.classificationType);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        ClassificationTypeStage id(@NotNull String id);

        Builder from(ClassifyResponseClassificationsItem other);
    }

    public interface ClassificationTypeStage {
        _FinalStage classificationType(
                @NotNull ClassifyResponseClassificationsItemClassificationType classificationType);
    }

    public interface _FinalStage {
        ClassifyResponseClassificationsItem build();

        _FinalStage input(Optional<String> input);

        _FinalStage input(String input);

        _FinalStage prediction(Optional<String> prediction);

        _FinalStage prediction(String prediction);

        _FinalStage predictions(List<String> predictions);

        _FinalStage addPredictions(String predictions);

        _FinalStage addAllPredictions(List<String> predictions);

        _FinalStage confidence(Optional<Float> confidence);

        _FinalStage confidence(Float confidence);

        _FinalStage confidences(List<Float> confidences);

        _FinalStage addConfidences(Float confidences);

        _FinalStage addAllConfidences(List<Float> confidences);

        _FinalStage labels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels);

        _FinalStage putAllLabels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels);

        _FinalStage labels(String key, ClassifyResponseClassificationsItemLabelsValue value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, ClassificationTypeStage, _FinalStage {
        private String id;

        private ClassifyResponseClassificationsItemClassificationType classificationType;

        private Map<String, ClassifyResponseClassificationsItemLabelsValue> labels = new LinkedHashMap<>();

        private List<Float> confidences = new ArrayList<>();

        private Optional<Float> confidence = Optional.empty();

        private List<String> predictions = new ArrayList<>();

        private Optional<String> prediction = Optional.empty();

        private Optional<String> input = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ClassifyResponseClassificationsItem other) {
            id(other.getId());
            input(other.getInput());
            prediction(other.getPrediction());
            predictions(other.getPredictions());
            confidence(other.getConfidence());
            confidences(other.getConfidences());
            labels(other.getLabels());
            classificationType(other.getClassificationType());
            return this;
        }

        @java.lang.Override
        @JsonSetter("id")
        public ClassificationTypeStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The type of classification performed</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("classification_type")
        public _FinalStage classificationType(
                @NotNull ClassifyResponseClassificationsItemClassificationType classificationType) {
            this.classificationType = Objects.requireNonNull(classificationType, "classificationType must not be null");
            return this;
        }

        /**
         * <p>A map containing each label and its confidence score according to the classifier. All the confidence scores add up to 1 for single-label classification. For multi-label classification the label confidences are independent of each other, so they don't have to sum up to 1.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage labels(String key, ClassifyResponseClassificationsItemLabelsValue value) {
            this.labels.put(key, value);
            return this;
        }

        /**
         * <p>A map containing each label and its confidence score according to the classifier. All the confidence scores add up to 1 for single-label classification. For multi-label classification the label confidences are independent of each other, so they don't have to sum up to 1.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage putAllLabels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels) {
            this.labels.putAll(labels);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public _FinalStage labels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels) {
            this.labels.clear();
            this.labels.putAll(labels);
            return this;
        }

        /**
         * <p>An array containing the confidence scores of all the predictions in the same order</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllConfidences(List<Float> confidences) {
            this.confidences.addAll(confidences);
            return this;
        }

        /**
         * <p>An array containing the confidence scores of all the predictions in the same order</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addConfidences(Float confidences) {
            this.confidences.add(confidences);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "confidences", nulls = Nulls.SKIP)
        public _FinalStage confidences(List<Float> confidences) {
            this.confidences.clear();
            this.confidences.addAll(confidences);
            return this;
        }

        /**
         * <p>The confidence score for the top predicted class (only filled for single-label classification)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage confidence(Float confidence) {
            this.confidence = Optional.ofNullable(confidence);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "confidence", nulls = Nulls.SKIP)
        public _FinalStage confidence(Optional<Float> confidence) {
            this.confidence = confidence;
            return this;
        }

        /**
         * <p>An array containing the predicted labels for the associated query (only filled for single-label classification)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllPredictions(List<String> predictions) {
            this.predictions.addAll(predictions);
            return this;
        }

        /**
         * <p>An array containing the predicted labels for the associated query (only filled for single-label classification)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addPredictions(String predictions) {
            this.predictions.add(predictions);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "predictions", nulls = Nulls.SKIP)
        public _FinalStage predictions(List<String> predictions) {
            this.predictions.clear();
            this.predictions.addAll(predictions);
            return this;
        }

        /**
         * <p>The predicted label for the associated query (only filled for single-label models)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage prediction(String prediction) {
            this.prediction = Optional.ofNullable(prediction);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "prediction", nulls = Nulls.SKIP)
        public _FinalStage prediction(Optional<String> prediction) {
            this.prediction = prediction;
            return this;
        }

        /**
         * <p>The input text that was classified</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage input(String input) {
            this.input = Optional.ofNullable(input);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "input", nulls = Nulls.SKIP)
        public _FinalStage input(Optional<String> input) {
            this.input = input;
            return this;
        }

        @java.lang.Override
        public ClassifyResponseClassificationsItem build() {
            return new ClassifyResponseClassificationsItem(
                    id,
                    input,
                    prediction,
                    predictions,
                    confidence,
                    confidences,
                    labels,
                    classificationType,
                    additionalProperties);
        }
    }
}
