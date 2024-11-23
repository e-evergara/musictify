package com.has.app.musictify.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.has.app.musictify.excepcion.IllegalBodyException;

public class JsonUtil {

    public static String toStringJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(AppConstant.ERROR_PARSE_JSON);
        }
    }

    public static Object bodyMapper(Object body, Class<?> typeReturn) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            String json = mapper.writeValueAsString(body);
            return mapper.readValue(json, typeReturn);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalBodyException(AppConstant.ERROR_PARSE_BODY);
        }
    }

}