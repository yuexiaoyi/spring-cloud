package com.lxy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.lxy.vo.UserVO;

/**
 * @author lxy
 * @create 2019-08-14 9:53
 **/
@FeignClient(name = "USER-SERVICE")
public interface UserFeignClient {
    /**服务提供方的接口地址*/
    @PostMapping(value = "user")
    int addUser(@RequestBody UserVO userVO);

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    UserVO findById(@PathVariable("id") String id);
}
