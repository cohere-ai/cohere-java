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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NonStreamedChatResponse.Builder.class)
public final class NonStreamedChatResponse {
    private final String text;

    private final Optional<String> generationId;

    private final Optional<List<ChatCitation>> citations;

    private final Optional<List<Map<String, String>>> documents;

    private final Optional<Boolean> isSearchRequired;

    private final Optional<List<ChatSearchQuery>> searchQueries;

    private final Optional<List<ChatSearchResult>> searchResults;

    private final Optional<FinishReason> finishReason;

    private final Map<String, Object> additionalProperties;

    private NonStreamedChatResponse(
            String text,
            Optional<String> generationId,
            Optional<List<ChatCitation>> citations,
            Optional<List<Map<String, String>>> documents,
            Optional<Boolean> isSearchRequired,
            Optional<List<ChatSearchQuery>> searchQueries,
            Optional<List<ChatSearchResult>> searchResults,
            Optional<FinishReason> finishReason,
            Map<String, Object> additionalProperties) {
        this.text = text;
        this.generationId = generationId;
        this.citations = citations;
        this.documents = documents;
        this.isSearchRequired = isSearchRequired;
        this.searchQueries = searchQueries;
        this.searchResults = searchResults;
        this.finishReason = finishReason;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Contents of the reply generated by the model.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return Unique identifier for the generated reply. Useful for submitting feedback.
     */
    @JsonProperty("generation_id")
    public Optional<String> getGenerationId() {
        return generationId;
    }

    /**
     * @return Inline citations for the generated reply.
     */
    @JsonProperty("citations")
    public Optional<List<ChatCitation>> getCitations() {
        return citations;
    }

    /**
     * @return Documents seen by the model when generating the reply.
     */
    @JsonProperty("documents")
    public Optional<List<Map<String, String>>> getDocuments() {
        return documents;
    }

    /**
     * @return Denotes that a search for documents is required during the RAG flow.
     */
    @JsonProperty("is_search_required")
    public Optional<Boolean> getIsSearchRequired() {
        return isSearchRequired;
    }

    /**
     * @return Generated search queries, meant to be used as part of the RAG flow.
     */
    @JsonProperty("search_queries")
    public Optional<List<ChatSearchQuery>> getSearchQueries() {
        return searchQueries;
    }

    /**
     * @return Documents retrieved from each of the conducted searches.
     */
    @JsonProperty("search_results")
    public Optional<List<ChatSearchResult>> getSearchResults() {
        return searchResults;
    }

    @JsonProperty("finish_reason")
    public Optional<FinishReason> getFinishReason() {
        return finishReason;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NonStreamedChatResponse && equalTo((NonStreamedChatResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(NonStreamedChatResponse other) {
        return text.equals(other.text)
                && generationId.equals(other.generationId)
                && citations.equals(other.citations)
                && documents.equals(other.documents)
                && isSearchRequired.equals(other.isSearchRequired)
                && searchQueries.equals(other.searchQueries)
                && searchResults.equals(other.searchResults)
                && finishReason.equals(other.finishReason);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.text,
                this.generationId,
                this.citations,
                this.documents,
                this.isSearchRequired,
                this.searchQueries,
                this.searchResults,
                this.finishReason);
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

        Builder from(NonStreamedChatResponse other);
    }

    public interface _FinalStage {
        NonStreamedChatResponse build();

        _FinalStage generationId(Optional<String> generationId);

        _FinalStage generationId(String generationId);

        _FinalStage citations(Optional<List<ChatCitation>> citations);

        _FinalStage citations(List<ChatCitation> citations);

        _FinalStage documents(Optional<List<Map<String, String>>> documents);

        _FinalStage documents(List<Map<String, String>> documents);

        _FinalStage isSearchRequired(Optional<Boolean> isSearchRequired);

        _FinalStage isSearchRequired(Boolean isSearchRequired);

        _FinalStage searchQueries(Optional<List<ChatSearchQuery>> searchQueries);

        _FinalStage searchQueries(List<ChatSearchQuery> searchQueries);

        _FinalStage searchResults(Optional<List<ChatSearchResult>> searchResults);

        _FinalStage searchResults(List<ChatSearchResult> searchResults);

        _FinalStage finishReason(Optional<FinishReason> finishReason);

        _FinalStage finishReason(FinishReason finishReason);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        private Optional<FinishReason> finishReason = Optional.empty();

        private Optional<List<ChatSearchResult>> searchResults = Optional.empty();

        private Optional<List<ChatSearchQuery>> searchQueries = Optional.empty();

        private Optional<Boolean> isSearchRequired = Optional.empty();

        private Optional<List<Map<String, String>>> documents = Optional.empty();

        private Optional<List<ChatCitation>> citations = Optional.empty();

        private Optional<String> generationId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(NonStreamedChatResponse other) {
            text(other.getText());
            generationId(other.getGenerationId());
            citations(other.getCitations());
            documents(other.getDocuments());
            isSearchRequired(other.getIsSearchRequired());
            searchQueries(other.getSearchQueries());
            searchResults(other.getSearchResults());
            finishReason(other.getFinishReason());
            return this;
        }

        /**
         * <p>Contents of the reply generated by the model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @java.lang.Override
        public _FinalStage finishReason(FinishReason finishReason) {
            this.finishReason = Optional.of(finishReason);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "finish_reason", nulls = Nulls.SKIP)
        public _FinalStage finishReason(Optional<FinishReason> finishReason) {
            this.finishReason = finishReason;
            return this;
        }

        /**
         * <p>Documents retrieved from each of the conducted searches.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage searchResults(List<ChatSearchResult> searchResults) {
            this.searchResults = Optional.of(searchResults);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "search_results", nulls = Nulls.SKIP)
        public _FinalStage searchResults(Optional<List<ChatSearchResult>> searchResults) {
            this.searchResults = searchResults;
            return this;
        }

        /**
         * <p>Generated search queries, meant to be used as part of the RAG flow.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage searchQueries(List<ChatSearchQuery> searchQueries) {
            this.searchQueries = Optional.of(searchQueries);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "search_queries", nulls = Nulls.SKIP)
        public _FinalStage searchQueries(Optional<List<ChatSearchQuery>> searchQueries) {
            this.searchQueries = searchQueries;
            return this;
        }

        /**
         * <p>Denotes that a search for documents is required during the RAG flow.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage isSearchRequired(Boolean isSearchRequired) {
            this.isSearchRequired = Optional.of(isSearchRequired);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_search_required", nulls = Nulls.SKIP)
        public _FinalStage isSearchRequired(Optional<Boolean> isSearchRequired) {
            this.isSearchRequired = isSearchRequired;
            return this;
        }

        /**
         * <p>Documents seen by the model when generating the reply.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage documents(List<Map<String, String>> documents) {
            this.documents = Optional.of(documents);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "documents", nulls = Nulls.SKIP)
        public _FinalStage documents(Optional<List<Map<String, String>>> documents) {
            this.documents = documents;
            return this;
        }

        /**
         * <p>Inline citations for the generated reply.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage citations(List<ChatCitation> citations) {
            this.citations = Optional.of(citations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "citations", nulls = Nulls.SKIP)
        public _FinalStage citations(Optional<List<ChatCitation>> citations) {
            this.citations = citations;
            return this;
        }

        /**
         * <p>Unique identifier for the generated reply. Useful for submitting feedback.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage generationId(String generationId) {
            this.generationId = Optional.of(generationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "generation_id", nulls = Nulls.SKIP)
        public _FinalStage generationId(Optional<String> generationId) {
            this.generationId = generationId;
            return this;
        }

        @java.lang.Override
        public NonStreamedChatResponse build() {
            return new NonStreamedChatResponse(
                    text,
                    generationId,
                    citations,
                    documents,
                    isSearchRequired,
                    searchQueries,
                    searchResults,
                    finishReason,
                    additionalProperties);
        }
    }
}
