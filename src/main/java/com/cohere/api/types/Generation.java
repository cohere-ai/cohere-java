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
@JsonDeserialize(builder = Generation.Builder.class)
public final class Generation {
    private final String id;

    private final Optional<String> prompt;

    private final List<SingleGeneration> generations;

    private final Optional<ApiMeta> meta;

    private final Map<String, Object> additionalProperties;

    private Generation(
            String id,
            Optional<String> prompt,
            List<SingleGeneration> generations,
            Optional<ApiMeta> meta,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.prompt = prompt;
        this.generations = generations;
        this.meta = meta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return Prompt used for generations.
     */
    @JsonProperty("prompt")
    public Optional<String> getPrompt() {
        return prompt;
    }

    /**
     * @return List of generated results
     */
    @JsonProperty("generations")
    public List<SingleGeneration> getGenerations() {
        return generations;
    }

    @JsonProperty("meta")
    public Optional<ApiMeta> getMeta() {
        return meta;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Generation && equalTo((Generation) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Generation other) {
        return id.equals(other.id)
                && prompt.equals(other.prompt)
                && generations.equals(other.generations)
                && meta.equals(other.meta);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.prompt, this.generations, this.meta);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        _FinalStage id(String id);

        Builder from(Generation other);
    }

    public interface _FinalStage {
        Generation build();

        _FinalStage prompt(Optional<String> prompt);

        _FinalStage prompt(String prompt);

        _FinalStage generations(List<SingleGeneration> generations);

        _FinalStage addGenerations(SingleGeneration generations);

        _FinalStage addAllGenerations(List<SingleGeneration> generations);

        _FinalStage meta(Optional<ApiMeta> meta);

        _FinalStage meta(ApiMeta meta);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        private Optional<ApiMeta> meta = Optional.empty();

        private List<SingleGeneration> generations = new ArrayList<>();

        private Optional<String> prompt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Generation other) {
            id(other.getId());
            prompt(other.getPrompt());
            generations(other.getGenerations());
            meta(other.getMeta());
            return this;
        }

        @java.lang.Override
        @JsonSetter("id")
        public _FinalStage id(String id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public _FinalStage meta(ApiMeta meta) {
            this.meta = Optional.of(meta);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<ApiMeta> meta) {
            this.meta = meta;
            return this;
        }

        /**
         * <p>List of generated results</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllGenerations(List<SingleGeneration> generations) {
            this.generations.addAll(generations);
            return this;
        }

        /**
         * <p>List of generated results</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addGenerations(SingleGeneration generations) {
            this.generations.add(generations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "generations", nulls = Nulls.SKIP)
        public _FinalStage generations(List<SingleGeneration> generations) {
            this.generations.clear();
            this.generations.addAll(generations);
            return this;
        }

        /**
         * <p>Prompt used for generations.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage prompt(String prompt) {
            this.prompt = Optional.of(prompt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "prompt", nulls = Nulls.SKIP)
        public _FinalStage prompt(Optional<String> prompt) {
            this.prompt = prompt;
            return this;
        }

        @java.lang.Override
        public Generation build() {
            return new Generation(id, prompt, generations, meta, additionalProperties);
        }
    }
}
