package by.gsu.pms.idz_10_jdbc;

import java.sql.*;
import java.util.Scanner;

import static by.gsu.pms.idz_10_jdbc.Constants.URI_BELORUSSIAN_RUSSIAN_DB;
import static by.gsu.pms.idz_10_jdbc.Constants.URI_RUSSIAN_BELORUSSIAN_DB;

public class WordsAdding {

    public void addBelorussianToRussian(String russianWord,
                                          String belorussianWord) throws SQLException {

        Connector connector = new Connector();
        PreparedStatement setWord = null;
        try (Connection connection = connector.createConnection(URI_BELORUSSIAN_RUSSIAN_DB)) {
            String query = "INSERT INTO words (belorussian, russian)\n" +
                    "\tVALUES (?,?);";
            setWord = connection.prepareStatement(query);
            setWord.setString(1, belorussianWord);
            setWord.setString(2, russianWord);
            setWord.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert setWord != null;
            setWord.close();
        }
    }

    public void addRussianToBelorussian(String russianWord,
                                        String belorussianWord) throws SQLException {

        Connector connector = new Connector();
        PreparedStatement setWord = null;
        try (Connection connection = connector.createConnection(URI_RUSSIAN_BELORUSSIAN_DB)) {
            String query = "INSERT INTO words (russian, belorussian)\n" +
                    "\tVALUES (?,?);";
            setWord = connection.prepareStatement(query);
            setWord.setString(1, russianWord);
            setWord.setString(2, belorussianWord);
            setWord.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert setWord != null;
            setWord.close();
        }
    }


    public void addTranslating() {

        System.out.println("Выбран режим перевода");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер словаря для добавления перевода:\n 1 - Русско-Белорусский\n 2 - Белорусско-русский");
        int dictCode = scan.nextInt();
        switch (dictCode) {
            case 1->extendRussianBelorussianDict();
            case 2-> extendBelorussianRussianDict();
            default -> System.out.println("Словарь не распознан");
        }
        System.out.println("Введите слово для перевода");

    }

    public void extendBelorussianRussianDict() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите белорусское слово");
        String belorussianWord = scan.next();
        System.out.println("Введите русское слово");
        String russianWord = scan.next();
        try {
            addBelorussianToRussian(russianWord, belorussianWord);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void extendRussianBelorussianDict() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите русское слово");
        String russianWord = scan.next();
        System.out.println("Введите белорусское слово");
        String belorussianWord = scan.next();

        try {
            addRussianToBelorussian(russianWord, belorussianWord);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}