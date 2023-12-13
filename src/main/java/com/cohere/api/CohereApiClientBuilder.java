/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api;

import com.cohere.api.core.ClientOptions;
import com.cohere.api.core.Environment;

public final class CohereApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.PRODUCTION;

    public CohereApiClientBuilder token(String token) {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + token);
        return this;
    }

    public CohereApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public CohereApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public CohereApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new CohereApiClient(clientOptionsBuilder.build());
    }
}
