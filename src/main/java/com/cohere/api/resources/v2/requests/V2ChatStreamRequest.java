/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.resources.v2.types.V2ChatStreamRequestDocumentsItem;
import com.cohere.api.resources.v2.types.V2ChatStreamRequestSafetyMode;
import com.cohere.api.types.ChatMessageV2;
import com.cohere.api.types.CitationOptions;
import com.cohere.api.types.ResponseFormatV2;
import com.cohere.api.types.ToolV2;
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
@JsonDeserialize(builder = V2ChatStreamRequest.Builder.class)
public final class V2ChatStreamRequest {
    private final String model;

    private final List<ChatMessageV2> messages;

    private final Optional<List<ToolV2>> tools;

    private final Optional<List<V2ChatStreamRequestDocumentsItem>> documents;

    private final Optional<CitationOptions> citationOptions;

    private final Optional<ResponseFormatV2> responseFormat;

    private final Optional<V2ChatStreamRequestSafetyMode> safetyMode;

    private final Optional<Integer> maxTokens;

    private final Optional<List<String>> stopSequences;

    private final Optional<Double> temperature;

    private final Optional<Integer> seed;

    private final Optional<Double> frequencyPenalty;

    private final Optional<Double> presencePenalty;

    private final Optional<Double> k;

    private final Optional<Double> p;

    private final Optional<Boolean> returnPrompt;

    private final Map<String, Object> additionalProperties;

