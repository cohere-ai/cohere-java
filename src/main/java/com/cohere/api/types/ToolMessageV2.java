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
@JsonDeserialize(builder = ToolMessageV2.Builder.class)
public final class ToolMessageV2 {
    private final String toolCallId;

    private final ToolMessageV2Content content;

    private final Map<String, Object> additionalProperties;

    private ToolMessageV2(String toolCallId, ToolMessageV2Content content, Map<String, Object> additionalProperties) {
        this.toolCallId = toolCallId;
        this.content = content;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The id of the associated tool call that has provided the given content
     */
    @JsonProperty("tool_call_id")
    public String getToolCallId() {
        return toolCallId;
    }

    /**
     * @return Outputs from a tool. The content should formatted as a JSON object string, or a list of tool content blocks
     */
    @JsonProperty("content")
    public ToolMessageV2Content getContent() {
        return content;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ToolMessageV2 && equalTo((ToolMessageV2) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ToolMessageV2 other) {
        return toolCallId.equals(other.toolCallId) && content.equals(other.content);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.toolCallId, this.content);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ToolCallIdStage builder() {
        return new Builder();
    }

    public interface ToolCallIdStage {
        ContentStage toolCallId(@NotNull String toolCallId);

        Builder from(ToolMessageV2 other);
    }

    public interface ContentStage {
        _FinalStage content(@NotNull ToolMessageV2Content content);
    }

    public interface _FinalStage {
        ToolMessageV2 build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ToolCallIdStage, ContentStage, _FinalStage {
        private String toolCallId;

        private ToolMessageV2Content content;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ToolMessageV2 other) {
            toolCallId(other.getToolCallId());
            content(other.getContent());
            return this;
        }

        /**
         * <p>The id of the associated tool call that has provided the given content</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("tool_call_id")
        public ContentStage toolCallId(@NotNull String toolCallId) {
            this.toolCallId = Objects.requireNonNull(toolCallId, "toolCallId must not be null");
            return this;
        }

        /**
         * <p>Outputs from a tool. The content should formatted as a JSON object string, or a list of tool content blocks</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("content")
        public _FinalStage content(@NotNull ToolMessageV2Content content) {
            this.content = Objects.requireNonNull(content, "content must not be null");
            return this;
        }

        @java.lang.Override
        public ToolMessageV2 build() {
            return new ToolMessageV2(toolCallId, content, additionalProperties);
        }
    }
}
