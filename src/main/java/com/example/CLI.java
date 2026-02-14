package com.example;

import java.sql.SQLException;
import java.util.Scanner;

public class CLI {
    static void runCLI(){
        Scanner sc = new Scanner(System.in);
        while(true){
            
        try{
            int choice=0;
            while(choice!=4){
                System.out.print("""
                        1.Add task
                        2.Mark task as done/undone
                        3.Delete task
                        4.Quit
                        Enter choice: """);
                choice=sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1->{
                        System.out.print("Enter task: ");
                        String task=sc.nextLine();
                        UpdateToDo.addTask(task);
                     
                        
                    }
                    case 2->{
                        System.out.print("Enter task: ");
                        String task=sc.nextLine();
                        UpdateToDo.toggleDone(task);
                   
                       
                    }
                    case 3->{
                        System.out.print("Enter task: ");
                        String task=sc.nextLine();
                        UpdateToDo.deleteTask(task);
                      
                       
                    }
                    case 4->{
                        System.out.println("Quiting");
                        System.exit(0);;
                    }
                    default->System.out.println("Error");
                        
                }
                System.out.println();
                ReadToDo.disp();
                System.out.println();
            }
          
            break;
        }
       
        catch(SQLException e){
            System.err.println(e);
            System.out.print("Press Enter to continue: ");
            sc.nextLine();
        }
        catch(TaskAlreadyExists|TaskNotFound e){
            System.out.println(e.getMessage());
            System.out.print("Press Enter to continue: ");
            sc.nextLine();
        }
        catch(Exception e){
            System.err.println(e);
            System.out.print("Press Enter to continue: ");
            sc.nextLine();
        }
        }
    }
}
