package com.lxy.cloud.eurekaclient.service;

import com.lxy.cloud.eurekaclient.mapper.UserMapper;
import com.lxy.cloud.eurekaclient.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxy
 * @create 2019-04-25 10:58
 **/
@RestController
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public UserVO findById(@PathVariable String id){
        return userMapper.selectById(id);
    }

    @RequestMapping(value ="user",method = RequestMethod.POST)
    public int add(@RequestBody UserVO vo){
        return userMapper.insert(vo);
    }

    @RequestMapping(value = "testError")
    public void testExcp(){
        throw new RuntimeException("测试异常信息！");
    }
}
