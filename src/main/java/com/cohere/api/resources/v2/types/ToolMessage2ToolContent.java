/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = ToolMessage2ToolContent.Deserializer.class)
public final class ToolMessage2ToolContent {
    private final Object value;

    private final int type;

    private ToolMessage2ToolContent(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((String) this.value);
        } else if (this.type == 1) {
            return visitor.visit((List<ToolContent>) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ToolMessage2ToolContent && equalTo((ToolMessage2ToolContent) other);
    }

    private boolean equalTo(ToolMessage2ToolContent other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static ToolMessage2ToolContent of(String value) {
        return new ToolMessage2ToolContent(value, 0);
    }

    public static ToolMessage2ToolContent of(List<ToolContent> value) {
        return new ToolMessage2ToolContent(value, 1);
    }

    public interface Visitor<T> {
        T visit(String value);

        T visit(List<ToolContent> value);
    }

    static final class Deserializer extends StdDeserializer<ToolMessage2ToolContent> {
        Deserializer() {
            super(ToolMessage2ToolContent.class);
        }

        @java.lang.Override
        public ToolMessage2ToolContent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, new TypeReference<List<ToolContent>>() {}));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
