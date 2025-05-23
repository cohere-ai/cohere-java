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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = EmbedByTypeResponseEmbeddings.Builder.class)
public final class EmbedByTypeResponseEmbeddings {
    private final Optional<List<List<Double>>> float_;

    private final Optional<List<List<Integer>>> int8;

    private final Optional<List<List<Integer>>> uint8;

    private final Optional<List<List<Integer>>> binary;

    private final Optional<List<List<Integer>>> ubinary;

    private final Map<String, Object> additionalProperties;

    private EmbedByTypeResponseEmbeddings(
            Optional<List<List<Double>>> float_,
            Optional<List<List<Integer>>> int8,
            Optional<List<List<Integer>>> uint8,
            Optional<List<List<Integer>>> binary,
            Optional<List<List<Integer>>> ubinary,
            Map<String, Object> additionalProperties) {
        this.float_ = float_;
        this.int8 = int8;
        this.uint8 = uint8;
        this.binary = binary;
        this.ubinary = ubinary;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return An array of float embeddings.
     */
    @JsonProperty("float")
    public Optional<List<List<Double>>> getFloat() {
        return float_;
    }

    /**
     * @return An array of signed int8 embeddings. Each value is between -128 and 127.
     */
    @JsonProperty("int8")
    public Optional<List<List<Integer>>> getInt8() {
        return int8;
    }

    /**
     * @return An array of unsigned int8 embeddings. Each value is between 0 and 255.
     */
    @JsonProperty("uint8")
    public Optional<List<List<Integer>>> getUint8() {
        return uint8;
    }

    /**
     * @return An array of packed signed binary embeddings. The length of each binary embedding is 1/8 the length of the float embeddings of the provided model. Each value is between -128 and 127.
     */
    @JsonProperty("binary")
    public Optional<List<List<Integer>>> getBinary() {
        return binary;
    }

    /**
     * @return An array of packed unsigned binary embeddings. The length of each binary embedding is 1/8 the length of the float embeddings of the provided model. Each value is between 0 and 255.
     */
    @JsonProperty("ubinary")
    public Optional<List<List<Integer>>> getUbinary() {
        return ubinary;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmbedByTypeResponseEmbeddings && equalTo((EmbedByTypeResponseEmbeddings) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EmbedByTypeResponseEmbeddings other) {
        return float_.equals(other.float_)
                && int8.equals(other.int8)
                && uint8.equals(other.uint8)
                && binary.equals(other.binary)
                && ubinary.equals(other.ubinary);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.float_, this.int8, this.uint8, this.binary, this.ubinary);
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
        private Optional<List<List<Double>>> float_ = Optional.empty();

        private Optional<List<List<Integer>>> int8 = Optional.empty();

        private Optional<List<List<Integer>>> uint8 = Optional.empty();

        private Optional<List<List<Integer>>> binary = Optional.empty();

        private Optional<List<List<Integer>>> ubinary = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(EmbedByTypeResponseEmbeddings other) {
            float_(other.getFloat());
            int8(other.getInt8());
            uint8(other.getUint8());
            binary(other.getBinary());
            ubinary(other.getUbinary());
            return this;
        }

        @JsonSetter(value = "float", nulls = Nulls.SKIP)
        public Builder float_(Optional<List<List<Double>>> float_) {
            this.float_ = float_;
            return this;
        }

        public Builder float_(List<List<Double>> float_) {
            this.float_ = Optional.ofNullable(float_);
            return this;
        }

        @JsonSetter(value = "int8", nulls = Nulls.SKIP)
        public Builder int8(Optional<List<List<Integer>>> int8) {
            this.int8 = int8;
            return this;
        }

        public Builder int8(List<List<Integer>> int8) {
            this.int8 = Optional.ofNullable(int8);
            return this;
        }

        @JsonSetter(value = "uint8", nulls = Nulls.SKIP)
        public Builder uint8(Optional<List<List<Integer>>> uint8) {
            this.uint8 = uint8;
            return this;
        }

        public Builder uint8(List<List<Integer>> uint8) {
            this.uint8 = Optional.ofNullable(uint8);
            return this;
        }

        @JsonSetter(value = "binary", nulls = Nulls.SKIP)
        public Builder binary(Optional<List<List<Integer>>> binary) {
            this.binary = binary;
            return this;
        }

        public Builder binary(List<List<Integer>> binary) {
            this.binary = Optional.ofNullable(binary);
            return this;
        }

        @JsonSetter(value = "ubinary", nulls = Nulls.SKIP)
        public Builder ubinary(Optional<List<List<Integer>>> ubinary) {
            this.ubinary = ubinary;
            return this;
        }

        public Builder ubinary(List<List<Integer>> ubinary) {
            this.ubinary = Optional.ofNullable(ubinary);
            return this;
        }

        public EmbedByTypeResponseEmbeddings build() {
            return new EmbedByTypeResponseEmbeddings(float_, int8, uint8, binary, ubinary, additionalProperties);
        }
    }
}
