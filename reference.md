# Reference
<details><summary><code>client.chatStream(request) -> Optional&lt;StreamedChatResponse&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Generates a streamed text response to a user message.

To learn how to use the Chat API and RAG follow our [Text Generation guides](https://docs.cohere.com/docs/chat-api).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.chatStream(
    ChatStreamRequest
        .builder()
        .message("hello world!")
        .stream(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accepts:** `Optional<String>` — Pass text/event-stream to receive the streamed response as server-sent events. The default is `\n` delimited events.
    
</dd>
</dl>

<dl>
<dd>

**message:** `String` 

Text input for the model to respond to.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` 

The name of a compatible [Cohere model](https://docs.cohere.com/docs/models) or the ID of a [fine-tuned](https://docs.cohere.com/docs/chat-fine-tuning) model.

Compatible Deployments: Cohere Platform, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**stream:** `Boolean` 

Defaults to `false`.

When `true`, the response will be a JSON stream of events. The final event will contain the complete response, and will have an `event_type` of `"stream-end"`.

Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**preamble:** `Optional<String>` 

When specified, the default Cohere preamble will be replaced with the provided one. Preambles are a part of the prompt used to adjust the model's overall behavior and conversation style, and use the `SYSTEM` role.

The `SYSTEM` role is also used for the contents of the optional `chat_history=` parameter. When used with the `chat_history=` parameter it adds content throughout a conversation. Conversely, when used with the `preamble=` parameter it adds content at the start of the conversation only.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**chatHistory:** `Optional<List<Message>>` 

A list of previous messages between the user and the model, giving the model conversational context for responding to the user's `message`.

Each item represents a single message in the chat history, excluding the current user turn. It has two properties: `role` and `message`. The `role` identifies the sender (`CHATBOT`, `SYSTEM`, or `USER`), while the `message` contains the text content.

The chat_history parameter should not be used for `SYSTEM` messages in most cases. Instead, to add a `SYSTEM` role message at the beginning of a conversation, the `preamble` parameter should be used.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**conversationId:** `Optional<String>` 

An alternative to `chat_history`.

Providing a `conversation_id` creates or resumes a persisted conversation with the specified ID. The ID can be any non empty string.

Compatible Deployments: Cohere Platform
    
</dd>
</dl>

<dl>
<dd>

**promptTruncation:** `Optional<ChatStreamRequestPromptTruncation>` 

Defaults to `AUTO` when `connectors` are specified and `OFF` in all other cases.

Dictates how the prompt will be constructed.

With `prompt_truncation` set to "AUTO", some elements from `chat_history` and `documents` will be dropped in an attempt to construct a prompt that fits within the model's context length limit. During this process the order of the documents and chat history will be changed and ranked by relevance.

With `prompt_truncation` set to "AUTO_PRESERVE_ORDER", some elements from `chat_history` and `documents` will be dropped in an attempt to construct a prompt that fits within the model's context length limit. During this process the order of the documents and chat history will be preserved as they are inputted into the API.

With `prompt_truncation` set to "OFF", no elements will be dropped. If the sum of the inputs exceeds the model's context length limit, a `TooManyTokens` error will be returned.

Compatible Deployments:
 - AUTO: Cohere Platform Only
 - AUTO_PRESERVE_ORDER: Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**connectors:** `Optional<List<ChatConnector>>` 

Accepts `{"id": "web-search"}`, and/or the `"id"` for a custom [connector](https://docs.cohere.com/docs/connectors), if you've [created](https://docs.cohere.com/v1/docs/creating-and-deploying-a-connector) one.

When specified, the model's reply will be enriched with information found by querying each of the connectors (RAG).

Compatible Deployments: Cohere Platform
    
</dd>
</dl>

<dl>
<dd>

**searchQueriesOnly:** `Optional<Boolean>` 

Defaults to `false`.

When `true`, the response will only contain a list of generated search queries, but no search will take place, and no reply from the model to the user's `message` will be generated.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**documents:** `Optional<List<Map<String, String>>>` 

A list of relevant documents that the model can cite to generate a more accurate reply. Each document is a string-string dictionary.

Example:
```
[
  { "title": "Tall penguins", "text": "Emperor penguins are the tallest." },
  { "title": "Penguin habitats", "text": "Emperor penguins only live in Antarctica." },
]
```

Keys and values from each document will be serialized to a string and passed to the model. The resulting generation will include citations that reference some of these documents.

Some suggested keys are "text", "author", and "date". For better generation quality, it is recommended to keep the total word count of the strings in the dictionary to under 300 words.

An `id` field (string) can be optionally supplied to identify the document in the citations. This field will not be passed to the model.

An `_excludes` field (array of strings) can be optionally supplied to omit some key-value pairs from being shown to the model. The omitted fields will still show up in the citation object. The "_excludes" field will not be passed to the model.

See ['Document Mode'](https://docs.cohere.com/docs/retrieval-augmented-generation-rag#document-mode) in the guide for more information.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**citationQuality:** `Optional<ChatStreamRequestCitationQuality>` 

Defaults to `"accurate"`.

Dictates the approach taken to generating citations as part of the RAG flow by allowing the user to specify whether they want `"accurate"` results, `"fast"` results or no results.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` 

Defaults to `0.3`.

A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.

Randomness can be further maximized by increasing the  value of the `p` parameter.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` 

The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**maxInputTokens:** `Optional<Integer>` 

The maximum number of input tokens to send to the model. If not specified, `max_input_tokens` is the model's context length limit minus a small buffer.

Input will be truncated according to the `prompt_truncation` parameter.

Compatible Deployments: Cohere Platform
    
</dd>
</dl>

<dl>
<dd>

**k:** `Optional<Integer>` 

Ensures only the top `k` most likely tokens are considered for generation at each step.
Defaults to `0`, min value of `0`, max value of `500`.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**p:** `Optional<Float>` 

Ensures that only the most likely tokens, with total probability mass of `p`, are considered for generation at each step. If both `k` and `p` are enabled, `p` acts after `k`.
Defaults to `0.75`. min value of `0.01`, max value of `0.99`.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**seed:** `Optional<Integer>` 

If specified, the backend will make a best effort to sample tokens
deterministically, such that repeated requests with the same
seed and parameters should return the same result. However,
determinism cannot be totally guaranteed.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**stopSequences:** `Optional<List<String>>` 

A list of up to 5 strings that the model will use to stop generation. If the model generates a string that matches any of the strings in the list, it will stop generating tokens and return the generated text up to that point not including the stop sequence.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**frequencyPenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.

Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**presencePenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.

Used to reduce repetitiveness of generated tokens. Similar to `frequency_penalty`, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**tools:** `Optional<List<Tool>>` 

A list of available tools (functions) that the model may suggest invoking before producing a text response.

When `tools` is passed (without `tool_results`), the `text` field in the response will be `""` and the `tool_calls` field in the response will be populated with a list of tool calls that need to be made. If no calls need to be made, the `tool_calls` array will be empty.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**toolResults:** `Optional<List<ToolResult>>` 

A list of results from invoking tools recommended by the model in the previous chat turn. Results are used to produce a text response and will be referenced in citations. When using `tool_results`, `tools` must be passed as well.
Each tool_result contains information about how it was invoked, as well as a list of outputs in the form of dictionaries.

**Note**: `outputs` must be a list of objects. If your tool returns a single object (eg `{"status": 200}`), make sure to wrap it in a list.
```
tool_results = [
  {
    "call": {
      "name": <tool name>,
      "parameters": {
        <param name>: <param value>
      }
    },
    "outputs": [{
      <key>: <value>
    }]
  },
  ...
]
```
**Note**: Chat calls with `tool_results` should not be included in the Chat history to avoid duplication of the message text.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**forceSingleStep:** `Optional<Boolean>` — Forces the chat to be single step. Defaults to `false`.
    
</dd>
</dl>

<dl>
<dd>

**responseFormat:** `Optional<ResponseFormat>` 
    
</dd>
</dl>

<dl>
<dd>

**safetyMode:** `Optional<ChatStreamRequestSafetyMode>` 

Used to select the [safety instruction](https://docs.cohere.com/docs/safety-modes) inserted into the prompt. Defaults to `CONTEXTUAL`.
When `NONE` is specified, the safety instruction will be omitted.

Safety modes are not yet configurable in combination with `tools`, `tool_results` and `documents` parameters.

**Note**: This parameter is only compatible newer Cohere models, starting with [Command R 08-2024](https://docs.cohere.com/docs/command-r#august-2024-release) and [Command R+ 08-2024](https://docs.cohere.com/docs/command-r-plus#august-2024-release).

**Note**: `command-r7b-12-2024` and newer models only support `"CONTEXTUAL"` and `"STRICT"` modes.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.chat(request) -> NonStreamedChatResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Generates a text response to a user message.
To learn how to use the Chat API and RAG follow our [Text Generation guides](https://docs.cohere.com/docs/chat-api).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.chatStream(
    ChatStreamRequest
        .builder()
        .message("What year was he born?")
        .stream(false)
        .chatHistory(
            new ArrayList<Message>(
                Arrays.asList(
                    Message.user(
                        ChatMessage
                            .builder()
                            .message("Who discovered gravity?")
                            .build()
                    ),
                    Message.chatbot(
                        ChatMessage
                            .builder()
                            .message("The man who is widely credited with discovering gravity is Sir Isaac Newton")
                            .build()
                    )
                )
            )
        )
        .connectors(
            new ArrayList<ChatConnector>(
                Arrays.asList(
                    ChatConnector
                        .builder()
                        .id("web-search")
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accepts:** `Optional<String>` — Pass text/event-stream to receive the streamed response as server-sent events. The default is `\n` delimited events.
    
</dd>
</dl>

<dl>
<dd>

**message:** `String` 

Text input for the model to respond to.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` 

The name of a compatible [Cohere model](https://docs.cohere.com/docs/models) or the ID of a [fine-tuned](https://docs.cohere.com/docs/chat-fine-tuning) model.

Compatible Deployments: Cohere Platform, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**stream:** `Boolean` 

Defaults to `false`.

When `true`, the response will be a JSON stream of events. The final event will contain the complete response, and will have an `event_type` of `"stream-end"`.

Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**preamble:** `Optional<String>` 

When specified, the default Cohere preamble will be replaced with the provided one. Preambles are a part of the prompt used to adjust the model's overall behavior and conversation style, and use the `SYSTEM` role.

The `SYSTEM` role is also used for the contents of the optional `chat_history=` parameter. When used with the `chat_history=` parameter it adds content throughout a conversation. Conversely, when used with the `preamble=` parameter it adds content at the start of the conversation only.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**chatHistory:** `Optional<List<Message>>` 

A list of previous messages between the user and the model, giving the model conversational context for responding to the user's `message`.

Each item represents a single message in the chat history, excluding the current user turn. It has two properties: `role` and `message`. The `role` identifies the sender (`CHATBOT`, `SYSTEM`, or `USER`), while the `message` contains the text content.

The chat_history parameter should not be used for `SYSTEM` messages in most cases. Instead, to add a `SYSTEM` role message at the beginning of a conversation, the `preamble` parameter should be used.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**conversationId:** `Optional<String>` 

An alternative to `chat_history`.

Providing a `conversation_id` creates or resumes a persisted conversation with the specified ID. The ID can be any non empty string.

Compatible Deployments: Cohere Platform
    
</dd>
</dl>

<dl>
<dd>

**promptTruncation:** `Optional<ChatRequestPromptTruncation>` 

Defaults to `AUTO` when `connectors` are specified and `OFF` in all other cases.

Dictates how the prompt will be constructed.

With `prompt_truncation` set to "AUTO", some elements from `chat_history` and `documents` will be dropped in an attempt to construct a prompt that fits within the model's context length limit. During this process the order of the documents and chat history will be changed and ranked by relevance.

With `prompt_truncation` set to "AUTO_PRESERVE_ORDER", some elements from `chat_history` and `documents` will be dropped in an attempt to construct a prompt that fits within the model's context length limit. During this process the order of the documents and chat history will be preserved as they are inputted into the API.

With `prompt_truncation` set to "OFF", no elements will be dropped. If the sum of the inputs exceeds the model's context length limit, a `TooManyTokens` error will be returned.

Compatible Deployments:
 - AUTO: Cohere Platform Only
 - AUTO_PRESERVE_ORDER: Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**connectors:** `Optional<List<ChatConnector>>` 

Accepts `{"id": "web-search"}`, and/or the `"id"` for a custom [connector](https://docs.cohere.com/docs/connectors), if you've [created](https://docs.cohere.com/v1/docs/creating-and-deploying-a-connector) one.

When specified, the model's reply will be enriched with information found by querying each of the connectors (RAG).

Compatible Deployments: Cohere Platform
    
</dd>
</dl>

<dl>
<dd>

**searchQueriesOnly:** `Optional<Boolean>` 

Defaults to `false`.

When `true`, the response will only contain a list of generated search queries, but no search will take place, and no reply from the model to the user's `message` will be generated.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**documents:** `Optional<List<Map<String, String>>>` 

A list of relevant documents that the model can cite to generate a more accurate reply. Each document is a string-string dictionary.

Example:
```
[
  { "title": "Tall penguins", "text": "Emperor penguins are the tallest." },
  { "title": "Penguin habitats", "text": "Emperor penguins only live in Antarctica." },
]
```

Keys and values from each document will be serialized to a string and passed to the model. The resulting generation will include citations that reference some of these documents.

Some suggested keys are "text", "author", and "date". For better generation quality, it is recommended to keep the total word count of the strings in the dictionary to under 300 words.

An `id` field (string) can be optionally supplied to identify the document in the citations. This field will not be passed to the model.

An `_excludes` field (array of strings) can be optionally supplied to omit some key-value pairs from being shown to the model. The omitted fields will still show up in the citation object. The "_excludes" field will not be passed to the model.

See ['Document Mode'](https://docs.cohere.com/docs/retrieval-augmented-generation-rag#document-mode) in the guide for more information.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**citationQuality:** `Optional<ChatRequestCitationQuality>` 

Defaults to `"accurate"`.

Dictates the approach taken to generating citations as part of the RAG flow by allowing the user to specify whether they want `"accurate"` results, `"fast"` results or no results.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` 

Defaults to `0.3`.

A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.

Randomness can be further maximized by increasing the  value of the `p` parameter.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` 

The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**maxInputTokens:** `Optional<Integer>` 

The maximum number of input tokens to send to the model. If not specified, `max_input_tokens` is the model's context length limit minus a small buffer.

Input will be truncated according to the `prompt_truncation` parameter.

Compatible Deployments: Cohere Platform
    
</dd>
</dl>

<dl>
<dd>

**k:** `Optional<Integer>` 

Ensures only the top `k` most likely tokens are considered for generation at each step.
Defaults to `0`, min value of `0`, max value of `500`.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**p:** `Optional<Float>` 

Ensures that only the most likely tokens, with total probability mass of `p`, are considered for generation at each step. If both `k` and `p` are enabled, `p` acts after `k`.
Defaults to `0.75`. min value of `0.01`, max value of `0.99`.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**seed:** `Optional<Integer>` 

If specified, the backend will make a best effort to sample tokens
deterministically, such that repeated requests with the same
seed and parameters should return the same result. However,
determinism cannot be totally guaranteed.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**stopSequences:** `Optional<List<String>>` 

A list of up to 5 strings that the model will use to stop generation. If the model generates a string that matches any of the strings in the list, it will stop generating tokens and return the generated text up to that point not including the stop sequence.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**frequencyPenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.

Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**presencePenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.

Used to reduce repetitiveness of generated tokens. Similar to `frequency_penalty`, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**tools:** `Optional<List<Tool>>` 

A list of available tools (functions) that the model may suggest invoking before producing a text response.

When `tools` is passed (without `tool_results`), the `text` field in the response will be `""` and the `tool_calls` field in the response will be populated with a list of tool calls that need to be made. If no calls need to be made, the `tool_calls` array will be empty.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**toolResults:** `Optional<List<ToolResult>>` 

A list of results from invoking tools recommended by the model in the previous chat turn. Results are used to produce a text response and will be referenced in citations. When using `tool_results`, `tools` must be passed as well.
Each tool_result contains information about how it was invoked, as well as a list of outputs in the form of dictionaries.

**Note**: `outputs` must be a list of objects. If your tool returns a single object (eg `{"status": 200}`), make sure to wrap it in a list.
```
tool_results = [
  {
    "call": {
      "name": <tool name>,
      "parameters": {
        <param name>: <param value>
      }
    },
    "outputs": [{
      <key>: <value>
    }]
  },
  ...
]
```
**Note**: Chat calls with `tool_results` should not be included in the Chat history to avoid duplication of the message text.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**forceSingleStep:** `Optional<Boolean>` — Forces the chat to be single step. Defaults to `false`.
    
</dd>
</dl>

<dl>
<dd>

**responseFormat:** `Optional<ResponseFormat>` 
    
</dd>
</dl>

<dl>
<dd>

**safetyMode:** `Optional<ChatRequestSafetyMode>` 

Used to select the [safety instruction](https://docs.cohere.com/docs/safety-modes) inserted into the prompt. Defaults to `CONTEXTUAL`.
When `NONE` is specified, the safety instruction will be omitted.

Safety modes are not yet configurable in combination with `tools`, `tool_results` and `documents` parameters.

**Note**: This parameter is only compatible newer Cohere models, starting with [Command R 08-2024](https://docs.cohere.com/docs/command-r#august-2024-release) and [Command R+ 08-2024](https://docs.cohere.com/docs/command-r-plus#august-2024-release).

**Note**: `command-r7b-12-2024` and newer models only support `"CONTEXTUAL"` and `"STRICT"` modes.

Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.generateStream(request) -> Optional&lt;GenerateStreamedResponse&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<Warning>
This API is marked as "Legacy" and is no longer maintained. Follow the [migration guide](https://docs.cohere.com/docs/migrating-from-cogenerate-to-cochat) to start using the Chat with Streaming API.
</Warning>
Generates realistic text conditioned on a given input.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.generateStream(
    GenerateStreamRequest
        .builder()
        .prompt("Please explain to me how LLMs work")
        .stream(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**prompt:** `String` 

The input text that serves as the starting point for generating the response.
Note: The prompt will be pre-processed and modified before reaching the model.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` 

The identifier of the model to generate with. Currently available models are `command` (default), `command-nightly` (experimental), `command-light`, and `command-light-nightly` (experimental).
Smaller, "light" models are faster, while larger models will perform better. [Custom models](https://docs.cohere.com/docs/training-custom-models) can also be supplied with their full ID.
    
</dd>
</dl>

<dl>
<dd>

**numGenerations:** `Optional<Integer>` — The maximum number of generations that will be returned. Defaults to `1`, min value of `1`, max value of `5`.
    
</dd>
</dl>

<dl>
<dd>

**stream:** `Boolean` 

When `true`, the response will be a JSON stream of events. Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.

The final event will contain the complete response, and will contain an `is_finished` field set to `true`. The event will also contain a `finish_reason`, which can be one of the following:
- `COMPLETE` - the model sent back a finished reply
- `MAX_TOKENS` - the reply was cut off because the model reached the maximum number of tokens for its context length
- `ERROR` - something went wrong when generating the reply
- `ERROR_TOXIC` - the model generated a reply that was deemed toxic
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` 

The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.

This parameter is off by default, and if it's not specified, the model will continue generating until it emits an EOS completion token. See [BPE Tokens](/bpe-tokens-wiki) for more details.

Can only be set to `0` if `return_likelihoods` is set to `ALL` to get the likelihood of the prompt.
    
</dd>
</dl>

<dl>
<dd>

**truncate:** `Optional<GenerateStreamRequestTruncate>` 

One of `NONE|START|END` to specify how the API will handle inputs longer than the maximum token length.

Passing `START` will discard the start of the input. `END` will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.

If `NONE` is selected, when the input exceeds the maximum input token length an error will be returned.
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` 

A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations. See [Temperature](/temperature-wiki) for more details.
Defaults to `0.75`, min value of `0.0`, max value of `5.0`.
    
</dd>
</dl>

<dl>
<dd>

**seed:** `Optional<Integer>` 

If specified, the backend will make a best effort to sample tokens
deterministically, such that repeated requests with the same
seed and parameters should return the same result. However,
determinism cannot be totally guaranteed.
Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**preset:** `Optional<String>` 

Identifier of a custom preset. A preset is a combination of parameters, such as prompt, temperature etc. You can create presets in the [playground](https://dashboard.cohere.com/playground/generate).
When a preset is specified, the `prompt` parameter becomes optional, and any included parameters will override the preset's parameters.
    
</dd>
</dl>

<dl>
<dd>

**endSequences:** `Optional<List<String>>` — The generated text will be cut at the beginning of the earliest occurrence of an end sequence. The sequence will be excluded from the text.
    
</dd>
</dl>

<dl>
<dd>

**stopSequences:** `Optional<List<String>>` — The generated text will be cut at the end of the earliest occurrence of a stop sequence. The sequence will be included the text.
    
</dd>
</dl>

<dl>
<dd>

**k:** `Optional<Integer>` 

Ensures only the top `k` most likely tokens are considered for generation at each step.
Defaults to `0`, min value of `0`, max value of `500`.
    
</dd>
</dl>

<dl>
<dd>

**p:** `Optional<Float>` 

Ensures that only the most likely tokens, with total probability mass of `p`, are considered for generation at each step. If both `k` and `p` are enabled, `p` acts after `k`.
Defaults to `0.75`. min value of `0.01`, max value of `0.99`.
    
</dd>
</dl>

<dl>
<dd>

**frequencyPenalty:** `Optional<Float>` 

Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.

Using `frequency_penalty` in combination with `presence_penalty` is not supported on newer models.
    
</dd>
</dl>

<dl>
<dd>

**presencePenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.

Can be used to reduce repetitiveness of generated tokens. Similar to `frequency_penalty`, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.

Using `frequency_penalty` in combination with `presence_penalty` is not supported on newer models.
    
</dd>
</dl>

<dl>
<dd>

**returnLikelihoods:** `Optional<GenerateStreamRequestReturnLikelihoods>` 

One of `GENERATION|NONE` to specify how and if the token likelihoods are returned with the response. Defaults to `NONE`.

If `GENERATION` is selected, the token likelihoods will only be provided for generated text.

WARNING: `ALL` is deprecated, and will be removed in a future release.
    
</dd>
</dl>

<dl>
<dd>

**rawPrompting:** `Optional<Boolean>` — When enabled, the user's prompt will be sent to the model without any pre-processing.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.generate(request) -> Generation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<Warning>
This API is marked as "Legacy" and is no longer maintained. Follow the [migration guide](https://docs.cohere.com/docs/migrating-from-cogenerate-to-cochat) to start using the Chat API.
</Warning>
Generates realistic text conditioned on a given input.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.generateStream(
    GenerateStreamRequest
        .builder()
        .prompt("Please explain to me how LLMs work")
        .stream(false)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**prompt:** `String` 

The input text that serves as the starting point for generating the response.
Note: The prompt will be pre-processed and modified before reaching the model.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` 

The identifier of the model to generate with. Currently available models are `command` (default), `command-nightly` (experimental), `command-light`, and `command-light-nightly` (experimental).
Smaller, "light" models are faster, while larger models will perform better. [Custom models](https://docs.cohere.com/docs/training-custom-models) can also be supplied with their full ID.
    
</dd>
</dl>

<dl>
<dd>

**numGenerations:** `Optional<Integer>` — The maximum number of generations that will be returned. Defaults to `1`, min value of `1`, max value of `5`.
    
</dd>
</dl>

<dl>
<dd>

**stream:** `Boolean` 

When `true`, the response will be a JSON stream of events. Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.

The final event will contain the complete response, and will contain an `is_finished` field set to `true`. The event will also contain a `finish_reason`, which can be one of the following:
- `COMPLETE` - the model sent back a finished reply
- `MAX_TOKENS` - the reply was cut off because the model reached the maximum number of tokens for its context length
- `ERROR` - something went wrong when generating the reply
- `ERROR_TOXIC` - the model generated a reply that was deemed toxic
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` 

The maximum number of tokens the model will generate as part of the response. Note: Setting a low value may result in incomplete generations.

This parameter is off by default, and if it's not specified, the model will continue generating until it emits an EOS completion token. See [BPE Tokens](/bpe-tokens-wiki) for more details.

Can only be set to `0` if `return_likelihoods` is set to `ALL` to get the likelihood of the prompt.
    
</dd>
</dl>

<dl>
<dd>

**truncate:** `Optional<GenerateRequestTruncate>` 

One of `NONE|START|END` to specify how the API will handle inputs longer than the maximum token length.

Passing `START` will discard the start of the input. `END` will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.

If `NONE` is selected, when the input exceeds the maximum input token length an error will be returned.
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` 

A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations. See [Temperature](/temperature-wiki) for more details.
Defaults to `0.75`, min value of `0.0`, max value of `5.0`.
    
</dd>
</dl>

<dl>
<dd>

**seed:** `Optional<Integer>` 

If specified, the backend will make a best effort to sample tokens
deterministically, such that repeated requests with the same
seed and parameters should return the same result. However,
determinism cannot be totally guaranteed.
Compatible Deployments: Cohere Platform, Azure, AWS Sagemaker/Bedrock, Private Deployments
    
</dd>
</dl>

<dl>
<dd>

**preset:** `Optional<String>` 

Identifier of a custom preset. A preset is a combination of parameters, such as prompt, temperature etc. You can create presets in the [playground](https://dashboard.cohere.com/playground/generate).
When a preset is specified, the `prompt` parameter becomes optional, and any included parameters will override the preset's parameters.
    
</dd>
</dl>

<dl>
<dd>

**endSequences:** `Optional<List<String>>` — The generated text will be cut at the beginning of the earliest occurrence of an end sequence. The sequence will be excluded from the text.
    
</dd>
</dl>

<dl>
<dd>

**stopSequences:** `Optional<List<String>>` — The generated text will be cut at the end of the earliest occurrence of a stop sequence. The sequence will be included the text.
    
</dd>
</dl>

<dl>
<dd>

**k:** `Optional<Integer>` 

Ensures only the top `k` most likely tokens are considered for generation at each step.
Defaults to `0`, min value of `0`, max value of `500`.
    
</dd>
</dl>

<dl>
<dd>

**p:** `Optional<Float>` 

Ensures that only the most likely tokens, with total probability mass of `p`, are considered for generation at each step. If both `k` and `p` are enabled, `p` acts after `k`.
Defaults to `0.75`. min value of `0.01`, max value of `0.99`.
    
</dd>
</dl>

<dl>
<dd>

**frequencyPenalty:** `Optional<Float>` 

Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.

Using `frequency_penalty` in combination with `presence_penalty` is not supported on newer models.
    
</dd>
</dl>

<dl>
<dd>

**presencePenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.

Can be used to reduce repetitiveness of generated tokens. Similar to `frequency_penalty`, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.

Using `frequency_penalty` in combination with `presence_penalty` is not supported on newer models.
    
</dd>
</dl>

<dl>
<dd>

**returnLikelihoods:** `Optional<GenerateRequestReturnLikelihoods>` 

One of `GENERATION|NONE` to specify how and if the token likelihoods are returned with the response. Defaults to `NONE`.

If `GENERATION` is selected, the token likelihoods will only be provided for generated text.

WARNING: `ALL` is deprecated, and will be removed in a future release.
    
</dd>
</dl>

<dl>
<dd>

**rawPrompting:** `Optional<Boolean>` — When enabled, the user's prompt will be sent to the model without any pre-processing.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.embed(request) -> EmbedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint returns text and image embeddings. An embedding is a list of floating point numbers that captures semantic information about the content that it represents.

Embeddings can be used to create classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.

If you want to learn more how to use the embedding model, have a look at the [Semantic Search Guide](https://docs.cohere.com/docs/semantic-search).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.embed(
    EmbedRequest
        .builder()
        .texts(
            new ArrayList<String>(
                Arrays.asList("hello", "goodbye")
            )
        )
        .model("embed-v4.0")
        .inputType(EmbedInputType.CLASSIFICATION)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**texts:** `Optional<List<String>>` — An array of strings for the model to embed. Maximum number of texts per call is `96`.
    
</dd>
</dl>

<dl>
<dd>

**images:** `Optional<List<String>>` 

An array of image data URIs for the model to embed. Maximum number of images per call is `1`.

The image must be a valid [data URI](https://developer.mozilla.org/en-US/docs/Web/URI/Schemes/data). The image must be in either `image/jpeg` or `image/png` format and has a maximum size of 5MB.

Images are only supported with Embed v3.0 and newer models.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` — ID of one of the available [Embedding models](https://docs.cohere.com/docs/cohere-embed).
    
</dd>
</dl>

<dl>
<dd>

**inputType:** `Optional<EmbedInputType>` 
    
</dd>
</dl>

<dl>
<dd>

**embeddingTypes:** `Optional<List<EmbeddingType>>` 

Specifies the types of embeddings you want to get back. Not required and default is None, which returns the Embed Floats response type. Can be one or more of the following types.

* `"float"`: Use this when you want to get back the default float embeddings. Supported with all Embed models.
* `"int8"`: Use this when you want to get back signed int8 embeddings. Supported with Embed v3.0 and newer Embed models.
* `"uint8"`: Use this when you want to get back unsigned int8 embeddings. Supported with Embed v3.0 and newer Embed models.
* `"binary"`: Use this when you want to get back signed binary embeddings. Supported with Embed v3.0 and newer Embed models.
* `"ubinary"`: Use this when you want to get back unsigned binary embeddings. Supported with Embed v3.0 and newer Embed models.
    
</dd>
</dl>

<dl>
<dd>

**truncate:** `Optional<EmbedRequestTruncate>` 

One of `NONE|START|END` to specify how the API will handle inputs longer than the maximum token length.

Passing `START` will discard the start of the input. `END` will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.

If `NONE` is selected, when the input exceeds the maximum input token length an error will be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.rerank(request) -> RerankResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.rerank(
    RerankRequest
        .builder()
        .documents(
            new ArrayList<RerankRequestDocumentsItem>(
                Arrays.asList(
                    RerankRequestDocumentsItem.of(),
                    RerankRequestDocumentsItem.of(),
                    RerankRequestDocumentsItem.of(),
                    RerankRequestDocumentsItem.of(),
                    RerankRequestDocumentsItem.of()
                )
            )
        )
        .query("What is the capital of the United States?")
        .topN(3)
        .model("rerank-v3.5")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**model:** `Optional<String>` — The identifier of the model to use, eg `rerank-v3.5`.
    
</dd>
</dl>

<dl>
<dd>

**query:** `String` — The search query
    
</dd>
</dl>

<dl>
<dd>

**documents:** `List<RerankRequestDocumentsItem>` 

A list of document objects or strings to rerank.
If a document is provided the text fields is required and all other fields will be preserved in the response.

The total max chunks (length of documents * max_chunks_per_doc) must be less than 10000.

We recommend a maximum of 1,000 documents for optimal endpoint performance.
    
</dd>
</dl>

<dl>
<dd>

**topN:** `Optional<Integer>` — The number of most relevant documents or indices to return, defaults to the length of the documents
    
</dd>
</dl>

<dl>
<dd>

**rankFields:** `Optional<List<String>>` — If a JSON object is provided, you can specify which keys you would like to have considered for reranking. The model will rerank based on order of the fields passed in (i.e. rank_fields=['title','author','text'] will rerank using the values in title, author, text  sequentially. If the length of title, author, and text exceeds the context length of the model, the chunking will not re-consider earlier fields). If not provided, the model will use the default text field for ranking.
    
</dd>
</dl>

<dl>
<dd>

**returnDocuments:** `Optional<Boolean>` 

- If false, returns results without the doc text - the api will return a list of {index, relevance score} where index is inferred from the list passed into the request.
- If true, returns results with the doc text passed in - the api will return an ordered list of {index, text, relevance score} where index + text refers to the list passed into the request.
    
</dd>
</dl>

<dl>
<dd>

**maxChunksPerDoc:** `Optional<Integer>` — The maximum number of chunks to produce internally from a document
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.classify(request) -> ClassifyResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint makes a prediction about which label fits the specified text inputs best. To make a prediction, Classify uses the provided `examples` of text + label pairs as a reference.
Note: [Fine-tuned models](https://docs.cohere.com/docs/classify-fine-tuning) trained on classification examples don't require the `examples` parameter to be passed in explicitly.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.classify(
            ClassifyRequest
                .builder()
                .inputs(
                    new ArrayList<String>(
                        Arrays.asList("Confirm your email address", "hey i need u to send some $")
                    )
                )
                .examples(
                    new ArrayList<ClassifyExample>(
                        Arrays.asList(
                            ClassifyExample
                                .builder()
                                .text("Dermatologists don't like her!")
                                .label("Spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("'Hello, open to this?'")
                                .label("Spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("I need help please wire me $1000 right now")
                                .label("Spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("Nice to know you ;)")
                                .label("Spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("Please help me?")
                                .label("Spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("Your parcel will be delivered today")
                                .label("Not spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("Review changes to our Terms and Conditions")
                                .label("Not spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("Weekly sync notes")
                                .label("Not spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("'Re: Follow up from today's meeting'")
                                .label("Not spam")
                                .build(),
                            ClassifyExample
                                .builder()
                                .text("Pre-read for tomorrow")
                                .label("Not spam")
                                .build()
                        )
                    )
                )
                .model("YOUR-FINE-TUNED-MODEL-ID")
                .build()
        );
    }
}
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**inputs:** `List<String>` 

A list of up to 96 texts to be classified. Each one must be a non-empty string.
There is, however, no consistent, universal limit to the length a particular input can be. We perform classification on the first `x` tokens of each input, and `x` varies depending on which underlying model is powering classification. The maximum token length for each model is listed in the "max tokens" column [here](https://docs.cohere.com/docs/models).
Note: by default the `truncate` parameter is set to `END`, so tokens exceeding the limit will be automatically dropped. This behavior can be disabled by setting `truncate` to `NONE`, which will result in validation errors for longer texts.
    
</dd>
</dl>

<dl>
<dd>

**examples:** `Optional<List<ClassifyExample>>` 

An array of examples to provide context to the model. Each example is a text string and its associated label/class. Each unique label requires at least 2 examples associated with it; the maximum number of examples is 2500, and each example has a maximum length of 512 tokens. The values should be structured as `{text: "...",label: "..."}`.
Note: [Fine-tuned Models](https://docs.cohere.com/docs/classify-fine-tuning) trained on classification examples don't require the `examples` parameter to be passed in explicitly.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` — ID of a [Fine-tuned](https://docs.cohere.com/v2/docs/classify-starting-the-training) Classify model
    
</dd>
</dl>

<dl>
<dd>

**preset:** `Optional<String>` — The ID of a custom playground preset. You can create presets in the [playground](https://dashboard.cohere.com/playground). If you use a preset, all other parameters become optional, and any included parameters will override the preset's parameters.
    
</dd>
</dl>

<dl>
<dd>

**truncate:** `Optional<ClassifyRequestTruncate>` 

One of `NONE|START|END` to specify how the API will handle inputs longer than the maximum token length.
Passing `START` will discard the start of the input. `END` will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.
If `NONE` is selected, when the input exceeds the maximum input token length an error will be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.summarize(request) -> SummarizeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

<Warning>
This API is marked as "Legacy" and is no longer maintained. Follow the [migration guide](https://docs.cohere.com/docs/migrating-from-cogenerate-to-cochat) to start using the Chat API.
</Warning>
Generates a summary in English for a given text.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.summarize(
    SummarizeRequest
        .builder()
        .text("Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It may be made from milk or cream and is flavoured with a sweetener, either sugar or an alternative, and a spice, such as cocoa or vanilla, or with fruit such as strawberries or peaches. It can also be made by whisking a flavored cream base and liquid nitrogen together. Food coloring is sometimes added, in addition to stabilizers. The mixture is cooled below the freezing point of water and stirred to incorporate air spaces and to prevent detectable ice crystals from forming. The result is a smooth, semi-solid foam that is solid at very low temperatures (below 2 °C or 35 °F). It becomes more malleable as its temperature increases.\n\nThe meaning of the name \"ice cream\" varies from one country to another. In some countries, such as the United States, \"ice cream\" applies only to a specific variety, and most governments regulate the commercial use of the various terms according to the relative quantities of the main ingredients, notably the amount of cream. Products that do not meet the criteria to be called ice cream are sometimes labelled \"frozen dairy dessert\" instead. In other countries, such as Italy and Argentina, one word is used fo\r all variants. Analogues made from dairy alternatives, such as goat's or sheep's milk, or milk substitutes (e.g., soy, cashew, coconut, almond milk or tofu), are available for those who are lactose intolerant, allergic to dairy protein or vegan.")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**text:** `String` — The text to generate a summary for. Can be up to 100,000 characters long. Currently the only supported language is English.
    
</dd>
</dl>

<dl>
<dd>

**length:** `Optional<SummarizeRequestLength>` — One of `short`, `medium`, `long`, or `auto` defaults to `auto`. Indicates the approximate length of the summary. If `auto` is selected, the best option will be picked based on the input text.
    
</dd>
</dl>

<dl>
<dd>

**format:** `Optional<SummarizeRequestFormat>` — One of `paragraph`, `bullets`, or `auto`, defaults to `auto`. Indicates the style in which the summary will be delivered - in a free form paragraph or in bullet points. If `auto` is selected, the best option will be picked based on the input text.
    
</dd>
</dl>

<dl>
<dd>

**model:** `Optional<String>` — The identifier of the model to generate the summary with. Currently available models are `command` (default), `command-nightly` (experimental), `command-light`, and `command-light-nightly` (experimental). Smaller, "light" models are faster, while larger models will perform better.
    
</dd>
</dl>

<dl>
<dd>

**extractiveness:** `Optional<SummarizeRequestExtractiveness>` — One of `low`, `medium`, `high`, or `auto`, defaults to `auto`. Controls how close to the original text the summary is. `high` extractiveness summaries will lean towards reusing sentences verbatim, while `low` extractiveness summaries will tend to paraphrase more. If `auto` is selected, the best option will be picked based on the input text.
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` — Ranges from 0 to 5. Controls the randomness of the output. Lower values tend to generate more “predictable” output, while higher values tend to generate more “creative” output. The sweet spot is typically between 0 and 1.
    
</dd>
</dl>

<dl>
<dd>

**additionalCommand:** `Optional<String>` — A free-form instruction for modifying how the summaries get generated. Should complete the sentence "Generate a summary _". Eg. "focusing on the next steps" or "written by Yoda"
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tokenize(request) -> TokenizeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint splits input text into smaller units called tokens using byte-pair encoding (BPE). To learn more about tokenization and byte pair encoding, see the tokens page.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.tokenize(
    TokenizeRequest
        .builder()
        .text("tokenize me! :D")
        .model("command")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**text:** `String` — The string to be tokenized, the minimum text length is 1 character, and the maximum text length is 65536 characters.
    
</dd>
</dl>

<dl>
<dd>

**model:** `String` — The input will be tokenized by the tokenizer that is used by this model.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.detokenize(request) -> DetokenizeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint takes tokens using byte-pair encoding and returns their text representation. To learn more about tokenization and byte pair encoding, see the tokens page.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.detokenize(
    DetokenizeRequest
        .builder()
        .tokens(
            new ArrayList<Integer>(
                Arrays.asList(10002, 2261, 2012, 8, 2792, 43)
            )
        )
        .model("command")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**tokens:** `List<Integer>` — The list of tokens to be detokenized.
    
</dd>
</dl>

<dl>
<dd>

**model:** `String` — An optional parameter to provide the model name. This will ensure that the detokenization is done by the tokenizer used by that model.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.checkApiKey() -> CheckApiKeyResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Checks that the api key in the Authorization header is valid and active
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.checkApiKey();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## V2
<details><summary><code>client.v2.chatStream(request) -> Optional&lt;V2ChatStreamResponse&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Generates a text response to a user message. To learn how to use the Chat API and RAG follow our [Text Generation guides](https://docs.cohere.com/v2/docs/chat-api).

Follow the [Migration Guide](https://docs.cohere.com/v2/docs/migrating-v1-to-v2) for instructions on moving from API v1 to API v2.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v2().chatStream(
    V2ChatStreamRequest
        .builder()
        .model("command-r")
        .messages(
            new ArrayList<ChatMessageV2>(
                Arrays.asList(
                    ChatMessageV2.user(
                        UserMessageV2
                            .builder()
                            .content(
                                UserMessageV2Content.of("Hello!")
                            )
                            .build()
                    )
                )
            )
        )
        .stream(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stream:** `Boolean` 

Defaults to `false`.

When `true`, the response will be a SSE stream of events.

Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.
    
</dd>
</dl>

<dl>
<dd>

**model:** `String` — The name of a compatible [Cohere model](https://docs.cohere.com/v2/docs/models) or the ID of a [fine-tuned](https://docs.cohere.com/v2/docs/chat-fine-tuning) model.
    
</dd>
</dl>

<dl>
<dd>

**messages:** `List<ChatMessageV2>` 
    
</dd>
</dl>

<dl>
<dd>

**tools:** `Optional<List<ToolV2>>` 

A list of tools (functions) available to the model. The model response may contain 'tool_calls' to the specified tools.

Learn more in the [Tool Use guide](https://docs.cohere.com/docs/tools).
    
</dd>
</dl>

<dl>
<dd>

**strictTools:** `Optional<Boolean>` 

When set to `true`, tool calls in the Assistant message will be forced to follow the tool definition strictly. Learn more in the [Structured Outputs (Tools) guide](https://docs.cohere.com/docs/structured-outputs-json#structured-outputs-tools).

**Note**: The first few requests with a new set of tools will take longer to process.
    
</dd>
</dl>

<dl>
<dd>

**documents:** `Optional<List<V2ChatStreamRequestDocumentsItem>>` — A list of relevant documents that the model can cite to generate a more accurate reply. Each document is either a string or document object with content and metadata.
    
</dd>
</dl>

<dl>
<dd>

**citationOptions:** `Optional<CitationOptions>` 
    
</dd>
</dl>

<dl>
<dd>

**responseFormat:** `Optional<ResponseFormatV2>` 
    
</dd>
</dl>

<dl>
<dd>

**safetyMode:** `Optional<V2ChatStreamRequestSafetyMode>` 

Used to select the [safety instruction](https://docs.cohere.com/v2/docs/safety-modes) inserted into the prompt. Defaults to `CONTEXTUAL`.
When `OFF` is specified, the safety instruction will be omitted.

Safety modes are not yet configurable in combination with `tools` and `documents` parameters.

**Note**: This parameter is only compatible newer Cohere models, starting with [Command R 08-2024](https://docs.cohere.com/docs/command-r#august-2024-release) and [Command R+ 08-2024](https://docs.cohere.com/docs/command-r-plus#august-2024-release).

**Note**: `command-r7b-12-2024` and newer models only support `"CONTEXTUAL"` and `"STRICT"` modes.
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` 

The maximum number of tokens the model will generate as part of the response.

**Note**: Setting a low value may result in incomplete generations.
    
</dd>
</dl>

<dl>
<dd>

**stopSequences:** `Optional<List<String>>` — A list of up to 5 strings that the model will use to stop generation. If the model generates a string that matches any of the strings in the list, it will stop generating tokens and return the generated text up to that point not including the stop sequence.
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` 

Defaults to `0.3`.

A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.

Randomness can be further maximized by increasing the  value of the `p` parameter.
    
</dd>
</dl>

<dl>
<dd>

**seed:** `Optional<Integer>` 

If specified, the backend will make a best effort to sample tokens
deterministically, such that repeated requests with the same
seed and parameters should return the same result. However,
determinism cannot be totally guaranteed.
    
</dd>
</dl>

<dl>
<dd>

**frequencyPenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.
Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.
    
</dd>
</dl>

<dl>
<dd>

**presencePenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.
Used to reduce repetitiveness of generated tokens. Similar to `frequency_penalty`, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.
    
</dd>
</dl>

<dl>
<dd>

**k:** `Optional<Integer>` 

Ensures that only the top `k` most likely tokens are considered for generation at each step. When `k` is set to `0`, k-sampling is disabled.
Defaults to `0`, min value of `0`, max value of `500`.
    
</dd>
</dl>

<dl>
<dd>

**p:** `Optional<Float>` 

Ensures that only the most likely tokens, with total probability mass of `p`, are considered for generation at each step. If both `k` and `p` are enabled, `p` acts after `k`.
Defaults to `0.75`. min value of `0.01`, max value of `0.99`.
    
</dd>
</dl>

<dl>
<dd>

**logprobs:** `Optional<Boolean>` — Defaults to `false`. When set to `true`, the log probabilities of the generated tokens will be included in the response.
    
</dd>
</dl>

<dl>
<dd>

**toolChoice:** `Optional<V2ChatStreamRequestToolChoice>` 

Used to control whether or not the model will be forced to use a tool when answering. When `REQUIRED` is specified, the model will be forced to use at least one of the user-defined tools, and the `tools` parameter must be passed in the request.
When `NONE` is specified, the model will be forced **not** to use one of the specified tools, and give a direct response.
If tool_choice isn't specified, then the model is free to choose whether to use the specified tools or not.

**Note**: This parameter is only compatible with models [Command-r7b](https://docs.cohere.com/v2/docs/command-r7b) and newer.

**Note**: The same functionality can be achieved in `/v1/chat` using the `force_single_step` parameter. If `force_single_step=true`, this is equivalent to specifying `REQUIRED`. While if `force_single_step=true` and `tool_results` are passed, this is equivalent to specifying `NONE`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.v2.chat(request) -> V2ChatResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Generates a text response to a user message and streams it down, token by token. To learn how to use the Chat API with streaming follow our [Text Generation guides](https://docs.cohere.com/v2/docs/chat-api).

Follow the [Migration Guide](https://docs.cohere.com/v2/docs/migrating-v1-to-v2) for instructions on moving from API v1 to API v2.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v2().chatStream(
    V2ChatStreamRequest
        .builder()
        .model("command-a-03-2025")
        .messages(
            new ArrayList<ChatMessageV2>(
                Arrays.asList(
                    ChatMessageV2.user(
                        UserMessageV2
                            .builder()
                            .content(
                                UserMessageV2Content.of("Tell me about LLMs")
                            )
                            .build()
                    )
                )
            )
        )
        .stream(false)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stream:** `Boolean` 

Defaults to `false`.

When `true`, the response will be a SSE stream of events.

Streaming is beneficial for user interfaces that render the contents of the response piece by piece, as it gets generated.
    
</dd>
</dl>

<dl>
<dd>

**model:** `String` — The name of a compatible [Cohere model](https://docs.cohere.com/v2/docs/models) or the ID of a [fine-tuned](https://docs.cohere.com/v2/docs/chat-fine-tuning) model.
    
</dd>
</dl>

<dl>
<dd>

**messages:** `List<ChatMessageV2>` 
    
</dd>
</dl>

<dl>
<dd>

**tools:** `Optional<List<ToolV2>>` 

A list of tools (functions) available to the model. The model response may contain 'tool_calls' to the specified tools.

Learn more in the [Tool Use guide](https://docs.cohere.com/docs/tools).
    
</dd>
</dl>

<dl>
<dd>

**strictTools:** `Optional<Boolean>` 

When set to `true`, tool calls in the Assistant message will be forced to follow the tool definition strictly. Learn more in the [Structured Outputs (Tools) guide](https://docs.cohere.com/docs/structured-outputs-json#structured-outputs-tools).

**Note**: The first few requests with a new set of tools will take longer to process.
    
</dd>
</dl>

<dl>
<dd>

**documents:** `Optional<List<V2ChatRequestDocumentsItem>>` — A list of relevant documents that the model can cite to generate a more accurate reply. Each document is either a string or document object with content and metadata.
    
</dd>
</dl>

<dl>
<dd>

**citationOptions:** `Optional<CitationOptions>` 
    
</dd>
</dl>

<dl>
<dd>

**responseFormat:** `Optional<ResponseFormatV2>` 
    
</dd>
</dl>

<dl>
<dd>

**safetyMode:** `Optional<V2ChatRequestSafetyMode>` 

Used to select the [safety instruction](https://docs.cohere.com/v2/docs/safety-modes) inserted into the prompt. Defaults to `CONTEXTUAL`.
When `OFF` is specified, the safety instruction will be omitted.

Safety modes are not yet configurable in combination with `tools` and `documents` parameters.

**Note**: This parameter is only compatible newer Cohere models, starting with [Command R 08-2024](https://docs.cohere.com/docs/command-r#august-2024-release) and [Command R+ 08-2024](https://docs.cohere.com/docs/command-r-plus#august-2024-release).

**Note**: `command-r7b-12-2024` and newer models only support `"CONTEXTUAL"` and `"STRICT"` modes.
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` 

The maximum number of tokens the model will generate as part of the response.

**Note**: Setting a low value may result in incomplete generations.
    
</dd>
</dl>

<dl>
<dd>

**stopSequences:** `Optional<List<String>>` — A list of up to 5 strings that the model will use to stop generation. If the model generates a string that matches any of the strings in the list, it will stop generating tokens and return the generated text up to that point not including the stop sequence.
    
</dd>
</dl>

<dl>
<dd>

**temperature:** `Optional<Float>` 

Defaults to `0.3`.

A non-negative float that tunes the degree of randomness in generation. Lower temperatures mean less random generations, and higher temperatures mean more random generations.

Randomness can be further maximized by increasing the  value of the `p` parameter.
    
</dd>
</dl>

<dl>
<dd>

**seed:** `Optional<Integer>` 

If specified, the backend will make a best effort to sample tokens
deterministically, such that repeated requests with the same
seed and parameters should return the same result. However,
determinism cannot be totally guaranteed.
    
</dd>
</dl>

<dl>
<dd>

**frequencyPenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.
Used to reduce repetitiveness of generated tokens. The higher the value, the stronger a penalty is applied to previously present tokens, proportional to how many times they have already appeared in the prompt or prior generation.
    
</dd>
</dl>

<dl>
<dd>

**presencePenalty:** `Optional<Float>` 

Defaults to `0.0`, min value of `0.0`, max value of `1.0`.
Used to reduce repetitiveness of generated tokens. Similar to `frequency_penalty`, except that this penalty is applied equally to all tokens that have already appeared, regardless of their exact frequencies.
    
</dd>
</dl>

<dl>
<dd>

**k:** `Optional<Integer>` 

Ensures that only the top `k` most likely tokens are considered for generation at each step. When `k` is set to `0`, k-sampling is disabled.
Defaults to `0`, min value of `0`, max value of `500`.
    
</dd>
</dl>

<dl>
<dd>

**p:** `Optional<Float>` 

Ensures that only the most likely tokens, with total probability mass of `p`, are considered for generation at each step. If both `k` and `p` are enabled, `p` acts after `k`.
Defaults to `0.75`. min value of `0.01`, max value of `0.99`.
    
</dd>
</dl>

<dl>
<dd>

**logprobs:** `Optional<Boolean>` — Defaults to `false`. When set to `true`, the log probabilities of the generated tokens will be included in the response.
    
</dd>
</dl>

<dl>
<dd>

**toolChoice:** `Optional<V2ChatRequestToolChoice>` 

Used to control whether or not the model will be forced to use a tool when answering. When `REQUIRED` is specified, the model will be forced to use at least one of the user-defined tools, and the `tools` parameter must be passed in the request.
When `NONE` is specified, the model will be forced **not** to use one of the specified tools, and give a direct response.
If tool_choice isn't specified, then the model is free to choose whether to use the specified tools or not.

**Note**: This parameter is only compatible with models [Command-r7b](https://docs.cohere.com/v2/docs/command-r7b) and newer.

**Note**: The same functionality can be achieved in `/v1/chat` using the `force_single_step` parameter. If `force_single_step=true`, this is equivalent to specifying `REQUIRED`. While if `force_single_step=true` and `tool_results` are passed, this is equivalent to specifying `NONE`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.v2.embed(request) -> EmbedByTypeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.

Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.

If you want to learn more how to use the embedding model, have a look at the [Semantic Search Guide](https://docs.cohere.com/docs/semantic-search).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v2().embed(
    V2EmbedRequest
        .builder()
        .model("embed-v4.0")
        .inputType(EmbedInputType.CLASSIFICATION)
        .texts(
            new ArrayList<String>(
                Arrays.asList("hello", "goodbye")
            )
        )
        .embeddingTypes(
            new ArrayList<EmbeddingType>(
                Arrays.asList(EmbeddingType.FLOAT)
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**texts:** `Optional<List<String>>` — An array of strings for the model to embed. Maximum number of texts per call is `96`.
    
</dd>
</dl>

<dl>
<dd>

**images:** `Optional<List<String>>` 

An array of image data URIs for the model to embed. Maximum number of images per call is `1`.

The image must be a valid [data URI](https://developer.mozilla.org/en-US/docs/Web/URI/Schemes/data). The image must be in either `image/jpeg` or `image/png` format and has a maximum size of 5MB.

Image embeddings are supported with Embed v3.0 and newer models.
    
</dd>
</dl>

<dl>
<dd>

**model:** `String` — ID of one of the available [Embedding models](https://docs.cohere.com/docs/cohere-embed).
    
</dd>
</dl>

<dl>
<dd>

**inputType:** `EmbedInputType` 
    
</dd>
</dl>

<dl>
<dd>

**inputs:** `Optional<List<EmbedInput>>` — An array of inputs for the model to embed. Maximum number of inputs per call is `96`. An input can contain a mix of text and image components.
    
</dd>
</dl>

<dl>
<dd>

**maxTokens:** `Optional<Integer>` — The maximum number of tokens to embed per input. If the input text is longer than this, it will be truncated according to the `truncate` parameter.
    
</dd>
</dl>

<dl>
<dd>

**outputDimension:** `Optional<Integer>` 

The number of dimensions of the output embedding. This is only available for `embed-v4` and newer models.
Possible values are `256`, `512`, `1024`, and `1536`. The default is `1536`.
    
</dd>
</dl>

<dl>
<dd>

**embeddingTypes:** `Optional<List<EmbeddingType>>` 

Specifies the types of embeddings you want to get back. Can be one or more of the following types.

* `"float"`: Use this when you want to get back the default float embeddings. Supported with all Embed models.
* `"int8"`: Use this when you want to get back signed int8 embeddings. Supported with Embed v3.0 and newer Embed models.
* `"uint8"`: Use this when you want to get back unsigned int8 embeddings. Supported with Embed v3.0 and newer Embed models.
* `"binary"`: Use this when you want to get back signed binary embeddings. Supported with Embed v3.0 and newer Embed models.
* `"ubinary"`: Use this when you want to get back unsigned binary embeddings. Supported with Embed v3.0 and newer Embed models.
    
</dd>
</dl>

<dl>
<dd>

**truncate:** `Optional<V2EmbedRequestTruncate>` 

One of `NONE|START|END` to specify how the API will handle inputs longer than the maximum token length.

Passing `START` will discard the start of the input. `END` will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.

If `NONE` is selected, when the input exceeds the maximum input token length an error will be returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.v2.rerank(request) -> V2RerankResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v2().rerank(
    V2RerankRequest
        .builder()
        .documents(
            new ArrayList<String>(
                Arrays.asList("Carson City is the capital city of the American state of Nevada.", "The Commonwealth of the Northern Mariana Islands is a group of islands in the Pacific Ocean. Its capital is Saipan.", "Capitalization or capitalisation in English grammar is the use of a capital letter at the start of a word. English usage varies from capitalization in other languages.", "Washington, D.C. (also known as simply Washington or D.C., and officially as the District of Columbia) is the capital of the United States. It is a federal district.", "Capital punishment has existed in the United States since beforethe United States was a country. As of 2017, capital punishment is legal in 30 of the 50 states.")
            )
        )
        .query("What is the capital of the United States?")
        .model("rerank-v3.5")
        .topN(3)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**model:** `String` — The identifier of the model to use, eg `rerank-v3.5`.
    
</dd>
</dl>

<dl>
<dd>

**query:** `String` — The search query
    
</dd>
</dl>

<dl>
<dd>

**documents:** `List<String>` 

A list of texts that will be compared to the `query`.
For optimal performance we recommend against sending more than 1,000 documents in a single request.

**Note**: long documents will automatically be truncated to the value of `max_tokens_per_doc`.

**Note**: structured data should be formatted as YAML strings for best performance.
    
</dd>
</dl>

<dl>
<dd>

**topN:** `Optional<Integer>` — Limits the number of returned rerank results to the specified value. If not passed, all the rerank results will be returned.
    
</dd>
</dl>

<dl>
<dd>

**maxTokensPerDoc:** `Optional<Integer>` — Defaults to `4096`. Long documents will be automatically truncated to the specified number of tokens.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## EmbedJobs
<details><summary><code>client.embedJobs.list() -> ListEmbedJobResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

The list embed job endpoint allows users to view all embed jobs history for that specific user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.embedJobs().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.embedJobs.create(request) -> CreateEmbedJobResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This API launches an async Embed job for a [Dataset](https://docs.cohere.com/docs/datasets) of type `embed-input`. The result of a completed embed job is new Dataset of type `embed-output`, which contains the original text entries and the corresponding embeddings.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.embedJobs().create(
    CreateEmbedJobRequest
        .builder()
        .model("model")
        .datasetId("dataset_id")
        .inputType(EmbedInputType.SEARCH_DOCUMENT)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**model:** `String` 

ID of the embedding model.

Available models and corresponding embedding dimensions:

- `embed-english-v3.0` : 1024
- `embed-multilingual-v3.0` : 1024
- `embed-english-light-v3.0` : 384
- `embed-multilingual-light-v3.0` : 384
    
</dd>
</dl>

<dl>
<dd>

**datasetId:** `String` — ID of a [Dataset](https://docs.cohere.com/docs/datasets). The Dataset must be of type `embed-input` and must have a validation status `Validated`
    
</dd>
</dl>

<dl>
<dd>

**inputType:** `EmbedInputType` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The name of the embed job.
    
</dd>
</dl>

<dl>
<dd>

**embeddingTypes:** `Optional<List<EmbeddingType>>` 

Specifies the types of embeddings you want to get back. Not required and default is None, which returns the Embed Floats response type. Can be one or more of the following types.

* `"float"`: Use this when you want to get back the default float embeddings. Valid for all models.
* `"int8"`: Use this when you want to get back signed int8 embeddings. Valid for v3 and newer model versions.
* `"uint8"`: Use this when you want to get back unsigned int8 embeddings. Valid for v3 and newer model versions.
* `"binary"`: Use this when you want to get back signed binary embeddings. Valid for v3 and newer model versions.
* `"ubinary"`: Use this when you want to get back unsigned binary embeddings. Valid for v3 and newer model versions.
    
</dd>
</dl>

<dl>
<dd>

**truncate:** `Optional<CreateEmbedJobRequestTruncate>` 

One of `START|END` to specify how the API will handle inputs longer than the maximum token length.

Passing `START` will discard the start of the input. `END` will discard the end of the input. In both cases, input is discarded until the remaining input is exactly the maximum input token length for the model.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.embedJobs.get(id) -> EmbedJob</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This API retrieves the details about an embed job started by the same user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.embedJobs().get("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the embed job to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.embedJobs.cancel(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This API allows users to cancel an active embed job. Once invoked, the embedding process will be terminated, and users will be charged for the embeddings processed up to the cancellation point. It's important to note that partial results will not be available to users after cancellation.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.embedJobs().cancel("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the embed job to cancel.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Datasets
<details><summary><code>client.datasets.list() -> DatasetsListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List datasets that have been created.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.datasets().list(
    DatasetsListRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**datasetType:** `Optional<String>` — optional filter by dataset type
    
</dd>
</dl>

<dl>
<dd>

**before:** `Optional<OffsetDateTime>` — optional filter before a date
    
</dd>
</dl>

<dl>
<dd>

**after:** `Optional<OffsetDateTime>` — optional filter after a date
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Float>` — optional limit to number of results
    
</dd>
</dl>

<dl>
<dd>

**offset:** `Optional<Float>` — optional offset to start of results
    
</dd>
</dl>

<dl>
<dd>

**validationStatus:** `Optional<DatasetValidationStatus>` — optional filter by validation status
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.datasets.create(request) -> DatasetsCreateResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a dataset by uploading a file. See ['Dataset Creation'](https://docs.cohere.com/docs/datasets#dataset-creation) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.datasets().create(
    DatasetsCreateRequest
        .builder()
        .name("name")
        .type(DatasetType.EMBED_INPUT)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` — The name of the uploaded dataset.
    
</dd>
</dl>

<dl>
<dd>

**type:** `DatasetType` — The dataset type, which is used to validate the data. Valid types are `embed-input`, `reranker-finetune-input`, `single-label-classification-finetune-input`, `chat-finetune-input`, and `multi-label-classification-finetune-input`.
    
</dd>
</dl>

<dl>
<dd>

**keepOriginalFile:** `Optional<Boolean>` — Indicates if the original file should be stored.
    
</dd>
</dl>

<dl>
<dd>

**skipMalformedInput:** `Optional<Boolean>` — Indicates whether rows with malformed input should be dropped (instead of failing the validation check). Dropped rows will be returned in the warnings field.
    
</dd>
</dl>

<dl>
<dd>

**keepFields:** `Optional<String>` — List of names of fields that will be persisted in the Dataset. By default the Dataset will retain only the required fields indicated in the [schema for the corresponding Dataset type](https://docs.cohere.com/docs/datasets#dataset-types). For example, datasets of type `embed-input` will drop all fields other than the required `text` field. If any of the fields in `keep_fields` are missing from the uploaded file, Dataset validation will fail.
    
</dd>
</dl>

<dl>
<dd>

**optionalFields:** `Optional<String>` — List of names of fields that will be persisted in the Dataset. By default the Dataset will retain only the required fields indicated in the [schema for the corresponding Dataset type](https://docs.cohere.com/docs/datasets#dataset-types). For example, Datasets of type `embed-input` will drop all fields other than the required `text` field. If any of the fields in `optional_fields` are missing from the uploaded file, Dataset validation will pass.
    
</dd>
</dl>

<dl>
<dd>

**textSeparator:** `Optional<String>` — Raw .txt uploads will be split into entries using the text_separator value.
    
</dd>
</dl>

<dl>
<dd>

**csvDelimiter:** `Optional<String>` — The delimiter used for .csv uploads.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.datasets.getUsage() -> DatasetsGetUsageResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

View the dataset storage usage for your Organization. Each Organization can have up to 10GB of storage across all their users.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.datasets().getUsage();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.datasets.get(id) -> DatasetsGetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a dataset by ID. See ['Datasets'](https://docs.cohere.com/docs/datasets) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.datasets().get("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.datasets.delete(id) -> Map&lt;String, Object&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a dataset by ID. Datasets are automatically deleted after 30 days, but they can also be deleted manually.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.datasets().delete("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Connectors
<details><summary><code>client.connectors.list() -> ListConnectorsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of connectors ordered by descending creation date (newer first). See ['Managing your Connector'](https://docs.cohere.com/docs/managing-your-connector) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connectors().list(
    ConnectorsListRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Float>` — Maximum number of connectors to return [0, 100].
    
</dd>
</dl>

<dl>
<dd>

**offset:** `Optional<Float>` — Number of connectors to skip before returning results [0, inf].
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connectors.create(request) -> CreateConnectorResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new connector. The connector is tested during registration and will cancel registration when the test is unsuccessful. See ['Creating and Deploying a Connector'](https://docs.cohere.com/v1/docs/creating-and-deploying-a-connector) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connectors().create(
    CreateConnectorRequest
        .builder()
        .name("name")
        .url("url")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` — A human-readable name for the connector.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — A description of the connector.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the connector that will be used to search for documents.
    
</dd>
</dl>

<dl>
<dd>

**excludes:** `Optional<List<String>>` — A list of fields to exclude from the prompt (fields remain in the document).
    
</dd>
</dl>

<dl>
<dd>

**oauth:** `Optional<CreateConnectorOAuth>` — The OAuth 2.0 configuration for the connector. Cannot be specified if service_auth is specified.
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` — Whether the connector is active or not.
    
</dd>
</dl>

<dl>
<dd>

**continueOnFailure:** `Optional<Boolean>` — Whether a chat request should continue or not if the request to this connector fails.
    
</dd>
</dl>

<dl>
<dd>

**serviceAuth:** `Optional<CreateConnectorServiceAuth>` — The service to service authentication configuration for the connector. Cannot be specified if oauth is specified.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connectors.get(id) -> GetConnectorResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a connector by ID. See ['Connectors'](https://docs.cohere.com/docs/connectors) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connectors().get("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the connector to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connectors.delete(id) -> Map&lt;String, Object&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a connector by ID. See ['Connectors'](https://docs.cohere.com/docs/connectors) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connectors().delete("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the connector to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connectors.update(id, request) -> UpdateConnectorResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a connector by ID. Omitted fields will not be updated. See ['Managing your Connector'](https://docs.cohere.com/docs/managing-your-connector) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connectors().update(
    "id",
    UpdateConnectorRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the connector to update.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — A human-readable name for the connector.
    
</dd>
</dl>

<dl>
<dd>

**url:** `Optional<String>` — The URL of the connector that will be used to search for documents.
    
</dd>
</dl>

<dl>
<dd>

**excludes:** `Optional<List<String>>` — A list of fields to exclude from the prompt (fields remain in the document).
    
</dd>
</dl>

<dl>
<dd>

**oauth:** `Optional<CreateConnectorOAuth>` — The OAuth 2.0 configuration for the connector. Cannot be specified if service_auth is specified.
    
</dd>
</dl>

<dl>
<dd>

**active:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**continueOnFailure:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**serviceAuth:** `Optional<CreateConnectorServiceAuth>` — The service to service authentication configuration for the connector. Cannot be specified if oauth is specified.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.connectors.oAuthAuthorize(id) -> OAuthAuthorizeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Authorize the connector with the given ID for the connector oauth app.  See ['Connector Authentication'](https://docs.cohere.com/docs/connector-authentication) for more information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.connectors().oAuthAuthorize(
    "id",
    ConnectorsOAuthAuthorizeRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the connector to authorize.
    
</dd>
</dl>

<dl>
<dd>

**afterTokenRedirect:** `Optional<String>` — The URL to redirect to after the connector has been authorized.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Models
<details><summary><code>client.models.get(model) -> GetModelResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the details of a model, provided its name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().get("command-a-03-2025");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**model:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.models.list() -> ListModelsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of models available for use. The list contains models from Cohere as well as your fine-tuned models.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.models().list(
    ModelsListRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**pageSize:** `Optional<Float>` 

Maximum number of models to include in a page
Defaults to `20`, min value of `1`, max value of `1000`.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Page token provided in the `next_page_token` field of a previous response.
    
</dd>
</dl>

<dl>
<dd>

**endpoint:** `Optional<CompatibleEndpoint>` — When provided, filters the list of models to only those that are compatible with the specified endpoint.
    
</dd>
</dl>

<dl>
<dd>

**defaultOnly:** `Optional<Boolean>` — When provided, filters the list of models to only the default model to the endpoint. This parameter is only valid when `endpoint` is provided.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## /finetuning
<details><summary><code>client.finetuning.listFinetunedModels() -> ListFinetunedModelsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of fine-tuned models that the user has access to.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().listFinetunedModels(
    FinetuningListFinetunedModelsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 

Maximum number of results to be returned by the server. If 0, defaults to
50.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Request a specific page of the list results.
    
</dd>
</dl>

<dl>
<dd>

**orderBy:** `Optional<String>` 

Comma separated list of fields. For example: "created_at,name". The default
sorting order is ascending. To specify descending order for a field, append
" desc" to the field name. For example: "created_at desc,name".

Supported sorting fields:
  - created_at (default)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.finetuning.createFinetunedModel(request) -> CreateFinetunedModelResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new fine-tuned model. The model will be trained on the dataset specified in the request body. The training process may take some time, and the model will be available once the training is complete.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().createFinetunedModel(
    FinetunedModel
        .builder()
        .name("api-test")
        .settings(
            Settings
                .builder()
                .baseModel(
                    BaseModel
                        .builder()
                        .baseType(BaseType.BASE_TYPE_CHAT)
                        .build()
                )
                .datasetId("my-dataset-id")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `FinetunedModel` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.finetuning.getFinetunedModel(id) -> GetFinetunedModelResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a fine-tuned model by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().getFinetunedModel("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The fine-tuned model ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.finetuning.deleteFinetunedModel(id) -> Map&lt;String, Object&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a fine-tuned model. The model will be removed from the system and will no longer be available for use.
This operation is irreversible.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().deleteFinetunedModel("id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The fine-tuned model ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.finetuning.updateFinetunedModel(id, request) -> UpdateFinetunedModelResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the fine-tuned model with the given ID. The model will be updated with the new settings and name provided in the request body.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().updateFinetunedModel(
    "id",
    FinetuningUpdateFinetunedModelRequest
        .builder()
        .name("name")
        .settings(
            Settings
                .builder()
                .baseModel(
                    BaseModel
                        .builder()
                        .baseType(BaseType.BASE_TYPE_UNSPECIFIED)
                        .build()
                )
                .datasetId("dataset_id")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — FinetunedModel ID.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — FinetunedModel name (e.g. `foobar`).
    
</dd>
</dl>

<dl>
<dd>

**settings:** `Settings` — FinetunedModel settings such as dataset, hyperparameters...
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<Status>` — Current stage in the life-cycle of the fine-tuned model.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.finetuning.listEvents(finetunedModelId) -> ListEventsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of events that occurred during the life-cycle of the fine-tuned model.
The events are ordered by creation time, with the most recent event first.
The list can be paginated using `page_size` and `page_token` parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().listEvents(
    "finetuned_model_id",
    FinetuningListEventsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**finetunedModelId:** `String` — The parent fine-tuned model ID.
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 

Maximum number of results to be returned by the server. If 0, defaults to
50.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Request a specific page of the list results.
    
</dd>
</dl>

<dl>
<dd>

**orderBy:** `Optional<String>` 

Comma separated list of fields. For example: "created_at,name". The default
sorting order is ascending. To specify descending order for a field, append
" desc" to the field name. For example: "created_at desc,name".

Supported sorting fields:
  - created_at (default)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.finetuning.listTrainingStepMetrics(finetunedModelId) -> ListTrainingStepMetricsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of metrics measured during the training of a fine-tuned model.
The metrics are ordered by step number, with the most recent step first.
The list can be paginated using `page_size` and `page_token` parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.finetuning().listTrainingStepMetrics(
    "finetuned_model_id",
    FinetuningListTrainingStepMetricsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**finetunedModelId:** `String` — The parent fine-tuned model ID.
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 

Maximum number of results to be returned by the server. If 0, defaults to
50.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Request a specific page of the list results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>
