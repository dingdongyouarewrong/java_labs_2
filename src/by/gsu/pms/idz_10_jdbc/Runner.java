package by.gsu.pms.idz_10_jdbc;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Подключение к бд");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите  номер операции:\n 1 - Перевод\n 2 - Добавление перевода");
        int operation = scan.nextInt();
        Translator translator = new Translator();
        WordsAdding adding = new WordsAdding();
        switch (operation) {
            case 1 -> translator.translateOperation();
            case 2 -> adding.addTranslating();
            default -> System.out.println("Операция не распознана");

        }

    }


}
