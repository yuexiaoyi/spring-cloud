package com.lxy.cloud.ribbonconsumer.service;

import com.lxy.cloud.ribbonconsumer.command.UserCommand;
import com.lxy.cloud.ribbonconsumer.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author lxy
 * @time 2019-04-24 17:00
 **/
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public String helloConsumer() {
        return restTemplate.getForObject("http://USER-SERVICE/hello", String.class);
    }

    /**
     * 增加Hystrix
     * 使用主机的方式实现
     * execute同步执行
     * queue 异步执行
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "findByUserFallback")
    public UserVO findUserById(long id) {
//        return restTemplate.getForObject("http://USER-SERVICE/user/{id}", UserVO.class, id);
          //execute同步执行
//        UserVO user = new UserCommand(restTemplate, id).execute();
//        return user;
        //queue是异步处理
        Future<UserVO> futureUser =  new UserCommand(restTemplate, id).queue();
        try {
            return futureUser.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int insertUser(UserVO user){
        return restTemplate.postForObject("Http://USER-SERVICE/user", user, Integer.class);
    }



}
