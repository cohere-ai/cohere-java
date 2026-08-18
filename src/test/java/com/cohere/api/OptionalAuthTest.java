package com.cohere.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Map;
import org.junit.jupiter.api.Test;

public final class OptionalAuthTest {
    @Test
    public void omitsAuthorizationHeaderWhenTokenIsEmpty() {
        assertFalse(headers(new HeaderCapturingBuilder().token("")).containsKey("Authorization"));
        assertFalse(headers(new AsyncHeaderCapturingBuilder().token("")).containsKey("Authorization"));
    }

    @Test
    public void sendsAuthorizationHeaderWhenTokenIsProvided() {
        assertEquals(
                "Bearer test-token",
                headers(new HeaderCapturingBuilder().token("test-token")).get("Authorization"));
        assertEquals(
                "Bearer test-token",
                headers(new AsyncHeaderCapturingBuilder().token("test-token")).get("Authorization"));
    }

    private static Map<String, String> headers(CohereBuilder builder) {
        return ((HeaderCapturingBuilder) builder).headers();
    }

    private static Map<String, String> headers(AsyncCohereBuilder builder) {
        return ((AsyncHeaderCapturingBuilder) builder).headers();
    }

    private static final class HeaderCapturingBuilder extends CohereBuilder {
        Map<String, String> headers() {
            return buildClientOptions().headers(null);
        }
    }

    private static final class AsyncHeaderCapturingBuilder extends AsyncCohereBuilder {
        Map<String, String> headers() {
            return buildClientOptions().headers(null);
        }
    }
}
