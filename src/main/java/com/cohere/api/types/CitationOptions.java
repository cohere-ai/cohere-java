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
@JsonDeserialize(builder = CitationOptions.Builder.class)
public final class CitationOptions {
    private final Optional<CitationOptionsMode> mode;

    private final Map<String, Object> additionalProperties;

    private CitationOptions(Optional<CitationOptionsMode> mode, Map<String, Object> additionalProperties) {
        this.mode = mode;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Defaults to <code>&quot;accurate&quot;</code>.
     * Dictates the approach taken to generating citations as part of the RAG flow by allowing the user to specify whether they want <code>&quot;accurate&quot;</code> results, <code>&quot;fast&quot;</code> results or no results.
     * <p><strong>Note</strong>: <code>command-r7b-12-2024</code> and <code>command-a-03-2025</code> only support <code>&quot;fast&quot;</code> and <code>&quot;off&quot;</code> modes. The default is <code>&quot;fast&quot;</code>.</p>
     */
    @JsonProperty("mode")
    public Optional<CitationOptionsMode> getMode() {
        return mode;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CitationOptions && equalTo((CitationOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CitationOptions other) {
        return mode.equals(other.mode);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.mode);
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
        private Optional<CitationOptionsMode> mode = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CitationOptions other) {
            mode(other.getMode());
            return this;
        }

        @JsonSetter(value = "mode", nulls = Nulls.SKIP)
        public Builder mode(Optional<CitationOptionsMode> mode) {
            this.mode = mode;
            return this;
        }

        public Builder mode(CitationOptionsMode mode) {
            this.mode = Optional.ofNullable(mode);
            return this;
        }

        public CitationOptions build() {
            return new CitationOptions(mode, additionalProperties);
        }
    }
}
