/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.types;

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

public final class AssistantMessageContentItem {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private AssistantMessageContentItem(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static AssistantMessageContentItem text(TextContent value) {
        return new AssistantMessageContentItem(new TextValue(value));
    }

    public boolean isText() {
        return value instanceof TextValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<TextContent> getText() {
        if (isText()) {
            return Optional.of(((TextValue) value).value);
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
        T visitText(TextContent text);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes(@JsonSubTypes.Type(TextValue.class))
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("text")
    private static final class TextValue implements Value {
        @JsonUnwrapped
        private TextContent value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TextValue() {}

        private TextValue(TextContent value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitText(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TextValue && equalTo((TextValue) other);
        }

        private boolean equalTo(TextValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "AssistantMessageContentItem{" + "value: " + value + "}";
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
            return "AssistantMessageContentItem{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
