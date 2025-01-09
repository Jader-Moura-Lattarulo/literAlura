package br.com.alura.literAlura.initializer;

import br.com.alura.literAlura.ui.Display;
import br.com.alura.literAlura.util.UserInputReader;

public class MenuInitializer {

    public static void menu(){
        String userChoice = "";

        while (!userChoice.equals("0")) {
            Display.firstMenu();
            userChoice = UserInputReader.getUserInputString();

            switch (userChoice) {
                case "1" -> menuChoice01();
                case "2" -> menuChoice02();
                case "3" -> menuChoice03();
                case "4" -> menuChoice04();
                case "5" -> menuChoice05();
                case "0" -> Display.goodByeMessage();
                default -> Display.makeAValidChoiceMessage();
            }
        }
    }

    public static void menuChoice01(){
        System.out.println("Você escolheu - Buscar livro pelo título");
        System.out.println("Entre com o título que quer buscar: ");
        String bookToBeSought = UserInputReader.getUserInputString();
        System.out.println("Livro a ser buscado: " + bookToBeSought);
    }

    public static void menuChoice02(){
        System.out.println("Você escolheu - Listar livros registrados");
        System.out.println("Segue a lista de livros registrados: ");
    }

    public static void menuChoice03(){
        System.out.println("Você escolheu -Listar autores registrados ");
        System.out.println("Segue a lista de autores registrados");
    }

    public static void menuChoice04(){
        System.out.println("Você escolheu - Listar autores vivos em um determinado ano");
        System.out.println("Digite o ano que deseja buscar: ");
        int year = UserInputReader.getUserInputInt();
        System.out.println("Esses sao os autores vivos no ano " + year);
    }

    public static void menuChoice05(){
        System.out.println("Você escolheu - Listar livros em um determinado idioma");
        System.out.println("Entre com o idioma dos livros que quer buscar: ");
        String booksWithLanguage = UserInputReader.getUserInputString();
        System.out.println("Segue a lista de livros no idioma: " + booksWithLanguage);
    }
}
