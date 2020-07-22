package com.example.whereplace.entity;


public class Goods {

  private long goodId;
  private long storeId;
  private String goodName;
  private double price;
  private String goodDesc;
  private String goodPhoto;
  private long favorites;
  private long sales;



    public Goods() {

    }

    public Goods(long storeId, String goodName, String goodDesc, String url, double price) {
      this.storeId = storeId;
      this.goodName = goodName;
      this.goodDesc = goodDesc;
      this.goodPhoto = url;
      this.price= price;
    }


    public long getGoodId() {
    return goodId;
  }

  public void setGoodId(long goodId) {
    this.goodId = goodId;
  }


  public long getStoreId() {
    return storeId;
  }

  public void setStoreId(long storeId) {
    this.storeId = storeId;
  }


  public String getGoodName() {
    return goodName;
  }

  public void setGoodName(String goodName) {
    this.goodName = goodName;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public String getGoodDesc() {
    return goodDesc;
  }

  public void setGoodDesc(String goodDesc) {
    this.goodDesc = goodDesc;
  }


  public String getGoodPhoto() {
    return goodPhoto;
  }

  public void setGoodPhoto(String goodPhoto) {
    this.goodPhoto = goodPhoto;
  }


  public long getFavorites() {
    return favorites;
  }

  public void setFavorites(long favorites) {
    this.favorites = favorites;
  }


  public long getSales() {
    return sales;
  }

  public void setSales(long sales) {
    this.sales = sales;
  }

}
