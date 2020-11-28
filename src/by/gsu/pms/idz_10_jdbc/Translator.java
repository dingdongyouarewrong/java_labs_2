package by.gsu.pms.idz_10_jdbc;

import by.gsu.pms.idz_10_jdbc.database_support.WordsExtraction;

import java.sql.SQLException;
import java.util.Scanner;

public class Translator {

    int langCode;
    String langFrom;
    String langTo;

    public void translateOperation() {
        System.out.println("Перевод");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер языка для перевода:\n 1 - Русский\n 2 - Белорусский");
        langCode = scan.nextInt();
        if (langCode!=1 && langCode!=2) {
            System.out.println("Язык не распознан");
        }
        System.out.println("Введите слово для перевода");
        String word = scan.next();
        String translatedWord = translateWord(word);
        HTMLGenerator generator = new HTMLGenerator();
        generator.generateTranslatedMarkup(langFrom, langTo, word, translatedWord);
    }

    public String translateWord(String word) {
        String outWord = "";
        WordsExtraction extractor = new WordsExtraction();
        if (langCode==2) {
            langFrom = "Белорусский";
            langTo = "Русский";
            try {
                outWord = extractor.extractRussianWord(word);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (langCode==1) {
            langFrom = "Русский";
            langTo = "Белорусский";
            try {
                outWord = extractor.extractBelorussianWord(word);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return outWord;
    }
}
