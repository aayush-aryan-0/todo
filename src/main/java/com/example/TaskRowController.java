package com.example;

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
   
    public void deleteTask(){
        VBox parentBox=(VBox)taskBox.getParent();
        parentBox.getChildren().remove(taskBox);
    }
    public void toggleTask(){

    }
   
   

}
