/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2RerankResponseResultsItemDocument.Builder.class)
public final class V2RerankResponseResultsItemDocument {
    private final String text;

    private final Map<String, Object> additionalProperties;

    private V2RerankResponseResultsItemDocument(String text, Map<String, Object> additionalProperties) {
        this.text = text;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The text of the document to rerank
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2RerankResponseResultsItemDocument
                && equalTo((V2RerankResponseResultsItemDocument) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2RerankResponseResultsItemDocument other) {
        return text.equals(other.text);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.text);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        _FinalStage text(String text);

        Builder from(V2RerankResponseResultsItemDocument other);
    }

    public interface _FinalStage {
        V2RerankResponseResultsItemDocument build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(V2RerankResponseResultsItemDocument other) {
            text(other.getText());
            return this;
        }

        /**
         * <p>The text of the document to rerank</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @java.lang.Override
        public V2RerankResponseResultsItemDocument build() {
            return new V2RerankResponseResultsItemDocument(text, additionalProperties);
        }
    }
}
