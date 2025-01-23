package com.aca.musicfinderv2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MariaDbUtil {

    private static String connectionURL = "jdbc:mariadb://localhost:3306/myartistsv2?user=root&password=Deviant";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) {
        Connection connection = MariaDbUtil.getConnection();
        if (null != connection) {
            System.out.println("Real DB Connection!!");
        } else {
            System.out.println("No connection");
        }
    }
}