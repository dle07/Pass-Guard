package com.passguard.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


@Service
public class UtilFunctions {

  
  public boolean isEmail(String possible_email_string){
    Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    Matcher mat = pattern.matcher(possible_email_string);

    return mat.matches();
    
  }
}
