package com.example.whereplace.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@ConfigurationProperties(prefix="myprops")
public class MyProps {

    private long expireTime;
    private String AccessKeyId;
    private String AccessKeySecret;
    private Map<String,Integer> sessionExpireTime = new HashMap<>();

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getAccessKeyId() {
        return AccessKeyId;
    }

    public void setAccessKeyId(String accessKeyuId) {
        AccessKeyId = accessKeyuId;
    }

    public String getAccessKeySecret() {
        return AccessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        AccessKeySecret = accessKeySecret;
    }

    public Map<String, Integer> getSessionExpireTime() {
        return sessionExpireTime;
    }

    public void setSessionExpireTime(Map<String, Integer> sessionExpireTime) {
        this.sessionExpireTime = sessionExpireTime;
    }


}
