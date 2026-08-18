package com.cohere.api;

/**
 * Support for clients that authenticate outside of the SDK.
 *
 * <p>Building a client with an empty token, e.g. {@code Cohere.builder().token("").build()}, sends
 * no {@code Authorization} header at all, which allows pointing the client at a proxy or a
 * self-hosted deployment that performs its own authentication.
 */
public final class OptionalAuth {
    private OptionalAuth() {}

    /**
     * Returns whether a client configured with the given token should send an {@code Authorization}
     * header.
     */
    public static boolean sendsAuthorizationHeader(String token) {
        return token != null && !token.isEmpty();
    }
}
