/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.finetuning.requests;

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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = FinetuningListFinetunedModelsRequest.Builder.class)
public final class FinetuningListFinetunedModelsRequest {
    private final Optional<Integer> pageSize;

    private final Optional<String> pageToken;

    private final Optional<String> orderBy;

    private final Map<String, Object> additionalProperties;

    private FinetuningListFinetunedModelsRequest(
            Optional<Integer> pageSize,
            Optional<String> pageToken,
            Optional<String> orderBy,
            Map<String, Object> additionalProperties) {
        this.pageSize = pageSize;
        this.pageToken = pageToken;
        this.orderBy = orderBy;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Maximum number of results to be returned by the server. If 0, defaults to
     * 50.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return Request a specific page of the list results.
     */
    @JsonProperty("page_token")
    public Optional<String> getPageToken() {
        return pageToken;
    }

    /**
     * @return Comma separated list of fields. For example: &quot;created_at,name&quot;. The default
     * sorting order is ascending. To specify descending order for a field, append
     * &quot; desc&quot; to the field name. For example: &quot;created_at desc,name&quot;.
     * <p>Supported sorting fields:</p>
     * <ul>
     * <li>created_at (default)</li>
     * </ul>
     */
    @JsonProperty("order_by")
    public Optional<String> getOrderBy() {
        return orderBy;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FinetuningListFinetunedModelsRequest
                && equalTo((FinetuningListFinetunedModelsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FinetuningListFinetunedModelsRequest other) {
        return pageSize.equals(other.pageSize) && pageToken.equals(other.pageToken) && orderBy.equals(other.orderBy);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.pageSize, this.pageToken, this.orderBy);
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
        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> pageToken = Optional.empty();

        private Optional<String> orderBy = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FinetuningListFinetunedModelsRequest other) {
            pageSize(other.getPageSize());
            pageToken(other.getPageToken());
            orderBy(other.getOrderBy());
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        @JsonSetter(value = "page_token", nulls = Nulls.SKIP)
        public Builder pageToken(Optional<String> pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public Builder pageToken(String pageToken) {
            this.pageToken = Optional.ofNullable(pageToken);
            return this;
        }

        @JsonSetter(value = "order_by", nulls = Nulls.SKIP)
        public Builder orderBy(Optional<String> orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public Builder orderBy(String orderBy) {
            this.orderBy = Optional.ofNullable(orderBy);
            return this;
        }

        public FinetuningListFinetunedModelsRequest build() {
            return new FinetuningListFinetunedModelsRequest(pageSize, pageToken, orderBy, additionalProperties);
        }
    }
}
