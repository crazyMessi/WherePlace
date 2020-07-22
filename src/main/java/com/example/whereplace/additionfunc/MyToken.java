package com.example.whereplace.additionfunc;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author 19892
 */
@Service
public class MyToken {
    private String userId;
    private long expireTime;
    private static final String key="XSZXJCWX";

    public MyToken() {

    }

    public MyToken(String userId, long expireTime) {
        this.userId = userId;
        this.expireTime = expireTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
    //加密
    public String generate(){
        Base64.Encoder encoder = Base64.getEncoder();
        return new String(encoder.encode(encrypt(JSON.toJSONString(this).getBytes(), key)));
    }
    //解密
    public static MyToken valid(String token){
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            String tem=new String(decrypt(decoder.decode(token.getBytes()),key));
            MyToken object=JSON.parseObject(tem, MyToken.class);
            System.out.println("用户账号："+object.userId);
            if(object.expireTime > System.currentTimeMillis()){
                return object;
            }else {
                System.out.println("该token过期\n");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private byte[] encrypt(byte[] datasource, String key) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] decrypt(byte[] src, String key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }



}

