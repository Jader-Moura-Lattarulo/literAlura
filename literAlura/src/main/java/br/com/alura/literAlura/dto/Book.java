package br.com.alura.literAlura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String title;
    private List<Author> authors;
    private List<String> languages;

    @JsonProperty("download_count")
    private int downloadCount;

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }
}
