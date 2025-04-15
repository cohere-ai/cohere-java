/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.connectors.requests;

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
@JsonDeserialize(builder = ConnectorsListRequest.Builder.class)
public final class ConnectorsListRequest {
    private final Optional<Double> limit;

    private final Optional<Double> offset;

    private final Map<String, Object> additionalProperties;

    private ConnectorsListRequest(
            Optional<Double> limit, Optional<Double> offset, Map<String, Object> additionalProperties) {
        this.limit = limit;
        this.offset = offset;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Maximum number of connectors to return [0, 100].
     */
    @JsonProperty("limit")
    public Optional<Double> getLimit() {
        return limit;
    }

    /**
     * @return Number of connectors to skip before returning results [0, inf].
     */
    @JsonProperty("offset")
    public Optional<Double> getOffset() {
        return offset;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConnectorsListRequest && equalTo((ConnectorsListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConnectorsListRequest other) {
        return limit.equals(other.limit) && offset.equals(other.offset);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.limit, this.offset);
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
        private Optional<Double> limit = Optional.empty();

        private Optional<Double> offset = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ConnectorsListRequest other) {
            limit(other.getLimit());
            offset(other.getOffset());
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Double> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Double limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        @JsonSetter(value = "offset", nulls = Nulls.SKIP)
        public Builder offset(Optional<Double> offset) {
            this.offset = offset;
            return this;
        }

        public Builder offset(Double offset) {
            this.offset = Optional.ofNullable(offset);
            return this;
        }

        public ConnectorsListRequest build() {
            return new ConnectorsListRequest(limit, offset, additionalProperties);
        }
    }
}
