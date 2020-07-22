package com.example.whereplace.mapper;

import com.example.whereplace.entity.Goods;
import com.example.whereplace.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 19892
 */
@Repository
public interface StoreMapper {

    /**
     * 创建商店
     *@param store
     * @return
     */
    void setStore(Store store);

    /**
     * 改变商店的开张状态 并更新地理位置
     *
     * @param store
     * @return
     */
    void changeState(Store store);


    /**
     * 获取摊库
     * @param userId 非空
     *
     * @return
     */
    List<String> getFavorList(long userId);


    /**
     * 创建一个摊库
     * 若已存在同名的摊库 则返回-1
     * @param userId 非空
     * @param favorListName 非空
     * @return
     */
    int  creatFavorList(long userId,String favorListName);

    /**
     *放入已有的摊库
     * @param userId 非空
     * @param favorListName 默认为"默认摊库”
     * @param storeId 非空
     * @return
     */
    int favorStore(long userId,String favorListName,long storeId);


    /**、
     * 为商店分类
     * @param typeName
     * @param storeId
     * @return
     */
    int storeClassification(String typeName,long storeId);


    /**
     * 判断上商店与店主是否匹配 不匹配则返回0
     * @param userId
     * @param storeId
     * @return
     */
    int judge(long userId,long storeId);

    /**
     * 查看所有商店
     * @param street
     * @param block
     * @return
     */
    List<Store> viewStoreList(String street, String block);



    /**
     * 根据店的id获取商店
     * @param storeId
     * @return
     */

    Store selectStore(long storeId);

    /**
     * 获取用户名下的商店
     * @param userId 非空
     * @return
     */
    List<Store> viewMyStore(long userId);

    /**
     * 获取一个商店中的商品
     * @param storeId 非空
     * @param columnName 排序字段名
     * @return
     */
    List<Goods> viewGoods(long storeId,String columnName);


    /**
     * 获取关注的商品
     * @param userId
     * @return
     */
    List<Goods> viewFocusGoods(long userId);

    /**
     * 关注商品
     * @param userId
     * @param goodId
     * @return
     */
    int favorGood(long userId,long goodId);


    /**
     * @param goodId
     * @param commentContent
     * @param userId
     * @param date
     * @return
     */
    int commentGood(long goodId, String content, long userId, Timestamp timestamp);

    /**
     * 商品的结算
     * @param goodId
     * @return 返回增加后的sales
     */
    int accountGood(long goodId);

    /**
     * 获取一个摊库中的商店
     * @param userId
     * @param favorListName
     * @return
     */
    List<Store> viewFavorList(long userId, String favorListName);

    /**
     * 发布商品
     * @param goods
     * @return
     */
    void publishGood(Goods goods);

    /**
     * 条件查询商品
     * @param columnName
     * @param keyValue
     * @param distance
     * @param latitude
     * @param longitude
     * @return
     */
    List<Store> viewStore(String columnName, String keyValue, double distance, double latitude, double longitude);
}
