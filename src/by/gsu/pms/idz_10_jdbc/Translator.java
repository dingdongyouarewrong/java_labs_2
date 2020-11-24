package by.gsu.pms.idz_10_jdbc;

import java.sql.SQLException;
import java.util.Objects;

public class Translator {
    public Translator(String lang) {
        this.lang = lang;
    }

    String lang;

    public String translate_word(String word) {
        String output_word = "";
        if (Objects.equals(lang, "Belorussian")) {
            WordsExtraction extractor = new WordsExtraction();
            try {
                output_word = extractor.extractRussianWord(word);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            System.out.println("jazik");
        }

        return output_word;
    }
}
