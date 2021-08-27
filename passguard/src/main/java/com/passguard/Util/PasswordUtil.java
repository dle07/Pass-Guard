package com.passguard.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.stereotype.Service;

@Service
public class PasswordUtil {
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  private RandomValueStringGenerator randomValueStringGenerator;

  public String getRandomPassword(){
    int length = 18;
    randomValueStringGenerator.setLength(length);
  
    return randomValueStringGenerator.generate();
  }
  

  // Can be anything, username, email, password etc.
  public String encode(String string){
    return bCryptPasswordEncoder.encode(string);
  }
}
