package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection con;
    public static Connection getConnection() throws SQLException{
        if(con==null||con.isClosed())
         con = DriverManager.getConnection("jdbc:sqlite:data.db");
        return con;
    }
}
