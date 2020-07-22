package com.example.whereplace.entity;


public class Userinformation {

  private long userId;
  private String userName;
  private String password;
  private long userType;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getUserType() {
    return userType;
  }

  public void setUserType(long userType) {
    this.userType = userType;
  }

}
