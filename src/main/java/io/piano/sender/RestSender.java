package io.piano.sender;

import io.piano.response.StackResponse;

/**
 * REST Client
 */
public interface RestSender {

    StackResponse sendRequest(String absoluteUri);

}

