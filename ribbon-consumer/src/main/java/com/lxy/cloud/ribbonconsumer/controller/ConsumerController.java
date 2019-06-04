package com.lxy.cloud.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lxy
 * @time 2019-04-24 17:00
 **/
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(name = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForObject("http://USER-SERVICE/hello", String.class);
    }

    @RequestMapping(name = "/consumer/user/{id}", method = RequestMethod.GET)
    public String findUserById(@PathVariable long id) {
        return restTemplate.getForObject("http://USER-SERVICE/user/{id}", String.class, id);
    }

}
