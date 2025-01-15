package br.com.jmdev.literalura.service;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumptionAPI {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books/?search=";

    public String getData(String address) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(GUTENDEX_API_URL+address, String.class);
    }
}
