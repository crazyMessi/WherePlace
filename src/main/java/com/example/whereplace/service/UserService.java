package com.example.whereplace.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.whereplace.additionfunc.MyToken;
import com.example.whereplace.additionfunc.SendSms;
import com.example.whereplace.entity.MyProps;
import com.example.whereplace.entity.OutputInformation;
import com.example.whereplace.entity.Userinformation;
import com.example.whereplace.mapper.StoreMapper;
import com.example.whereplace.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19892
 */

@Service
public class UserService {

    @Autowired
    private MyProps myProps;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    SendSms sendSms;

    public OutputInformation login(long userId,String password){
        OutputInformation outputInformation;
        Userinformation user=userMapper.login(userId);
        if (password.equals(user.getPassword())){
            user.setPassword("null");
            MyToken myToken=new MyToken(Long.toString(userId),System.currentTimeMillis()+myProps.getExpireTime());
            JSONObject output=new JSONObject();
            output.put("token",myToken.generate());
            output.put("user",JSON.toJSONString(user));
            outputInformation= new OutputInformation(0,"success",output);
            return outputInformation;
        }
        else {
            return new OutputInformation(1,"账号或密码错误");
        }
    }

    public OutputInformation register(HttpServletRequest request,String userName, String password, long phoneNumber){
        if (userMapper.checkIfExist(phoneNumber)!=0){
            return new OutputInformation(-1,"账号已注册");
        }
        String code=sendSms.smsCode();
        String returnData=sendSms.sendSms(code,Long.toString(phoneNumber));

        if (returnData!=null){
            JSONObject data= JSON.parseObject(returnData);
            String msg=data.getString("Message");
            if ("OK".equals(msg)) {
                HttpSession session=request.getSession();
                Userinformation user=new Userinformation();
                user.setPassword(password);
                user.setUserName(userName);
                user.setUserId(phoneNumber);
                HashMap<String,Userinformation> codeUserMap=new HashMap<>();
                codeUserMap.put(code,user);
                session.setMaxInactiveInterval(myProps.getSessionExpireTime().get("register"));
                session.setAttribute(Long.toString(phoneNumber),codeUserMap);
            }
            return new OutputInformation(0,msg);
        }else {
            return new OutputInformation(-1,"验证码发送失败");
        }

    }


    public OutputInformation verify(HttpServletRequest request, String code,long phoneNumber) {
        HttpSession session=request.getSession();
        HashMap<String,Userinformation> codeUserMap=(HashMap)session.getAttribute(Long.toString(phoneNumber));
        Userinformation user= null;
        try {
            user = codeUserMap.get(code);
        } catch (NullPointerException e) {
            return new OutputInformation(-1,"请先完善账户信息");
        }
        if (codeUserMap.get(code)!=null){
            try {
                userMapper.register(user);
                storeMapper.creatFavorList(user.getUserId(),"默认摊库");
                session.removeAttribute(Long.toString(phoneNumber));
            }catch (DuplicateKeyException e){
                return new OutputInformation(-1,"账号已注册");
            }catch (Exception e){
                return new OutputInformation(-1);
            }
            return new OutputInformation(0);
        }else {
            return new OutputInformation(-1,"验证码错误");
        }
    }
}
