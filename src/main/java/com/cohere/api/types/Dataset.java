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
@JsonDeserialize(builder = Dataset.Builder.class)
public final class Dataset {
    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> updatedAt;

    private final Optional<String> datasetType;

    private final Optional<String> validationStatus;

    private final Optional<String> validationError;

    private final Optional<String> schema;

    private final Optional<List<String>> requiredFields;

    private final Optional<List<String>> preserveFields;

    private final Optional<List<DatasetPart>> datasetParts;

    private final Optional<List<String>> validationWarnings;

    private final Map<String, Object> additionalProperties;

    private Dataset(
            Optional<String> id,
            Optional<String> name,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> updatedAt,
            Optional<String> datasetType,
            Optional<String> validationStatus,
            Optional<String> validationError,
            Optional<String> schema,
            Optional<List<String>> requiredFields,
            Optional<List<String>> preserveFields,
            Optional<List<DatasetPart>> datasetParts,
            Optional<List<String>> validationWarnings,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.datasetType = datasetType;
        this.validationStatus = validationStatus;
        this.validationError = validationError;
        this.schema = schema;
        this.requiredFields = requiredFields;
        this.preserveFields = preserveFields;
        this.datasetParts = datasetParts;
        this.validationWarnings = validationWarnings;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The dataset ID
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The name of the dataset
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The creation date
     */
    @JsonProperty("createdAt")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The last update date
     */
    @JsonProperty("updatedAt")
    public Optional<OffsetDateTime> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The type of the dataset
     */
    @JsonProperty("datasetType")
    public Optional<String> getDatasetType() {
        return datasetType;
    }

    /**
     * @return The validation status of the dataset
     */
    @JsonProperty("validationStatus")
    public Optional<String> getValidationStatus() {
        return validationStatus;
    }

    /**
     * @return errors found during validation
     */
    @JsonProperty("validationError")
    public Optional<String> getValidationError() {
        return validationError;
    }

    /**
     * @return the avro schema of the dataset
     */
    @JsonProperty("schema")
    public Optional<String> getSchema() {
        return schema;
    }

    @JsonProperty("requiredFields")
    public Optional<List<String>> getRequiredFields() {
        return requiredFields;
    }

    @JsonProperty("preserveFields")
    public Optional<List<String>> getPreserveFields() {
        return preserveFields;
    }

    /**
     * @return the underlying files that make up the dataset
     */
    @JsonProperty("datasetParts")
    public Optional<List<DatasetPart>> getDatasetParts() {
        return datasetParts;
    }

    /**
     * @return warnings found during validation
     */
    @JsonProperty("validationWarnings")
    public Optional<List<String>> getValidationWarnings() {
        return validationWarnings;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Dataset && equalTo((Dataset) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Dataset other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && datasetType.equals(other.datasetType)
                && validationStatus.equals(other.validationStatus)
                && validationError.equals(other.validationError)
                && schema.equals(other.schema)
                && requiredFields.equals(other.requiredFields)
                && preserveFields.equals(other.preserveFields)
                && datasetParts.equals(other.datasetParts)
                && validationWarnings.equals(other.validationWarnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.createdAt,
                this.updatedAt,
                this.datasetType,
                this.validationStatus,
                this.validationError,
                this.schema,
                this.requiredFields,
                this.preserveFields,
                this.datasetParts,
                this.validationWarnings);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> updatedAt = Optional.empty();

        private Optional<String> datasetType = Optional.empty();

        private Optional<String> validationStatus = Optional.empty();

        private Optional<String> validationError = Optional.empty();

        private Optional<String> schema = Optional.empty();

        private Optional<List<String>> requiredFields = Optional.empty();

        private Optional<List<String>> preserveFields = Optional.empty();

        private Optional<List<DatasetPart>> datasetParts = Optional.empty();

        private Optional<List<String>> validationWarnings = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Dataset other) {
            id(other.getId());
            name(other.getName());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            datasetType(other.getDatasetType());
            validationStatus(other.getValidationStatus());
            validationError(other.getValidationError());
            schema(other.getSchema());
            requiredFields(other.getRequiredFields());
            preserveFields(other.getPreserveFields());
            datasetParts(other.getDatasetParts());
            validationWarnings(other.getValidationWarnings());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "createdAt", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
            return this;
        }

        @JsonSetter(value = "updatedAt", nulls = Nulls.SKIP)
        public Builder updatedAt(Optional<OffsetDateTime> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = Optional.of(updatedAt);
            return this;
        }

        @JsonSetter(value = "datasetType", nulls = Nulls.SKIP)
        public Builder datasetType(Optional<String> datasetType) {
            this.datasetType = datasetType;
            return this;
        }

        public Builder datasetType(String datasetType) {
            this.datasetType = Optional.of(datasetType);
            return this;
        }

        @JsonSetter(value = "validationStatus", nulls = Nulls.SKIP)
        public Builder validationStatus(Optional<String> validationStatus) {
            this.validationStatus = validationStatus;
            return this;
        }

        public Builder validationStatus(String validationStatus) {
            this.validationStatus = Optional.of(validationStatus);
            return this;
        }

        @JsonSetter(value = "validationError", nulls = Nulls.SKIP)
        public Builder validationError(Optional<String> validationError) {
            this.validationError = validationError;
            return this;
        }

        public Builder validationError(String validationError) {
            this.validationError = Optional.of(validationError);
            return this;
        }

        @JsonSetter(value = "schema", nulls = Nulls.SKIP)
        public Builder schema(Optional<String> schema) {
            this.schema = schema;
            return this;
        }

        public Builder schema(String schema) {
            this.schema = Optional.of(schema);
            return this;
        }

        @JsonSetter(value = "requiredFields", nulls = Nulls.SKIP)
        public Builder requiredFields(Optional<List<String>> requiredFields) {
            this.requiredFields = requiredFields;
            return this;
        }

        public Builder requiredFields(List<String> requiredFields) {
            this.requiredFields = Optional.of(requiredFields);
            return this;
        }

        @JsonSetter(value = "preserveFields", nulls = Nulls.SKIP)
        public Builder preserveFields(Optional<List<String>> preserveFields) {
            this.preserveFields = preserveFields;
            return this;
        }

        public Builder preserveFields(List<String> preserveFields) {
            this.preserveFields = Optional.of(preserveFields);
            return this;
        }

        @JsonSetter(value = "datasetParts", nulls = Nulls.SKIP)
        public Builder datasetParts(Optional<List<DatasetPart>> datasetParts) {
            this.datasetParts = datasetParts;
            return this;
        }

        public Builder datasetParts(List<DatasetPart> datasetParts) {
            this.datasetParts = Optional.of(datasetParts);
            return this;
        }

        @JsonSetter(value = "validationWarnings", nulls = Nulls.SKIP)
        public Builder validationWarnings(Optional<List<String>> validationWarnings) {
            this.validationWarnings = validationWarnings;
            return this;
        }

        public Builder validationWarnings(List<String> validationWarnings) {
            this.validationWarnings = Optional.of(validationWarnings);
            return this;
        }

        public Dataset build() {
            return new Dataset(
                    id,
                    name,
                    createdAt,
                    updatedAt,
                    datasetType,
                    validationStatus,
                    validationError,
                    schema,
                    requiredFields,
                    preserveFields,
                    datasetParts,
                    validationWarnings,
                    additionalProperties);
        }
    }
}