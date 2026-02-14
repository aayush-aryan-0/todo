package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UpdateToDo {
    static void addTask(String task) throws SQLException,TaskAlreadyExists{
            Connection con = DatabaseManager.getConnection();
            PreparedStatement checkExistence=con.prepareStatement("SELECT * FROM todo WHERE task=?");
            checkExistence.setString(1, task);
            ResultSet rs = checkExistence.executeQuery();
            if (rs.next()) {
                throw new TaskAlreadyExists("Such task already exist");
            }
           
            PreparedStatement ps = con.prepareStatement("INSERT INTO todo(task) VALUES(?)");
            ps.setString(1, task);
            ps.executeUpdate();
            con.close();
           
    }
    static void deleteTask(String task) throws SQLException,TaskNotFound{
            Connection con = DatabaseManager.getConnection();
            PreparedStatement checkExistence=con.prepareStatement("SELECT * FROM todo WHERE task=?");
            checkExistence.setString(1, task);
            ResultSet rs = checkExistence.executeQuery();
            if (!rs.next()) {
                throw new TaskNotFound("Task Not Found");
            }
            PreparedStatement ps = con.prepareStatement("DELETE FROM todo WHERE task = ?");
            ps.setString(1, task);
            ps.executeUpdate();
            con.close();
    }
    static void toggleDone(String task) throws SQLException,TaskNotFound{
            Connection con = DatabaseManager.getConnection();
            PreparedStatement checkExistence=con.prepareStatement("SELECT * FROM todo WHERE task=?");
            checkExistence.setString(1, task);
            ResultSet rs = checkExistence.executeQuery();
            if (!rs.next()) {
                throw new TaskNotFound("Task Not Found");
            }
            PreparedStatement ps = con.prepareStatement("UPDATE todo SET done = 1-done WHERE task = ?");
            ps.setString(1, task);
            ps.executeUpdate();
            con.close();
        
          
    }
    
      
}