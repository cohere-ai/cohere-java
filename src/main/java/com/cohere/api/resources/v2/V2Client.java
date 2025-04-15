/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.v2;

import com.cohere.api.core.ClientOptions;
import com.cohere.api.core.CohereApiException;
import com.cohere.api.core.CohereException;
import com.cohere.api.core.MediaTypes;
import com.cohere.api.core.ObjectMappers;
import com.cohere.api.core.RequestOptions;
import com.cohere.api.core.ResponseBodyReader;
import com.cohere.api.core.Stream;
import com.cohere.api.errors.BadRequestError;
import com.cohere.api.errors.ClientClosedRequestError;
import com.cohere.api.errors.ForbiddenError;
import com.cohere.api.errors.GatewayTimeoutError;
import com.cohere.api.errors.InternalServerError;
import com.cohere.api.errors.InvalidTokenError;
import com.cohere.api.errors.NotFoundError;
import com.cohere.api.errors.NotImplementedError;
import com.cohere.api.errors.ServiceUnavailableError;
import com.cohere.api.errors.TooManyRequestsError;
import com.cohere.api.errors.UnauthorizedError;
import com.cohere.api.errors.UnprocessableEntityError;
import com.cohere.api.resources.v2.requests.V2ChatRequest;
import com.cohere.api.resources.v2.requests.V2ChatStreamRequest;
import com.cohere.api.resources.v2.requests.V2EmbedRequest;
import com.cohere.api.resources.v2.requests.V2RerankRequest;
import com.cohere.api.resources.v2.types.V2RerankResponse;
import com.cohere.api.types.ChatResponse;
import com.cohere.api.types.EmbedByTypeResponse;
import com.cohere.api.types.StreamedChatResponseV2;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class V2Client {
    protected final ClientOptions clientOptions;

    public V2Client(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Generates a text response to a user message. To learn how to use the Chat API and RAG follow our <a href="https://docs.cohere.com/v2/docs/chat-api">Text Generation guides</a>.
     * <p>Follow the <a href="https://docs.cohere.com/v2/docs/migrating-v1-to-v2">Migration Guide</a> for instructions on moving from API v1 to API v2.</p>
     */
    public Iterable<StreamedChatResponseV2> chatStream(V2ChatStreamRequest request) {
        return chatStream(request, null);
    }

    /**
     * Generates a text response to a user message. To learn how to use the Chat API and RAG follow our <a href="https://docs.cohere.com/v2/docs/chat-api">Text Generation guides</a>.
     * <p>Follow the <a href="https://docs.cohere.com/v2/docs/migrating-v1-to-v2">Migration Guide</a> for instructions on moving from API v1 to API v2.</p>
     */
    public Iterable<StreamedChatResponseV2> chatStream(V2ChatStreamRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/chat")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try {
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new Stream<StreamedChatResponseV2>(
                        StreamedChatResponseV2.class, new ResponseBodyReader(response), "\n");
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new UnprocessableEntityError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 498:
                        throw new InvalidTokenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 499:
                        throw new ClientClosedRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new NotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereException("Network error executing HTTP request", e);
        }
    }

    /**
     * Generates a text response to a user message and streams it down, token by token. To learn how to use the Chat API with streaming follow our <a href="https://docs.cohere.com/v2/docs/chat-api">Text Generation guides</a>.
     * <p>Follow the <a href="https://docs.cohere.com/v2/docs/migrating-v1-to-v2">Migration Guide</a> for instructions on moving from API v1 to API v2.</p>
     */
    public ChatResponse chat(V2ChatRequest request) {
        return chat(request, null);
    }

    /**
     * Generates a text response to a user message and streams it down, token by token. To learn how to use the Chat API with streaming follow our <a href="https://docs.cohere.com/v2/docs/chat-api">Text Generation guides</a>.
     * <p>Follow the <a href="https://docs.cohere.com/v2/docs/migrating-v1-to-v2">Migration Guide</a> for instructions on moving from API v1 to API v2.</p>
     */
    public ChatResponse chat(V2ChatRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/chat")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ChatResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new UnprocessableEntityError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 498:
                        throw new InvalidTokenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 499:
                        throw new ClientClosedRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new NotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereException("Network error executing HTTP request", e);
        }
    }

    /**
     * This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.
     * <p>Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.</p>
     * <p>If you want to learn more how to use the embedding model, have a look at the <a href="https://docs.cohere.com/docs/semantic-search">Semantic Search Guide</a>.</p>
     */
    public EmbedByTypeResponse embed(V2EmbedRequest request) {
        return embed(request, null);
    }

    /**
     * This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.
     * <p>Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.</p>
     * <p>If you want to learn more how to use the embedding model, have a look at the <a href="https://docs.cohere.com/docs/semantic-search">Semantic Search Guide</a>.</p>
     */
    public EmbedByTypeResponse embed(V2EmbedRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/embed")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), EmbedByTypeResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new UnprocessableEntityError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 498:
                        throw new InvalidTokenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 499:
                        throw new ClientClosedRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new NotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereException("Network error executing HTTP request", e);
        }
    }

    /**
     * This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
     */
    public V2RerankResponse rerank(V2RerankRequest request) {
        return rerank(request, null);
    }

    /**
     * This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
     */
    public V2RerankResponse rerank(V2RerankRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/rerank")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), V2RerankResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new UnprocessableEntityError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 498:
                        throw new InvalidTokenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 499:
                        throw new ClientClosedRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new NotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereException("Network error executing HTTP request", e);
        }
    }
}
