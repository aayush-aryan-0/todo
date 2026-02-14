package com.example;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static Connection con;
    public static Connection getConnection() throws SQLException{
        String folder = "resources";
            File dbFolder = new File(folder);
            if (!dbFolder.exists()) {
                dbFolder.mkdirs();
            }

            // Full path to the database file
            String dbPath = folder + File.separator + "data.db";

        if(con==null||con.isClosed())
         con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS todo(task TEXT PRIMARY KEY, done INTEGER NOT NULL DEFAULT 0)");
        return con;
        
    }
    
   
}
