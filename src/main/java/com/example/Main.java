package com.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try{
            Task[] tasks=ReadToDo.loadDB();
            for(Task task:tasks){
                System.out.println(task.getTask()+":"+task.isDone());
            }
             MainFX.main(args);

        }
        catch(Exception e){
            System.err.println(e);
        }
      
    }
      
}