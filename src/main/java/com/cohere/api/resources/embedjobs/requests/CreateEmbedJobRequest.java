/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.embedjobs.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.resources.embedjobs.types.CreateEmbedJobRequestTruncate;
import com.cohere.api.types.EmbedInputType;
import com.cohere.api.types.EmbeddingType;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateEmbedJobRequest.Builder.class)
public final class CreateEmbedJobRequest {
    private final String model;

    private final String datasetId;

    private final EmbedInputType inputType;

    private final Optional<String> name;

    private final Optional<List<EmbeddingType>> embeddingTypes;

    private final Optional<CreateEmbedJobRequestTruncate> truncate;

    private final Map<String, Object> additionalProperties;

    private CreateEmbedJobRequest(
            String model,
            String datasetId,
            EmbedInputType inputType,
            Optional<String> name,
            Optional<List<EmbeddingType>> embeddingTypes,
            Optional<CreateEmbedJobRequestTruncate> truncate,
            Map<String, Object> additionalProperties) {
        this.model = model;
        this.datasetId = datasetId;
        this.inputType = inputType;
        this.name = name;
        this.embeddingTypes = embeddingTypes;
        this.truncate = truncate;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return ID of the embedding model.
     * <p>Available models and corresponding embedding dimensions:</p>
     * <ul>
     * <li><code>embed-english-v3.0</code> : 1024</li>
     * <li><code>embed-multilingual-v3.0</code> : 1024</li>
     * <li><code>embed-english-light-v3.0</code> : 384</li>
     * <li><code>embed-multilingual-light-v3.0</code> : 384</li>
     * </ul>
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * @return ID of a <a href="https://docs.cohere.com/docs/datasets">Dataset</a>. The Dataset must be of type <code>embed-input</code> and must have a validation status <code>Validated</code>
     */
    @JsonProperty("dataset_id")
    public String getDatasetId() {
        return datasetId;
    }

    @JsonProperty("input_type")
    public EmbedInputType getInputType() {
        return inputType;
    }

    /**
     * @return The name of the embed job.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return Specifies the types of embeddings you want to get back. Not required and default is None, which returns the Embed Floats response type. Can be one or more of the following types.
     * <ul>
     * <li><code>&quot;float&quot;</code>: Use this when you want to get back the default float embeddings. Valid for all models.</li>
     * <li><code>&quot;int8&quot;</code>: Use this when you want to get back signed int8 embeddings. Valid for only v3 models.</li>
     * <li><code>&quot;uint8&quot;</code>: Use this when you want to get back unsigned int8 embeddings. Valid for only v3 models.</li>
     * <li><code>&quot;binary&quot;</code>: Use this when you want to get back signed binary embeddings. Valid for only v3 models.</li>
     * <li><code>&quot;ubinary&quot;</code>: Use this when you want to get back unsigned binary embeddings. Valid for only v3 models.</li>
     * </ul>
     */
    @JsonProperty("embedding_types")
    public Optional<List<EmbeddingType>> getEmbeddingTypes() {
        return embeddingTypes;
    }

    /**
     * @return One of <code>START|END</code> to specify how the API will handle inputs longer than the maximum token length.
     * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
     */
    @JsonProperty("truncate")
    public Optional<CreateEmbedJobRequestTruncate> getTruncate() {
        return truncate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateEmbedJobRequest && equalTo((CreateEmbedJobRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateEmbedJobRequest other) {
        return model.equals(other.model)
                && datasetId.equals(other.datasetId)
                && inputType.equals(other.inputType)
                && name.equals(other.name)
                && embeddingTypes.equals(other.embeddingTypes)
                && truncate.equals(other.truncate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.model, this.datasetId, this.inputType, this.name, this.embeddingTypes, this.truncate);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        DatasetIdStage model(@NotNull String model);

        Builder from(CreateEmbedJobRequest other);
    }

    public interface DatasetIdStage {
        InputTypeStage datasetId(@NotNull String datasetId);
    }

    public interface InputTypeStage {
        _FinalStage inputType(@NotNull EmbedInputType inputType);
    }

    public interface _FinalStage {
        CreateEmbedJobRequest build();

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        _FinalStage embeddingTypes(Optional<List<EmbeddingType>> embeddingTypes);

        _FinalStage embeddingTypes(List<EmbeddingType> embeddingTypes);

        _FinalStage truncate(Optional<CreateEmbedJobRequestTruncate> truncate);

        _FinalStage truncate(CreateEmbedJobRequestTruncate truncate);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, DatasetIdStage, InputTypeStage, _FinalStage {
        private String model;

        private String datasetId;

        private EmbedInputType inputType;

        private Optional<CreateEmbedJobRequestTruncate> truncate = Optional.empty();

        private Optional<List<EmbeddingType>> embeddingTypes = Optional.empty();

        private Optional<String> name = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateEmbedJobRequest other) {
            model(other.getModel());
            datasetId(other.getDatasetId());
            inputType(other.getInputType());
            name(other.getName());
            embeddingTypes(other.getEmbeddingTypes());
            truncate(other.getTruncate());
            return this;
        }

        /**
         * <p>ID of the embedding model.</p>
         * <p>Available models and corresponding embedding dimensions:</p>
         * <ul>
         * <li><code>embed-english-v3.0</code> : 1024</li>
         * <li><code>embed-multilingual-v3.0</code> : 1024</li>
         * <li><code>embed-english-light-v3.0</code> : 384</li>
         * <li><code>embed-multilingual-light-v3.0</code> : 384</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("model")
        public DatasetIdStage model(@NotNull String model) {
            this.model = Objects.requireNonNull(model, "model must not be null");
            return this;
        }

        /**
         * <p>ID of a <a href="https://docs.cohere.com/docs/datasets">Dataset</a>. The Dataset must be of type <code>embed-input</code> and must have a validation status <code>Validated</code></p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("dataset_id")
        public InputTypeStage datasetId(@NotNull String datasetId) {
            this.datasetId = Objects.requireNonNull(datasetId, "datasetId must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("input_type")
        public _FinalStage inputType(@NotNull EmbedInputType inputType) {
            this.inputType = Objects.requireNonNull(inputType, "inputType must not be null");
            return this;
        }

        /**
         * <p>One of <code>START|END</code> to specify how the API will handle inputs longer than the maximum token length.</p>
         * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage truncate(CreateEmbedJobRequestTruncate truncate) {
            this.truncate = Optional.ofNullable(truncate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "truncate", nulls = Nulls.SKIP)
        public _FinalStage truncate(Optional<CreateEmbedJobRequestTruncate> truncate) {
            this.truncate = truncate;
            return this;
        }

        /**
         * <p>Specifies the types of embeddings you want to get back. Not required and default is None, which returns the Embed Floats response type. Can be one or more of the following types.</p>
         * <ul>
         * <li><code>&quot;float&quot;</code>: Use this when you want to get back the default float embeddings. Valid for all models.</li>
         * <li><code>&quot;int8&quot;</code>: Use this when you want to get back signed int8 embeddings. Valid for only v3 models.</li>
         * <li><code>&quot;uint8&quot;</code>: Use this when you want to get back unsigned int8 embeddings. Valid for only v3 models.</li>
         * <li><code>&quot;binary&quot;</code>: Use this when you want to get back signed binary embeddings. Valid for only v3 models.</li>
         * <li><code>&quot;ubinary&quot;</code>: Use this when you want to get back unsigned binary embeddings. Valid for only v3 models.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage embeddingTypes(List<EmbeddingType> embeddingTypes) {
            this.embeddingTypes = Optional.ofNullable(embeddingTypes);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "embedding_types", nulls = Nulls.SKIP)
        public _FinalStage embeddingTypes(Optional<List<EmbeddingType>> embeddingTypes) {
            this.embeddingTypes = embeddingTypes;
            return this;
        }

        /**
         * <p>The name of the embed job.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        public CreateEmbedJobRequest build() {
            return new CreateEmbedJobRequest(
                    model, datasetId, inputType, name, embeddingTypes, truncate, additionalProperties);
        }
    }
}
