/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.cohere.api;

import com.cohere.api.core.ApiError;
import com.cohere.api.core.ClientOptions;
import com.cohere.api.core.ObjectMappers;
import com.cohere.api.core.RequestOptions;
import com.cohere.api.core.Stream;
import com.cohere.api.core.Suppliers;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.requests.ChatStreamRequest;
import com.cohere.api.requests.ClassifyRequest;
import com.cohere.api.requests.DetectLanguageRequest;
import com.cohere.api.requests.DetokenizeRequest;
import com.cohere.api.requests.EmbedRequest;
import com.cohere.api.requests.GenerateRequest;
import com.cohere.api.requests.RerankRequest;
import com.cohere.api.requests.SummarizeRequest;
import com.cohere.api.requests.TokenizeRequest;
import com.cohere.api.resources.connectors.ConnectorsClient;
import com.cohere.api.types.ClassifyResponse;
import com.cohere.api.types.DetectLanguageResponse;
import com.cohere.api.types.DetokenizeResponse;
import com.cohere.api.types.EmbedResponse;
import com.cohere.api.types.Generation;
import com.cohere.api.types.NonStreamedChatResponse;
import com.cohere.api.types.RerankResponse;
import com.cohere.api.types.StreamedChatResponse;
import com.cohere.api.types.SummarizeResponse;
import com.cohere.api.types.TokenizeResponse;
import java.io.IOException;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CohereApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<ConnectorsClient> connectorsClient;

    public CohereApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.connectorsClient = Suppliers.memoize(() -> new ConnectorsClient(clientOptions));
    }

    /**
     * The <code>chat</code> endpoint allows users to have conversations with a Large Language Model (LLM) from Cohere. Users can send messages as part of a persisted conversation using the <code>conversation_id</code> parameter, or they can pass in their own conversation history using the <code>chat_history</code> parameter.
     * The endpoint features additional parameters such as <a href="https://docs.cohere.com/docs/connectors">connectors</a> and <code>documents</code> that enable conversations enriched by external knowledge. We call this &quot;Retrieval Augmented Generation&quot;, or &quot;RAG&quot;.
     */
    public Iterable<StreamedChatResponse> chatStream(ChatStreamRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/chat")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return new Stream<StreamedChatResponse>(
                        StreamedChatResponse.class, response.body().charStream(), "\n");
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The <code>chat</code> endpoint allows users to have conversations with a Large Language Model (LLM) from Cohere. Users can send messages as part of a persisted conversation using the <code>conversation_id</code> parameter, or they can pass in their own conversation history using the <code>chat_history</code> parameter.
     * The endpoint features additional parameters such as <a href="https://docs.cohere.com/docs/connectors">connectors</a> and <code>documents</code> that enable conversations enriched by external knowledge. We call this &quot;Retrieval Augmented Generation&quot;, or &quot;RAG&quot;.
     */
    public Iterable<StreamedChatResponse> chatStream(ChatStreamRequest request) {
        return chatStream(request, null);
    }

    /**
     * The <code>chat</code> endpoint allows users to have conversations with a Large Language Model (LLM) from Cohere. Users can send messages as part of a persisted conversation using the <code>conversation_id</code> parameter, or they can pass in their own conversation history using the <code>chat_history</code> parameter.
     * The endpoint features additional parameters such as <a href="https://docs.cohere.com/docs/connectors">connectors</a> and <code>documents</code> that enable conversations enriched by external knowledge. We call this &quot;Retrieval Augmented Generation&quot;, or &quot;RAG&quot;.
     */
    public NonStreamedChatResponse chat(ChatRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/chat")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), NonStreamedChatResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The <code>chat</code> endpoint allows users to have conversations with a Large Language Model (LLM) from Cohere. Users can send messages as part of a persisted conversation using the <code>conversation_id</code> parameter, or they can pass in their own conversation history using the <code>chat_history</code> parameter.
     * The endpoint features additional parameters such as <a href="https://docs.cohere.com/docs/connectors">connectors</a> and <code>documents</code> that enable conversations enriched by external knowledge. We call this &quot;Retrieval Augmented Generation&quot;, or &quot;RAG&quot;.
     */
    public NonStreamedChatResponse chat(ChatRequest request) {
        return chat(request, null);
    }

    /**
     * This endpoint generates realistic text conditioned on a given input.
     */
    public Generation generate(GenerateRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/generate")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Generation.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint generates realistic text conditioned on a given input.
     */
    public Generation generate(GenerateRequest request) {
        return generate(request, null);
    }

    /**
     * This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.
     * <p>Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.</p>
     * <p>If you want to learn more how to use the embedding model, have a look at the <a href="/docs/semantic-search">Semantic Search Guide</a>.</p>
     */
    public EmbedResponse embed(EmbedRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/embed")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), EmbedResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.
     * <p>Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.</p>
     * <p>If you want to learn more how to use the embedding model, have a look at the <a href="/docs/semantic-search">Semantic Search Guide</a>.</p>
     */
    public EmbedResponse embed(EmbedRequest request) {
        return embed(request, null);
    }

    /**
     * This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
     */
    public RerankResponse rerank(RerankRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/rerank")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), RerankResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
     */
    public RerankResponse rerank(RerankRequest request) {
        return rerank(request, null);
    }

    /**
     * This endpoint makes a prediction about which label fits the specified text inputs best. To make a prediction, Classify uses the provided <code>examples</code> of text + label pairs as a reference.
     * Note: <a href="/training-representation-models">Custom Models</a> trained on classification examples don't require the <code>examples</code> parameter to be passed in explicitly.
     */
    public ClassifyResponse classify(ClassifyRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/classify")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ClassifyResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint makes a prediction about which label fits the specified text inputs best. To make a prediction, Classify uses the provided <code>examples</code> of text + label pairs as a reference.
     * Note: <a href="/training-representation-models">Custom Models</a> trained on classification examples don't require the <code>examples</code> parameter to be passed in explicitly.
     */
    public ClassifyResponse classify(ClassifyRequest request) {
        return classify(request, null);
    }

    /**
     * This endpoint identifies which language each of the provided texts is written in.
     */
    public DetectLanguageResponse detectLanguage(DetectLanguageRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/detect-language")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), DetectLanguageResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint identifies which language each of the provided texts is written in.
     */
    public DetectLanguageResponse detectLanguage(DetectLanguageRequest request) {
        return detectLanguage(request, null);
    }

    /**
     * This endpoint generates a summary in English for a given text.
     */
    public SummarizeResponse summarize(SummarizeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/summarize")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), SummarizeResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint generates a summary in English for a given text.
     */
    public SummarizeResponse summarize(SummarizeRequest request) {
        return summarize(request, null);
    }

    /**
     * This endpoint splits input text into smaller units called tokens using byte-pair encoding (BPE). To learn more about tokenization and byte pair encoding, see the tokens page.
     */
    public TokenizeResponse tokenize(TokenizeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/tokenize")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), TokenizeResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint splits input text into smaller units called tokens using byte-pair encoding (BPE). To learn more about tokenization and byte pair encoding, see the tokens page.
     */
    public TokenizeResponse tokenize(TokenizeRequest request) {
        return tokenize(request, null);
    }

    /**
     * This endpoint takes tokens using byte-pair encoding and returns their text representation. To learn more about tokenization and byte pair encoding, see the tokens page.
     */
    public DetokenizeResponse detokenize(DetokenizeRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/detokenize")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), DetokenizeResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This endpoint takes tokens using byte-pair encoding and returns their text representation. To learn more about tokenization and byte pair encoding, see the tokens page.
     */
    public DetokenizeResponse detokenize(DetokenizeRequest request) {
        return detokenize(request, null);
    }

    public ConnectorsClient connectors() {
        return this.connectorsClient.get();
    }

    public static CohereApiClientBuilder builder() {
        return new CohereApiClientBuilder();
    }
}
