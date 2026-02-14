package com.example;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReadToDo {
    static void disp() throws SQLException{
        Connection con = DatabaseManager.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM todo");

        while(rs.next()) {
            
            String task = rs.getString("task");

            int done = rs.getInt("done");
            String taskDone=(done==0)?"Not done":"Done";
        

            System.out.println(task + " " + taskDone );

        }

    }
}
