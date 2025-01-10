package br.com.alura.literAlura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    private String name;

    public String getName() {
        return name;
    }
}
