package by.gsu.pms.idz_10_jdbc;

import java.sql.*;

public class WordsExtraction {
    public String extractRussianWord(String word) throws SQLException {
        Connector connector = new Connector();
        String uri = "jdbc:sqlite:/Users/dmitry/IdeaProjects/java_labs_2/src/by/gsu/pms/idz_10_jdbc/belorussian-russian.db";
        Connection connection = connector.createConnection(uri);
        String belorussianWord = null;
        String query = "SELECT * FROM words WHERE belorussian=?;";
        PreparedStatement getWord = connection.prepareStatement(query);
        getWord.setString(1, word);
        ResultSet resultSet = getWord.executeQuery();
        if (resultSet.next()) {
            belorussianWord = resultSet.getString("russian");
        }
        connection.close();


        return belorussianWord;
    }
}
