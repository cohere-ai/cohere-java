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
@JsonDeserialize(builder = DetectLanguageResponseResultsItem.Builder.class)
public final class DetectLanguageResponseResultsItem {
    private final Optional<String> languageName;

    private final Optional<String> languageCode;

    private final Map<String, Object> additionalProperties;

    private DetectLanguageResponseResultsItem(
            Optional<String> languageName, Optional<String> languageCode, Map<String, Object> additionalProperties) {
        this.languageName = languageName;
        this.languageCode = languageCode;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("language_name")
    public Optional<String> getLanguageName() {
        return languageName;
    }

    @JsonProperty("language_code")
    public Optional<String> getLanguageCode() {
        return languageCode;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DetectLanguageResponseResultsItem && equalTo((DetectLanguageResponseResultsItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DetectLanguageResponseResultsItem other) {
        return languageName.equals(other.languageName) && languageCode.equals(other.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.languageName, this.languageCode);
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
        private Optional<String> languageName = Optional.empty();

        private Optional<String> languageCode = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(DetectLanguageResponseResultsItem other) {
            languageName(other.getLanguageName());
            languageCode(other.getLanguageCode());
            return this;
        }

        @JsonSetter(value = "language_name", nulls = Nulls.SKIP)
        public Builder languageName(Optional<String> languageName) {
            this.languageName = languageName;
            return this;
        }

        public Builder languageName(String languageName) {
            this.languageName = Optional.of(languageName);
            return this;
        }

        @JsonSetter(value = "language_code", nulls = Nulls.SKIP)
        public Builder languageCode(Optional<String> languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public Builder languageCode(String languageCode) {
            this.languageCode = Optional.of(languageCode);
            return this;
        }

        public DetectLanguageResponseResultsItem build() {
            return new DetectLanguageResponseResultsItem(languageName, languageCode, additionalProperties);
        }
    }
}
