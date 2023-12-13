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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClassifyResponse.Builder.class)
public final class ClassifyResponse {
    private final String id;

    private final List<ClassifyResponseClassificationsItem> classifications;

    private final Optional<ApiMeta> meta;

    private final Map<String, Object> additionalProperties;

    private ClassifyResponse(
            String id,
            List<ClassifyResponseClassificationsItem> classifications,
            Optional<ApiMeta> meta,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.classifications = classifications;
        this.meta = meta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("classifications")
    public List<ClassifyResponseClassificationsItem> getClassifications() {
        return classifications;
    }

    @JsonProperty("meta")
    public Optional<ApiMeta> getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassifyResponse && equalTo((ClassifyResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ClassifyResponse other) {
        return id.equals(other.id) && classifications.equals(other.classifications) && meta.equals(other.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.classifications, this.meta);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        _FinalStage id(String id);

        Builder from(ClassifyResponse other);
    }

    public interface _FinalStage {
        ClassifyResponse build();

        _FinalStage classifications(List<ClassifyResponseClassificationsItem> classifications);

        _FinalStage addClassifications(ClassifyResponseClassificationsItem classifications);

        _FinalStage addAllClassifications(List<ClassifyResponseClassificationsItem> classifications);

        _FinalStage meta(Optional<ApiMeta> meta);

        _FinalStage meta(ApiMeta meta);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        private Optional<ApiMeta> meta = Optional.empty();

        private List<ClassifyResponseClassificationsItem> classifications = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ClassifyResponse other) {
            id(other.getId());
            classifications(other.getClassifications());
            meta(other.getMeta());
            return this;
        }

        @Override
        @JsonSetter("id")
        public _FinalStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public _FinalStage meta(ApiMeta meta) {
            this.meta = Optional.of(meta);
            return this;
        }

        @Override
        @JsonSetter(value = "meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<ApiMeta> meta) {
            this.meta = meta;
            return this;
        }

        @Override
        public _FinalStage addAllClassifications(List<ClassifyResponseClassificationsItem> classifications) {
            this.classifications.addAll(classifications);
            return this;
        }

        @Override
        public _FinalStage addClassifications(ClassifyResponseClassificationsItem classifications) {
            this.classifications.add(classifications);
            return this;
        }

        @Override
        @JsonSetter(value = "classifications", nulls = Nulls.SKIP)
        public _FinalStage classifications(List<ClassifyResponseClassificationsItem> classifications) {
            this.classifications.clear();
            this.classifications.addAll(classifications);
            return this;
        }

        @Override
        public ClassifyResponse build() {
            return new ClassifyResponse(id, classifications, meta, additionalProperties);
        }
    }
}
