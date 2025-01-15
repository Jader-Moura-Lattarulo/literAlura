package br.com.jmdev.literalura.service;

import br.com.jmdev.literalura.model.ApiResponse;
import br.com.jmdev.literalura.model.BookData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertsData implements IConvertsData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> clazz) {
        try {
            if (clazz == ApiResponse.class) {
                return mapper.readValue(json, clazz);
            } else if (clazz == BookData.class) {
                ApiResponse apiResponse = mapper.readValue(json, ApiResponse.class);
                return (T) apiResponse.getResults().get(0);
            }
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