    private V2ChatStreamRequest(
            String model,
            List<ChatMessageV2> messages,
            Optional<List<ToolV2>> tools,
            Optional<List<V2ChatStreamRequestDocumentsItem>> documents,
            Optional<CitationOptions> citationOptions,
            Optional<ResponseFormatV2> responseFormat,
            Optional<V2ChatStreamRequestSafetyMode> safetyMode,
            Optional<Integer> maxTokens,
            Optional<List<String>> stopSequences,
            Optional<Double> temperature,
            Optional<Integer> seed,
            Optional<Double> frequencyPenalty,
            Optional<Double> presencePenalty,
            Optional<Double> k,
            Optional<Double> p,
            Optional<Boolean> returnPrompt,
            Map<String, Object> additionalProperties) {
        this.model = model;
        this.messages = messages;
        this.tools = tools;
        this.documents = documents;
        this.citationOptions = citationOptions;
        this.responseFormat = responseFormat;
        this.safetyMode = safetyMode;
        this.maxTokens = maxTokens;
        this.stopSequences = stopSequences;
        this.temperature = temperature;
        this.seed = seed;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
        this.k = k;
        this.p = p;
        this.returnPrompt = returnPrompt;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of a compatible <a href="https://docs.cohere.com/docs/models">Cohere model</a> (such as command-r or command-r-plus) or the ID of a <a href="https://docs.cohere.com/docs/chat-fine-tuning">fine-tuned</a> model.
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("messages")
    public List<ChatMessageV2> getMessages() {
        return messages;
    }

    /**
     * @return A list of available tools (functions) that the model may suggest invoking before producing a text response.
     * <p>When <code>tools</code> is passed (without <code>tool_results</code>), the <code>text</code> content in the response will be empty and the <code>tool_calls</code> field in the response will be populated with a list of tool calls that need to be made. If no calls need to be made, the <code>tool_calls</code> array will be empty.</p>
     */
    @JsonProperty("tools")
    public Optional<List<ToolV2>> getTools() {
        return tools;
    }

    /**
     * @return A list of relevant documents that the model can cite to generate a more accurate reply. Each document is either a string or document object with content and metadata.
     */
    @JsonProperty("documents")
    public Optional<List<V2ChatStreamRequestDocumentsItem>> getDocuments() {
        return documents;
    }

    @JsonProperty("citation_options")
    public Optional<CitationOptions> getCitationOptions() {
        return citationOptions;
    }

    @JsonProperty("response_format")
    public Optional<ResponseFormatV2> getResponseFormat() {
        return responseFormat;
    }

    /**
     * @return Used to select the <a href="/docs/safety-modes">safety instruction</a> inserted into the prompt. Defaults to <code>CONTEXTUAL</code>.
     * When <code>OFF</code> is specified, the safety instruction will be omitted.
     * <p>Safety modes are not yet configurable in combination with <code>tools</code>, <code>tool_results</code> and <code>documents</code> parameters.</p>
     * <p><strong>Note</strong>: This parameter is only compatible with models <a href="/docs/command-r#august-2024-release">Command R 08-2024</a>, <a href="/docs/command-r-plus#august-2024-release">Command R+ 08-2024</a> and newer.</p>
     * <p>Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments</p>
     */
    @JsonProperty("safety_mode")
    public Optional<V2ChatStreamRequestSafetyMode> getSafetyMode() {
        return safetyMode;
    }

    /**
     * @return The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.
     */
    @JsonProperty("max_tokens")
    public Optional<Integer> getMaxTokens() {
        return maxTokens;
    }

    /**
     * @return A list of up to 5 strings that the model will use to stop generation. If the model generates a string that matches any of the strings in the list, it will stop generating tokens and return the generated text up to that point not including the stop sequence.
     */
    @JsonProperty("stop_sequences")
    public Optional<List<String>> getStopSequences() {
        return stopSequences;
    }

    /**
     * @return Defaults to <code>0.3</code>.
     * <p>A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.</p>
     * <p>Randomness can be further maximized by increasing the  value of the <code>p</code> parameter.</p>
     */
    @JsonProperty("temperature")
    public Optional<Double> getTemperature() {
        return temperature;
    }

    /**
     * @return If specified, the backend will make a best effort to sample tokens
     * deterministically, such that repeated requests with the same
     * seed and parameters should return the same result. However,
     * determinism cannot be totally guaranteed.
     */
    @JsonProperty("seed")
    public Optional<Integer> getSeed() {
        return seed;
    }

    /**
     * @return Defaults to <code>0.0</code>, min value of <code>0.0</code>, max value of <code>1.0</code>.
     * Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.
     */
    @JsonProperty("frequency_penalty")
    public Optional<Double> getFrequencyPenalty() {
        return frequencyPenalty;
    }

    /**
     * @return Defaults to <code>0.0</code>, min value of <code>0.0</code>, max value of <code>1.0</code>.
     * Used to reduce repetitiveness of generated tokens. Similar to <code>frequency_penalty</code>, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.
     */
    @JsonProperty("presence_penalty")
    public Optional<Double> getPresencePenalty() {
        return presencePenalty;
    }

    /**
     * @return Ensures only the top <code>k</code> most likely tokens are considered for generation at each step.
     * Defaults to <code>0</code>, min value of <code>0</code>, max value of <code>500</code>.
     */
    @JsonProperty("k")
    public Optional<Double> getK() {
        return k;
    }

    /**
     * @return Ensures that only the most likely tokens, with total probability mass of <code>p</code>, are considered for generation at each step. If both <code>k</code> and <code>p</code> are enabled, <code>p</code> acts after <code>k</code>.
     * Defaults to <code>0.75</code>. min value of <code>0.01</code>, max value of <code>0.99</code>.
     */
    @JsonProperty("p")
    public Optional<Double> getP() {
        return p;
    }

    /**
     * @return Whether to return the prompt in the response.
     */
    @JsonProperty("return_prompt")
    public Optional<Boolean> getReturnPrompt() {
        return returnPrompt;
    }

    @JsonProperty("stream")
    public Boolean getStream() {
        return true;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ChatStreamRequest && equalTo((V2ChatStreamRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ChatStreamRequest other) {
        return model.equals(other.model)
                && messages.equals(other.messages)
                && tools.equals(other.tools)
                && documents.equals(other.documents)
                && citationOptions.equals(other.citationOptions)
                && responseFormat.equals(other.responseFormat)
                && safetyMode.equals(other.safetyMode)
                && maxTokens.equals(other.maxTokens)
                && stopSequences.equals(other.stopSequences)
                && temperature.equals(other.temperature)
                && seed.equals(other.seed)
                && frequencyPenalty.equals(other.frequencyPenalty)
                && presencePenalty.equals(other.presencePenalty)
                && k.equals(other.k)
                && p.equals(other.p)
                && returnPrompt.equals(other.returnPrompt);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.model,
                this.messages,
                this.tools,
                this.documents,
                this.citationOptions,
                this.responseFormat,
                this.safetyMode,
                this.maxTokens,
                this.stopSequences,
                this.temperature,
                this.seed,
                this.frequencyPenalty,
                this.presencePenalty,
                this.k,
                this.p,
                this.returnPrompt);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        _FinalStage model(String model);

        Builder from(V2ChatStreamRequest other);
    }

    public interface _FinalStage {
        V2ChatStreamRequest build();

        _FinalStage messages(List<ChatMessageV2> messages);

        _FinalStage addMessages(ChatMessageV2 messages);

        _FinalStage addAllMessages(List<ChatMessageV2> messages);

        _FinalStage tools(Optional<List<ToolV2>> tools);

        _FinalStage tools(List<ToolV2> tools);

        _FinalStage documents(Optional<List<V2ChatStreamRequestDocumentsItem>> documents);

        _FinalStage documents(List<V2ChatStreamRequestDocumentsItem> documents);

        _FinalStage citationOptions(Optional<CitationOptions> citationOptions);

        _FinalStage citationOptions(CitationOptions citationOptions);

        _FinalStage responseFormat(Optional<ResponseFormatV2> responseFormat);

        _FinalStage responseFormat(ResponseFormatV2 responseFormat);

        _FinalStage safetyMode(Optional<V2ChatStreamRequestSafetyMode> safetyMode);

        _FinalStage safetyMode(V2ChatStreamRequestSafetyMode safetyMode);

        _FinalStage maxTokens(Optional<Integer> maxTokens);

        _FinalStage maxTokens(Integer maxTokens);

        _FinalStage stopSequences(Optional<List<String>> stopSequences);

        _FinalStage stopSequences(List<String> stopSequences);

        _FinalStage temperature(Optional<Double> temperature);

        _FinalStage temperature(Double temperature);

        _FinalStage seed(Optional<Integer> seed);

        _FinalStage seed(Integer seed);

        _FinalStage frequencyPenalty(Optional<Double> frequencyPenalty);

        _FinalStage frequencyPenalty(Double frequencyPenalty);

        _FinalStage presencePenalty(Optional<Double> presencePenalty);

        _FinalStage presencePenalty(Double presencePenalty);

        _FinalStage k(Optional<Double> k);

        _FinalStage k(Double k);

        _FinalStage p(Optional<Double> p);

        _FinalStage p(Double p);

        _FinalStage returnPrompt(Optional<Boolean> returnPrompt);

        _FinalStage returnPrompt(Boolean returnPrompt);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, _FinalStage {
        private String model;

        private Optional<Boolean> returnPrompt = Optional.empty();

        private Optional<Double> p = Optional.empty();

        private Optional<Double> k = Optional.empty();

        private Optional<Double> presencePenalty = Optional.empty();

        private Optional<Double> frequencyPenalty = Optional.empty();

        private Optional<Integer> seed = Optional.empty();

        private Optional<Double> temperature = Optional.empty();

        private Optional<List<String>> stopSequences = Optional.empty();

        private Optional<Integer> maxTokens = Optional.empty();

        private Optional<V2ChatStreamRequestSafetyMode> safetyMode = Optional.empty();

        private Optional<ResponseFormatV2> responseFormat = Optional.empty();

        private Optional<CitationOptions> citationOptions = Optional.empty();

        private Optional<List<V2ChatStreamRequestDocumentsItem>> documents = Optional.empty();

        private Optional<List<ToolV2>> tools = Optional.empty();

        private List<ChatMessageV2> messages = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(V2ChatStreamRequest other) {
            model(other.getModel());
            messages(other.getMessages());
            tools(other.getTools());
            documents(other.getDocuments());
            citationOptions(other.getCitationOptions());
            responseFormat(other.getResponseFormat());
            safetyMode(other.getSafetyMode());
            maxTokens(other.getMaxTokens());
            stopSequences(other.getStopSequences());
            temperature(other.getTemperature());
            seed(other.getSeed());
            frequencyPenalty(other.getFrequencyPenalty());
            presencePenalty(other.getPresencePenalty());
            k(other.getK());
            p(other.getP());
            returnPrompt(other.getReturnPrompt());
            return this;
        }

        /**
         * <p>The name of a compatible <a href="https://docs.cohere.com/docs/models">Cohere model</a> (such as command-r or command-r-plus) or the ID of a <a href="https://docs.cohere.com/docs/chat-fine-tuning">fine-tuned</a> model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("model")
        public _FinalStage model(String model) {
            this.model = model;
            return this;
        }

        /**
         * <p>Whether to return the prompt in the response.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage returnPrompt(Boolean returnPrompt) {
            this.returnPrompt = Optional.of(returnPrompt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "return_prompt", nulls = Nulls.SKIP)
        public _FinalStage returnPrompt(Optional<Boolean> returnPrompt) {
            this.returnPrompt = returnPrompt;
            return this;
        }

        /**
         * <p>Ensures that only the most likely tokens, with total probability mass of <code>p</code>, are considered for generation at each step. If both <code>k</code> and <code>p</code> are enabled, <code>p</code> acts after <code>k</code>.
         * Defaults to <code>0.75</code>. min value of <code>0.01</code>, max value of <code>0.99</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage p(Double p) {
            this.p = Optional.of(p);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "p", nulls = Nulls.SKIP)
        public _FinalStage p(Optional<Double> p) {
            this.p = p;
            return this;
        }

        /**
         * <p>Ensures only the top <code>k</code> most likely tokens are considered for generation at each step.
         * Defaults to <code>0</code>, min value of <code>0</code>, max value of <code>500</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage k(Double k) {
            this.k = Optional.of(k);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "k", nulls = Nulls.SKIP)
        public _FinalStage k(Optional<Double> k) {
            this.k = k;
            return this;
        }

        /**
         * <p>Defaults to <code>0.0</code>, min value of <code>0.0</code>, max value of <code>1.0</code>.
         * Used to reduce repetitiveness of generated tokens. Similar to <code>frequency_penalty</code>, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage presencePenalty(Double presencePenalty) {
            this.presencePenalty = Optional.of(presencePenalty);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "presence_penalty", nulls = Nulls.SKIP)
        public _FinalStage presencePenalty(Optional<Double> presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        /**
         * <p>Defaults to <code>0.0</code>, min value of <code>0.0</code>, max value of <code>1.0</code>.
         * Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage frequencyPenalty(Double frequencyPenalty) {
            this.frequencyPenalty = Optional.of(frequencyPenalty);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "frequency_penalty", nulls = Nulls.SKIP)
        public _FinalStage frequencyPenalty(Optional<Double> frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        /**
         * <p>If specified, the backend will make a best effort to sample tokens
         * deterministically, such that repeated requests with the same
         * seed and parameters should return the same result. However,
         * determinism cannot be totally guaranteed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage seed(Integer seed) {
            this.seed = Optional.of(seed);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "seed", nulls = Nulls.SKIP)
        public _FinalStage seed(Optional<Integer> seed) {
            this.seed = seed;
            return this;
        }

        /**
         * <p>Defaults to <code>0.3</code>.</p>
         * <p>A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.</p>
         * <p>Randomness can be further maximized by increasing the  value of the <code>p</code> parameter.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage temperature(Double temperature) {
            this.temperature = Optional.of(temperature);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "temperature", nulls = Nulls.SKIP)
        public _FinalStage temperature(Optional<Double> temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * <p>A list of up to 5 strings that the model will use to stop generation. If the model generates a string that matches any of the strings in the list, it will stop generating tokens and return the generated text up to that point not including the stop sequence.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage stopSequences(List<String> stopSequences) {
            this.stopSequences = Optional.of(stopSequences);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "stop_sequences", nulls = Nulls.SKIP)
        public _FinalStage stopSequences(Optional<List<String>> stopSequences) {
            this.stopSequences = stopSequences;
            return this;
        }

        /**
         * <p>The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage maxTokens(Integer maxTokens) {
            this.maxTokens = Optional.of(maxTokens);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "max_tokens", nulls = Nulls.SKIP)
        public _FinalStage maxTokens(Optional<Integer> maxTokens) {
            this.maxTokens = maxTokens;
            return this;
        }

        /**
         * <p>Used to select the <a href="/docs/safety-modes">safety instruction</a> inserted into the prompt. Defaults to <code>CONTEXTUAL</code>.
         * When <code>OFF</code> is specified, the safety instruction will be omitted.</p>
         * <p>Safety modes are not yet configurable in combination with <code>tools</code>, <code>tool_results</code> and <code>documents</code> parameters.</p>
         * <p><strong>Note</strong>: This parameter is only compatible with models <a href="/docs/command-r#august-2024-release">Command R 08-2024</a>, <a href="/docs/command-r-plus#august-2024-release">Command R+ 08-2024</a> and newer.</p>
         * <p>Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage safetyMode(V2ChatStreamRequestSafetyMode safetyMode) {
            this.safetyMode = Optional.of(safetyMode);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "safety_mode", nulls = Nulls.SKIP)
        public _FinalStage safetyMode(Optional<V2ChatStreamRequestSafetyMode> safetyMode) {
            this.safetyMode = safetyMode;
            return this;
        }

        @java.lang.Override
        public _FinalStage responseFormat(ResponseFormatV2 responseFormat) {
            this.responseFormat = Optional.of(responseFormat);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "response_format", nulls = Nulls.SKIP)
        public _FinalStage responseFormat(Optional<ResponseFormatV2> responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }

        @java.lang.Override
        public _FinalStage citationOptions(CitationOptions citationOptions) {
            this.citationOptions = Optional.of(citationOptions);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "citation_options", nulls = Nulls.SKIP)
        public _FinalStage citationOptions(Optional<CitationOptions> citationOptions) {
            this.citationOptions = citationOptions;
            return this;
        }

        /**
         * <p>A list of relevant documents that the model can cite to generate a more accurate reply. Each document is either a string or document object with content and metadata.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage documents(List<V2ChatStreamRequestDocumentsItem> documents) {
            this.documents = Optional.of(documents);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "documents", nulls = Nulls.SKIP)
        public _FinalStage documents(Optional<List<V2ChatStreamRequestDocumentsItem>> documents) {
            this.documents = documents;
            return this;
        }

        /**
         * <p>A list of available tools (functions) that the model may suggest invoking before producing a text response.</p>
         * <p>When <code>tools</code> is passed (without <code>tool_results</code>), the <code>text</code> content in the response will be empty and the <code>tool_calls</code> field in the response will be populated with a list of tool calls that need to be made. If no calls need to be made, the <code>tool_calls</code> array will be empty.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage tools(List<ToolV2> tools) {
            this.tools = Optional.of(tools);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "tools", nulls = Nulls.SKIP)
        public _FinalStage tools(Optional<List<ToolV2>> tools) {
            this.tools = tools;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllMessages(List<ChatMessageV2> messages) {
            this.messages.addAll(messages);
            return this;
        }

        @java.lang.Override
        public _FinalStage addMessages(ChatMessageV2 messages) {
            this.messages.add(messages);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "messages", nulls = Nulls.SKIP)
        public _FinalStage messages(List<ChatMessageV2> messages) {
            this.messages.clear();
            this.messages.addAll(messages);
            return this;
        }

        @java.lang.Override
        public V2ChatStreamRequest build() {
            return new V2ChatStreamRequest(
                    model,
                    messages,
                    tools,
                    documents,
                    citationOptions,
                    responseFormat,
                    safetyMode,
                    maxTokens,
                    stopSequences,
                    temperature,
                    seed,
                    frequencyPenalty,
                    presencePenalty,
                    k,
                    p,
                    returnPrompt,
                    additionalProperties);
        }
    }
}
