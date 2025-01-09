package br.com.alura.literAlura.util;

import java.util.Scanner;

public class UserInputReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInputString(){
        return scanner.nextLine();
    }

    public static int getUserInputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }
}
