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
@JsonDeserialize(builder = ChatRequestConnectorsSearchOptions.Builder.class)
public final class ChatRequestConnectorsSearchOptions {
    private final Optional<Integer> seed;

    private final Map<String, Object> additionalProperties;

    private ChatRequestConnectorsSearchOptions(Optional<Integer> seed, Map<String, Object> additionalProperties) {
        this.seed = seed;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return If specified, the backend will make a best effort to sample tokens
     * deterministically, such that repeated requests with the same
     * seed and parameters should return the same result. However,
     * determinism cannot be totally guaranteed.
     * Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
     */
    @JsonProperty("seed")
    public Optional<Integer> getSeed() {
        return seed;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatRequestConnectorsSearchOptions
                && equalTo((ChatRequestConnectorsSearchOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatRequestConnectorsSearchOptions other) {
        return seed.equals(other.seed);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.seed);
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
        private Optional<Integer> seed = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatRequestConnectorsSearchOptions other) {
            seed(other.getSeed());
            return this;
        }

        @JsonSetter(value = "seed", nulls = Nulls.SKIP)
        public Builder seed(Optional<Integer> seed) {
            this.seed = seed;
            return this;
        }

        public Builder seed(Integer seed) {
            this.seed = Optional.of(seed);
            return this;
        }

        public ChatRequestConnectorsSearchOptions build() {
            return new ChatRequestConnectorsSearchOptions(seed, additionalProperties);
        }
    }
}
