package by.gsu.pms.idz_10_jdbc;

public class HTMLGenerator {

    public void generateTranslatedMarkup(String langFrom,
                                         String langTo,
                                         String wordFrom,
                                         String wordTo) {
        System.out.println("<h3>Вот ваш перевод </h3>\n" +
                "<h2>"+langFrom+" -> "+langTo+" </h2>\n" +
                "<h1>"+wordFrom+"->"+wordTo+"</h1>");
    }
}
