package io.piano.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Json parser
 */
public class JacksonObjectMapper {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T parseJson(String data, Class<T> clazz) throws IOException {
        T stack = objectMapper.readValue(data, clazz);
        return stack;
    }
}
