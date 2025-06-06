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
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TokenizeResponse.Builder.class)
public final class TokenizeResponse {
    private final List<Integer> tokens;

    private final List<String> tokenStrings;

    private final Optional<ApiMeta> meta;

    private final Map<String, Object> additionalProperties;

    private TokenizeResponse(
            List<Integer> tokens,
            List<String> tokenStrings,
            Optional<ApiMeta> meta,
            Map<String, Object> additionalProperties) {
        this.tokens = tokens;
        this.tokenStrings = tokenStrings;
        this.meta = meta;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return An array of tokens, where each token is an integer.
     */
    @JsonProperty("tokens")
    public List<Integer> getTokens() {
        return tokens;
    }

    @JsonProperty("token_strings")
    public List<String> getTokenStrings() {
        return tokenStrings;
    }

    @JsonProperty("meta")
    public Optional<ApiMeta> getMeta() {
        return meta;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TokenizeResponse && equalTo((TokenizeResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TokenizeResponse other) {
        return tokens.equals(other.tokens) && tokenStrings.equals(other.tokenStrings) && meta.equals(other.meta);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.tokens, this.tokenStrings, this.meta);
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
        private List<Integer> tokens = new ArrayList<>();

        private List<String> tokenStrings = new ArrayList<>();

        private Optional<ApiMeta> meta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TokenizeResponse other) {
            tokens(other.getTokens());
            tokenStrings(other.getTokenStrings());
            meta(other.getMeta());
            return this;
        }

        @JsonSetter(value = "tokens", nulls = Nulls.SKIP)
        public Builder tokens(List<Integer> tokens) {
            this.tokens.clear();
            this.tokens.addAll(tokens);
            return this;
        }

        public Builder addTokens(Integer tokens) {
            this.tokens.add(tokens);
            return this;
        }

        public Builder addAllTokens(List<Integer> tokens) {
            this.tokens.addAll(tokens);
            return this;
        }

        @JsonSetter(value = "token_strings", nulls = Nulls.SKIP)
        public Builder tokenStrings(List<String> tokenStrings) {
            this.tokenStrings.clear();
            this.tokenStrings.addAll(tokenStrings);
            return this;
        }

        public Builder addTokenStrings(String tokenStrings) {
            this.tokenStrings.add(tokenStrings);
            return this;
        }

        public Builder addAllTokenStrings(List<String> tokenStrings) {
            this.tokenStrings.addAll(tokenStrings);
            return this;
        }

        @JsonSetter(value = "meta", nulls = Nulls.SKIP)
        public Builder meta(Optional<ApiMeta> meta) {
            this.meta = meta;
            return this;
        }

        public Builder meta(ApiMeta meta) {
            this.meta = Optional.ofNullable(meta);
            return this;
        }

        public TokenizeResponse build() {
            return new TokenizeResponse(tokens, tokenStrings, meta, additionalProperties);
        }
    }
}
