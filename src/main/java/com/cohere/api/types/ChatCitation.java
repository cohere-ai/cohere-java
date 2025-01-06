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
@JsonDeserialize(builder = ChatCitation.Builder.class)
public final class ChatCitation {
    private final int start;

    private final int end;

    private final String text;

    private final List<String> documentIds;

    private final Map<String, Object> additionalProperties;

    private ChatCitation(
            int start, int end, String text, List<String> documentIds, Map<String, Object> additionalProperties) {
        this.start = start;
        this.end = end;
        this.text = text;
        this.documentIds = documentIds;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The index of text that the citation starts at, counting from zero. For example, a generation of <code>Hello, world!</code> with a citation on <code>world</code> would have a start value of <code>7</code>. This is because the citation starts at <code>w</code>, which is the seventh character.
     */
    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    /**
     * @return The index of text that the citation ends after, counting from zero. For example, a generation of <code>Hello, world!</code> with a citation on <code>world</code> would have an end value of <code>11</code>. This is because the citation ends after <code>d</code>, which is the eleventh character.
     */
    @JsonProperty("end")
    public int getEnd() {
        return end;
    }

    /**
     * @return The text of the citation. For example, a generation of <code>Hello, world!</code> with a citation of <code>world</code> would have a text value of <code>world</code>.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return Identifiers of documents cited by this section of the generated reply.
     */
    @JsonProperty("document_ids")
    public List<String> getDocumentIds() {
        return documentIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatCitation && equalTo((ChatCitation) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatCitation other) {
        return start == other.start
                && end == other.end
                && text.equals(other.text)
                && documentIds.equals(other.documentIds);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.start, this.end, this.text, this.documentIds);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StartStage builder() {
        return new Builder();
    }

    public interface StartStage {
        EndStage start(int start);

        Builder from(ChatCitation other);
    }

    public interface EndStage {
        TextStage end(int end);
    }

    public interface TextStage {
        _FinalStage text(@NotNull String text);
    }

    public interface _FinalStage {
        ChatCitation build();

        _FinalStage documentIds(List<String> documentIds);

        _FinalStage addDocumentIds(String documentIds);

        _FinalStage addAllDocumentIds(List<String> documentIds);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StartStage, EndStage, TextStage, _FinalStage {
        private int start;

        private int end;

        private String text;

        private List<String> documentIds = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ChatCitation other) {
            start(other.getStart());
            end(other.getEnd());
            text(other.getText());
            documentIds(other.getDocumentIds());
            return this;
        }

        /**
         * <p>The index of text that the citation starts at, counting from zero. For example, a generation of <code>Hello, world!</code> with a citation on <code>world</code> would have a start value of <code>7</code>. This is because the citation starts at <code>w</code>, which is the seventh character.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("start")
        public EndStage start(int start) {
            this.start = start;
            return this;
        }

        /**
         * <p>The index of text that the citation ends after, counting from zero. For example, a generation of <code>Hello, world!</code> with a citation on <code>world</code> would have an end value of <code>11</code>. This is because the citation ends after <code>d</code>, which is the eleventh character.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("end")
        public TextStage end(int end) {
            this.end = end;
            return this;
        }

        /**
         * <p>The text of the citation. For example, a generation of <code>Hello, world!</code> with a citation of <code>world</code> would have a text value of <code>world</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public _FinalStage text(@NotNull String text) {
            this.text = Objects.requireNonNull(text, "text must not be null");
            return this;
        }

        /**
         * <p>Identifiers of documents cited by this section of the generated reply.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllDocumentIds(List<String> documentIds) {
            this.documentIds.addAll(documentIds);
            return this;
        }

        /**
         * <p>Identifiers of documents cited by this section of the generated reply.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addDocumentIds(String documentIds) {
            this.documentIds.add(documentIds);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "document_ids", nulls = Nulls.SKIP)
        public _FinalStage documentIds(List<String> documentIds) {
            this.documentIds.clear();
            this.documentIds.addAll(documentIds);
            return this;
        }

        @java.lang.Override
        public ChatCitation build() {
            return new ChatCitation(start, end, text, documentIds, additionalProperties);
        }
    }
}
