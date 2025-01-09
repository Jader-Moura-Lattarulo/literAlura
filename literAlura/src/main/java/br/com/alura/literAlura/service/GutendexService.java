package br.com.alura.literAlura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GutendexService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://gutendex.com/books/";

    public String searchBooksById(Long id) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .path(String.valueOf(id))
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }
}
