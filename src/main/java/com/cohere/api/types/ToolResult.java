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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ToolResult.Builder.class)
public final class ToolResult {
    private final ToolCall call;

    private final List<Map<String, Object>> outputs;

    private final Map<String, Object> additionalProperties;

    private ToolResult(ToolCall call, List<Map<String, Object>> outputs, Map<String, Object> additionalProperties) {
        this.call = call;
        this.outputs = outputs;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("call")
    public ToolCall getCall() {
        return call;
    }

    @JsonProperty("outputs")
    public List<Map<String, Object>> getOutputs() {
        return outputs;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ToolResult && equalTo((ToolResult) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ToolResult other) {
        return call.equals(other.call) && outputs.equals(other.outputs);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.call, this.outputs);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CallStage builder() {
        return new Builder();
    }

    public interface CallStage {
        _FinalStage call(@NotNull ToolCall call);

        Builder from(ToolResult other);
    }

    public interface _FinalStage {
        ToolResult build();

        _FinalStage outputs(List<Map<String, Object>> outputs);

        _FinalStage addOutputs(Map<String, Object> outputs);

        _FinalStage addAllOutputs(List<Map<String, Object>> outputs);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CallStage, _FinalStage {
        private ToolCall call;

        private List<Map<String, Object>> outputs = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ToolResult other) {
            call(other.getCall());
            outputs(other.getOutputs());
            return this;
        }

        @java.lang.Override
        @JsonSetter("call")
        public _FinalStage call(@NotNull ToolCall call) {
            this.call = Objects.requireNonNull(call, "call must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllOutputs(List<Map<String, Object>> outputs) {
            this.outputs.addAll(outputs);
            return this;
        }

        @java.lang.Override
        public _FinalStage addOutputs(Map<String, Object> outputs) {
            this.outputs.add(outputs);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "outputs", nulls = Nulls.SKIP)
        public _FinalStage outputs(List<Map<String, Object>> outputs) {
            this.outputs.clear();
            this.outputs.addAll(outputs);
            return this;
        }

        @java.lang.Override
        public ToolResult build() {
            return new ToolResult(call, outputs, additionalProperties);
        }
    }
}
