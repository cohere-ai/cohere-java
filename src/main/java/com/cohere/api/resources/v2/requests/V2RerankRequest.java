/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.resources.v2.types.V2RerankRequestDocumentsItem;
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
@JsonDeserialize(builder = V2RerankRequest.Builder.class)
public final class V2RerankRequest {
    private final String model;

    private final String query;

    private final List<V2RerankRequestDocumentsItem> documents;

    private final Optional<Integer> topN;

    private final Optional<List<String>> rankFields;

    private final Optional<Boolean> returnDocuments;

    private final Optional<Integer> maxChunksPerDoc;

    private final Map<String, Object> additionalProperties;

    private V2RerankRequest(
            String model,
            String query,
            List<V2RerankRequestDocumentsItem> documents,
            Optional<Integer> topN,
            Optional<List<String>> rankFields,
            Optional<Boolean> returnDocuments,
            Optional<Integer> maxChunksPerDoc,
            Map<String, Object> additionalProperties) {
        this.model = model;
        this.query = query;
        this.documents = documents;
        this.topN = topN;
        this.rankFields = rankFields;
        this.returnDocuments = returnDocuments;
        this.maxChunksPerDoc = maxChunksPerDoc;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The identifier of the model to use, one of : <code>rerank-english-v3.0</code>, <code>rerank-multilingual-v3.0</code>, <code>rerank-english-v2.0</code>, <code>rerank-multilingual-v2.0</code>
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * @return The search query
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    /**
     * @return A list of document objects or strings to rerank.
     * If a document is provided the text fields is required and all other fields will be preserved in the response.
     * <p>The total max chunks (length of documents * max_chunks_per_doc) must be less than 10000.</p>
     * <p>We recommend a maximum of 1,000 documents for optimal endpoint performance.</p>
     */
    @JsonProperty("documents")
    public List<V2RerankRequestDocumentsItem> getDocuments() {
        return documents;
    }

    /**
     * @return The number of most relevant documents or indices to return, defaults to the length of the documents
     */
    @JsonProperty("top_n")
    public Optional<Integer> getTopN() {
        return topN;
    }

    /**
     * @return If a JSON object is provided, you can specify which keys you would like to have considered for reranking. The model will rerank based on order of the fields passed in (i.e. rank_fields=['title','author','text'] will rerank using the values in title, author, text  sequentially. If the length of title, author, and text exceeds the context length of the model, the chunking will not re-consider earlier fields). If not provided, the model will use the default text field for ranking.
     */
    @JsonProperty("rank_fields")
    public Optional<List<String>> getRankFields() {
        return rankFields;
    }

    /**
     * @return <ul>
     * <li>If false, returns results without the doc text - the api will return a list of {index, relevance score} where index is inferred from the list passed into the request.</li>
     * <li>If true, returns results with the doc text passed in - the api will return an ordered list of {index, text, relevance score} where index + text refers to the list passed into the request.</li>
     * </ul>
     */
    @JsonProperty("return_documents")
    public Optional<Boolean> getReturnDocuments() {
        return returnDocuments;
    }

    /**
     * @return The maximum number of chunks to produce internally from a document
     */
    @JsonProperty("max_chunks_per_doc")
    public Optional<Integer> getMaxChunksPerDoc() {
        return maxChunksPerDoc;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2RerankRequest && equalTo((V2RerankRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2RerankRequest other) {
        return model.equals(other.model)
                && query.equals(other.query)
                && documents.equals(other.documents)
                && topN.equals(other.topN)
                && rankFields.equals(other.rankFields)
                && returnDocuments.equals(other.returnDocuments)
                && maxChunksPerDoc.equals(other.maxChunksPerDoc);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.model,
                this.query,
                this.documents,
                this.topN,
                this.rankFields,
                this.returnDocuments,
                this.maxChunksPerDoc);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        QueryStage model(String model);

        Builder from(V2RerankRequest other);
    }

    public interface QueryStage {
        _FinalStage query(String query);
    }

    public interface _FinalStage {
        V2RerankRequest build();

        _FinalStage documents(List<V2RerankRequestDocumentsItem> documents);

        _FinalStage addDocuments(V2RerankRequestDocumentsItem documents);

        _FinalStage addAllDocuments(List<V2RerankRequestDocumentsItem> documents);

        _FinalStage topN(Optional<Integer> topN);

        _FinalStage topN(Integer topN);

        _FinalStage rankFields(Optional<List<String>> rankFields);

        _FinalStage rankFields(List<String> rankFields);

        _FinalStage returnDocuments(Optional<Boolean> returnDocuments);

        _FinalStage returnDocuments(Boolean returnDocuments);

        _FinalStage maxChunksPerDoc(Optional<Integer> maxChunksPerDoc);

        _FinalStage maxChunksPerDoc(Integer maxChunksPerDoc);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, QueryStage, _FinalStage {
        private String model;

        private String query;

        private Optional<Integer> maxChunksPerDoc = Optional.empty();

        private Optional<Boolean> returnDocuments = Optional.empty();

        private Optional<List<String>> rankFields = Optional.empty();

        private Optional<Integer> topN = Optional.empty();

        private List<V2RerankRequestDocumentsItem> documents = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(V2RerankRequest other) {
            model(other.getModel());
            query(other.getQuery());
            documents(other.getDocuments());
            topN(other.getTopN());
            rankFields(other.getRankFields());
            returnDocuments(other.getReturnDocuments());
            maxChunksPerDoc(other.getMaxChunksPerDoc());
            return this;
        }

        /**
         * <p>The identifier of the model to use, one of : <code>rerank-english-v3.0</code>, <code>rerank-multilingual-v3.0</code>, <code>rerank-english-v2.0</code>, <code>rerank-multilingual-v2.0</code></p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("model")
        public QueryStage model(String model) {
            this.model = model;
            return this;
        }

        /**
         * <p>The search query</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("query")
        public _FinalStage query(String query) {
            this.query = query;
            return this;
        }

        /**
         * <p>The maximum number of chunks to produce internally from a document</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage maxChunksPerDoc(Integer maxChunksPerDoc) {
            this.maxChunksPerDoc = Optional.of(maxChunksPerDoc);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "max_chunks_per_doc", nulls = Nulls.SKIP)
        public _FinalStage maxChunksPerDoc(Optional<Integer> maxChunksPerDoc) {
            this.maxChunksPerDoc = maxChunksPerDoc;
            return this;
        }

        /**
         * <ul>
         * <li>If false, returns results without the doc text - the api will return a list of {index, relevance score} where index is inferred from the list passed into the request.</li>
         * <li>If true, returns results with the doc text passed in - the api will return an ordered list of {index, text, relevance score} where index + text refers to the list passed into the request.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage returnDocuments(Boolean returnDocuments) {
            this.returnDocuments = Optional.of(returnDocuments);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "return_documents", nulls = Nulls.SKIP)
        public _FinalStage returnDocuments(Optional<Boolean> returnDocuments) {
            this.returnDocuments = returnDocuments;
            return this;
        }

        /**
         * <p>If a JSON object is provided, you can specify which keys you would like to have considered for reranking. The model will rerank based on order of the fields passed in (i.e. rank_fields=['title','author','text'] will rerank using the values in title, author, text  sequentially. If the length of title, author, and text exceeds the context length of the model, the chunking will not re-consider earlier fields). If not provided, the model will use the default text field for ranking.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage rankFields(List<String> rankFields) {
            this.rankFields = Optional.of(rankFields);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "rank_fields", nulls = Nulls.SKIP)
        public _FinalStage rankFields(Optional<List<String>> rankFields) {
            this.rankFields = rankFields;
            return this;
        }

        /**
         * <p>The number of most relevant documents or indices to return, defaults to the length of the documents</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage topN(Integer topN) {
            this.topN = Optional.of(topN);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "top_n", nulls = Nulls.SKIP)
        public _FinalStage topN(Optional<Integer> topN) {
            this.topN = topN;
            return this;
        }

        /**
         * <p>A list of document objects or strings to rerank.
         * If a document is provided the text fields is required and all other fields will be preserved in the response.</p>
         * <p>The total max chunks (length of documents * max_chunks_per_doc) must be less than 10000.</p>
         * <p>We recommend a maximum of 1,000 documents for optimal endpoint performance.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllDocuments(List<V2RerankRequestDocumentsItem> documents) {
            this.documents.addAll(documents);
            return this;
        }

        /**
         * <p>A list of document objects or strings to rerank.
         * If a document is provided the text fields is required and all other fields will be preserved in the response.</p>
         * <p>The total max chunks (length of documents * max_chunks_per_doc) must be less than 10000.</p>
         * <p>We recommend a maximum of 1,000 documents for optimal endpoint performance.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addDocuments(V2RerankRequestDocumentsItem documents) {
            this.documents.add(documents);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "documents", nulls = Nulls.SKIP)
        public _FinalStage documents(List<V2RerankRequestDocumentsItem> documents) {
            this.documents.clear();
            this.documents.addAll(documents);
            return this;
        }

        @java.lang.Override
        public V2RerankRequest build() {
            return new V2RerankRequest(
                    model, query, documents, topN, rankFields, returnDocuments, maxChunksPerDoc, additionalProperties);
        }
    }
}
