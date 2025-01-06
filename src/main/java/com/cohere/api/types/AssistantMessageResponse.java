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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AssistantMessageResponse.Builder.class)
public final class AssistantMessageResponse {
    private final Optional<List<ToolCallV2>> toolCalls;

    private final Optional<String> toolPlan;

    private final Optional<List<AssistantMessageResponseContentItem>> content;

    private final Optional<List<Citation>> citations;

    private final Map<String, Object> additionalProperties;

    private AssistantMessageResponse(
            Optional<List<ToolCallV2>> toolCalls,
            Optional<String> toolPlan,
            Optional<List<AssistantMessageResponseContentItem>> content,
            Optional<List<Citation>> citations,
            Map<String, Object> additionalProperties) {
        this.toolCalls = toolCalls;
        this.toolPlan = toolPlan;
        this.content = content;
        this.citations = citations;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("role")
    public String getRole() {
        return "assistant";
    }

    @JsonProperty("tool_calls")
    public Optional<List<ToolCallV2>> getToolCalls() {
        return toolCalls;
    }

    /**
     * @return A chain-of-thought style reflection and plan that the model generates when working with Tools.
     */
    @JsonProperty("tool_plan")
    public Optional<String> getToolPlan() {
        return toolPlan;
    }

    @JsonProperty("content")
    public Optional<List<AssistantMessageResponseContentItem>> getContent() {
        return content;
    }

    @JsonProperty("citations")
    public Optional<List<Citation>> getCitations() {
        return citations;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssistantMessageResponse && equalTo((AssistantMessageResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AssistantMessageResponse other) {
        return toolCalls.equals(other.toolCalls)
                && toolPlan.equals(other.toolPlan)
                && content.equals(other.content)
                && citations.equals(other.citations);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.toolCalls, this.toolPlan, this.content, this.citations);
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
        private Optional<List<ToolCallV2>> toolCalls = Optional.empty();

        private Optional<String> toolPlan = Optional.empty();

        private Optional<List<AssistantMessageResponseContentItem>> content = Optional.empty();

        private Optional<List<Citation>> citations = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(AssistantMessageResponse other) {
            toolCalls(other.getToolCalls());
            toolPlan(other.getToolPlan());
            content(other.getContent());
            citations(other.getCitations());
            return this;
        }

        @JsonSetter(value = "tool_calls", nulls = Nulls.SKIP)
        public Builder toolCalls(Optional<List<ToolCallV2>> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }

        public Builder toolCalls(List<ToolCallV2> toolCalls) {
            this.toolCalls = Optional.ofNullable(toolCalls);
            return this;
        }

        @JsonSetter(value = "tool_plan", nulls = Nulls.SKIP)
        public Builder toolPlan(Optional<String> toolPlan) {
            this.toolPlan = toolPlan;
            return this;
        }

        public Builder toolPlan(String toolPlan) {
            this.toolPlan = Optional.ofNullable(toolPlan);
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<List<AssistantMessageResponseContentItem>> content) {
            this.content = content;
            return this;
        }

        public Builder content(List<AssistantMessageResponseContentItem> content) {
            this.content = Optional.ofNullable(content);
            return this;
        }

        @JsonSetter(value = "citations", nulls = Nulls.SKIP)
        public Builder citations(Optional<List<Citation>> citations) {
            this.citations = citations;
            return this;
        }

        public Builder citations(List<Citation> citations) {
            this.citations = Optional.ofNullable(citations);
            return this;
        }

        public AssistantMessageResponse build() {
            return new AssistantMessageResponse(toolCalls, toolPlan, content, citations, additionalProperties);
        }
    }
}
