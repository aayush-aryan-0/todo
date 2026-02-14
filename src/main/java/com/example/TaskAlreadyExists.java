package com.example;

public class TaskAlreadyExists extends Exception {
    public TaskAlreadyExists(String mssg){
        super(mssg);
    }
}
