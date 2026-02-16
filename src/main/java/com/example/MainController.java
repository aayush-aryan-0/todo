package com.example;

import java.io.IOException;
import java.rmi.server.ExportException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority; 
import javafx.geometry.Pos;

public class MainController {
   
    @FXML
    private Button addButton;
    
    @FXML
    private VBox taskContainer;

   
    
    @FXML
    public void addTask() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/taskBox.fxml"));

            HBox newTaskBox = loader.load(); 
            
            taskContainer.getChildren().add(newTaskBox);

        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}

   


   
