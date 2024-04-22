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
@JsonDeserialize(builder = RerankResponseResultsItem.Builder.class)
public final class RerankResponseResultsItem {
    private final Optional<RerankResponseResultsItemDocument> document;

    private final int index;

    private final double relevanceScore;

    private final Map<String, Object> additionalProperties;

    private RerankResponseResultsItem(
            Optional<RerankResponseResultsItemDocument> document,
            int index,
            double relevanceScore,
            Map<String, Object> additionalProperties) {
        this.document = document;
        this.index = index;
        this.relevanceScore = relevanceScore;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return If <code>return_documents</code> is set as <code>false</code> this will return none, if <code>true</code> it will return the documents passed in
     */
    @JsonProperty("document")
    public Optional<RerankResponseResultsItemDocument> getDocument() {
        return document;
    }

    /**
     * @return Corresponds to the index in the original list of documents to which the ranked document belongs. (i.e. if the first value in the <code>results</code> object has an <code>index</code> value of 3, it means in the list of documents passed in, the document at <code>index=3</code> had the highest relevance)
     */
    @JsonProperty("index")
    public int getIndex() {
        return index;
    }

    /**
     * @return Relevance scores are normalized to be in the range <code>[0, 1]</code>. Scores close to <code>1</code> indicate a high relevance to the query, and scores closer to <code>0</code> indicate low relevance. It is not accurate to assume a score of 0.9 means the document is 2x more relevant than a document with a score of 0.45
     */
    @JsonProperty("relevance_score")
    public double getRelevanceScore() {
        return relevanceScore;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RerankResponseResultsItem && equalTo((RerankResponseResultsItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RerankResponseResultsItem other) {
        return document.equals(other.document) && index == other.index && relevanceScore == other.relevanceScore;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.document, this.index, this.relevanceScore);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IndexStage builder() {
        return new Builder();
    }

    public interface IndexStage {
        RelevanceScoreStage index(int index);

        Builder from(RerankResponseResultsItem other);
    }

    public interface RelevanceScoreStage {
        _FinalStage relevanceScore(double relevanceScore);
    }

    public interface _FinalStage {
        RerankResponseResultsItem build();

        _FinalStage document(Optional<RerankResponseResultsItemDocument> document);

        _FinalStage document(RerankResponseResultsItemDocument document);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IndexStage, RelevanceScoreStage, _FinalStage {
        private int index;

        private double relevanceScore;

        private Optional<RerankResponseResultsItemDocument> document = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(RerankResponseResultsItem other) {
            document(other.getDocument());
            index(other.getIndex());
            relevanceScore(other.getRelevanceScore());
            return this;
        }

        /**
         * <p>Corresponds to the index in the original list of documents to which the ranked document belongs. (i.e. if the first value in the <code>results</code> object has an <code>index</code> value of 3, it means in the list of documents passed in, the document at <code>index=3</code> had the highest relevance)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("index")
        public RelevanceScoreStage index(int index) {
            this.index = index;
            return this;
        }

        /**
         * <p>Relevance scores are normalized to be in the range <code>[0, 1]</code>. Scores close to <code>1</code> indicate a high relevance to the query, and scores closer to <code>0</code> indicate low relevance. It is not accurate to assume a score of 0.9 means the document is 2x more relevant than a document with a score of 0.45</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("relevance_score")
        public _FinalStage relevanceScore(double relevanceScore) {
            this.relevanceScore = relevanceScore;
            return this;
        }

        /**
         * <p>If <code>return_documents</code> is set as <code>false</code> this will return none, if <code>true</code> it will return the documents passed in</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage document(RerankResponseResultsItemDocument document) {
            this.document = Optional.of(document);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "document", nulls = Nulls.SKIP)
        public _FinalStage document(Optional<RerankResponseResultsItemDocument> document) {
            this.document = document;
            return this;
        }

        @java.lang.Override
        public RerankResponseResultsItem build() {
            return new RerankResponseResultsItem(document, index, relevanceScore, additionalProperties);
        }
    }
}
