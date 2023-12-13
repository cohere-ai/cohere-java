/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.ChatConnector;
import com.cohere.api.types.ChatMessage;
import com.cohere.api.types.ChatStreamRequestCitationQuality;
import com.cohere.api.types.ChatStreamRequestPromptTruncation;
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
@JsonDeserialize(builder = ChatStreamRequest.Builder.class)
public final class ChatStreamRequest {
    private final String message;

    private final Optional<String> model;

    private final Boolean stream;

    private final Optional<String> preambleOverride;

    private final Optional<List<ChatMessage>> chatHistory;

    private final Optional<String> conversationId;

    private final Optional<ChatStreamRequestPromptTruncation> promptTruncation;

    private final Optional<List<ChatConnector>> connectors;

    private final Optional<Boolean> searchQueriesOnly;

    private final Optional<List<Map<String, String>>> documents;

    private final Optional<ChatStreamRequestCitationQuality> citationQuality;

    private final Optional<Double> temperature;

    private final Map<String, Object> additionalProperties;

    private ChatStreamRequest(
            String message,
            Optional<String> model,
            Boolean stream,
            Optional<String> preambleOverride,
            Optional<List<ChatMessage>> chatHistory,
            Optional<String> conversationId,
            Optional<ChatStreamRequestPromptTruncation> promptTruncation,
            Optional<List<ChatConnector>> connectors,
            Optional<Boolean> searchQueriesOnly,
            Optional<List<Map<String, String>>> documents,
            Optional<ChatStreamRequestCitationQuality> citationQuality,
            Optional<Double> temperature,
            Map<String, Object> additionalProperties) {
        this.message = message;
        this.model = model;
        this.stream = stream;
        this.preambleOverride = preambleOverride;
        this.chatHistory = chatHistory;
        this.conversationId = conversationId;
        this.promptTruncation = promptTruncation;
        this.connectors = connectors;
        this.searchQueriesOnly = searchQueriesOnly;
        this.documents = documents;
        this.citationQuality = citationQuality;
        this.temperature = temperature;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Accepts a string.
     * The chat message from the user to the model.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @return Defaults to <code>command</code>.
     * The identifier of the model, which can be one of the existing Cohere models or the full ID for a <a href="/docs/training-custom-models">finetuned custom model</a>.
     * Compatible Cohere models are <code>command</code> and <code>command-light</code> as well as the experimental <code>command-nightly</code> and <code>command-light-nightly</code> variants. Read more about <a href="https://docs.cohere.com/docs/models">Cohere models</a>.
     */
    @JsonProperty("model")
    public Optional<String> getModel() {
        return model;
    }

    @JsonProperty("stream")
    public Boolean getStream() {
        return stream;
    }

    /**
     * @return When specified, the default Cohere preamble will be replaced with the provided one.
     */
    @JsonProperty("preamble_override")
    public Optional<String> getPreambleOverride() {
        return preambleOverride;
    }

    /**
     * @return A list of previous messages between the user and the model, meant to give the model conversational context for responding to the user's <code>message</code>.
     */
    @JsonProperty("chat_history")
    public Optional<List<ChatMessage>> getChatHistory() {
        return chatHistory;
    }

    /**
     * @return An alternative to <code>chat_history</code>. Previous conversations can be resumed by providing the conversation's identifier. The contents of <code>message</code> and the model's response will be stored as part of this conversation.
     * If a conversation with this id does not already exist, a new conversation will be created.
     */
    @JsonProperty("conversation_id")
    public Optional<String> getConversationId() {
        return conversationId;
    }

    /**
     * @return Defaults to <code>AUTO</code> when <code>connectors</code> are specified and <code>OFF</code> in all other cases.
     * Dictates how the prompt will be constructed.
     * With <code>prompt_truncation</code> set to &quot;AUTO&quot;, some elements from <code>chat_history</code> and <code>documents</code> will be dropped in an attempt to construct a prompt that fits within the model's context length limit.
     * With <code>prompt_truncation</code> set to &quot;OFF&quot;, no elements will be dropped. If the sum of the inputs exceeds the model's context length limit, a <code>TooManyTokens</code> error will be returned.
     */
    @JsonProperty("prompt_truncation")
    public Optional<ChatStreamRequestPromptTruncation> getPromptTruncation() {
        return promptTruncation;
    }

    /**
     * @return Accepts <code>{&quot;id&quot;: &quot;web-search&quot;}</code>, and/or the <code>&quot;id&quot;</code> for a custom <a href="https://docs.cohere.com/docs/connectors">connector</a>, if you've <a href="https://docs.cohere.com/docs/creating-and-deploying-a-connector">created</a> one.
     * When specified, the model's reply will be enriched with information found by quering each of the connectors (RAG).
     */
    @JsonProperty("connectors")
    public Optional<List<ChatConnector>> getConnectors() {
        return connectors;
    }

    /**
     * @return Defaults to <code>false</code>.
     * When <code>true</code>, the response will only contain a list of generated search queries, but no search will take place, and no reply from the model to the user's <code>message</code> will be generated.
     */
    @JsonProperty("search_queries_only")
    public Optional<Boolean> getSearchQueriesOnly() {
        return searchQueriesOnly;
    }

    /**
     * @return A list of relevant documents that the model can use to enrich its reply. See <a href="https://docs.cohere.com/docs/retrieval-augmented-generation-rag#document-mode">'Document Mode'</a> in the guide for more information.
     */
    @JsonProperty("documents")
    public Optional<List<Map<String, String>>> getDocuments() {
        return documents;
    }

    /**
     * @return Defaults to <code>&quot;accurate&quot;</code>.
     * Dictates the approach taken to generating citations as part of the RAG flow by allowing the user to specify whether they want <code>&quot;accurate&quot;</code> results or <code>&quot;fast&quot;</code> results.
     */
    @JsonProperty("citation_quality")
    public Optional<ChatStreamRequestCitationQuality> getCitationQuality() {
        return citationQuality;
    }

    /**
     * @return Defaults to <code>0.3</code>
     * A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.
     */
    @JsonProperty("temperature")
    public Optional<Double> getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatStreamRequest && equalTo((ChatStreamRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatStreamRequest other) {
        return message.equals(other.message)
                && model.equals(other.model)
                && stream.equals(other.stream)
                && preambleOverride.equals(other.preambleOverride)
                && chatHistory.equals(other.chatHistory)
                && conversationId.equals(other.conversationId)
                && promptTruncation.equals(other.promptTruncation)
                && connectors.equals(other.connectors)
                && searchQueriesOnly.equals(other.searchQueriesOnly)
                && documents.equals(other.documents)
                && citationQuality.equals(other.citationQuality)
                && temperature.equals(other.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.message,
                this.model,
                this.stream,
                this.preambleOverride,
                this.chatHistory,
                this.conversationId,
                this.promptTruncation,
                this.connectors,
                this.searchQueriesOnly,
                this.documents,
                this.citationQuality,
                this.temperature);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MessageStage builder() {
        return new Builder();
    }

    public interface MessageStage {
        StreamStage message(String message);

        Builder from(ChatStreamRequest other);
    }

    public interface StreamStage {
        _FinalStage stream(Boolean stream);
    }

    public interface _FinalStage {
        ChatStreamRequest build();

        _FinalStage model(Optional<String> model);

        _FinalStage model(String model);

        _FinalStage preambleOverride(Optional<String> preambleOverride);

        _FinalStage preambleOverride(String preambleOverride);

        _FinalStage chatHistory(Optional<List<ChatMessage>> chatHistory);

        _FinalStage chatHistory(List<ChatMessage> chatHistory);

        _FinalStage conversationId(Optional<String> conversationId);

        _FinalStage conversationId(String conversationId);

        _FinalStage promptTruncation(Optional<ChatStreamRequestPromptTruncation> promptTruncation);

        _FinalStage promptTruncation(ChatStreamRequestPromptTruncation promptTruncation);

        _FinalStage connectors(Optional<List<ChatConnector>> connectors);

        _FinalStage connectors(List<ChatConnector> connectors);

        _FinalStage searchQueriesOnly(Optional<Boolean> searchQueriesOnly);

        _FinalStage searchQueriesOnly(Boolean searchQueriesOnly);

        _FinalStage documents(Optional<List<Map<String, String>>> documents);

        _FinalStage documents(List<Map<String, String>> documents);

        _FinalStage citationQuality(Optional<ChatStreamRequestCitationQuality> citationQuality);

        _FinalStage citationQuality(ChatStreamRequestCitationQuality citationQuality);

        _FinalStage temperature(Optional<Double> temperature);

        _FinalStage temperature(Double temperature);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MessageStage, StreamStage, _FinalStage {
        private String message;

        private Boolean stream;

        private Optional<Double> temperature = Optional.empty();

        private Optional<ChatStreamRequestCitationQuality> citationQuality = Optional.empty();

        private Optional<List<Map<String, String>>> documents = Optional.empty();

        private Optional<Boolean> searchQueriesOnly = Optional.empty();

        private Optional<List<ChatConnector>> connectors = Optional.empty();

        private Optional<ChatStreamRequestPromptTruncation> promptTruncation = Optional.empty();

        private Optional<String> conversationId = Optional.empty();

        private Optional<List<ChatMessage>> chatHistory = Optional.empty();

        private Optional<String> preambleOverride = Optional.empty();

        private Optional<String> model = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ChatStreamRequest other) {
            message(other.getMessage());
            model(other.getModel());
            stream(other.getStream());
            preambleOverride(other.getPreambleOverride());
            chatHistory(other.getChatHistory());
            conversationId(other.getConversationId());
            promptTruncation(other.getPromptTruncation());
            connectors(other.getConnectors());
            searchQueriesOnly(other.getSearchQueriesOnly());
            documents(other.getDocuments());
            citationQuality(other.getCitationQuality());
            temperature(other.getTemperature());
            return this;
        }

        /**
         * <p>Accepts a string.
         * The chat message from the user to the model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("message")
        public StreamStage message(String message) {
            this.message = message;
            return this;
        }

        @Override
        @JsonSetter("stream")
        public _FinalStage stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        /**
         * <p>Defaults to <code>0.3</code>
         * A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage temperature(Double temperature) {
            this.temperature = Optional.of(temperature);
            return this;
        }

        @Override
        @JsonSetter(value = "temperature", nulls = Nulls.SKIP)
        public _FinalStage temperature(Optional<Double> temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * <p>Defaults to <code>&quot;accurate&quot;</code>.
         * Dictates the approach taken to generating citations as part of the RAG flow by allowing the user to specify whether they want <code>&quot;accurate&quot;</code> results or <code>&quot;fast&quot;</code> results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage citationQuality(ChatStreamRequestCitationQuality citationQuality) {
            this.citationQuality = Optional.of(citationQuality);
            return this;
        }

        @Override
        @JsonSetter(value = "citation_quality", nulls = Nulls.SKIP)
        public _FinalStage citationQuality(Optional<ChatStreamRequestCitationQuality> citationQuality) {
            this.citationQuality = citationQuality;
            return this;
        }

        /**
         * <p>A list of relevant documents that the model can use to enrich its reply. See <a href="https://docs.cohere.com/docs/retrieval-augmented-generation-rag#document-mode">'Document Mode'</a> in the guide for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage documents(List<Map<String, String>> documents) {
            this.documents = Optional.of(documents);
            return this;
        }

        @Override
        @JsonSetter(value = "documents", nulls = Nulls.SKIP)
        public _FinalStage documents(Optional<List<Map<String, String>>> documents) {
            this.documents = documents;
            return this;
        }

        /**
         * <p>Defaults to <code>false</code>.
         * When <code>true</code>, the response will only contain a list of generated search queries, but no search will take place, and no reply from the model to the user's <code>message</code> will be generated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage searchQueriesOnly(Boolean searchQueriesOnly) {
            this.searchQueriesOnly = Optional.of(searchQueriesOnly);
            return this;
        }

        @Override
        @JsonSetter(value = "search_queries_only", nulls = Nulls.SKIP)
        public _FinalStage searchQueriesOnly(Optional<Boolean> searchQueriesOnly) {
            this.searchQueriesOnly = searchQueriesOnly;
            return this;
        }

        /**
         * <p>Accepts <code>{&quot;id&quot;: &quot;web-search&quot;}</code>, and/or the <code>&quot;id&quot;</code> for a custom <a href="https://docs.cohere.com/docs/connectors">connector</a>, if you've <a href="https://docs.cohere.com/docs/creating-and-deploying-a-connector">created</a> one.
         * When specified, the model's reply will be enriched with information found by quering each of the connectors (RAG).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage connectors(List<ChatConnector> connectors) {
            this.connectors = Optional.of(connectors);
            return this;
        }

        @Override
        @JsonSetter(value = "connectors", nulls = Nulls.SKIP)
        public _FinalStage connectors(Optional<List<ChatConnector>> connectors) {
            this.connectors = connectors;
            return this;
        }

        /**
         * <p>Defaults to <code>AUTO</code> when <code>connectors</code> are specified and <code>OFF</code> in all other cases.
         * Dictates how the prompt will be constructed.
         * With <code>prompt_truncation</code> set to &quot;AUTO&quot;, some elements from <code>chat_history</code> and <code>documents</code> will be dropped in an attempt to construct a prompt that fits within the model's context length limit.
         * With <code>prompt_truncation</code> set to &quot;OFF&quot;, no elements will be dropped. If the sum of the inputs exceeds the model's context length limit, a <code>TooManyTokens</code> error will be returned.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage promptTruncation(ChatStreamRequestPromptTruncation promptTruncation) {
            this.promptTruncation = Optional.of(promptTruncation);
            return this;
        }

        @Override
        @JsonSetter(value = "prompt_truncation", nulls = Nulls.SKIP)
        public _FinalStage promptTruncation(Optional<ChatStreamRequestPromptTruncation> promptTruncation) {
            this.promptTruncation = promptTruncation;
            return this;
        }

        /**
         * <p>An alternative to <code>chat_history</code>. Previous conversations can be resumed by providing the conversation's identifier. The contents of <code>message</code> and the model's response will be stored as part of this conversation.
         * If a conversation with this id does not already exist, a new conversation will be created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage conversationId(String conversationId) {
            this.conversationId = Optional.of(conversationId);
            return this;
        }

        @Override
        @JsonSetter(value = "conversation_id", nulls = Nulls.SKIP)
        public _FinalStage conversationId(Optional<String> conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        /**
         * <p>A list of previous messages between the user and the model, meant to give the model conversational context for responding to the user's <code>message</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage chatHistory(List<ChatMessage> chatHistory) {
            this.chatHistory = Optional.of(chatHistory);
            return this;
        }

        @Override
        @JsonSetter(value = "chat_history", nulls = Nulls.SKIP)
        public _FinalStage chatHistory(Optional<List<ChatMessage>> chatHistory) {
            this.chatHistory = chatHistory;
            return this;
        }

        /**
         * <p>When specified, the default Cohere preamble will be replaced with the provided one.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage preambleOverride(String preambleOverride) {
            this.preambleOverride = Optional.of(preambleOverride);
            return this;
        }

        @Override
        @JsonSetter(value = "preamble_override", nulls = Nulls.SKIP)
        public _FinalStage preambleOverride(Optional<String> preambleOverride) {
            this.preambleOverride = preambleOverride;
            return this;
        }

        /**
         * <p>Defaults to <code>command</code>.
         * The identifier of the model, which can be one of the existing Cohere models or the full ID for a <a href="/docs/training-custom-models">finetuned custom model</a>.
         * Compatible Cohere models are <code>command</code> and <code>command-light</code> as well as the experimental <code>command-nightly</code> and <code>command-light-nightly</code> variants. Read more about <a href="https://docs.cohere.com/docs/models">Cohere models</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage model(String model) {
            this.model = Optional.of(model);
            return this;
        }

        @Override
        @JsonSetter(value = "model", nulls = Nulls.SKIP)
        public _FinalStage model(Optional<String> model) {
            this.model = model;
            return this;
        }

        @Override
        public ChatStreamRequest build() {
            return new ChatStreamRequest(
                    message,
                    model,
                    stream,
                    preambleOverride,
                    chatHistory,
                    conversationId,
                    promptTruncation,
                    connectors,
                    searchQueriesOnly,
                    documents,
                    citationQuality,
                    temperature,
                    additionalProperties);
        }
    }
}
