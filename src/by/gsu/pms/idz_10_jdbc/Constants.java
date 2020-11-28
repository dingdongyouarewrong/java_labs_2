package by.gsu.pms.idz_10_jdbc;


public class Constants {
    private Constants() {}

    public static final String URI_BELORUSSIAN_RUSSIAN_DB = "jdbc:sqlite:/Users/dmitry/IdeaProjects/java_labs_2/src/by/gsu/pms/idz_10_jdbc/belorussian-russian.db";
    public static final String URI_RUSSIAN_BELORUSSIAN_DB = "jdbc:sqlite:/Users/dmitry/IdeaProjects/java_labs_2/src/by/gsu/pms/idz_10_jdbc/russian-belorussian.db";
    public static final String CREATE_TABLE_BELORUSSIAN_RUSSIAN_QUERY = "CREATE TABLE IF NOT EXISTS 'words' (\n" +
            "  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\n" +
            "  `belorussian` varchar(255) NOT NULL,\n" +
            "  `russian` varchar(255) NOT NULL);";
    public static final String CREATE_TABLE_RUSSIAN_BELORUSSIAN_QUERY = "CREATE TABLE IF NOT EXISTS \"words\" (\n" +
            "  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\n" +
            "  `russian` varchar(255) NOT NULL,\n" +
            "  `belorussian` varchar(255) NOT NULL);";


}
