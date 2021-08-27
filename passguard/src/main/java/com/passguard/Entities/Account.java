package com.passguard.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "accounts")
@Entity
public class Account {
  @Id
  @GeneratedValue ( strategy = GenerationType.AUTO)
  private int id;

  private String email;
  private String website_url;
  private String password;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;


  public Account(){
    
  }

  public Account(String email, String website_url, String password, User user) {
    this.email = email;
    this.website_url = website_url;
    this.password = password;
    this.user = user;
  }

  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getWebsite_url() {
    return website_url;
  }


  public void setWebsite_url(String website) {
    this.website_url = website;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public User getUser() {
    return user;
  }


  public void setUser(User user) {
    this.user = user;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  
}
