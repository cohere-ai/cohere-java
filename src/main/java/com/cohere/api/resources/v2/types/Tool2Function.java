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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Tool2Function.Builder.class)
public final class Tool2Function {
    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<Map<String, Object>> parameters;

    private final Map<String, Object> additionalProperties;

    private Tool2Function(
            Optional<String> name,
            Optional<String> description,
            Optional<Map<String, Object>> parameters,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the function.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The description of the function.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The parameters of the function as a JSON schema.
     */
    @JsonProperty("parameters")
    public Optional<Map<String, Object>> getParameters() {
        return parameters;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Tool2Function && equalTo((Tool2Function) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Tool2Function other) {
        return name.equals(other.name) && description.equals(other.description) && parameters.equals(other.parameters);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.parameters);
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
        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<Map<String, Object>> parameters = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Tool2Function other) {
            name(other.getName());
            description(other.getDescription());
            parameters(other.getParameters());
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "parameters", nulls = Nulls.SKIP)
        public Builder parameters(Optional<Map<String, Object>> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder parameters(Map<String, Object> parameters) {
            this.parameters = Optional.of(parameters);
            return this;
        }

        public Tool2Function build() {
            return new Tool2Function(name, description, parameters, additionalProperties);
        }
    }
}
