package training.generics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericMethod {
    private final static ObjectMapper MAPPER = new ObjectMapper();
    public static <T> String writeValueAsString(T type) throws JsonProcessingException {
        return MAPPER.writeValueAsString(type);
    }
}
