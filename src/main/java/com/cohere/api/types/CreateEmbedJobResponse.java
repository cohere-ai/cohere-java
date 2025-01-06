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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateEmbedJobResponse.Builder.class)
public final class CreateEmbedJobResponse {
    private final String jobId;

    private final Optional<ApiMeta> meta;

    private final Map<String, Object> additionalProperties;

    private CreateEmbedJobResponse(String jobId, Optional<ApiMeta> meta, Map<String, Object> additionalProperties) {
        this.jobId = jobId;
        this.meta = meta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("job_id")
    public String getJobId() {
        return jobId;
    }

    @JsonProperty("meta")
    public Optional<ApiMeta> getMeta() {
        return meta;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateEmbedJobResponse && equalTo((CreateEmbedJobResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateEmbedJobResponse other) {
        return jobId.equals(other.jobId) && meta.equals(other.meta);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.jobId, this.meta);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static JobIdStage builder() {
        return new Builder();
    }

    public interface JobIdStage {
        _FinalStage jobId(@NotNull String jobId);

        Builder from(CreateEmbedJobResponse other);
    }

    public interface _FinalStage {
        CreateEmbedJobResponse build();

        _FinalStage meta(Optional<ApiMeta> meta);

        _FinalStage meta(ApiMeta meta);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements JobIdStage, _FinalStage {
        private String jobId;

        private Optional<ApiMeta> meta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateEmbedJobResponse other) {
            jobId(other.getJobId());
            meta(other.getMeta());
            return this;
        }

        @java.lang.Override
        @JsonSetter("job_id")
        public _FinalStage jobId(@NotNull String jobId) {
            this.jobId = Objects.requireNonNull(jobId, "jobId must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage meta(ApiMeta meta) {
            this.meta = Optional.ofNullable(meta);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<ApiMeta> meta) {
            this.meta = meta;
            return this;
        }

        @java.lang.Override
        public CreateEmbedJobResponse build() {
            return new CreateEmbedJobResponse(jobId, meta, additionalProperties);
        }
    }
}
