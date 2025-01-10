package br.com.alura.literAlura.service;

import br.com.alura.literAlura.dto.Book;
import br.com.alura.literAlura.dto.Response;
import br.com.alura.literAlura.ui.Display;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {
    String url = "https://gutendex.com/books?search=";
    RestTemplate restTemplate = new RestTemplate();

    public void fetchBooks(String bookToBeSought) {
        Response response = restTemplate.getForObject(url + bookToBeSought, Response.class);

        if (response != null && response.getResults() != null) {
            response.getResults().forEach(Display::showBookInformation);
        }
    }
}
