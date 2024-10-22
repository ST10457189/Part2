/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2;

/**
 *
 * @author Dell
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
 public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public boolean checkUserName() {
        boolean condition = username.contains("_") && username.length() <= 5;
        return condition;
    }

   
    public boolean checkPasswordComplexity() {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasNumber && hasSpecialChar;
    }

 
    public String registerUser() {
        String Message ;
        
        if(checkUserName()){
            System.out.println("Username successfully captured");

              if(checkPasswordComplexity()){
                    System.out.println("Username successfully captured");
                    Message = "The user has been registered successfully";
    }else{
         Message = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
              }
        }else{
      Message =  "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
  
        }
        return Message;
             
        
    }

   
    public boolean loginUser(String Username, String Password) {
        if(username.equals(Username) && password.equals(Password))
        {
            return true;
        }else{
         return false;
        }
       
    }

  
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}