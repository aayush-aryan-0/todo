package com.example;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
    private MainController parentController;

    public void setParentController(MainController parentController){
        this.parentController=parentController;
    }
   
    public void deleteTask() {
        try{
            if(taskText.getText()!=null)
                UpdateToDo.deleteTask(taskText.getText());
            VBox parentBox=(VBox)taskBox.getParent();
            parentBox.getChildren().remove(taskBox);
            parentController.setMessageLabel("Task Deleted",Color.RED);
            
            

        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        catch(TaskNotFound e){
            parentController.setMessageLabel("No such task exists",Color.RED);
        }
       
       

    }
    public void toggleTask(){
         try{
           UpdateToDo.toggleDone(taskText.getText());
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        catch(TaskNotFound e){
            parentController.setMessageLabel("No such task exists",Color.RED);
        }
    }
        

    public void setText(String text){
        taskText.setText(text);
    }

    public void setTaskDone(boolean done){
        taskDone.setSelected(done);
    }
    
    public void saveTask(){
        try{
            if(taskText.getText()==null||taskText.getText().equals("")) throw new TaskNotFound("Task Is Empty");
            UpdateToDo.addTask(taskText.getText());
           
            parentController.setMessageLabel("Task saved successfull!!!",Color.GREEN);
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(TaskAlreadyExists e){
            parentController.setMessageLabel("This task already exists",Color.RED);
            
        } 
        catch(TaskNotFound e){
            parentController.setMessageLabel(e.getMessage(),Color.RED);
        }

    }
   

}
