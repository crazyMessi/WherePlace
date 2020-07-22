package com.example.whereplace.entity;


/**
 * @author 19892
 */
public class Comment {
  private long commentId;
  private long userId;
  private java.sql.Timestamp timestamp;
  private String content;
  private long goodId;


  public long getCommentId() {
    return commentId;
  }

  public void setCommentId(long commentId) {
    this.commentId = commentId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.sql.Timestamp timestamp) {
    this.timestamp = timestamp;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getGoodId() {
    return goodId;
  }

  public void setGoodId(long goodId) {
    this.goodId = goodId;
  }

}
