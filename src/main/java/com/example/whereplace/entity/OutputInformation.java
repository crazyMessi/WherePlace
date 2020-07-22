package com.example.whereplace.entity;

/**
 * @author 19892
 */
public class OutputInformation {
    int code;

    String massage;

    Object data;

    public OutputInformation(int code, String massage, Object data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public OutputInformation(int code, String massage) {
        this.code=code;
        this.massage=massage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OutputInformation(int code){
        this.code=code;
        switch (code){
            case -1:massage="服务器错误";
            break;
            case 0: massage="success! !";
            break;
            case 601:massage="登陆已过期，请重新登录";
            break;
            case 602:massage="请求字段不能为空";
            break;
            default:break;
        }

    }
}
