package br.com.alura.literAlura;

import br.com.alura.literAlura.initializer.MenuInitializer;
import br.com.alura.literAlura.ui.Display;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Display.wellcomeMessage();
		MenuInitializer.menu();
	}
}
