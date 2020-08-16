package com.example.whereplace.controller;

import com.example.whereplace.entity.OutputInformation;
import com.example.whereplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 19892
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "register")
    public OutputInformation register(
            HttpServletRequest request,
            @RequestParam("userName") String userName,
            @RequestParam("password")String password,
            @RequestParam("phoneNumber")long phoneNumber
    ) {
        try {
            return userService.register(request,userName,password,phoneNumber);
        }catch (NullPointerException e){
            return new OutputInformation(602);
        }
    }

    @RequestMapping(value = "verify")
    public OutputInformation verify(
            HttpServletRequest request,
            @RequestParam("code") String code,
            @RequestParam("phoneNumber")long phoneNumber
    ){
        try {
            return userService.verify(request,code,phoneNumber);
        }catch (NullPointerException e){
            return new OutputInformation(602);
        }
    }


    @RequestMapping(value = "login")
    public OutputInformation login(
            @RequestParam("userId")long userId,
            @RequestParam("password")String password
    ) {
        try {
            return userService.login(userId, password);
        }catch (NullPointerException e){
            return new OutputInformation(602);
        }
    }

}
