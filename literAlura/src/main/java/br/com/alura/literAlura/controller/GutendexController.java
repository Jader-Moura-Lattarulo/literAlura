package br.com.alura.literAlura.controller;

import br.com.alura.literAlura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GutendexController {

    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/books/{id}")
    public String searchBooks(@PathVariable Long id) {
        return gutendexService.searchBooksById(id);
    }
}
