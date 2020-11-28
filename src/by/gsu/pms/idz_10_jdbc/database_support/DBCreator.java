package by.gsu.pms.idz_10_jdbc.database_support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.gsu.pms.idz_10_jdbc.Constants.*;

public class DBCreator {

    public final String[] insertDataRussianBelorussianQueries = {
            "INSERT INTO words('russian', 'belorussian') VALUES('онлайн','онлайн');",
            "INSERT INTO words('russian', 'belorussian') VALUES('бесплатный','бясплатны');",
            "INSERT INTO words('russian', 'belorussian') VALUES('переводчик','перакладчык');"};
    public final String[] insertDataBelorussianRussianQueries = {
            "INSERT INTO words VALUES(1,'бясплатны','бесплатный');",
            "INSERT INTO words VALUES(2,'онлайн','онлайн');",
            "INSERT INTO words VALUES(3,'перакладчык','переводчик');"};

    public void createTables() {
        try {
            createRussianBelorussianTables();
            createBelorussianRussianTables();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void createBelorussianRussianTables() throws SQLException {
        Connector connector = new Connector();
        PreparedStatement statement = null;
        try (Connection connection = connector.createConnection(URI_BELORUSSIAN_RUSSIAN_DB)) {
            statement = connection.prepareStatement(CREATE_TABLE_BELORUSSIAN_RUSSIAN_QUERY);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert statement != null;
            statement.close();
        }
    }

    public void createRussianBelorussianTables() throws SQLException {
        Connector connector = new Connector();
        PreparedStatement statement = null;
        try (Connection connection = connector.createConnection(URI_RUSSIAN_BELORUSSIAN_DB)) {

            statement = connection.prepareStatement(CREATE_TABLE_RUSSIAN_BELORUSSIAN_QUERY);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert statement != null;
            statement.close();
        }
    }

    public void insertData() {
        try {
            insertBelorussianRussianData();
            insertRussianBelorussianData();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertRussianBelorussianData() throws SQLException {
        Connector connector = new Connector();
        PreparedStatement statement = null;
        try (Connection connection = connector.createConnection(URI_RUSSIAN_BELORUSSIAN_DB)) {
            for (String query: insertDataRussianBelorussianQueries) {
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void insertBelorussianRussianData() throws SQLException {
        Connector connector = new Connector();
        PreparedStatement statement = null;
        try (Connection connection = connector.createConnection(URI_BELORUSSIAN_RUSSIAN_DB)) {
            for (String query: insertDataBelorussianRussianQueries) {
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}

