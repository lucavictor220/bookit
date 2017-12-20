package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConverter {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String pojoToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static Object jsonToPojo(String json, Class klass) throws IOException {
        return objectMapper.readValue(json, klass);
    }

    public static Object jsonListToPojo(String json, TypeReference<?> typeReference) throws IOException {
        return objectMapper.readValue(json, typeReference);
    }
}
