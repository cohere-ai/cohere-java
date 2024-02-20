/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.datasets.requests;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DatasetsListRequest.Builder.class)
public final class DatasetsListRequest {
    private final Optional<String> datasetType;

    private final Optional<OffsetDateTime> before;

    private final Optional<OffsetDateTime> after;

    private final Optional<String> limit;

    private final Optional<String> offset;

    private final Map<String, Object> additionalProperties;

    private DatasetsListRequest(
            Optional<String> datasetType,
            Optional<OffsetDateTime> before,
            Optional<OffsetDateTime> after,
            Optional<String> limit,
            Optional<String> offset,
            Map<String, Object> additionalProperties) {
        this.datasetType = datasetType;
        this.before = before;
        this.after = after;
        this.limit = limit;
        this.offset = offset;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return optional filter by dataset type
     */
    @JsonProperty("datasetType")
    public Optional<String> getDatasetType() {
        return datasetType;
    }

    /**
     * @return optional filter before a date
     */
    @JsonProperty("before")
    public Optional<OffsetDateTime> getBefore() {
        return before;
    }

    /**
     * @return optional filter after a date
     */
    @JsonProperty("after")
    public Optional<OffsetDateTime> getAfter() {
        return after;
    }

    /**
     * @return optional limit to number of results
     */
    @JsonProperty("limit")
    public Optional<String> getLimit() {
        return limit;
    }

    /**
     * @return optional offset to start of results
     */
    @JsonProperty("offset")
    public Optional<String> getOffset() {
        return offset;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DatasetsListRequest && equalTo((DatasetsListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DatasetsListRequest other) {
        return datasetType.equals(other.datasetType)
                && before.equals(other.before)
                && after.equals(other.after)
                && limit.equals(other.limit)
                && offset.equals(other.offset);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.datasetType, this.before, this.after, this.limit, this.offset);
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
        private Optional<String> datasetType = Optional.empty();

        private Optional<OffsetDateTime> before = Optional.empty();

        private Optional<OffsetDateTime> after = Optional.empty();

        private Optional<String> limit = Optional.empty();

        private Optional<String> offset = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(DatasetsListRequest other) {
            datasetType(other.getDatasetType());
            before(other.getBefore());
            after(other.getAfter());
            limit(other.getLimit());
            offset(other.getOffset());
            return this;
        }

        @JsonSetter(value = "datasetType", nulls = Nulls.SKIP)
        public Builder datasetType(Optional<String> datasetType) {
            this.datasetType = datasetType;
            return this;
        }

        public Builder datasetType(String datasetType) {
            this.datasetType = Optional.of(datasetType);
            return this;
        }

        @JsonSetter(value = "before", nulls = Nulls.SKIP)
        public Builder before(Optional<OffsetDateTime> before) {
            this.before = before;
            return this;
        }

        public Builder before(OffsetDateTime before) {
            this.before = Optional.of(before);
            return this;
        }

        @JsonSetter(value = "after", nulls = Nulls.SKIP)
        public Builder after(Optional<OffsetDateTime> after) {
            this.after = after;
            return this;
        }

        public Builder after(OffsetDateTime after) {
            this.after = Optional.of(after);
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<String> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(String limit) {
            this.limit = Optional.of(limit);
            return this;
        }

        @JsonSetter(value = "offset", nulls = Nulls.SKIP)
        public Builder offset(Optional<String> offset) {
            this.offset = offset;
            return this;
        }

        public Builder offset(String offset) {
            this.offset = Optional.of(offset);
            return this;
        }

        public DatasetsListRequest build() {
            return new DatasetsListRequest(datasetType, before, after, limit, offset, additionalProperties);
        }
    }
}
