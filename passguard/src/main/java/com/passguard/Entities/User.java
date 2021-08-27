package com.passguard.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  private String username;
  @Column
  private String email;
  @Column
  private String password;

  
  @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL, mappedBy = "user")
  private List<Account> accounts = new ArrayList<Account>();

  
  public User() {
  }


  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }


  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }


  public int getId() {
    return id;
  }


  public List<Account> getAccounts() {
    return accounts;
  }


  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }



  
  
}
