package com.lxy.cloud.eurekaclient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author lxy
 * @time 2019-04-24 10:49
 **/
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(HelloController.class.getName());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        List<ServiceInstance> instances= client.getInstances("hello-service");
        ServiceInstance instance = instances.get(0);
        logger.info("/hello,host:" + instance.getHost() + ",service_id" + instance.getServiceId() );
        return "hello world!";
    }


}
