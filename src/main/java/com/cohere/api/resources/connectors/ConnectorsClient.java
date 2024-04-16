/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api.resources.connectors;

import com.cohere.api.core.ApiError;
import com.cohere.api.core.ClientOptions;
import com.cohere.api.core.MediaTypes;
import com.cohere.api.core.ObjectMappers;
import com.cohere.api.core.RequestOptions;
import com.cohere.api.resources.connectors.requests.ConnectorsListRequest;
import com.cohere.api.resources.connectors.requests.ConnectorsOAuthAuthorizeRequest;
import com.cohere.api.resources.connectors.requests.CreateConnectorRequest;
import com.cohere.api.resources.connectors.requests.UpdateConnectorRequest;
import com.cohere.api.types.CreateConnectorResponse;
import com.cohere.api.types.GetConnectorResponse;
import com.cohere.api.types.ListConnectorsResponse;
import com.cohere.api.types.OAuthAuthorizeResponse;
import com.cohere.api.types.UpdateConnectorResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectorsClient {
    protected final ClientOptions clientOptions;

    public ConnectorsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of connectors ordered by descending creation date (newer first). See <a href="https://docs.cohere.com/docs/managing-your-connector">'Managing your Connector'</a> for more information.
     */
    public ListConnectorsResponse list() {
        return list(ConnectorsListRequest.builder().build());
    }

    /**
     * Returns a list of connectors ordered by descending creation date (newer first). See <a href="https://docs.cohere.com/docs/managing-your-connector">'Managing your Connector'</a> for more information.
     */
    public ListConnectorsResponse list(ConnectorsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of connectors ordered by descending creation date (newer first). See <a href="https://docs.cohere.com/docs/managing-your-connector">'Managing your Connector'</a> for more information.
     */
    public ListConnectorsResponse list(ConnectorsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("connectors");
        if (request.getLimit().isPresent()) {
            httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        if (request.getOffset().isPresent()) {
            httpUrl.addQueryParameter("offset", request.getOffset().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions.getTimeout().isPresent()) {
                client = client.newBuilder()
                        .readTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit())
                        .build();
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ListConnectorsResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new connector. The connector is tested during registration and will cancel registration when the test is unsuccessful. See <a href="https://docs.cohere.com/docs/creating-and-deploying-a-connector">'Creating and Deploying a Connector'</a> for more information.
     */
    public CreateConnectorResponse create(CreateConnectorRequest request) {
        return create(request, null);
    }

    /**
     * Creates a new connector. The connector is tested during registration and will cancel registration when the test is unsuccessful. See <a href="https://docs.cohere.com/docs/creating-and-deploying-a-connector">'Creating and Deploying a Connector'</a> for more information.
     */
    public CreateConnectorResponse create(CreateConnectorRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("connectors")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions.getTimeout().isPresent()) {
                client = client.newBuilder()
                        .readTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit())
                        .build();
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), CreateConnectorResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieve a connector by ID. See <a href="https://docs.cohere.com/docs/connectors">'Connectors'</a> for more information.
     */
    public GetConnectorResponse get(String id) {
        return get(id, null);
    }

    /**
     * Retrieve a connector by ID. See <a href="https://docs.cohere.com/docs/connectors">'Connectors'</a> for more information.
     */
    public GetConnectorResponse get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("connectors")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions.getTimeout().isPresent()) {
                client = client.newBuilder()
                        .readTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit())
                        .build();
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), GetConnectorResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete a connector by ID. See <a href="https://docs.cohere.com/docs/connectors">'Connectors'</a> for more information.
     */
    public Map<String, Object> delete(String id) {
        return delete(id, null);
    }

    /**
     * Delete a connector by ID. See <a href="https://docs.cohere.com/docs/connectors">'Connectors'</a> for more information.
     */
    public Map<String, Object> delete(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("connectors")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions.getTimeout().isPresent()) {
                client = client.newBuilder()
                        .readTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit())
                        .build();
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), new TypeReference<Map<String, Object>>() {});
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update a connector by ID. Omitted fields will not be updated. See <a href="https://docs.cohere.com/docs/managing-your-connector">'Managing your Connector'</a> for more information.
     */
    public UpdateConnectorResponse update(String id) {
        return update(id, UpdateConnectorRequest.builder().build());
    }

    /**
     * Update a connector by ID. Omitted fields will not be updated. See <a href="https://docs.cohere.com/docs/managing-your-connector">'Managing your Connector'</a> for more information.
     */
    public UpdateConnectorResponse update(String id, UpdateConnectorRequest request) {
        return update(id, request, null);
    }

    /**
     * Update a connector by ID. Omitted fields will not be updated. See <a href="https://docs.cohere.com/docs/managing-your-connector">'Managing your Connector'</a> for more information.
     */
    public UpdateConnectorResponse update(String id, UpdateConnectorRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("connectors")
                .addPathSegment(id)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PATCH", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions.getTimeout().isPresent()) {
                client = client.newBuilder()
                        .readTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit())
                        .build();
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), UpdateConnectorResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Authorize the connector with the given ID for the connector oauth app. See <a href="https://docs.cohere.com/docs/connector-authentication">'Connector Authentication'</a> for more information.
     */
    public OAuthAuthorizeResponse oAuthAuthorize(String id) {
        return oAuthAuthorize(id, ConnectorsOAuthAuthorizeRequest.builder().build());
    }

    /**
     * Authorize the connector with the given ID for the connector oauth app. See <a href="https://docs.cohere.com/docs/connector-authentication">'Connector Authentication'</a> for more information.
     */
    public OAuthAuthorizeResponse oAuthAuthorize(String id, ConnectorsOAuthAuthorizeRequest request) {
        return oAuthAuthorize(id, request, null);
    }

    /**
     * Authorize the connector with the given ID for the connector oauth app. See <a href="https://docs.cohere.com/docs/connector-authentication">'Connector Authentication'</a> for more information.
     */
    public OAuthAuthorizeResponse oAuthAuthorize(
            String id, ConnectorsOAuthAuthorizeRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("connectors")
                .addPathSegment(id)
                .addPathSegments("oauth/authorize");
        if (request.getAfterTokenRedirect().isPresent()) {
            httpUrl.addQueryParameter(
                    "after_token_redirect", request.getAfterTokenRedirect().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions.getTimeout().isPresent()) {
                client = client.newBuilder()
                        .readTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit())
                        .build();
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), OAuthAuthorizeResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
