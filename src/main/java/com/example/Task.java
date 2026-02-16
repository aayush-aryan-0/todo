package com.example;

public class Task {
    private String task;
    private boolean done;
    public Task(String task,boolean done){
        this.task=task;
        this.done=done;
    }
    public String getTask(){
        return task;
    }
    public boolean isDone(){
        return done;
    }
}
