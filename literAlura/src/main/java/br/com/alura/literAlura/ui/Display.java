package br.com.alura.literAlura.ui;

import br.com.alura.literAlura.dto.Book;

public class Display {
    public static void wellcomeMessage() {
        System.out.println("Bem-vind@ ao LiterAlura!");
    }

    public static void firstMenu(){
        System.out.println("""
                Digite o número referente a sua opção:
                1- Buscar livro pelo título
                2- Listar livros registrados
                3- Listar autores registrados
                4- Listar autores vivos em um determinado ano
                5- Listar livros em um determinado idioma
                0- Sair
                """);
    }

    public static void goodByeMessage() {
        System.out.println("Saindo... Obrigado por usar o LiterAlura\n");
    }

    public static void makeAValidChoiceMessage() {
        System.out.println("Por favor, escolha uma opção válida\n");
    }

    public static void showBookInformation(Book book) {
        System.out.println("Título: " + book.getTitle());
        System.out.println("Autor: " + (book.getAuthors().isEmpty() ? "Desconhecido" : book.getAuthors().get(0).getName()));
        System.out.println("Idioma: " + (book.getLanguages().isEmpty() ? "Desconhecido" : book.getLanguages().get(0)));
        System.out.println("Número de Downloads: " + book.getDownloadCount());
        System.out.println("-----------------------------------");
    }
}
