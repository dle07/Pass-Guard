package com.passguard.Services;

import com.passguard.Entities.User;

/**
 * renderAllAcounts() 
 *  Prints all accounts the password manager has for the current user
 * 
 * 
 * 
 * 
 */
public interface MasterMenuService {
  public void renderAllAccounts(User user);
  public void  addNewAccount( User user, String email, String website_url);
}
