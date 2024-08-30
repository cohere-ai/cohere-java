/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.errors;

import com.cohere.api.core.CohereApiApiError;
import com.cohere.api.types.ClientClosedRequestErrorBody;

public final class CohereApiClientClosedRequestError extends CohereApiApiError {
    /**
     * The body of the response that triggered the exception.
     */
    private final ClientClosedRequestErrorBody body;

    public CohereApiClientClosedRequestError(ClientClosedRequestErrorBody body) {
        super("ClientClosedRequestError", 499, body);
        this.body = body;
    }

    /**
     * @return the body
     */
    @java.lang.Override
    public ClientClosedRequestErrorBody body() {
        return this.body;
    }
}