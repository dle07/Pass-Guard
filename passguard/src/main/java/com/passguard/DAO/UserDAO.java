package com.passguard.DAO;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.passguard.Entities.User;
import com.passguard.Util.PasswordUtil;
import com.passguard.Util.UtilFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class UserDAO {

  @Autowired
  private EntityManager em;
  @Autowired 
  private PasswordUtil passwordUtil;
  @Autowired
  UtilFunctions utilFunctions;

  public void insertUser(String username, String email, String password){
    username = passwordUtil.encode(username);
    email = passwordUtil.encode(email);
    password = passwordUtil.encode(email);
    
    User newUser = new User(username, email, password);
    em.persist(newUser);

  }

  public void update(User user){
    em.merge(user);
  }
  //Throws exception if user is not found
  public User getUser(String username_or_email, String password) throws Exception{
    

    String credential_type = (utilFunctions.isEmail(username_or_email)? "email" : "username");  //It's safe to encode now because we know what type of credential it is
    username_or_email = passwordUtil.encode(username_or_email);
    password = passwordUtil.encode(password);

    
    Query query = em.createNativeQuery("select from users u where u.:credential_type = :credential_string and u.password = :password")
                  .setParameter("credential_type", credential_type)
                  .setParameter("credential_string",username_or_email)
                  .setParameter("password",password);
    return (User)query.getSingleResult(); 
    

  }
  
  public User getUserById(int id){
    return em.find(User.class,id);
  }

  
}
