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
@JsonDeserialize(builder = JsonResponseFormat.Builder.class)
public final class JsonResponseFormat {
    private final Optional<Map<String, Object>> schema;

    private final Map<String, Object> additionalProperties;

    private JsonResponseFormat(Optional<Map<String, Object>> schema, Map<String, Object> additionalProperties) {
        this.schema = schema;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return [BETA] A JSON schema object that the output will adhere to. There are some restrictions we have on the schema, refer to <a href="/docs/structured-outputs-json#schema-constraints">our guide</a> for more information.
     * Example (required name and age object):
     * <pre><code class="language-json">{
     *   &quot;type&quot;: &quot;object&quot;,
     *   &quot;properties&quot;: {
     *     &quot;name&quot;: { &quot;type&quot;: &quot;string&quot; },
     *     &quot;age&quot;: { &quot;type&quot;: &quot;integer&quot; }
     *   },
     *   &quot;required&quot;: [&quot;name&quot;, &quot;age&quot;]
     * }
     * </code></pre>
     * <p><strong>Note</strong>: This field must not be specified when the <code>type</code> is set to <code>&quot;text&quot;</code>.</p>
     */
    @JsonProperty("schema")
    public Optional<Map<String, Object>> getSchema() {
        return schema;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof JsonResponseFormat && equalTo((JsonResponseFormat) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(JsonResponseFormat other) {
        return schema.equals(other.schema);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.schema);
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
        private Optional<Map<String, Object>> schema = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(JsonResponseFormat other) {
            schema(other.getSchema());
            return this;
        }

        @JsonSetter(value = "schema", nulls = Nulls.SKIP)
        public Builder schema(Optional<Map<String, Object>> schema) {
            this.schema = schema;
            return this;
        }

        public Builder schema(Map<String, Object> schema) {
            this.schema = Optional.of(schema);
            return this;
        }

        public JsonResponseFormat build() {
            return new JsonResponseFormat(schema, additionalProperties);
        }
    }
}
