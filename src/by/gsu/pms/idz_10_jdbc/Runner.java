package by.gsu.pms.idz_10_jdbc;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите  номер операции:\n 1 - Перевод\n 2 - Добавление перевода\n 3 - Удаление перевода");
        int operation = scan.nextInt();
        Translator translator = new Translator();
        WordsAdding adder = new WordsAdding();
        WordsRemoving remover = new WordsRemoving();
        switch (operation) {
            case 1 -> translator.translateOperation();
            case 2 -> adder.addTranslating();
            case 3 -> remover.removeOperation();
            default -> System.out.println("Операция не распознана");

        }

    }


}
