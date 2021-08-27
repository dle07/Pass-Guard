package com.passguard.Services;


/**
 * startProgram
 *  -render_And_Handle_Welcome_Interface();
 *  -Prompt Register or Login
 *    -Register
 *       Rerenders prompt if registered
 *     -Prompt Login
 *        Control goes to the master menu 
 *
 * 
 * 
 * 
 *  */
public interface TerminalInterface {
  public void startProgram();
  public void renderWelcome();
  public void promptRegisterOrLogin();
  public void registerNewUser();
  public void validateCredentialsAndGetUser() throws Exception;
  public void renderMasterMenu();

}
