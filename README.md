# Cohere Java Library

![](banner.png)

[![Maven Central](https://img.shields.io/maven-central/v/com.cohere.cohere-java/cohere)](https://central.sonatype.com/artifact/com.cohere.cohere-java/cohere)
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

## ✨🪩✨ Announcing Cohere's new Java SDK ✨🪩✨

We are very excited to publish this brand new Java SDK. We now officially support Java and will continuously update this library with all of the latest features in our API. Please create issues where you have feedback so that we can continue to improve the developer experience!
d
## Documentation

API reference documentation is available [here](https://docs.cohere.com/docs).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.cohere.cohere-java:cohere:1.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.cohere.cohere-java</groupId>
    <artifactId>cohere</artifactId>
    <version>1.x.x</version>
</dependency>
```

## Usage
```java
import com.cohere.api.Cohere;

Cohere cohere = Cohere.builder()
  .apiKey("YOUR_API_KEY")
  .build();
  
GenerateResponse response = cohere.generate(GenerateRequest.builder()
      .prompt("Summarize the blog post...")
      .build());

System.out.printlin("Received response!" + response);
```

### Handling Errors
When the API returns a non-success status code (4xx or 5xx response),
a subclass of [ApiError](src/main/java/com/Cohere/api/core/ApiError.java)
will be thrown:

```ts
import com.cohere.api.core.ApiError;

try {
  cohere.generate(/* ... */);
} catch (ApiError error) {
  System.out.println(error.getBody());
  System.out.println(error.getStatusCode());
}
```

## Beta status
This SDK is in beta, and there may be breaking changes between versions 
without a major version update. Therefore, we recommend pinning the package
version to a specific version in your build.gradle file. This way, you can 
install the same version each time without breaking changes unless you are
intentionally looking for the latest version.

## Contributing
While we value open-source contributions to this SDK, this library 
is generated programmatically. Additions made directly to this library 
would have to be moved over to our generation code, otherwise they would 
be overwritten upon the next generated release. Feel free to open a PR as a
proof of concept, but know that we will not be able to merge it as-is. 
We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
