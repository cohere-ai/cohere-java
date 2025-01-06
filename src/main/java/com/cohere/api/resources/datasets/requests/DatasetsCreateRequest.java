/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.datasets.requests;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.DatasetType;
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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DatasetsCreateRequest.Builder.class)
public final class DatasetsCreateRequest {
    private final String name;

    private final DatasetType type;

    private final Optional<Boolean> keepOriginalFile;

    private final Optional<Boolean> skipMalformedInput;

    private final Optional<String> keepFields;

    private final Optional<String> optionalFields;

    private final Optional<String> textSeparator;

    private final Optional<String> csvDelimiter;

    private final Optional<Boolean> dryRun;

    private final Map<String, Object> additionalProperties;

    private DatasetsCreateRequest(
            String name,
            DatasetType type,
            Optional<Boolean> keepOriginalFile,
            Optional<Boolean> skipMalformedInput,
            Optional<String> keepFields,
            Optional<String> optionalFields,
            Optional<String> textSeparator,
            Optional<String> csvDelimiter,
            Optional<Boolean> dryRun,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.type = type;
        this.keepOriginalFile = keepOriginalFile;
        this.skipMalformedInput = skipMalformedInput;
        this.keepFields = keepFields;
        this.optionalFields = optionalFields;
        this.textSeparator = textSeparator;
        this.csvDelimiter = csvDelimiter;
        this.dryRun = dryRun;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The name of the uploaded dataset.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The dataset type, which is used to validate the data. Valid types are <code>embed-input</code>, <code>reranker-finetune-input</code>, <code>single-label-classification-finetune-input</code>, <code>chat-finetune-input</code>, and <code>multi-label-classification-finetune-input</code>.
     */
    @JsonProperty("type")
    public DatasetType getType() {
        return type;
    }

    /**
     * @return Indicates if the original file should be stored.
     */
    @JsonProperty("keep_original_file")
    public Optional<Boolean> getKeepOriginalFile() {
        return keepOriginalFile;
    }

    /**
     * @return Indicates whether rows with malformed input should be dropped (instead of failing the validation check). Dropped rows will be returned in the warnings field.
     */
    @JsonProperty("skip_malformed_input")
    public Optional<Boolean> getSkipMalformedInput() {
        return skipMalformedInput;
    }

    /**
     * @return List of names of fields that will be persisted in the Dataset. By default the Dataset will retain only the required fields indicated in the <a href="https://docs.cohere.com/docs/datasets#dataset-types">schema for the corresponding Dataset type</a>. For example, datasets of type <code>embed-input</code> will drop all fields other than the required <code>text</code> field. If any of the fields in <code>keep_fields</code> are missing from the uploaded file, Dataset validation will fail.
     */
    @JsonProperty("keep_fields")
    public Optional<String> getKeepFields() {
        return keepFields;
    }

    /**
     * @return List of names of fields that will be persisted in the Dataset. By default the Dataset will retain only the required fields indicated in the <a href="https://docs.cohere.com/docs/datasets#dataset-types">schema for the corresponding Dataset type</a>. For example, Datasets of type <code>embed-input</code> will drop all fields other than the required <code>text</code> field. If any of the fields in <code>optional_fields</code> are missing from the uploaded file, Dataset validation will pass.
     */
    @JsonProperty("optional_fields")
    public Optional<String> getOptionalFields() {
        return optionalFields;
    }

    /**
     * @return Raw .txt uploads will be split into entries using the text_separator value.
     */
    @JsonProperty("text_separator")
    public Optional<String> getTextSeparator() {
        return textSeparator;
    }

    /**
     * @return The delimiter used for .csv uploads.
     */
    @JsonProperty("csv_delimiter")
    public Optional<String> getCsvDelimiter() {
        return csvDelimiter;
    }

    /**
     * @return flag to enable dry_run mode
     */
    @JsonProperty("dry_run")
    public Optional<Boolean> getDryRun() {
        return dryRun;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DatasetsCreateRequest && equalTo((DatasetsCreateRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DatasetsCreateRequest other) {
        return name.equals(other.name)
                && type.equals(other.type)
                && keepOriginalFile.equals(other.keepOriginalFile)
                && skipMalformedInput.equals(other.skipMalformedInput)
                && keepFields.equals(other.keepFields)
                && optionalFields.equals(other.optionalFields)
                && textSeparator.equals(other.textSeparator)
                && csvDelimiter.equals(other.csvDelimiter)
                && dryRun.equals(other.dryRun);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.type,
                this.keepOriginalFile,
                this.skipMalformedInput,
                this.keepFields,
                this.optionalFields,
                this.textSeparator,
                this.csvDelimiter,
                this.dryRun);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        TypeStage name(@NotNull String name);

        Builder from(DatasetsCreateRequest other);
    }

    public interface TypeStage {
        _FinalStage type(@NotNull DatasetType type);
    }

    public interface _FinalStage {
        DatasetsCreateRequest build();

        _FinalStage keepOriginalFile(Optional<Boolean> keepOriginalFile);

        _FinalStage keepOriginalFile(Boolean keepOriginalFile);

        _FinalStage skipMalformedInput(Optional<Boolean> skipMalformedInput);

        _FinalStage skipMalformedInput(Boolean skipMalformedInput);

        _FinalStage keepFields(Optional<String> keepFields);

        _FinalStage keepFields(String keepFields);

        _FinalStage optionalFields(Optional<String> optionalFields);

        _FinalStage optionalFields(String optionalFields);

        _FinalStage textSeparator(Optional<String> textSeparator);

        _FinalStage textSeparator(String textSeparator);

        _FinalStage csvDelimiter(Optional<String> csvDelimiter);

        _FinalStage csvDelimiter(String csvDelimiter);

        _FinalStage dryRun(Optional<Boolean> dryRun);

        _FinalStage dryRun(Boolean dryRun);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, TypeStage, _FinalStage {
        private String name;

        private DatasetType type;

        private Optional<Boolean> dryRun = Optional.empty();

        private Optional<String> csvDelimiter = Optional.empty();

        private Optional<String> textSeparator = Optional.empty();

        private Optional<String> optionalFields = Optional.empty();

        private Optional<String> keepFields = Optional.empty();

        private Optional<Boolean> skipMalformedInput = Optional.empty();

        private Optional<Boolean> keepOriginalFile = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DatasetsCreateRequest other) {
            name(other.getName());
            type(other.getType());
            keepOriginalFile(other.getKeepOriginalFile());
            skipMalformedInput(other.getSkipMalformedInput());
            keepFields(other.getKeepFields());
            optionalFields(other.getOptionalFields());
            textSeparator(other.getTextSeparator());
            csvDelimiter(other.getCsvDelimiter());
            dryRun(other.getDryRun());
            return this;
        }

        /**
         * <p>The name of the uploaded dataset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public TypeStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * <p>The dataset type, which is used to validate the data. Valid types are <code>embed-input</code>, <code>reranker-finetune-input</code>, <code>single-label-classification-finetune-input</code>, <code>chat-finetune-input</code>, and <code>multi-label-classification-finetune-input</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("type")
        public _FinalStage type(@NotNull DatasetType type) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            return this;
        }

        /**
         * <p>flag to enable dry_run mode</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage dryRun(Boolean dryRun) {
            this.dryRun = Optional.ofNullable(dryRun);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "dry_run", nulls = Nulls.SKIP)
        public _FinalStage dryRun(Optional<Boolean> dryRun) {
            this.dryRun = dryRun;
            return this;
        }

        /**
         * <p>The delimiter used for .csv uploads.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage csvDelimiter(String csvDelimiter) {
            this.csvDelimiter = Optional.ofNullable(csvDelimiter);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "csv_delimiter", nulls = Nulls.SKIP)
        public _FinalStage csvDelimiter(Optional<String> csvDelimiter) {
            this.csvDelimiter = csvDelimiter;
            return this;
        }

        /**
         * <p>Raw .txt uploads will be split into entries using the text_separator value.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage textSeparator(String textSeparator) {
            this.textSeparator = Optional.ofNullable(textSeparator);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "text_separator", nulls = Nulls.SKIP)
        public _FinalStage textSeparator(Optional<String> textSeparator) {
            this.textSeparator = textSeparator;
            return this;
        }

        /**
         * <p>List of names of fields that will be persisted in the Dataset. By default the Dataset will retain only the required fields indicated in the <a href="https://docs.cohere.com/docs/datasets#dataset-types">schema for the corresponding Dataset type</a>. For example, Datasets of type <code>embed-input</code> will drop all fields other than the required <code>text</code> field. If any of the fields in <code>optional_fields</code> are missing from the uploaded file, Dataset validation will pass.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage optionalFields(String optionalFields) {
            this.optionalFields = Optional.ofNullable(optionalFields);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "optional_fields", nulls = Nulls.SKIP)
        public _FinalStage optionalFields(Optional<String> optionalFields) {
            this.optionalFields = optionalFields;
            return this;
        }

        /**
         * <p>List of names of fields that will be persisted in the Dataset. By default the Dataset will retain only the required fields indicated in the <a href="https://docs.cohere.com/docs/datasets#dataset-types">schema for the corresponding Dataset type</a>. For example, datasets of type <code>embed-input</code> will drop all fields other than the required <code>text</code> field. If any of the fields in <code>keep_fields</code> are missing from the uploaded file, Dataset validation will fail.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage keepFields(String keepFields) {
            this.keepFields = Optional.ofNullable(keepFields);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "keep_fields", nulls = Nulls.SKIP)
        public _FinalStage keepFields(Optional<String> keepFields) {
            this.keepFields = keepFields;
            return this;
        }

        /**
         * <p>Indicates whether rows with malformed input should be dropped (instead of failing the validation check). Dropped rows will be returned in the warnings field.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage skipMalformedInput(Boolean skipMalformedInput) {
            this.skipMalformedInput = Optional.ofNullable(skipMalformedInput);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "skip_malformed_input", nulls = Nulls.SKIP)
        public _FinalStage skipMalformedInput(Optional<Boolean> skipMalformedInput) {
            this.skipMalformedInput = skipMalformedInput;
            return this;
        }

        /**
         * <p>Indicates if the original file should be stored.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage keepOriginalFile(Boolean keepOriginalFile) {
            this.keepOriginalFile = Optional.ofNullable(keepOriginalFile);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "keep_original_file", nulls = Nulls.SKIP)
        public _FinalStage keepOriginalFile(Optional<Boolean> keepOriginalFile) {
            this.keepOriginalFile = keepOriginalFile;
            return this;
        }

        @java.lang.Override
        public DatasetsCreateRequest build() {
            return new DatasetsCreateRequest(
                    name,
                    type,
                    keepOriginalFile,
                    skipMalformedInput,
                    keepFields,
                    optionalFields,
                    textSeparator,
                    csvDelimiter,
                    dryRun,
                    additionalProperties);
        }
    }
}
