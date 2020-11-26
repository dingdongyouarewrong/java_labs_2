package by.gsu.pms.idz_10_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static by.gsu.pms.idz_10_jdbc.Constants.URI_BELORUSSIAN_RUSSIAN_DB;
import static by.gsu.pms.idz_10_jdbc.Constants.URI_RUSSIAN_BELORUSSIAN_DB;

public class WordsRemoving {

    public void removeOperation() {
        System.out.println("Выбран режим удаления");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер словаря для удаления перевода:\n 1 - Белорусско-русский\n 2 - Русско-Белорусский");
        int dictCode = scan.nextInt();
        switch (dictCode) {
            case 1->removeEntryBelorussianRussian();
            case 2-> removeEntryRussianBelorussian();
            default -> System.out.println("Словарь не распознан");
        }
        System.out.println("Перевод удален");
    }

    public void removeBelorussianWord(String word ) throws SQLException {
        Connector connector = new Connector();
        PreparedStatement setWord = null;
        try (Connection connection = connector.createConnection(URI_BELORUSSIAN_RUSSIAN_DB)) {
            String query = "DELETE FROM words WHERE belorussian=?;";
            setWord = connection.prepareStatement(query);
            setWord.setString(1, word);
            setWord.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert setWord != null;
            setWord.close();
        }
    }

    public void removeRussianWord(String word ) throws SQLException {
        Connector connector = new Connector();
        PreparedStatement setWord = null;
        try (Connection connection = connector.createConnection(URI_RUSSIAN_BELORUSSIAN_DB)) {
            String query = "DELETE FROM words WHERE russian=?;";
            setWord = connection.prepareStatement(query);
            setWord.setString(1, word);
            setWord.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert setWord != null;
            setWord.close();
        }
    }

    public void removeEntryBelorussianRussian() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите белорусское слово");
        String word = scan.next();
        try {
            removeBelorussianWord(word);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void removeEntryRussianBelorussian() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите русское слово");
        String word = scan.next();
        try {
            removeRussianWord(word);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
