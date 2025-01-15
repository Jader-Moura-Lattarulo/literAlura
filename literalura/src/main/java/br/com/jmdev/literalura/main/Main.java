package br.com.jmdev.literalura.main;

import br.com.jmdev.literalura.model.Author;
import br.com.jmdev.literalura.model.AuthorData;
import br.com.jmdev.literalura.model.Book;
import br.com.jmdev.literalura.model.BookData;
import br.com.jmdev.literalura.repository.AuthorRepository;
import br.com.jmdev.literalura.repository.BookRepository;
import br.com.jmdev.literalura.service.ConsumptionAPI;
import br.com.jmdev.literalura.service.ConvertsData;
import org.hibernate.Hibernate;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    Scanner scanner = new Scanner(System.in);

    public Main(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void showMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    *** LiterAlura ***
                    
                    1- Buscar um novo livro
                    2- Listar livros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos em um determinado ano
                    5- Listar livros em um determinado idioma
                    
                    9- Sair
                    """;

            System.out.println(menu);

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    searchBookFromAPI();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    livingAuthorsList();
                    break;
                case 5:
                    listBooksWithSpecificLanguage();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }

    private void livingAuthorsList() {
        System.out.println("Entre com o ano que deseja saber os autores vivos: ");
        var year = scanner.nextInt();

        List<Author> authors = authorRepository.findAll();

        authors.forEach(a -> {
            if (a.wasAliveInYear(year)) {
                System.out.println("Autores vivos no ano: " + year);
                System.out.println(a.getName());
            } else {
                System.out.println("Não foi encontrado nenhum autor vivo no ano: " + year);
            }
        });

    }

    private void searchBookFromAPI() {
        var consumptionAPI = new ConsumptionAPI();
        var converter = new ConvertsData();

        System.out.println("Qual livro você deseja buscar? ");
        String bookToBeSearched = scanner.nextLine().replace(" ","+");
        var json = consumptionAPI.getData(bookToBeSearched);
        BookData bookData = converter.getData(json, BookData.class);
        AuthorData authorData = bookData.authors().get(0);

        //Verificar se o autor já existe no BD
        Author author = authorRepository.findByNameContainingIgnoreCase(authorData.name())
                .orElseGet(() -> authorRepository.save(Author.fromAuthorData(authorData)));

        Book book = Book.fromBookData(bookData, author);
        bookRepository.save(book);

        System.out.println(book);
    }

    private void listBooks() {
        List<Book> books = bookRepository.findAll();
        List<String> allTitles = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());

        allTitles.forEach(System.out::println);
    }

    private void listAuthors() {
        List<Book> books = bookRepository.findAll();
        Set<String> uniqueAuthors = books.stream()
                .map(b -> b.getAuthor().getName())
                .collect(Collectors.toSet());

        uniqueAuthors.forEach(System.out::println);
    }

    private void listBooksWithSpecificLanguage() {
        System.out.println("Qual idioma você quer buscar os livros? (pt, en, fr...)");
        String lang = scanner.nextLine();

        List<Book> booksWithSpecificLanguage = bookRepository.findByLanguagesContainingIgnoreCase(lang);

        if (booksWithSpecificLanguage.isEmpty()) {
            System.out.println("Nenhum livro em " + lang + " encontrado, tente novamente.");
        } else {
            booksWithSpecificLanguage.forEach(b -> System.out.println(b.getTitle()));
        }
    }
}
