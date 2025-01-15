package br.com.jmdev.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"count"})
public class GutendexResultDTO {
    private int count;
    private String next;
    private String previous;
    private List<BookDTO> results;

    public List<BookDTO> getResults() {
        return results;
    }
    public void setResults(List<BookDTO> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return String.format("""
                A lista de resultados %s
                """, getResults());
    }
}