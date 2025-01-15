package br.com.jmdev.literalura;

import br.com.jmdev.literalura.main.Main;
import br.com.jmdev.literalura.model.Author;
import br.com.jmdev.literalura.model.AuthorData;
import br.com.jmdev.literalura.model.Book;
import br.com.jmdev.literalura.model.BookData;
import br.com.jmdev.literalura.repository.AuthorRepository;
import br.com.jmdev.literalura.repository.BookRepository;
import br.com.jmdev.literalura.service.ConsumptionAPI;
import br.com.jmdev.literalura.service.ConvertsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(authorRepository, bookRepository);
		main.showMenu();
	}
}
