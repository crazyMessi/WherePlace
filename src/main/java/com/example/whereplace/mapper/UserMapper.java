package com.example.whereplace.mapper;

import com.example.whereplace.entity.Userinformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 19892
 */
@Repository
public interface UserMapper {

    /**
     * 注册
     * @param userinformation
     * @return 返回一个账号
     */
    void register(Userinformation userinformation);


    /**
     *注册前的检查工作
     * @param user_id
     * @return
     */
    long checkIfExist(long user_id);


    /**
     * 登陆
     * @param userId
     * @return 对应的password
     */
    Userinformation login(long userId);





}
