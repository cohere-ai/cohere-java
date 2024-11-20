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
@JsonDeserialize(builder = JsonResponseFormatV2.Builder.class)
public final class JsonResponseFormatV2 {
    private final Optional<Map<String, Object>> jsonSchema;

    private final Map<String, Object> additionalProperties;

    private JsonResponseFormatV2(Optional<Map<String, Object>> jsonSchema, Map<String, Object> additionalProperties) {
        this.jsonSchema = jsonSchema;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A <a href="https://json-schema.org/overview/what-is-jsonschema">JSON schema</a> object that the output will adhere to. There are some restrictions we have on the schema, refer to <a href="https://docs.cohere.com/docs/structured-outputs-json#schema-constraints">our guide</a> for more information.
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
    @JsonProperty("json_schema")
    public Optional<Map<String, Object>> getJsonSchema() {
        return jsonSchema;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof JsonResponseFormatV2 && equalTo((JsonResponseFormatV2) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(JsonResponseFormatV2 other) {
        return jsonSchema.equals(other.jsonSchema);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.jsonSchema);
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
        private Optional<Map<String, Object>> jsonSchema = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(JsonResponseFormatV2 other) {
            jsonSchema(other.getJsonSchema());
            return this;
        }

        @JsonSetter(value = "json_schema", nulls = Nulls.SKIP)
        public Builder jsonSchema(Optional<Map<String, Object>> jsonSchema) {
            this.jsonSchema = jsonSchema;
            return this;
        }

        public Builder jsonSchema(Map<String, Object> jsonSchema) {
            this.jsonSchema = Optional.of(jsonSchema);
            return this;
        }

        public JsonResponseFormatV2 build() {
            return new JsonResponseFormatV2(jsonSchema, additionalProperties);
        }
    }
}
