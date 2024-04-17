/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

public final class EmbedResponse {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private EmbedResponse(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static EmbedResponse embeddingsFloats(EmbedFloatsResponse value) {
        return new EmbedResponse(new EmbeddingsFloatsValue(value));
    }

    public static EmbedResponse embeddingsByType(EmbedByTypeResponse value) {
        return new EmbedResponse(new EmbeddingsByTypeValue(value));
    }

    public boolean isEmbeddingsFloats() {
        return value instanceof EmbeddingsFloatsValue;
    }

    public boolean isEmbeddingsByType() {
        return value instanceof EmbeddingsByTypeValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<EmbedFloatsResponse> getEmbeddingsFloats() {
        if (isEmbeddingsFloats()) {
            return Optional.of(((EmbeddingsFloatsValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<EmbedByTypeResponse> getEmbeddingsByType() {
        if (isEmbeddingsByType()) {
            return Optional.of(((EmbeddingsByTypeValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitEmbeddingsFloats(EmbedFloatsResponse embeddingsFloats);

        T visitEmbeddingsByType(EmbedByTypeResponse embeddingsByType);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "response_type",
            visible = true,
            defaultImpl = _UnknownValue.class)
    @JsonSubTypes({@JsonSubTypes.Type(EmbeddingsFloatsValue.class), @JsonSubTypes.Type(EmbeddingsByTypeValue.class)})
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("embeddings_floats")
    private static final class EmbeddingsFloatsValue implements Value {
        @JsonUnwrapped
        private EmbedFloatsResponse value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private EmbeddingsFloatsValue() {}

        private EmbeddingsFloatsValue(EmbedFloatsResponse value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitEmbeddingsFloats(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof EmbeddingsFloatsValue && equalTo((EmbeddingsFloatsValue) other);
        }

        private boolean equalTo(EmbeddingsFloatsValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "EmbedResponse{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("embeddings_by_type")
    private static final class EmbeddingsByTypeValue implements Value {
        @JsonUnwrapped
        private EmbedByTypeResponse value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private EmbeddingsByTypeValue() {}

        private EmbeddingsByTypeValue(EmbedByTypeResponse value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitEmbeddingsByType(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof EmbeddingsByTypeValue && equalTo((EmbeddingsByTypeValue) other);
        }

        private boolean equalTo(EmbeddingsByTypeValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "EmbedResponse{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @java.lang.Override
        public String toString() {
            return "EmbedResponse{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
