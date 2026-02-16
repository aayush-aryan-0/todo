package com.example;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.fxml.*;

import java.io.IOException;

import javafx.animation.*;
import javafx.concurrent.*;




public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
        stage.setTitle("To-Do");

    
        Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
        stage.getIcons().add(icon);

       
        Scene scene = new Scene(loader.load());
        //scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

     

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
