package com.lxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lxy.service.UserFeignClient;
import com.lxy.vo.UserVO;

/**
 * @author lxy
 * @time 2019-04-24 17:00
 **/
@RestController
public class ConsumerController {

    @Autowired
    UserFeignClient userFeignClient;

    @RequestMapping(value = "/consumer/user/{id}", method = RequestMethod.GET)
    public UserVO findUserById(@PathVariable String id) {
        return userFeignClient.findById(id);
    }

    @RequestMapping(value = "/consumer/user", method = RequestMethod.POST)
    public int insertUser(@RequestBody UserVO user){
        return userFeignClient.addUser(user);
    }

}
