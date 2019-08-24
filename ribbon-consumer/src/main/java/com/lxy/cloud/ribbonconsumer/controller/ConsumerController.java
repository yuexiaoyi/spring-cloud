package com.lxy.cloud.ribbonconsumer.controller;

import com.lxy.cloud.ribbonconsumer.service.UserService;
import com.lxy.cloud.ribbonconsumer.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxy
 * @time 2019-04-24 17:00
 **/
@RestController
public class ConsumerController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return userService.helloConsumer();
    }

    @RequestMapping(value = "/consumer/user/{id}", method = RequestMethod.GET)
    public UserVO findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/consumer/user", method = RequestMethod.POST)
    public int insertUser(@RequestBody UserVO user){
        return userService.insertUser(user);
    }

}
