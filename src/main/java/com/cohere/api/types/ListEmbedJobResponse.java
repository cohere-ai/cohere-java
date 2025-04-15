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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListEmbedJobResponse.Builder.class)
public final class ListEmbedJobResponse {
    private final Optional<List<EmbedJob>> embedJobs;

    private final Map<String, Object> additionalProperties;

    private ListEmbedJobResponse(Optional<List<EmbedJob>> embedJobs, Map<String, Object> additionalProperties) {
        this.embedJobs = embedJobs;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("embed_jobs")
    public Optional<List<EmbedJob>> getEmbedJobs() {
        return embedJobs;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListEmbedJobResponse && equalTo((ListEmbedJobResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListEmbedJobResponse other) {
        return embedJobs.equals(other.embedJobs);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.embedJobs);
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
        private Optional<List<EmbedJob>> embedJobs = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListEmbedJobResponse other) {
            embedJobs(other.getEmbedJobs());
            return this;
        }

        @JsonSetter(value = "embed_jobs", nulls = Nulls.SKIP)
        public Builder embedJobs(Optional<List<EmbedJob>> embedJobs) {
            this.embedJobs = embedJobs;
            return this;
        }

        public Builder embedJobs(List<EmbedJob> embedJobs) {
            this.embedJobs = Optional.ofNullable(embedJobs);
            return this;
        }

        public ListEmbedJobResponse build() {
            return new ListEmbedJobResponse(embedJobs, additionalProperties);
        }
    }
}
