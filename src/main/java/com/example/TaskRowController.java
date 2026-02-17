package com.example;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TaskRowController {
    
    @FXML
    private TextArea taskText;
    @FXML
    private Button deleteButton;
    @FXML
    private CheckBox taskDone;
    @FXML
    private HBox taskBox;
    @FXML
    private Button saveButton;
   
    public void deleteTask() {
        try{
            if(taskText.getText()!=null)
                UpdateToDo.deleteTask(taskText.getText());
            VBox parentBox=(VBox)taskBox.getParent();
            parentBox.getChildren().remove(taskBox);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        catch(TaskNotFound e){
            System.err.println(e);
        }
       

    }
    public void toggleTask() throws SQLException,TaskNotFound{
        UpdateToDo.toggleDone(taskText.getText());
    }

    public void setText(String text){
        taskText.setText(text);
    }

    public void setTaskDone(boolean done){
        taskDone.setSelected(done);
    }
    
    public void saveTask(){
        try{
            String content = taskText.getText();
    
  
            System.out.println("DEBUG - TEXT IS: " + content);
            UpdateToDo.addTask(taskText.getText());
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(TaskAlreadyExists e){
            System.err.println(e);
        }   
    }
   

}
