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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ImageContent.Builder.class)
public final class ImageContent {
    private final ImageUrl imageUrl;

    private final Map<String, Object> additionalProperties;

    private ImageContent(ImageUrl imageUrl, Map<String, Object> additionalProperties) {
        this.imageUrl = imageUrl;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("image_url")
    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ImageContent && equalTo((ImageContent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ImageContent other) {
        return imageUrl.equals(other.imageUrl);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.imageUrl);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ImageUrlStage builder() {
        return new Builder();
    }

    public interface ImageUrlStage {
        _FinalStage imageUrl(@NotNull ImageUrl imageUrl);

        Builder from(ImageContent other);
    }

    public interface _FinalStage {
        ImageContent build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ImageUrlStage, _FinalStage {
        private ImageUrl imageUrl;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ImageContent other) {
            imageUrl(other.getImageUrl());
            return this;
        }

        @java.lang.Override
        @JsonSetter("image_url")
        public _FinalStage imageUrl(@NotNull ImageUrl imageUrl) {
            this.imageUrl = Objects.requireNonNull(imageUrl, "imageUrl must not be null");
            return this;
        }

        @java.lang.Override
        public ImageContent build() {
            return new ImageContent(imageUrl, additionalProperties);
        }
    }
}
