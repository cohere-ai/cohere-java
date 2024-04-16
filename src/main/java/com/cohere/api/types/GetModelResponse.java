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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetModelResponse.Builder.class)
public final class GetModelResponse {
    private final Optional<String> name;

    private final Optional<List<CompatibleEndpoint>> endpoints;

    private final Optional<Boolean> finetuned;

    private final Optional<Double> contextLength;

    private final Optional<String> tokenizerUrl;

    private final Optional<List<CompatibleEndpoint>> defaultEndpoints;

    private final Map<String, Object> additionalProperties;

    private GetModelResponse(
            Optional<String> name,
            Optional<List<CompatibleEndpoint>> endpoints,
            Optional<Boolean> finetuned,
            Optional<Double> contextLength,
            Optional<String> tokenizerUrl,
            Optional<List<CompatibleEndpoint>> defaultEndpoints,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.endpoints = endpoints;
        this.finetuned = finetuned;
        this.contextLength = contextLength;
        this.tokenizerUrl = tokenizerUrl;
        this.defaultEndpoints = defaultEndpoints;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Specify this name in the <code>model</code> parameter of API requests to use your chosen model.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The API endpoints that the model is compatible with.
     */
    @JsonProperty("endpoints")
    public Optional<List<CompatibleEndpoint>> getEndpoints() {
        return endpoints;
    }

    /**
     * @return Whether the model has been fine-tuned or not.
     */
    @JsonProperty("finetuned")
    public Optional<Boolean> getFinetuned() {
        return finetuned;
    }

    /**
     * @return The maximum number of tokens that the model can process in a single request. Note that not all of these tokens are always available due to special tokens and preambles that Cohere has added by default.
     */
    @JsonProperty("context_length")
    public Optional<Double> getContextLength() {
        return contextLength;
    }

    /**
     * @return Public URL to the tokenizer's configuration file.
     */
    @JsonProperty("tokenizer_url")
    public Optional<String> getTokenizerUrl() {
        return tokenizerUrl;
    }

    /**
     * @return The API endpoints that the model is default to.
     */
    @JsonProperty("default_endpoints")
    public Optional<List<CompatibleEndpoint>> getDefaultEndpoints() {
        return defaultEndpoints;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetModelResponse && equalTo((GetModelResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetModelResponse other) {
        return name.equals(other.name)
                && endpoints.equals(other.endpoints)
                && finetuned.equals(other.finetuned)
                && contextLength.equals(other.contextLength)
                && tokenizerUrl.equals(other.tokenizerUrl)
                && defaultEndpoints.equals(other.defaultEndpoints);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.endpoints,
                this.finetuned,
                this.contextLength,
                this.tokenizerUrl,
                this.defaultEndpoints);
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
        private Optional<String> name = Optional.empty();

        private Optional<List<CompatibleEndpoint>> endpoints = Optional.empty();

        private Optional<Boolean> finetuned = Optional.empty();

        private Optional<Double> contextLength = Optional.empty();

        private Optional<String> tokenizerUrl = Optional.empty();

        private Optional<List<CompatibleEndpoint>> defaultEndpoints = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetModelResponse other) {
            name(other.getName());
            endpoints(other.getEndpoints());
            finetuned(other.getFinetuned());
            contextLength(other.getContextLength());
            tokenizerUrl(other.getTokenizerUrl());
            defaultEndpoints(other.getDefaultEndpoints());
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "endpoints", nulls = Nulls.SKIP)
        public Builder endpoints(Optional<List<CompatibleEndpoint>> endpoints) {
            this.endpoints = endpoints;
            return this;
        }

        public Builder endpoints(List<CompatibleEndpoint> endpoints) {
            this.endpoints = Optional.of(endpoints);
            return this;
        }

        @JsonSetter(value = "finetuned", nulls = Nulls.SKIP)
        public Builder finetuned(Optional<Boolean> finetuned) {
            this.finetuned = finetuned;
            return this;
        }

        public Builder finetuned(Boolean finetuned) {
            this.finetuned = Optional.of(finetuned);
            return this;
        }

        @JsonSetter(value = "context_length", nulls = Nulls.SKIP)
        public Builder contextLength(Optional<Double> contextLength) {
            this.contextLength = contextLength;
            return this;
        }

        public Builder contextLength(Double contextLength) {
            this.contextLength = Optional.of(contextLength);
            return this;
        }

        @JsonSetter(value = "tokenizer_url", nulls = Nulls.SKIP)
        public Builder tokenizerUrl(Optional<String> tokenizerUrl) {
            this.tokenizerUrl = tokenizerUrl;
            return this;
        }

        public Builder tokenizerUrl(String tokenizerUrl) {
            this.tokenizerUrl = Optional.of(tokenizerUrl);
            return this;
        }

        @JsonSetter(value = "default_endpoints", nulls = Nulls.SKIP)
        public Builder defaultEndpoints(Optional<List<CompatibleEndpoint>> defaultEndpoints) {
            this.defaultEndpoints = defaultEndpoints;
            return this;
        }

        public Builder defaultEndpoints(List<CompatibleEndpoint> defaultEndpoints) {
            this.defaultEndpoints = Optional.of(defaultEndpoints);
            return this;
        }

        public GetModelResponse build() {
            return new GetModelResponse(
                    name, endpoints, finetuned, contextLength, tokenizerUrl, defaultEndpoints, additionalProperties);
        }
    }
}
