package com.passguard.Services;

import com.passguard.DAO.UserDAO;
import com.passguard.Entities.Account;
import com.passguard.Entities.User;
import com.passguard.Util.PasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;

public class MasterMenuServiceImpl implements MasterMenuService {
  @Autowired
  private PasswordUtil passwordUtil;
  @Autowired
  private UserDAO userDAO;

  @Override
  public void renderAllAccounts(User user){
    System.out.println(
      "Email          |         Website Url         |         Password"
    );
    for( Account acc : user.getAccounts()){
      System.out.println(acc.getEmail()+"\t\t\t" + acc.getWebsite_url() + "\t\t\t" + acc.getPassword());
    }
  }

  @Override
  public void addNewAccount(User user, String email, String website_url) {
    String randomPassword = passwordUtil.getRandomPassword();


    Account new_account = new Account(email,website_url,randomPassword, user);
    user.getAccounts().add(new_account);
    userDAO.update(user);

    
  }
}
