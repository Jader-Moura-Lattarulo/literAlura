package br.com.alura.literAlura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private List<Book> results;

    public List<Book> getResults() {
        return results;
    }
}
