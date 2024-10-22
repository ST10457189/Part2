/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part2;

import java.util.Scanner;

public class Part2 {
 Scanner scanner = new Scanner(System.in);

     
        
        
    private static int totalTaskDuration = 0;
    private static int taskCount = 0;
    

    private static String[] taskNames;
    private static String[] taskDescriptions;
    private static String[] taskDevelopers;
    private static int[] taskDurations;
    private static String[] taskStatuses;
    private static String[] taskIds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        
        if (loginUser(scanner)) {
            System.out.println("Welcome to EasyKanban");
            runMenu(scanner);
        }
    }

    private static boolean loginUser(Scanner scanner) {
        
   System.out.println("Register a new account:");
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        
         Login login = new Login(username, password, firstName, lastName);
        String registrationResult = login.registerUser();
        System.out.println(registrationResult);
       Boolean  LoginStatus=false; 
    
        if (registrationResult.equals("The user has been registered successfully")) {
            System.out.println("\nLogin to your account:");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            String loginStatus = login.returnLoginStatus(loginUsername, loginPassword);
           System.out.println(loginStatus);
             
               LoginStatus = login.loginUser(username, password);
               
        }
     return LoginStatus;
 
        
    
}
    private static void runMenu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Add Tasks");
            System.out.println("2. Show Report");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTasks(scanner);
                    break;
                case "2":
                    System.out.println("Coming Soon");
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addTasks(Scanner scanner) {
        System.out.print("How many tasks do you want to add? ");
        int numTasks = Integer.parseInt(scanner.nextLine());

        taskNames = new String[numTasks];
        taskDescriptions = new String[numTasks];
        taskDevelopers = new String[numTasks];
        taskDurations = new int[numTasks];
        taskStatuses = new String[numTasks];
        taskIds = new String[numTasks];

        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter task name: ");
            String taskName = scanner.nextLine();
            System.out.print("Enter task description (max 50 characters): ");
            String taskDescription = scanner.nextLine();

            if (taskDescription.length() > 50) {
                System.out.println("Please enter a task description of less than 50 characters.");
                taskDescription = scanner.nextLine();
            }

            System.out.print("Enter developer name: ");
            String developerName = scanner.nextLine();
            System.out.print("Enter task duration (in hours): ");
            int taskDuration = Integer.parseInt(scanner.nextLine());

            System.out.println("Select task status:");
            System.out.println("1. To Do");
            System.out.println("2. Doing");
            System.out.println("3. Done");
            System.out.print("Choose a task status: ");
            int statusChoice = Integer.parseInt(scanner.nextLine());
            String taskStatus  ;
            switch (statusChoice) {
                case 1:
                    taskStatus ="To Do";
                    break;
                case 2:
                    taskStatus  ="Doing";
                    break;
                case 3:
                    taskStatus = "Done";
                    break;
                default:
                    taskStatus = "Unknown";
                    break;
            }
             
          
       
            String taskID = generateTaskID(taskName, i, developerName);

         
            taskNames[i] = taskName;
            taskDescriptions[i] = taskDescription;
            taskDevelopers[i] = developerName;
            taskDurations[i] = taskDuration;
            taskStatuses[i] = taskStatus;
            taskIds[i] = taskID;

            totalTaskDuration += taskDuration;
            taskCount++;

            System.out.println("Task successfully captured  ! Task ID: " + taskID);
        }

        System.out.println("Total task duration: " + totalTaskDuration + " hours");
    }

    private static String generateTaskID(String taskName, int taskNumber, String developerName) {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + 
                        developerName.substring(developerName.length() - 3).toUpperCase();
        return taskId;
    }
}
