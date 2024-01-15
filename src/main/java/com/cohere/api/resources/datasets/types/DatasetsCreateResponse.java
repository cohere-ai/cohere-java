/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.datasets.types;

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
@JsonDeserialize(builder = DatasetsCreateResponse.Builder.class)
public final class DatasetsCreateResponse {
    private final Optional<String> id;

    private final Map<String, Object> additionalProperties;

    private DatasetsCreateResponse(Optional<String> id, Map<String, Object> additionalProperties) {
        this.id = id;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The dataset ID
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DatasetsCreateResponse && equalTo((DatasetsCreateResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DatasetsCreateResponse other) {
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(DatasetsCreateResponse other) {
            id(other.getId());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        public DatasetsCreateResponse build() {
            return new DatasetsCreateResponse(id, additionalProperties);
        }
    }
}