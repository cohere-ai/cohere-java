/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.finetuning.requests;

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
@JsonDeserialize(builder = FinetuningListTrainingStepMetricsRequest.Builder.class)
public final class FinetuningListTrainingStepMetricsRequest {
    private final Optional<Integer> pageSize;

    private final Optional<String> pageToken;

    private final Map<String, Object> additionalProperties;

    private FinetuningListTrainingStepMetricsRequest(
            Optional<Integer> pageSize, Optional<String> pageToken, Map<String, Object> additionalProperties) {
        this.pageSize = pageSize;
        this.pageToken = pageToken;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Maximum number of results to be returned by the server. If 0, defaults to
     * 50.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return Request a specific page of the list results.
     */
    @JsonProperty("page_token")
    public Optional<String> getPageToken() {
        return pageToken;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FinetuningListTrainingStepMetricsRequest
                && equalTo((FinetuningListTrainingStepMetricsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FinetuningListTrainingStepMetricsRequest other) {
        return pageSize.equals(other.pageSize) && pageToken.equals(other.pageToken);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.pageSize, this.pageToken);
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
        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> pageToken = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FinetuningListTrainingStepMetricsRequest other) {
            pageSize(other.getPageSize());
            pageToken(other.getPageToken());
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        @JsonSetter(value = "page_token", nulls = Nulls.SKIP)
        public Builder pageToken(Optional<String> pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public Builder pageToken(String pageToken) {
            this.pageToken = Optional.ofNullable(pageToken);
            return this;
        }

        public FinetuningListTrainingStepMetricsRequest build() {
            return new FinetuningListTrainingStepMetricsRequest(pageSize, pageToken, additionalProperties);
        }
    }
}
