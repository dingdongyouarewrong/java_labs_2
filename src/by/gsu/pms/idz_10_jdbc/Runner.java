package by.gsu.pms.idz_10_jdbc;


public class Runner {
    public static void main(String[] args) {
        System.out.println("словарь ебать");
        System.out.println("Подключение к бд");

        String word = "перакладчык";
        String lang = "Belorussian";
        Translator translator = new Translator(lang);
        String translatedWord = translator.translate_word(word);
        System.out.println(translatedWord);

    }
}
