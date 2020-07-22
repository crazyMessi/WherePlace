package com.example.whereplace.service;

import com.example.whereplace.additionfunc.MyToken;
import com.example.whereplace.entity.OutputInformation;
import com.example.whereplace.entity.Userinformation;
import com.example.whereplace.mapper.StoreMapper;
import com.example.whereplace.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author 19892
 */

@Service
public class UserService {

    @Value("${expireTime}")
    private long expireTime;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StoreMapper storeMapper;

    public OutputInformation login(long userId,String password){
        OutputInformation outputInformation;
        if (password.equals(userMapper.login(userId))){
            MyToken myToken=new MyToken(Long.toString(userId),System.currentTimeMillis()+expireTime);
            outputInformation= new OutputInformation(0);
            outputInformation.setData(myToken.generate());
            return outputInformation;
        }
        else {
            return new OutputInformation(1,"账号或密码错误");
        }
    }

    public OutputInformation register(String userName,String password){
        try {
            Userinformation userinformation=new Userinformation();
            userinformation.setPassword(password);
            userinformation.setUserName(userName);
            userMapper.register(userinformation);
            storeMapper.creatFavorList(userinformation.getUserId(),"默认摊库");
            return new OutputInformation(0,"success",userinformation.getUserId());
        }catch (Exception e){
            if (e instanceof DuplicateKeyException){
                return new OutputInformation(1,"用户名已存在");
            }else {
                return new OutputInformation(-1);
            }
        }
    }
}
