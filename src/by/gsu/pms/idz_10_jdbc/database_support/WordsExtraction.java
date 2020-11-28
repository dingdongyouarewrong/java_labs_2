package by.gsu.pms.idz_10_jdbc.database_support;

import java.sql.*;

import static by.gsu.pms.idz_10_jdbc.Constants.URI_BELORUSSIAN_RUSSIAN_DB;
import static by.gsu.pms.idz_10_jdbc.Constants.URI_RUSSIAN_BELORUSSIAN_DB;

public class WordsExtraction {

    public String extractRussianWord(String word) throws SQLException {
        Connector connector = new Connector();
        PreparedStatement getWord = null;
        String russianWord;
        try (Connection connection = connector.createConnection(URI_BELORUSSIAN_RUSSIAN_DB)) {
            russianWord = null;
            String query = "SELECT * FROM words WHERE belorussian=?;";
            getWord = connection.prepareStatement(query);
            getWord.setString(1, word);
            ResultSet resultSet = getWord.executeQuery();
            if (resultSet.next()) {
                russianWord = resultSet.getString("russian");
            }
        }
        finally {
            assert getWord != null;
            getWord.close();
        }

        return russianWord;
    }

    public String extractBelorussianWord(String word) throws SQLException {
        Connector connector = new Connector();
        PreparedStatement getWord = null;
        String russianWord;
        try (Connection connection = connector.createConnection(URI_RUSSIAN_BELORUSSIAN_DB)) {
            russianWord = null;
            String query = "SELECT * FROM words WHERE russian=?;";
            getWord = connection.prepareStatement(query);
            getWord.setString(1, word);
            ResultSet resultSet = getWord.executeQuery();
            if (resultSet.next()) {
                russianWord = resultSet.getString("belorussian");
            }
        }
        finally {
            assert getWord != null;
            getWord.close();
        }

        return russianWord;
    }
}
