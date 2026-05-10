package library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/library_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lalaland17";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver"); // Або твій драйвер
            System.out.println("Спроба підключення до бази...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Підключення УСПІШНЕ!");
            return conn;
        } catch (Exception e) {
            System.out.println("ПОМИЛКА ПІДКЛЮЧЕННЯ ДО БД:");
            e.printStackTrace();
            return null;
        }
    }
}
