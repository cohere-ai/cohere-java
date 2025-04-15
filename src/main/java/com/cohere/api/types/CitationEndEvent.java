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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CitationEndEvent.Builder.class)
public final class CitationEndEvent implements IChatStreamEventType {
    private final Optional<Integer> index;

    private final Map<String, Object> additionalProperties;

    private CitationEndEvent(Optional<Integer> index, Map<String, Object> additionalProperties) {
        this.index = index;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("index")
    public Optional<Integer> getIndex() {
        return index;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CitationEndEvent && equalTo((CitationEndEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CitationEndEvent other) {
        return index.equals(other.index);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.index);
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
        private Optional<Integer> index = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CitationEndEvent other) {
            index(other.getIndex());
            return this;
        }

        @JsonSetter(value = "index", nulls = Nulls.SKIP)
        public Builder index(Optional<Integer> index) {
            this.index = index;
            return this;
        }

        public Builder index(Integer index) {
            this.index = Optional.ofNullable(index);
            return this;
        }

        public CitationEndEvent build() {
            return new CitationEndEvent(index, additionalProperties);
        }
    }
}
