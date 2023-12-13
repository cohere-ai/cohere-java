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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Connector.Builder.class)
public final class Connector {
    private final String id;

    private final Optional<String> organizationId;

    private final String name;

    private final Optional<String> description;

    private final Optional<String> url;

    private final OffsetDateTime createdAt;

    private final OffsetDateTime updatedAt;

    private final Optional<List<String>> excludes;

    private final Optional<String> authType;

    private final Optional<ConnectorOAuth> oauth;

    private final Optional<ConnectorAuthStatus> authStatus;

    private final Optional<Boolean> active;

    private final Optional<Boolean> continueOnFailure;

    private final Map<String, Object> additionalProperties;

    private Connector(
            String id,
            Optional<String> organizationId,
            String name,
            Optional<String> description,
            Optional<String> url,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt,
            Optional<List<String>> excludes,
            Optional<String> authType,
            Optional<ConnectorOAuth> oauth,
            Optional<ConnectorAuthStatus> authStatus,
            Optional<Boolean> active,
            Optional<Boolean> continueOnFailure,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.organizationId = organizationId;
        this.name = name;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.excludes = excludes;
        this.authType = authType;
        this.oauth = oauth;
        this.authStatus = authStatus;
        this.active = active;
        this.continueOnFailure = continueOnFailure;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique identifier of the connector (used in both <code>/connectors</code> &amp; <code>/chat</code> endpoints).
     * This is automatically created from the name of the connector upon registration.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The organization to which this connector belongs. This is automatically set to
     * the organization of the user who created the connector.
     */
    @JsonProperty("organizationId")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    /**
     * @return A human-readable name for the connector.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return A description of the connector.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The URL of the connector that will be used to search for documents.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    /**
     * @return The UTC time at which the connector was created.
     */
    @JsonProperty("createdAt")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The UTC time at which the connector was last updated.
     */
    @JsonProperty("updatedAt")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return A list of fields to exclude from the prompt (fields remain in the document).
     */
    @JsonProperty("excludes")
    public Optional<List<String>> getExcludes() {
        return excludes;
    }

    /**
     * @return The type of authentication/authorization used by the connector. Possible values: [oauth, service_auth]
     */
    @JsonProperty("authType")
    public Optional<String> getAuthType() {
        return authType;
    }

    /**
     * @return The OAuth 2.0 configuration for the connector.
     */
    @JsonProperty("oauth")
    public Optional<ConnectorOAuth> getOauth() {
        return oauth;
    }

    /**
     * @return The OAuth status for the user making the request. One of [&quot;valid&quot;, &quot;expired&quot;, &quot;&quot;]. Empty string (field is omitted) means the user has not authorized the connector yet.
     */
    @JsonProperty("authStatus")
    public Optional<ConnectorAuthStatus> getAuthStatus() {
        return authStatus;
    }

    /**
     * @return Whether the connector is active or not.
     */
    @JsonProperty("active")
    public Optional<Boolean> getActive() {
        return active;
    }

    /**
     * @return Whether a chat request should continue or not if the request to this connector fails.
     */
    @JsonProperty("continueOnFailure")
    public Optional<Boolean> getContinueOnFailure() {
        return continueOnFailure;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Connector && equalTo((Connector) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Connector other) {
        return id.equals(other.id)
                && organizationId.equals(other.organizationId)
                && name.equals(other.name)
                && description.equals(other.description)
                && url.equals(other.url)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && excludes.equals(other.excludes)
                && authType.equals(other.authType)
                && oauth.equals(other.oauth)
                && authStatus.equals(other.authStatus)
                && active.equals(other.active)
                && continueOnFailure.equals(other.continueOnFailure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.organizationId,
                this.name,
                this.description,
                this.url,
                this.createdAt,
                this.updatedAt,
                this.excludes,
                this.authType,
                this.oauth,
                this.authStatus,
                this.active,
                this.continueOnFailure);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        NameStage id(String id);

        Builder from(Connector other);
    }

    public interface NameStage {
        CreatedAtStage name(String name);
    }

    public interface CreatedAtStage {
        UpdatedAtStage createdAt(OffsetDateTime createdAt);
    }

    public interface UpdatedAtStage {
        _FinalStage updatedAt(OffsetDateTime updatedAt);
    }

    public interface _FinalStage {
        Connector build();

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);

        _FinalStage excludes(Optional<List<String>> excludes);

        _FinalStage excludes(List<String> excludes);

        _FinalStage authType(Optional<String> authType);

        _FinalStage authType(String authType);

        _FinalStage oauth(Optional<ConnectorOAuth> oauth);

        _FinalStage oauth(ConnectorOAuth oauth);

        _FinalStage authStatus(Optional<ConnectorAuthStatus> authStatus);

        _FinalStage authStatus(ConnectorAuthStatus authStatus);

        _FinalStage active(Optional<Boolean> active);

        _FinalStage active(Boolean active);

        _FinalStage continueOnFailure(Optional<Boolean> continueOnFailure);

        _FinalStage continueOnFailure(Boolean continueOnFailure);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, NameStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
        private String id;

        private String name;

        private OffsetDateTime createdAt;

        private OffsetDateTime updatedAt;

        private Optional<Boolean> continueOnFailure = Optional.empty();

        private Optional<Boolean> active = Optional.empty();

        private Optional<ConnectorAuthStatus> authStatus = Optional.empty();

        private Optional<ConnectorOAuth> oauth = Optional.empty();

        private Optional<String> authType = Optional.empty();

        private Optional<List<String>> excludes = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(Connector other) {
            id(other.getId());
            organizationId(other.getOrganizationId());
            name(other.getName());
            description(other.getDescription());
            url(other.getUrl());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            excludes(other.getExcludes());
            authType(other.getAuthType());
            oauth(other.getOauth());
            authStatus(other.getAuthStatus());
            active(other.getActive());
            continueOnFailure(other.getContinueOnFailure());
            return this;
        }

        /**
         * <p>The unique identifier of the connector (used in both <code>/connectors</code> &amp; <code>/chat</code> endpoints).
         * This is automatically created from the name of the connector upon registration.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public NameStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>A human-readable name for the connector.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public CreatedAtStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The UTC time at which the connector was created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("createdAt")
        public UpdatedAtStage createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>The UTC time at which the connector was last updated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("updatedAt")
        public _FinalStage updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>Whether a chat request should continue or not if the request to this connector fails.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage continueOnFailure(Boolean continueOnFailure) {
            this.continueOnFailure = Optional.of(continueOnFailure);
            return this;
        }

        @Override
        @JsonSetter(value = "continueOnFailure", nulls = Nulls.SKIP)
        public _FinalStage continueOnFailure(Optional<Boolean> continueOnFailure) {
            this.continueOnFailure = continueOnFailure;
            return this;
        }

        /**
         * <p>Whether the connector is active or not.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage active(Boolean active) {
            this.active = Optional.of(active);
            return this;
        }

        @Override
        @JsonSetter(value = "active", nulls = Nulls.SKIP)
        public _FinalStage active(Optional<Boolean> active) {
            this.active = active;
            return this;
        }

        /**
         * <p>The OAuth status for the user making the request. One of [&quot;valid&quot;, &quot;expired&quot;, &quot;&quot;]. Empty string (field is omitted) means the user has not authorized the connector yet.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage authStatus(ConnectorAuthStatus authStatus) {
            this.authStatus = Optional.of(authStatus);
            return this;
        }

        @Override
        @JsonSetter(value = "authStatus", nulls = Nulls.SKIP)
        public _FinalStage authStatus(Optional<ConnectorAuthStatus> authStatus) {
            this.authStatus = authStatus;
            return this;
        }

        /**
         * <p>The OAuth 2.0 configuration for the connector.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage oauth(ConnectorOAuth oauth) {
            this.oauth = Optional.of(oauth);
            return this;
        }

        @Override
        @JsonSetter(value = "oauth", nulls = Nulls.SKIP)
        public _FinalStage oauth(Optional<ConnectorOAuth> oauth) {
            this.oauth = oauth;
            return this;
        }

        /**
         * <p>The type of authentication/authorization used by the connector. Possible values: [oauth, service_auth]</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage authType(String authType) {
            this.authType = Optional.of(authType);
            return this;
        }

        @Override
        @JsonSetter(value = "authType", nulls = Nulls.SKIP)
        public _FinalStage authType(Optional<String> authType) {
            this.authType = authType;
            return this;
        }

        /**
         * <p>A list of fields to exclude from the prompt (fields remain in the document).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage excludes(List<String> excludes) {
            this.excludes = Optional.of(excludes);
            return this;
        }

        @Override
        @JsonSetter(value = "excludes", nulls = Nulls.SKIP)
        public _FinalStage excludes(Optional<List<String>> excludes) {
            this.excludes = excludes;
            return this;
        }

        /**
         * <p>The URL of the connector that will be used to search for documents.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage url(String url) {
            this.url = Optional.of(url);
            return this;
        }

        @Override
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public _FinalStage url(Optional<String> url) {
            this.url = url;
            return this;
        }

        /**
         * <p>A description of the connector.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The organization to which this connector belongs. This is automatically set to
         * the organization of the user who created the connector.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @Override
        @JsonSetter(value = "organizationId", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @Override
        public Connector build() {
            return new Connector(
                    id,
                    organizationId,
                    name,
                    description,
                    url,
                    createdAt,
                    updatedAt,
                    excludes,
                    authType,
                    oauth,
                    authStatus,
                    active,
                    continueOnFailure,
                    additionalProperties);
        }
    }
}
