package com.example.whereplace.service;


import com.example.whereplace.additionfunc.FileFactory;
import com.example.whereplace.entity.Goods;
import com.example.whereplace.entity.OutputInformation;
import com.example.whereplace.entity.Store;
import com.example.whereplace.mapper.StoreMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 19892
 */
@Service
public class StoreService {


    @Autowired
    StoreMapper storeMapper;


    public OutputInformation setStore(long userId, String storeName, String storeDesc, MultipartFile storePhoto,double longitude, double latitude, String provinces, String city, String block, String street, String streetNumber) throws IOException {
        String photoUrl=imgToUrl(storePhoto);
        Store store=new Store(userId,longitude,latitude,provinces,city,block,street,streetNumber,storeName,storeDesc,photoUrl);
        storeMapper.setStore(store);
        return new OutputInformation(0,"",store);
    }


    public OutputInformation changState(long userId,long storeId, double longitude, double latitude, String city, String block, String street, String streetNumber) {
        Store store=storeMapper.selectStore(storeId);
        if (userId==store.getUserId()){
            store.setIfOpen(store.getIfOpen()*-1);
            store.setLongitude(longitude);
            store.setLatitude(latitude);
            store.setBlock(block);
            store.setCity(city);
            store.setStreet(street);
            store.setStreetNumber(streetNumber);
            storeMapper.changeState(store);
            return new OutputInformation(0,"success",-1*store.getIfOpen());
        } else {
            return new OutputInformation(1,"店主与摊位不匹配或摊位不存在");
        }
    }


    public OutputInformation getFavorList(long userId) {
        return new OutputInformation(0,"succes",storeMapper.getFavorList(userId));
    }


    public OutputInformation creatFavorList(long userId, String favorListName) {
        return new OutputInformation(storeMapper.creatFavorList(userId,favorListName)==1?0:-1);
    }


    public OutputInformation favorStore(long userId, long storeId, String favorListName) {
        return new OutputInformation(storeMapper.favorStore(userId,favorListName,storeId)==1?0:-1);
    }


    public OutputInformation storeClassification(long userId, String typeName, long storeId) {
        return new OutputInformation(storeMapper.storeClassification(typeName,storeId)==1?0:-1);
    }


    public OutputInformation viewFavorList(long userId, String favorListName) {
        return new OutputInformation(0,"",storeMapper.viewFavorList(userId,favorListName));
    }


    public OutputInformation viewMyStore(long userId) {
        return new OutputInformation(0,"",storeMapper.viewMyStore(userId));
    }


    public OutputInformation favorGood(long userId, long goodId) {
        return new OutputInformation(0,"",storeMapper.favorGood(userId,goodId));
    }

    public OutputInformation commentGood(long goodId, long userId, String commentContent) {
        return new OutputInformation(0,"",storeMapper.commentGood(goodId,commentContent,userId, new Timestamp(System.currentTimeMillis())));
    }

    private  String imgToUrl(MultipartFile file){
        String photoUrl;
        //如果为null 那么路径也为null
        if (file==null){
            return null;
        }
        String fileType=file.getContentType();
        if (fileType.equals("image/jpg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
            try {
                FileFactory fileFactory=new FileFactory();
                photoUrl=fileFactory.fileToUrl(file);
                return photoUrl;
                }catch (IOException e) {
                e.printStackTrace();
                return "图片插入失败！";
            }
        }else {
            return "图片格式不正确";
        }
    }




    public OutputInformation publishGood(long storeId, String goodName, String goodDesc, MultipartFile goodPhoto,double price){
        String url=imgToUrl(goodPhoto);
        Goods goods=new Goods(storeId,goodName,goodDesc,url,price);
        storeMapper.publishGood(goods);
        return new OutputInformation(0,"",goods.getGoodId());
    }


    public OutputInformation accountGood(long goodId) {
        return new OutputInformation(storeMapper.accountGood(goodId)==1?0:-1);
    }


    public OutputInformation viewGoods(long userId, String columnName,long storeId) {
        if (storeId!=-1){
            return new OutputInformation(0,"",storeMapper.viewGoods(storeId,columnName));
        }else {
            return new OutputInformation(0,"",storeMapper.viewFocusGoods(userId));
        }
    }

    public OutputInformation viewStore(String columnName, String keyValue, double distance, double latitude, double longitude) {
        return new OutputInformation(0,"",storeMapper.viewStore(columnName,keyValue,distance,latitude,longitude));
    }
}
