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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateConnectorServiceAuth.Builder.class)
public final class CreateConnectorServiceAuth {
    private final String type;

    private final String token;

    private final Map<String, Object> additionalProperties;

    private CreateConnectorServiceAuth(String type, String token, Map<String, Object> additionalProperties) {
        this.type = type;
        this.token = token;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The token_type specifies the way the token is passed in the Authorization header. Valid values are &quot;bearer&quot;, &quot;basic&quot;, and &quot;noscheme&quot;.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @return The token that will be used in the HTTP Authorization header when making requests to the connector. This field is encrypted at rest and never returned in a response.
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateConnectorServiceAuth && equalTo((CreateConnectorServiceAuth) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateConnectorServiceAuth other) {
        return type.equals(other.type) && token.equals(other.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.token);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TypeStage builder() {
        return new Builder();
    }

    public interface TypeStage {
        TokenStage type(String type);

        Builder from(CreateConnectorServiceAuth other);
    }

    public interface TokenStage {
        _FinalStage token(String token);
    }

    public interface _FinalStage {
        CreateConnectorServiceAuth build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TypeStage, TokenStage, _FinalStage {
        private String type;

        private String token;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(CreateConnectorServiceAuth other) {
            type(other.getType());
            token(other.getToken());
            return this;
        }

        /**
         * <p>The token_type specifies the way the token is passed in the Authorization header. Valid values are &quot;bearer&quot;, &quot;basic&quot;, and &quot;noscheme&quot;.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("type")
        public TokenStage type(String type) {
            this.type = type;
            return this;
        }

        /**
         * <p>The token that will be used in the HTTP Authorization header when making requests to the connector. This field is encrypted at rest and never returned in a response.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("token")
        public _FinalStage token(String token) {
            this.token = token;
            return this;
        }

        @Override
        public CreateConnectorServiceAuth build() {
            return new CreateConnectorServiceAuth(type, token, additionalProperties);
        }
    }
}
