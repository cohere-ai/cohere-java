/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.models;

import com.cohere.api.core.ApiError;
import com.cohere.api.core.ClientOptions;
import com.cohere.api.core.ObjectMappers;
import com.cohere.api.core.RequestOptions;
import com.cohere.api.resources.models.requests.ModelsListRequest;
import com.cohere.api.types.GetModelResponse;
import com.cohere.api.types.ListModelsResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ModelsClient {
    protected final ClientOptions clientOptions;

    public ModelsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns the details of a model, provided its name.
     */
    public GetModelResponse get(String model) {
        return get(model, null);
    }

    /**
     * Returns the details of a model, provided its name.
     */
    public GetModelResponse get(String model, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("models")
                .addPathSegment(model)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), GetModelResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a list of models available for use. The list contains models from Cohere as well as your fine-tuned models.
     */
    public ListModelsResponse list() {
        return list(ModelsListRequest.builder().build());
    }

    /**
     * Returns a list of models available for use. The list contains models from Cohere as well as your fine-tuned models.
     */
    public ListModelsResponse list(ModelsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of models available for use. The list contains models from Cohere as well as your fine-tuned models.
     */
    public ListModelsResponse list(ModelsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("models");
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getPageToken().isPresent()) {
            httpUrl.addQueryParameter("page_token", request.getPageToken().get());
        }
        if (request.getEndpoint().isPresent()) {
            httpUrl.addQueryParameter("endpoint", request.getEndpoint().get().toString());
        }
        if (request.getDefaultOnly().isPresent()) {
            httpUrl.addQueryParameter(
                    "default_only", request.getDefaultOnly().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ListModelsResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
