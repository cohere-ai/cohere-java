/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.resources.v2.types.V2EmbedRequestTruncate;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = V2EmbedRequest.Builder.class)
public final class V2EmbedRequest {
    private final Optional<List<String>> texts;

    private final Optional<List<String>> images;

    private final String model;

    private final EmbedInputType inputType;

    private final List<EmbeddingType> embeddingTypes;

    private final Optional<V2EmbedRequestTruncate> truncate;

    private final Map<String, Object> additionalProperties;

    private V2EmbedRequest(
            Optional<List<String>> texts,
            Optional<List<String>> images,
            String model,
            EmbedInputType inputType,
            List<EmbeddingType> embeddingTypes,
            Optional<V2EmbedRequestTruncate> truncate,
            Map<String, Object> additionalProperties) {
        this.texts = texts;
        this.images = images;
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
    public Optional<List<String>> getTexts() {
        return texts;
    }

    /**
     * @return An array of image data URIs for the model to embed. Maximum number of images per call is <code>1</code>.
     * <p>The image must be a valid <a href="https://developer.mozilla.org/en-US/docs/Web/URI/Schemes/data">data URI</a>. The image must be in either <code>image/jpeg</code> or <code>image/png</code> format and has a maximum size of 5MB.</p>
     */
    @JsonProperty("images")
    public Optional<List<String>> getImages() {
        return images;
    }

    /**
     * @return Defaults to embed-english-v2.0
     * <p>The identifier of the model. Smaller &quot;light&quot; models are faster, while larger models will perform better. <a href="https://docs.cohere.com/docs/training-custom-models">Custom models</a> can also be supplied with their full ID.</p>
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
    public String getModel() {
        return model;
    }

    @JsonProperty("input_type")
    public EmbedInputType getInputType() {
        return inputType;
    }

    /**
     * @return Specifies the types of embeddings you want to get back. Can be one or more of the following types.
     * <ul>
     * <li><code>&quot;float&quot;</code>: Use this when you want to get back the default float embeddings. Valid for all models.</li>
     * <li><code>&quot;int8&quot;</code>: Use this when you want to get back signed int8 embeddings. Valid for only v3 models.</li>
     * <li><code>&quot;uint8&quot;</code>: Use this when you want to get back unsigned int8 embeddings. Valid for only v3 models.</li>
     * <li><code>&quot;binary&quot;</code>: Use this when you want to get back signed binary embeddings. Valid for only v3 models.</li>
     * <li><code>&quot;ubinary&quot;</code>: Use this when you want to get back unsigned binary embeddings. Valid for only v3 models.</li>
     * </ul>
     */
    @JsonProperty("embedding_types")
    public List<EmbeddingType> getEmbeddingTypes() {
        return embeddingTypes;
    }

    /**
     * @return One of <code>NONE|START|END</code> to specify how the API will handle inputs longer than the maximum token length.
     * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
     * <p>If <code>NONE</code> is selected, when the input exceeds the maximum input token length an error will be returned.</p>
     */
    @JsonProperty("truncate")
    public Optional<V2EmbedRequestTruncate> getTruncate() {
        return truncate;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2EmbedRequest && equalTo((V2EmbedRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2EmbedRequest other) {
        return texts.equals(other.texts)
                && images.equals(other.images)
                && model.equals(other.model)
                && inputType.equals(other.inputType)
                && embeddingTypes.equals(other.embeddingTypes)
                && truncate.equals(other.truncate);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.texts, this.images, this.model, this.inputType, this.embeddingTypes, this.truncate);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        InputTypeStage model(@NotNull String model);

        Builder from(V2EmbedRequest other);
    }

    public interface InputTypeStage {
        _FinalStage inputType(@NotNull EmbedInputType inputType);
    }

    public interface _FinalStage {
        V2EmbedRequest build();

        _FinalStage texts(Optional<List<String>> texts);

        _FinalStage texts(List<String> texts);

        _FinalStage images(Optional<List<String>> images);

        _FinalStage images(List<String> images);

        _FinalStage embeddingTypes(List<EmbeddingType> embeddingTypes);

        _FinalStage addEmbeddingTypes(EmbeddingType embeddingTypes);

        _FinalStage addAllEmbeddingTypes(List<EmbeddingType> embeddingTypes);

        _FinalStage truncate(Optional<V2EmbedRequestTruncate> truncate);

        _FinalStage truncate(V2EmbedRequestTruncate truncate);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, InputTypeStage, _FinalStage {
        private String model;

        private EmbedInputType inputType;

        private Optional<V2EmbedRequestTruncate> truncate = Optional.empty();

        private List<EmbeddingType> embeddingTypes = new ArrayList<>();

        private Optional<List<String>> images = Optional.empty();

        private Optional<List<String>> texts = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(V2EmbedRequest other) {
            texts(other.getTexts());
            images(other.getImages());
            model(other.getModel());
            inputType(other.getInputType());
            embeddingTypes(other.getEmbeddingTypes());
            truncate(other.getTruncate());
            return this;
        }

        /**
         * <p>Defaults to embed-english-v2.0</p>
         * <p>The identifier of the model. Smaller &quot;light&quot; models are faster, while larger models will perform better. <a href="https://docs.cohere.com/docs/training-custom-models">Custom models</a> can also be supplied with their full ID.</p>
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
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("model")
        public InputTypeStage model(@NotNull String model) {
            this.model = Objects.requireNonNull(model, "model must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("input_type")
        public _FinalStage inputType(@NotNull EmbedInputType inputType) {
            this.inputType = Objects.requireNonNull(inputType, "inputType must not be null");
            return this;
        }

        /**
         * <p>One of <code>NONE|START|END</code> to specify how the API will handle inputs longer than the maximum token length.</p>
         * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
         * <p>If <code>NONE</code> is selected, when the input exceeds the maximum input token length an error will be returned.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage truncate(V2EmbedRequestTruncate truncate) {
            this.truncate = Optional.ofNullable(truncate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "truncate", nulls = Nulls.SKIP)
        public _FinalStage truncate(Optional<V2EmbedRequestTruncate> truncate) {
            this.truncate = truncate;
            return this;
        }

        /**
         * <p>Specifies the types of embeddings you want to get back. Can be one or more of the following types.</p>
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
        public _FinalStage addAllEmbeddingTypes(List<EmbeddingType> embeddingTypes) {
            this.embeddingTypes.addAll(embeddingTypes);
            return this;
        }

        /**
         * <p>Specifies the types of embeddings you want to get back. Can be one or more of the following types.</p>
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
        public _FinalStage addEmbeddingTypes(EmbeddingType embeddingTypes) {
            this.embeddingTypes.add(embeddingTypes);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "embedding_types", nulls = Nulls.SKIP)
        public _FinalStage embeddingTypes(List<EmbeddingType> embeddingTypes) {
            this.embeddingTypes.clear();
            this.embeddingTypes.addAll(embeddingTypes);
            return this;
        }

        /**
         * <p>An array of image data URIs for the model to embed. Maximum number of images per call is <code>1</code>.</p>
         * <p>The image must be a valid <a href="https://developer.mozilla.org/en-US/docs/Web/URI/Schemes/data">data URI</a>. The image must be in either <code>image/jpeg</code> or <code>image/png</code> format and has a maximum size of 5MB.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage images(List<String> images) {
            this.images = Optional.ofNullable(images);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "images", nulls = Nulls.SKIP)
        public _FinalStage images(Optional<List<String>> images) {
            this.images = images;
            return this;
        }

        /**
         * <p>An array of strings for the model to embed. Maximum number of texts per call is <code>96</code>. We recommend reducing the length of each text to be under <code>512</code> tokens for optimal quality.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage texts(List<String> texts) {
            this.texts = Optional.ofNullable(texts);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "texts", nulls = Nulls.SKIP)
        public _FinalStage texts(Optional<List<String>> texts) {
            this.texts = texts;
            return this;
        }

        @java.lang.Override
        public V2EmbedRequest build() {
            return new V2EmbedRequest(texts, images, model, inputType, embeddingTypes, truncate, additionalProperties);
        }
    }
}
