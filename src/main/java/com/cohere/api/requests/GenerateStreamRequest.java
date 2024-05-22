/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.GenerateStreamRequestReturnLikelihoods;
import com.cohere.api.types.GenerateStreamRequestTruncate;
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
@JsonDeserialize(builder = GenerateStreamRequest.Builder.class)
public final class GenerateStreamRequest {
    private final String prompt;

    private final Optional<String> model;

    private final Optional<Integer> numGenerations;

    private final Optional<Integer> maxTokens;

    private final Optional<GenerateStreamRequestTruncate> truncate;

    private final Optional<Double> temperature;

    private final Optional<Double> seed;

    private final Optional<String> preset;

    private final Optional<List<String>> endSequences;

    private final Optional<List<String>> stopSequences;

    private final Optional<Integer> k;

    private final Optional<Double> p;

    private final Optional<Double> frequencyPenalty;

    private final Optional<Double> presencePenalty;

    private final Optional<GenerateStreamRequestReturnLikelihoods> returnLikelihoods;

    private final Optional<Boolean> rawPrompting;

    private final Map<String, Object> additionalProperties;

    private GenerateStreamRequest(
            String prompt,
            Optional<String> model,
            Optional<Integer> numGenerations,
            Optional<Integer> maxTokens,
            Optional<GenerateStreamRequestTruncate> truncate,
            Optional<Double> temperature,
            Optional<Double> seed,
            Optional<String> preset,
            Optional<List<String>> endSequences,
            Optional<List<String>> stopSequences,
            Optional<Integer> k,
            Optional<Double> p,
            Optional<Double> frequencyPenalty,
            Optional<Double> presencePenalty,
            Optional<GenerateStreamRequestReturnLikelihoods> returnLikelihoods,
            Optional<Boolean> rawPrompting,
            Map<String, Object> additionalProperties) {
        this.prompt = prompt;
        this.model = model;
        this.numGenerations = numGenerations;
        this.maxTokens = maxTokens;
        this.truncate = truncate;
        this.temperature = temperature;
        this.seed = seed;
        this.preset = preset;
        this.endSequences = endSequences;
        this.stopSequences = stopSequences;
        this.k = k;
        this.p = p;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
        this.returnLikelihoods = returnLikelihoods;
        this.rawPrompting = rawPrompting;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The input text that serves as the starting point for generating the response.
     * Note: The prompt will be pre-processed and modified before reaching the model.
     */
    @JsonProperty("prompt")
    public String getPrompt() {
        return prompt;
    }

    /**
     * @return The identifier of the model to generate with. Currently available models are <code>command</code> (default), <code>command-nightly</code> (experimental), <code>command-light</code>, and <code>command-light-nightly</code> (experimental).
     * Smaller, &quot;light&quot; models are faster, while larger models will perform better. <a href="/docs/training-custom-models">Custom models</a> can also be supplied with their full ID.
     */
    @JsonProperty("model")
    public Optional<String> getModel() {
        return model;
    }

    /**
     * @return The maximum number of generations that will be returned. Defaults to <code>1</code>, min value of <code>1</code>, max value of <code>5</code>.
     */
    @JsonProperty("num_generations")
    public Optional<Integer> getNumGenerations() {
        return numGenerations;
    }

    /**
     * @return When <code>true</code>, the response will be a JSON stream of events. Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.
     * <p>The final event will contain the complete response, and will contain an <code>is_finished</code> field set to <code>true</code>. The event will also contain a <code>finish_reason</code>, which can be one of the following:</p>
     * <ul>
     * <li><code>COMPLETE</code> - the model sent back a finished reply</li>
     * <li><code>MAX_TOKENS</code> - the reply was cut off because the model reached the maximum number of tokens for its context length</li>
     * <li><code>ERROR</code> - something went wrong when generating the reply</li>
     * <li><code>ERROR_TOXIC</code> - the model generated a reply that was deemed toxic</li>
     * </ul>
     */
    @JsonProperty("stream")
    public Boolean getStream() {
        return true;
    }

    /**
     * @return The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.
     * <p>This parameter is off by default, and if it's not specified, the model will continue generating until it emits an EOS completion token. See <a href="/bpe-tokens-wiki">BPE Tokens</a> for more details.</p>
     * <p>Can only be set to <code>0</code> if <code>return_likelihoods</code> is set to <code>ALL</code> to get the likelihood of the prompt.</p>
     */
    @JsonProperty("max_tokens")
    public Optional<Integer> getMaxTokens() {
        return maxTokens;
    }

    /**
     * @return One of <code>NONE|START|END</code> to specify how the API will handle inputs longer than the maximum token length.
     * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
     * <p>If <code>NONE</code> is selected, when the input exceeds the maximum input token length an error will be returned.</p>
     */
    @JsonProperty("truncate")
    public Optional<GenerateStreamRequestTruncate> getTruncate() {
        return truncate;
    }

    /**
     * @return A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations. See <a href="/temperature-wiki">Temperature</a> for more details.
     * Defaults to <code>0.75</code>, min value of <code>0.0</code>, max value of <code>5.0</code>.
     */
    @JsonProperty("temperature")
    public Optional<Double> getTemperature() {
        return temperature;
    }

    /**
     * @return If specified, the backend will make a best effort to sample tokens deterministically, such that repeated requests with the same seed and parameters should return the same result. However, determinsim cannot be totally guaranteed.
     */
    @JsonProperty("seed")
    public Optional<Double> getSeed() {
        return seed;
    }

    /**
     * @return Identifier of a custom preset. A preset is a combination of parameters, such as prompt, temperature etc. You can create presets in the <a href="https://dashboard.cohere.com/playground/generate">playground</a>.
     * When a preset is specified, the <code>prompt</code> parameter becomes optional, and any included parameters will override the preset's parameters.
     */
    @JsonProperty("preset")
    public Optional<String> getPreset() {
        return preset;
    }

    /**
     * @return The generated text will be cut at the beginning of the earliest occurrence of an end sequence. The sequence will be excluded from the text.
     */
    @JsonProperty("end_sequences")
    public Optional<List<String>> getEndSequences() {
        return endSequences;
    }

    /**
     * @return The generated text will be cut at the end of the earliest occurrence of a stop sequence. The sequence will be included the text.
     */
    @JsonProperty("stop_sequences")
    public Optional<List<String>> getStopSequences() {
        return stopSequences;
    }

    /**
     * @return Ensures only the top <code>k</code> most likely tokens are considered for generation at each step.
     * Defaults to <code>0</code>, min value of <code>0</code>, max value of <code>500</code>.
     */
    @JsonProperty("k")
    public Optional<Integer> getK() {
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
     * @return Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.
     * <p>Using <code>frequency_penalty</code> in combination with <code>presence_penalty</code> is not supported on newer models.</p>
     */
    @JsonProperty("frequency_penalty")
    public Optional<Double> getFrequencyPenalty() {
        return frequencyPenalty;
    }

    /**
     * @return Defaults to <code>0.0</code>, min value of <code>0.0</code>, max value of <code>1.0</code>.
     * <p>Can be used to reduce repetitiveness of generated tokens. Similar to <code>frequency_penalty</code>, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.</p>
     * <p>Using <code>frequency_penalty</code> in combination with <code>presence_penalty</code> is not supported on newer models.</p>
     */
    @JsonProperty("presence_penalty")
    public Optional<Double> getPresencePenalty() {
        return presencePenalty;
    }

    /**
     * @return One of <code>GENERATION|ALL|NONE</code> to specify how and if the token likelihoods are returned with the response. Defaults to <code>NONE</code>.
     * <p>If <code>GENERATION</code> is selected, the token likelihoods will only be provided for generated text.</p>
     * <p>If <code>ALL</code> is selected, the token likelihoods will be provided both for the prompt and the generated text.</p>
     */
    @JsonProperty("return_likelihoods")
    public Optional<GenerateStreamRequestReturnLikelihoods> getReturnLikelihoods() {
        return returnLikelihoods;
    }

    /**
     * @return When enabled, the user's prompt will be sent to the model without any pre-processing.
     */
    @JsonProperty("raw_prompting")
    public Optional<Boolean> getRawPrompting() {
        return rawPrompting;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GenerateStreamRequest && equalTo((GenerateStreamRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GenerateStreamRequest other) {
        return prompt.equals(other.prompt)
                && model.equals(other.model)
                && numGenerations.equals(other.numGenerations)
                && maxTokens.equals(other.maxTokens)
                && truncate.equals(other.truncate)
                && temperature.equals(other.temperature)
                && seed.equals(other.seed)
                && preset.equals(other.preset)
                && endSequences.equals(other.endSequences)
                && stopSequences.equals(other.stopSequences)
                && k.equals(other.k)
                && p.equals(other.p)
                && frequencyPenalty.equals(other.frequencyPenalty)
                && presencePenalty.equals(other.presencePenalty)
                && returnLikelihoods.equals(other.returnLikelihoods)
                && rawPrompting.equals(other.rawPrompting);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.prompt,
                this.model,
                this.numGenerations,
                this.maxTokens,
                this.truncate,
                this.temperature,
                this.seed,
                this.preset,
                this.endSequences,
                this.stopSequences,
                this.k,
                this.p,
                this.frequencyPenalty,
                this.presencePenalty,
                this.returnLikelihoods,
                this.rawPrompting);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PromptStage builder() {
        return new Builder();
    }

    public interface PromptStage {
        _FinalStage prompt(String prompt);

        Builder from(GenerateStreamRequest other);
    }

    public interface _FinalStage {
        GenerateStreamRequest build();

        _FinalStage model(Optional<String> model);

        _FinalStage model(String model);

        _FinalStage numGenerations(Optional<Integer> numGenerations);

        _FinalStage numGenerations(Integer numGenerations);

        _FinalStage maxTokens(Optional<Integer> maxTokens);

        _FinalStage maxTokens(Integer maxTokens);

        _FinalStage truncate(Optional<GenerateStreamRequestTruncate> truncate);

        _FinalStage truncate(GenerateStreamRequestTruncate truncate);

        _FinalStage temperature(Optional<Double> temperature);

        _FinalStage temperature(Double temperature);

        _FinalStage seed(Optional<Double> seed);

        _FinalStage seed(Double seed);

        _FinalStage preset(Optional<String> preset);

        _FinalStage preset(String preset);

        _FinalStage endSequences(Optional<List<String>> endSequences);

        _FinalStage endSequences(List<String> endSequences);

        _FinalStage stopSequences(Optional<List<String>> stopSequences);

        _FinalStage stopSequences(List<String> stopSequences);

        _FinalStage k(Optional<Integer> k);

        _FinalStage k(Integer k);

        _FinalStage p(Optional<Double> p);

        _FinalStage p(Double p);

        _FinalStage frequencyPenalty(Optional<Double> frequencyPenalty);

        _FinalStage frequencyPenalty(Double frequencyPenalty);

        _FinalStage presencePenalty(Optional<Double> presencePenalty);

        _FinalStage presencePenalty(Double presencePenalty);

        _FinalStage returnLikelihoods(Optional<GenerateStreamRequestReturnLikelihoods> returnLikelihoods);

        _FinalStage returnLikelihoods(GenerateStreamRequestReturnLikelihoods returnLikelihoods);

        _FinalStage rawPrompting(Optional<Boolean> rawPrompting);

        _FinalStage rawPrompting(Boolean rawPrompting);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PromptStage, _FinalStage {
        private String prompt;

        private Optional<Boolean> rawPrompting = Optional.empty();

        private Optional<GenerateStreamRequestReturnLikelihoods> returnLikelihoods = Optional.empty();

        private Optional<Double> presencePenalty = Optional.empty();

        private Optional<Double> frequencyPenalty = Optional.empty();

        private Optional<Double> p = Optional.empty();

        private Optional<Integer> k = Optional.empty();

        private Optional<List<String>> stopSequences = Optional.empty();

        private Optional<List<String>> endSequences = Optional.empty();

        private Optional<String> preset = Optional.empty();

        private Optional<Double> seed = Optional.empty();

        private Optional<Double> temperature = Optional.empty();

        private Optional<GenerateStreamRequestTruncate> truncate = Optional.empty();

        private Optional<Integer> maxTokens = Optional.empty();

        private Optional<Integer> numGenerations = Optional.empty();

        private Optional<String> model = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GenerateStreamRequest other) {
            prompt(other.getPrompt());
            model(other.getModel());
            numGenerations(other.getNumGenerations());
            maxTokens(other.getMaxTokens());
            truncate(other.getTruncate());
            temperature(other.getTemperature());
            seed(other.getSeed());
            preset(other.getPreset());
            endSequences(other.getEndSequences());
            stopSequences(other.getStopSequences());
            k(other.getK());
            p(other.getP());
            frequencyPenalty(other.getFrequencyPenalty());
            presencePenalty(other.getPresencePenalty());
            returnLikelihoods(other.getReturnLikelihoods());
            rawPrompting(other.getRawPrompting());
            return this;
        }

        /**
         * <p>The input text that serves as the starting point for generating the response.
         * Note: The prompt will be pre-processed and modified before reaching the model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("prompt")
        public _FinalStage prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        /**
         * <p>When enabled, the user's prompt will be sent to the model without any pre-processing.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage rawPrompting(Boolean rawPrompting) {
            this.rawPrompting = Optional.of(rawPrompting);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "raw_prompting", nulls = Nulls.SKIP)
        public _FinalStage rawPrompting(Optional<Boolean> rawPrompting) {
            this.rawPrompting = rawPrompting;
            return this;
        }

        /**
         * <p>One of <code>GENERATION|ALL|NONE</code> to specify how and if the token likelihoods are returned with the response. Defaults to <code>NONE</code>.</p>
         * <p>If <code>GENERATION</code> is selected, the token likelihoods will only be provided for generated text.</p>
         * <p>If <code>ALL</code> is selected, the token likelihoods will be provided both for the prompt and the generated text.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage returnLikelihoods(GenerateStreamRequestReturnLikelihoods returnLikelihoods) {
            this.returnLikelihoods = Optional.of(returnLikelihoods);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "return_likelihoods", nulls = Nulls.SKIP)
        public _FinalStage returnLikelihoods(Optional<GenerateStreamRequestReturnLikelihoods> returnLikelihoods) {
            this.returnLikelihoods = returnLikelihoods;
            return this;
        }

        /**
         * <p>Defaults to <code>0.0</code>, min value of <code>0.0</code>, max value of <code>1.0</code>.</p>
         * <p>Can be used to reduce repetitiveness of generated tokens. Similar to <code>frequency_penalty</code>, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.</p>
         * <p>Using <code>frequency_penalty</code> in combination with <code>presence_penalty</code> is not supported on newer models.</p>
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
         * <p>Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.</p>
         * <p>Using <code>frequency_penalty</code> in combination with <code>presence_penalty</code> is not supported on newer models.</p>
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
        public _FinalStage k(Integer k) {
            this.k = Optional.of(k);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "k", nulls = Nulls.SKIP)
        public _FinalStage k(Optional<Integer> k) {
            this.k = k;
            return this;
        }

        /**
         * <p>The generated text will be cut at the end of the earliest occurrence of a stop sequence. The sequence will be included the text.</p>
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
         * <p>The generated text will be cut at the beginning of the earliest occurrence of an end sequence. The sequence will be excluded from the text.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage endSequences(List<String> endSequences) {
            this.endSequences = Optional.of(endSequences);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "end_sequences", nulls = Nulls.SKIP)
        public _FinalStage endSequences(Optional<List<String>> endSequences) {
            this.endSequences = endSequences;
            return this;
        }

        /**
         * <p>Identifier of a custom preset. A preset is a combination of parameters, such as prompt, temperature etc. You can create presets in the <a href="https://dashboard.cohere.com/playground/generate">playground</a>.
         * When a preset is specified, the <code>prompt</code> parameter becomes optional, and any included parameters will override the preset's parameters.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage preset(String preset) {
            this.preset = Optional.of(preset);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "preset", nulls = Nulls.SKIP)
        public _FinalStage preset(Optional<String> preset) {
            this.preset = preset;
            return this;
        }

        /**
         * <p>If specified, the backend will make a best effort to sample tokens deterministically, such that repeated requests with the same seed and parameters should return the same result. However, determinsim cannot be totally guaranteed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage seed(Double seed) {
            this.seed = Optional.of(seed);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "seed", nulls = Nulls.SKIP)
        public _FinalStage seed(Optional<Double> seed) {
            this.seed = seed;
            return this;
        }

        /**
         * <p>A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations. See <a href="/temperature-wiki">Temperature</a> for more details.
         * Defaults to <code>0.75</code>, min value of <code>0.0</code>, max value of <code>5.0</code>.</p>
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
         * <p>One of <code>NONE|START|END</code> to specify how the API will handle inputs longer than the maximum token length.</p>
         * <p>Passing <code>START</code> will discard the start of the input. <code>END</code> will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.</p>
         * <p>If <code>NONE</code> is selected, when the input exceeds the maximum input token length an error will be returned.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage truncate(GenerateStreamRequestTruncate truncate) {
            this.truncate = Optional.of(truncate);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "truncate", nulls = Nulls.SKIP)
        public _FinalStage truncate(Optional<GenerateStreamRequestTruncate> truncate) {
            this.truncate = truncate;
            return this;
        }

        /**
         * <p>The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.</p>
         * <p>This parameter is off by default, and if it's not specified, the model will continue generating until it emits an EOS completion token. See <a href="/bpe-tokens-wiki">BPE Tokens</a> for more details.</p>
         * <p>Can only be set to <code>0</code> if <code>return_likelihoods</code> is set to <code>ALL</code> to get the likelihood of the prompt.</p>
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
         * <p>The maximum number of generations that will be returned. Defaults to <code>1</code>, min value of <code>1</code>, max value of <code>5</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage numGenerations(Integer numGenerations) {
            this.numGenerations = Optional.of(numGenerations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "num_generations", nulls = Nulls.SKIP)
        public _FinalStage numGenerations(Optional<Integer> numGenerations) {
            this.numGenerations = numGenerations;
            return this;
        }

        /**
         * <p>The identifier of the model to generate with. Currently available models are <code>command</code> (default), <code>command-nightly</code> (experimental), <code>command-light</code>, and <code>command-light-nightly</code> (experimental).
         * Smaller, &quot;light&quot; models are faster, while larger models will perform better. <a href="/docs/training-custom-models">Custom models</a> can also be supplied with their full ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage model(String model) {
            this.model = Optional.of(model);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "model", nulls = Nulls.SKIP)
        public _FinalStage model(Optional<String> model) {
            this.model = model;
            return this;
        }

        @java.lang.Override
        public GenerateStreamRequest build() {
            return new GenerateStreamRequest(
                    prompt,
                    model,
                    numGenerations,
                    maxTokens,
                    truncate,
                    temperature,
                    seed,
                    preset,
                    endSequences,
                    stopSequences,
                    k,
                    p,
                    frequencyPenalty,
                    presencePenalty,
                    returnLikelihoods,
                    rawPrompting,
                    additionalProperties);
        }
    }
}
