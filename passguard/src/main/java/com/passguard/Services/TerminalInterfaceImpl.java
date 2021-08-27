package com.passguard.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.passguard.DAO.UserDAO;
import com.passguard.Entities.User;
import com.passguard.Util.UtilFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalInterfaceImpl implements TerminalInterface{

  private User current_user = null;
  private Integer current_user_id = null;
  @Autowired
  private UserDAO userDAO;
  @Autowired
  private UtilFunctions utilFunctions;
  private Scanner sc = new Scanner(System.in);

  public TerminalInterfaceImpl(){
  }

  public void renderWelcome(){

    ArrayList<String> welcome_lines = new ArrayList<String>(
      Arrays.asList(
      "|-------------------------------------------------------|",
      "|                                                       |",
      "|                 Welcome To Pass Guard                 |",
      "|                  A Password Manager                   |",
      "|                                                       |",
      "|                                                       |",
      "|                                                       |",
      "|    Features:                                          |",
      "|    -BCrypt credential encoding                        |",
      "|    -Random Password Generator                         |",
      "|                                                       |",
      "|                                                       |",
      "|                                                       |",
      "|-------------------------------------------------------|",
      "|                                                       |"
    ));

    for( String line: welcome_lines){
      System.out.println(line);
    }
    
  }
  
  @Override
  public void startProgram(){
    renderWelcome();
    promptRegisterOrLogin();
    
  }

  @Override
  public void promptRegisterOrLogin(){
    System.out.println(
    "----------------MENU---------------\n"+
    "1) Register New User\n" +
    "2) Login\n"
    );
    boolean validIntegerInput = false;
    int input_choice = -1;
    while( !validIntegerInput ){
      sc.next();
      if( sc.hasNextInt()){
        input_choice = sc.nextInt();
        if( input_choice == 1 || input_choice == 2){
          validIntegerInput = true;
        }else{
          System.out.println("Enter 1 or 2");
        }
      }      
    }
    

    if( input_choice == 1){
      registerNewUser();
    }else{
      // Performs the Login, switches control to Main Menu
      while(current_user == null){  // While we haven't logged in
        try {
          validateCredentialsAndGetUser();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }


  }

  @Override
  public void registerNewUser(){
    String new_username;
    String new_password;
    String new_email;
    
    
    System.out.println("You chose to register a new master account. Please enter a username, email, and password. Remember these credentials.");

    System.out.println("Please your username");
    new_username = sc.nextLine();
    System.out.println("Please enter a valid email");
    new_email = sc.nextLine();
    
    while( !utilFunctions.isEmail(new_email)){
      System.out.println("Invalid Input, Enter a valid email please... ");
      new_email = sc.nextLine();
    }

    System.out.println("Please enter a password");
    new_password = sc.nextLine();
    userDAO.insertUser(new_username, new_email, new_password);
    
    promptRegisterOrLogin();
  }

  @Override
  public void validateCredentialsAndGetUser() throws Exception{

    while( true ){
      try {
        String username_or_email;
        String password;

        System.out.println("Please enter your username/email and password");
        System.out.println("Enter Username/Email:  ");
        username_or_email = sc.nextLine();
        System.out.println("Enter Password:   ");
        password = sc.nextLine();
        current_user = userDAO.getUser(username_or_email, password);  // Throws an exception if user is not found
        current_user_id = current_user.getId();
        break;
      } catch (Exception e) {
        System.out.println("------------Invalid Credentials Please Try Again------------");
        }
    }
  }
  
  @Override
  public void renderMasterMenu(){

    System.out.println(
      "-----------Master Menu-----------\n"+
      "1) See all accounts              \n"+
      "2) Add a new account             \n"+
      "9) Exit"
      );
  

    boolean exit_program = false;
    while( !exit_program ){
      
      boolean validIntegerInput = false;
      int input_choice = -1;
      while( !validIntegerInput ){
        sc.next();
        if( sc.hasNextInt()){
          input_choice = sc.nextInt();
          if( input_choice == 1 || input_choice == 2 || input_choice == 3){
            validIntegerInput = true;
            switch (input_choice) {
              case 1:
                
                break;
            
              default:
                break;
            }
          }else{
            System.out.println("Not a valid input. Try again: ");
          }
        }      
      }

    }
  }



}
