package com.example;

import java.io.IOException;
import javafx.scene.control.Label;
import java.rmi.server.ExportException;
import java.sql.SQLException;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
    private Label messageLabel;

   
    
    @FXML
    public void addTask() {
        addRow(new Task("",false));
       
    }
    public void addRow(Task task){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/taskBox.fxml"));

            HBox newTaskBox = loader.load(); 
            TaskRowController taskRowController = loader.getController();
            taskRowController.setTaskDone(task.isDone());
            taskRowController.setText(task.getTask());
            taskRowController.setParentController(this);
        
            taskContainer.getChildren().add(newTaskBox);

        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        try{
            Task[] tasks=ReadToDo.loadDB();
            for(Task task:tasks){
                addRow(task);
            }
        }
        catch(SQLException e){
            System.err.println(e);
        }
        

    }
    public void setMessageLabel(String message,Color color){
    
        messageLabel.setText(message);
        messageLabel.setTextFill(color);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> messageLabel.setText(""));
        pause.play();
        
    }

   
    
}

   


   
