package com.example.whereplace.entity;


public class Store {

  private long storeId;
  private long userId;
  private double longitude;
  private double latitude;
  private String provinces;
  private String city;
  private String block;
  private String street;
  private String streetNumber;
  private long ifOpen;
  private String storeName;
  private String storeDesc;
  private String storePhoto;
  private long followers;

  public Store(long userId, double longitude, double latitude, String provinces, String city, String block, String street, String streetNumber, String storeName, String storeDesc,String storePhoto) {
    this.userId = userId;
    this.longitude = longitude;
    this.latitude = latitude;
    this.provinces = provinces;
    this.city = city;
    this.block = block;
    this.street = street;
    this.streetNumber = streetNumber;
    this.storeName = storeName;
    this.storeDesc = storeDesc;
    this.storePhoto=storePhoto;
  }

  private long volumes;

    public Store() {

    }


    public long getStoreId() {
    return storeId;
  }

  public void setStoreId(long storeId) {
    this.storeId = storeId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }


  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }


  public String getProvinces() {
    return provinces;
  }

  public void setProvinces(String provinces) {
    this.provinces = provinces;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public String getBlock() {
    return block;
  }

  public void setBlock(String block) {
    this.block = block;
  }


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }


  public long getIfOpen() {
    return ifOpen;
  }

  public void setIfOpen(long ifOpen) {
    this.ifOpen = ifOpen;
  }


  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }


  public String getStoreDesc() {
    return storeDesc;
  }

  public void setStoreDesc(String storeDesc) {
    this.storeDesc = storeDesc;
  }


  public String getStorePhoto() {
    return storePhoto;
  }

  public void setStorePhoto(String storePhoto) {
    this.storePhoto = storePhoto;
  }


  public long getFollowers() {
    return followers;
  }

  public void setFollowers(long followers) {
    this.followers = followers;
  }


  public long getVolumes() {
    return volumes;
  }

  public void setVolumes(long volumes) {
    this.volumes = volumes;
  }



}
