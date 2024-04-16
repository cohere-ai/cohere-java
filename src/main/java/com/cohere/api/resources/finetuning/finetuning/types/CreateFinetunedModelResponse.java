/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.finetuning.finetuning.types;

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
@JsonDeserialize(builder = CreateFinetunedModelResponse.Builder.class)
public final class CreateFinetunedModelResponse {
    private final Optional<FinetunedModel> finetunedModel;

    private final Map<String, Object> additionalProperties;

    private CreateFinetunedModelResponse(
            Optional<FinetunedModel> finetunedModel, Map<String, Object> additionalProperties) {
        this.finetunedModel = finetunedModel;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information about the fine-tuned model.
     */
    @JsonProperty("finetuned_model")
    public Optional<FinetunedModel> getFinetunedModel() {
        return finetunedModel;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateFinetunedModelResponse && equalTo((CreateFinetunedModelResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateFinetunedModelResponse other) {
        return finetunedModel.equals(other.finetunedModel);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.finetunedModel);
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
        private Optional<FinetunedModel> finetunedModel = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateFinetunedModelResponse other) {
            finetunedModel(other.getFinetunedModel());
            return this;
        }

        @JsonSetter(value = "finetuned_model", nulls = Nulls.SKIP)
        public Builder finetunedModel(Optional<FinetunedModel> finetunedModel) {
            this.finetunedModel = finetunedModel;
            return this;
        }

        public Builder finetunedModel(FinetunedModel finetunedModel) {
            this.finetunedModel = Optional.of(finetunedModel);
            return this;
        }

        public CreateFinetunedModelResponse build() {
            return new CreateFinetunedModelResponse(finetunedModel, additionalProperties);
        }
    }
}
