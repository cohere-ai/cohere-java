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
@JsonDeserialize(builder = OAuthAuthorizeResponse.Builder.class)
public final class OAuthAuthorizeResponse {
    private final Optional<String> redirectUrl;

    private final Map<String, Object> additionalProperties;

    private OAuthAuthorizeResponse(Optional<String> redirectUrl, Map<String, Object> additionalProperties) {
        this.redirectUrl = redirectUrl;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The OAuth 2.0 redirect url. Redirect the user to this url to authorize the connector.
     */
    @JsonProperty("redirect_url")
    public Optional<String> getRedirectUrl() {
        return redirectUrl;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OAuthAuthorizeResponse && equalTo((OAuthAuthorizeResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OAuthAuthorizeResponse other) {
        return redirectUrl.equals(other.redirectUrl);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.redirectUrl);
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
        private Optional<String> redirectUrl = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(OAuthAuthorizeResponse other) {
            redirectUrl(other.getRedirectUrl());
            return this;
        }

        @JsonSetter(value = "redirect_url", nulls = Nulls.SKIP)
        public Builder redirectUrl(Optional<String> redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = Optional.of(redirectUrl);
            return this;
        }

        public OAuthAuthorizeResponse build() {
            return new OAuthAuthorizeResponse(redirectUrl, additionalProperties);
        }
    }
}
