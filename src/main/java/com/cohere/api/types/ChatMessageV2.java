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

public final class ChatMessageV2 {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private ChatMessageV2(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static ChatMessageV2 user(UserMessage value) {
        return new ChatMessageV2(new UserValue(value));
    }

    public static ChatMessageV2 assistant(AssistantMessage value) {
        return new ChatMessageV2(new AssistantValue(value));
    }

    public static ChatMessageV2 system(SystemMessage value) {
        return new ChatMessageV2(new SystemValue(value));
    }

    public static ChatMessageV2 tool(ToolMessageV2 value) {
        return new ChatMessageV2(new ToolValue(value));
    }

    public boolean isUser() {
        return value instanceof UserValue;
    }

    public boolean isAssistant() {
        return value instanceof AssistantValue;
    }

    public boolean isSystem() {
        return value instanceof SystemValue;
    }

    public boolean isTool() {
        return value instanceof ToolValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<UserMessage> getUser() {
        if (isUser()) {
            return Optional.of(((UserValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<AssistantMessage> getAssistant() {
        if (isAssistant()) {
            return Optional.of(((AssistantValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<SystemMessage> getSystem() {
        if (isSystem()) {
            return Optional.of(((SystemValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ToolMessageV2> getTool() {
        if (isTool()) {
            return Optional.of(((ToolValue) value).value);
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
        T visitUser(UserMessage user);

        T visitAssistant(AssistantMessage assistant);

        T visitSystem(SystemMessage system);

        T visitTool(ToolMessageV2 tool);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(UserValue.class),
        @JsonSubTypes.Type(AssistantValue.class),
        @JsonSubTypes.Type(SystemValue.class),
        @JsonSubTypes.Type(ToolValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("user")
    private static final class UserValue implements Value {
        @JsonUnwrapped
        private UserMessage value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private UserValue() {}

        private UserValue(UserMessage value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitUser(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof UserValue && equalTo((UserValue) other);
        }

        private boolean equalTo(UserValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "ChatMessageV2{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("assistant")
    private static final class AssistantValue implements Value {
        @JsonUnwrapped
        private AssistantMessage value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private AssistantValue() {}

        private AssistantValue(AssistantMessage value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitAssistant(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof AssistantValue && equalTo((AssistantValue) other);
        }

        private boolean equalTo(AssistantValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "ChatMessageV2{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("system")
    private static final class SystemValue implements Value {
        @JsonUnwrapped
        private SystemMessage value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private SystemValue() {}

        private SystemValue(SystemMessage value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitSystem(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof SystemValue && equalTo((SystemValue) other);
        }

        private boolean equalTo(SystemValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "ChatMessageV2{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("tool")
    private static final class ToolValue implements Value {
        @JsonUnwrapped
        private ToolMessageV2 value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ToolValue() {}

        private ToolValue(ToolMessageV2 value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitTool(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ToolValue && equalTo((ToolValue) other);
        }

        private boolean equalTo(ToolValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "ChatMessageV2{" + "value: " + value + "}";
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
            return "ChatMessageV2{" + "type: " + type + ", value: " + value + "}";
        }
    }
}