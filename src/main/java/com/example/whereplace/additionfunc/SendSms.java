package com.example.whereplace.additionfunc;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.whereplace.entity.MyProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @author 19892
 */

@Repository
public class SendSms {
    @Autowired
    private MyProps myProps;



    public String sendSms(String code,String phoneNum){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", myProps.getAccessKeyId(), myProps.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "摆哪儿");
        request.putQueryParameter("TemplateCode", "SMS_199806084");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String smsCode(){
        String random = new Random().nextInt(1000000)+"";
        if(random.length()!=6){
            return smsCode();
        }else{
            return random;
        }
    }

    public static void main(String[] args) {
    }
}