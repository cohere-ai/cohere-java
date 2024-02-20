/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.EmbedInputType;
import com.cohere.api.types.EmbedRequestEmbeddingTypesItem;
import com.cohere.api.types.EmbedRequestTruncate;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmbedRequest.Builder.class)
public final class EmbedRequest {
    private final List<String> texts;

    private final Optional<String> model;

    private final Optional<EmbedInputType> inputType;

    private final Optional<List<EmbedRequestEmbeddingTypesItem>> embeddingTypes;

    private final Optional<EmbedRequestTruncate> truncate;

    private final Map<String, Object> additionalProperties;

    private EmbedRequest(
            List<String> texts,
            Optional<String> model,
            Optional<EmbedInputType> inputType,
            Optional<List<EmbedRequestEmbeddingTypesItem>> embeddingTypes,
            Optional<EmbedRequestTruncate> truncate,
            Map<String, Object> additionalProperties) {
        this.texts = texts;
        this.model = model;
        this.inputType = inputType;
        this.embeddingTypes = embeddingTypes;
        this.truncate = truncate;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return An array of strings for the model to embed. Maximum number of texts per call is <code>96</code>. We recommend reducing the length of each text to be under <code>512</code> tokens for optimal quality.
     */
    @JsonProperty("texts")
    public List<String> getTexts() {
        return texts;
    }

    /**
     * @return Defaults to embed-english-v2.0
     * <p>The identifier of the model. Smaller &quot;light&quot; models are faster, while larger models will perform better. <a href="/docs/training-custom-models">Custom models</a> can also be supplied with their full ID.</p>
     * <p>Available models and corresponding embedding dimensions:</p>
     * <ul>
     * <li>
     * <p><code>embed-english-v3.0</code>  1024</p>
     * </li>
     * <li>
     * <p><code>embed-multilingual-v3.0</code>  1024</p>
     * </li>
     * <li>
     * <p><code>embed-english-light-v3.0</code>  384</p>
     * </li>
     * <li>
     * <p><code>embed-multilingual-light-v3.0</code>  384</p>
     * </li>
     * <li>
     * <p><code>embed-english-v2.0</code>  4096</p>
     * </li>
     * <li>
     * <p><code>embed-english-light-v2.0</code>  1024</p>
     * </li>
     * <li>
     * <p><code>embed-multilingual-v2.0</code>  768</p>
     * </li>
     * </ul>
     */
    @JsonProperty("model")
    public Optional<String> getModel() {
        return model;
    }

    @JsonProperty("input_type")
    public Optional<EmbedInputType> getInputType() {
        return inputType;
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
    public Optional<List<EmbedRequestEmbeddingTypesItem>> getEmbeddingTypes() {
        return embeddingTypes;
    }

    /**
     * @return One of <code>NONE|START|END</code> to specify how the API will handle inputs longer than the maximum token length.
     * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
     * <p>If <code>NONE</code> is selected, when the input exceeds the maximum input token length an error will be returned.</p>
     */
    @JsonProperty("truncate")
    public Optional<EmbedRequestTruncate> getTruncate() {
        return truncate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmbedRequest && equalTo((EmbedRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EmbedRequest other) {
        return texts.equals(other.texts)
                && model.equals(other.model)
                && inputType.equals(other.inputType)
                && embeddingTypes.equals(other.embeddingTypes)
                && truncate.equals(other.truncate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.texts, this.model, this.inputType, this.embeddingTypes, this.truncate);
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
        private List<String> texts = new ArrayList<>();

        private Optional<String> model = Optional.empty();

        private Optional<EmbedInputType> inputType = Optional.empty();

        private Optional<List<EmbedRequestEmbeddingTypesItem>> embeddingTypes = Optional.empty();

        private Optional<EmbedRequestTruncate> truncate = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(EmbedRequest other) {
            texts(other.getTexts());
            model(other.getModel());
            inputType(other.getInputType());
            embeddingTypes(other.getEmbeddingTypes());
            truncate(other.getTruncate());
            return this;
        }

        @JsonSetter(value = "texts", nulls = Nulls.SKIP)
        public Builder texts(List<String> texts) {
            this.texts.clear();
            this.texts.addAll(texts);
            return this;
        }

        public Builder addTexts(String texts) {
            this.texts.add(texts);
            return this;
        }

        public Builder addAllTexts(List<String> texts) {
            this.texts.addAll(texts);
            return this;
        }

        @JsonSetter(value = "model", nulls = Nulls.SKIP)
        public Builder model(Optional<String> model) {
            this.model = model;
            return this;
        }

        public Builder model(String model) {
            this.model = Optional.of(model);
            return this;
        }

        @JsonSetter(value = "input_type", nulls = Nulls.SKIP)
        public Builder inputType(Optional<EmbedInputType> inputType) {
            this.inputType = inputType;
            return this;
        }

        public Builder inputType(EmbedInputType inputType) {
            this.inputType = Optional.of(inputType);
            return this;
        }

        @JsonSetter(value = "embedding_types", nulls = Nulls.SKIP)
        public Builder embeddingTypes(Optional<List<EmbedRequestEmbeddingTypesItem>> embeddingTypes) {
            this.embeddingTypes = embeddingTypes;
            return this;
        }

        public Builder embeddingTypes(List<EmbedRequestEmbeddingTypesItem> embeddingTypes) {
            this.embeddingTypes = Optional.of(embeddingTypes);
            return this;
        }

        @JsonSetter(value = "truncate", nulls = Nulls.SKIP)
        public Builder truncate(Optional<EmbedRequestTruncate> truncate) {
            this.truncate = truncate;
            return this;
        }

        public Builder truncate(EmbedRequestTruncate truncate) {
            this.truncate = Optional.of(truncate);
            return this;
        }

        public EmbedRequest build() {
            return new EmbedRequest(texts, model, inputType, embeddingTypes, truncate, additionalProperties);
        }
    }
}
