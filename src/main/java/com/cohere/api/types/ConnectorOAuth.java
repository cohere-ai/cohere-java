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
@JsonDeserialize(builder = ConnectorOAuth.Builder.class)
public final class ConnectorOAuth {
    private final Optional<String> authorizeUrl;

    private final Optional<String> tokenUrl;

    private final Optional<String> scope;

    private final Map<String, Object> additionalProperties;

    private ConnectorOAuth(
            Optional<String> authorizeUrl,
            Optional<String> tokenUrl,
            Optional<String> scope,
            Map<String, Object> additionalProperties) {
        this.authorizeUrl = authorizeUrl;
        this.tokenUrl = tokenUrl;
        this.scope = scope;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The OAuth 2.0 /authorize endpoint to use when users authorize the connector.
     */
    @JsonProperty("authorizeUrl")
    public Optional<String> getAuthorizeUrl() {
        return authorizeUrl;
    }

    /**
     * @return The OAuth 2.0 /token endpoint to use when users authorize the connector.
     */
    @JsonProperty("tokenUrl")
    public Optional<String> getTokenUrl() {
        return tokenUrl;
    }

    /**
     * @return The OAuth scopes to request when users authorize the connector.
     */
    @JsonProperty("scope")
    public Optional<String> getScope() {
        return scope;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConnectorOAuth && equalTo((ConnectorOAuth) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConnectorOAuth other) {
        return authorizeUrl.equals(other.authorizeUrl) && tokenUrl.equals(other.tokenUrl) && scope.equals(other.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.authorizeUrl, this.tokenUrl, this.scope);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> authorizeUrl = Optional.empty();

        private Optional<String> tokenUrl = Optional.empty();

        private Optional<String> scope = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ConnectorOAuth other) {
            authorizeUrl(other.getAuthorizeUrl());
            tokenUrl(other.getTokenUrl());
            scope(other.getScope());
            return this;
        }

        @JsonSetter(value = "authorizeUrl", nulls = Nulls.SKIP)
        public Builder authorizeUrl(Optional<String> authorizeUrl) {
            this.authorizeUrl = authorizeUrl;
            return this;
        }

        public Builder authorizeUrl(String authorizeUrl) {
            this.authorizeUrl = Optional.of(authorizeUrl);
            return this;
        }

        @JsonSetter(value = "tokenUrl", nulls = Nulls.SKIP)
        public Builder tokenUrl(Optional<String> tokenUrl) {
            this.tokenUrl = tokenUrl;
            return this;
        }

        public Builder tokenUrl(String tokenUrl) {
            this.tokenUrl = Optional.of(tokenUrl);
            return this;
        }

        @JsonSetter(value = "scope", nulls = Nulls.SKIP)
        public Builder scope(Optional<String> scope) {
            this.scope = scope;
            return this;
        }

        public Builder scope(String scope) {
            this.scope = Optional.of(scope);
            return this;
        }

        public ConnectorOAuth build() {
            return new ConnectorOAuth(authorizeUrl, tokenUrl, scope, additionalProperties);
        }
    }
}
