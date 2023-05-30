package org.itmo.labs.jdbc;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DbConnection {
    private static Connection connection;
    private final static String user = "postgres";
    private final static String password = "";
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection connect() {
        try{
            connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (SQLException e) {
            System.out.println("Не удалось получить доступ к базе данных");
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
