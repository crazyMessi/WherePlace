package com.example.whereplace.entity;


/**
 * @author 19892
 */
public class Favorlist {

  private long userId;
  private String favorListName;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getFavorListName() {
    return favorListName;
  }

  public void setFavorListName(String favorListName) {
    this.favorListName = favorListName;
  }

}
