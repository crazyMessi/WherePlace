package com.example.whereplace.controller;

import com.example.whereplace.additionfunc.MyToken;
import com.example.whereplace.entity.OutputInformation;
import com.example.whereplace.entity.Store;
import com.example.whereplace.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 19892
 */
@RestController
public class StoreController {


    @Autowired
    StoreService storeService;


    @RequestMapping(value = "setStore")
    @ResponseBody
    public OutputInformation setStore(
                                      @RequestHeader(value = "token")String token,
                                      @RequestParam(value="storeName")String storeName,
                                      @RequestParam(value = "storeDesc",required = false)String storeDesc,
                                      @RequestParam(value = "storePhoto",required = false) MultipartFile storePhoto,
                                      @RequestParam(required = false,defaultValue = "-1")double longitude,
                                      @RequestParam(required = false,defaultValue = "-1")double latitude,
                                      @RequestParam(required = false) String provinces,
                                      @RequestParam(required = false) String city,
                                      @RequestParam(required = false) String block,
                                      @RequestParam(required = false) String street,
                                      @RequestParam(required = false) String streetNumber) throws IOException {
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.setStore(userId,storeName,storeDesc,storePhoto,longitude,latitude,provinces,city,block,street,streetNumber);
        }catch (NumberFormatException e){
            return new OutputInformation(-1);
        }catch (NullPointerException e){
            return new OutputInformation(601);
        }
    }





    @RequestMapping(value = "changeState")
    public OutputInformation changeState(@RequestHeader("token")String token,
                                         @RequestParam("storeId")long storeId,
                                         @RequestParam(required = false,defaultValue = "-1")double longitude,
                                         @RequestParam(required = false,defaultValue = "-1")double latitude,
                                         @RequestParam(required = false) String provinces,
                                         @RequestParam(required = false) String city,
                                         @RequestParam(required = false) String block,
                                         @RequestParam(required = false) String street,
                                         @RequestParam(required = false) String streetNumber
                                        ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.changState(userId,storeId,longitude,latitude,city,block,street,streetNumber);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }

    }

    @RequestMapping(value = "getFavorList")
    public OutputInformation getFavorList(
            @RequestHeader("token")String token
    ) {
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.getFavorList(userId);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }
    }

    @RequestMapping(value = "creatFavorList")
    public OutputInformation creatFavorList(
            @RequestHeader("token")String token,
            @RequestParam("favorListName")String favorListName
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.creatFavorList(userId,favorListName);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }
    }

    @RequestMapping(value = "favorStore")
    public OutputInformation favorStore(
            @RequestHeader("token")String token,
            @RequestParam("storeId")long storeId,
            @RequestParam(value = "favorListName",required = false)String favorListName
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.favorStore(userId,storeId,favorListName);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }
    }

    @RequestMapping(value = "storeClassification")
    public OutputInformation storeClassification(
            @RequestHeader("token")String token,
            @RequestParam("typeName")String typeName,
            @RequestParam("storeId")long storeId
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.storeClassification(userId,typeName,storeId);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException e){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "viewStore")
    public OutputInformation viewStore(
            @RequestHeader("token")String token,
            @RequestParam(value = "longitude",required = false,defaultValue = "-1")double longitude,
            @RequestParam(value = "latitude",required = false,defaultValue = "-1")double latitude,
            @RequestParam(value = "street",required = false)String street,
            @RequestParam(value = "block",required = false)String block,
            @RequestParam(value = "distance",required = false,defaultValue = "-1")double distance

    ){
        try {
            Long.parseLong(MyToken.valid(token).getUserId());
            String columnName=null;
            String keyValue=null;
            if (street!=null){
                columnName="street";
                keyValue=street;
            }
            if (block!=null){
                columnName="block";
                keyValue=block;
            }
            return storeService.viewStore(columnName,keyValue,distance,latitude,longitude);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "viewFavorList")
    public OutputInformation viewFavorList(
            @RequestHeader("token")String token,
            @RequestParam("favorListName")String favorListName
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.viewFavorList(userId,favorListName);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "viewMyStore")
    public OutputInformation viewMyStore(
            @RequestHeader("token")String token
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.viewMyStore(userId);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "favorGood")
    public OutputInformation favorGood(
            @RequestHeader("token")String token,
            @RequestParam("goodId")long goodId
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.favorGood(userId,goodId);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "commentGood")

    public OutputInformation commentGood(
            @RequestParam("goodId")long goodId,
            @RequestHeader("token")String token,
            @RequestParam("commentContent")String commentContent
    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.commentGood(goodId,userId,commentContent);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "publishGood")

    public OutputInformation publishGood(
            @RequestHeader("token")String token,
            @RequestParam("storeId")long storeId,
            @RequestParam(value = "goodName",required = false)String goodName,
            @RequestParam(value = "goodDesc",required = false)String goodDesc,
            @RequestParam(value = "goodPhoto",required = false)MultipartFile goodPhoto,
            @RequestParam(value = "price")double price

    ){
        long userId;
        try {
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.publishGood(storeId,goodName,goodDesc,goodPhoto,price);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "accountGood")
    public OutputInformation accountGood(
            @RequestParam("goodId")long goodId,
            @RequestHeader("token")String token
    ){
        try {
            Long.parseLong(MyToken.valid(token).getUserId());
            return storeService.accountGood(goodId);
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "viewGoods")
    public OutputInformation viewGoods(
            @RequestHeader("token")String token,
            @RequestParam(value = "storeId",defaultValue = "-1")long storeId,
            @RequestParam(value = "ifPrice",defaultValue = "-1")int ifPrice,
            @RequestParam(value = "ifComment",defaultValue = "-1")int ifComment,
            @RequestParam(value = "ifSales",defaultValue = "-1")int ifSales,
            @RequestParam(value = "ifFavor",defaultValue = "-1")int ifFavor
            ){
        long userId;
        try {
            OutputInformation outputInformation;
            userId=Long.parseLong(MyToken.valid(token).getUserId());
            String columnName=null;
            if (ifPrice!=-1){
               columnName="price";
            }
            if (ifSales!=-1){
                columnName="sales";
            }
            outputInformation=storeService.viewGoods(userId,columnName,storeId);
            return outputInformation;
        }catch (NumberFormatException e){
            return new OutputInformation(601);
        }catch (NullPointerException n){
            return new OutputInformation(602);
        }
    }

}
