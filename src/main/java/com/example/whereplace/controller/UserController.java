package com.example.whereplace.controller;

import com.example.whereplace.entity.OutputInformation;
import com.example.whereplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 19892
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "register")
    public OutputInformation register(
            @RequestParam("userName")String userName,
            @RequestParam("password")String password
    ) {
        try {
            return userService.register(userName,password);
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
