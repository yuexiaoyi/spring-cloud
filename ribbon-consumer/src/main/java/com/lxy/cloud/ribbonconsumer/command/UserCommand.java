package com.lxy.cloud.ribbonconsumer.command;

import com.lxy.cloud.ribbonconsumer.vo.UserVO;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * 使用继承HystrixCommand的方式来实现
 * 也可以使用注解的方式实现
 * @author lxy
 * @time 2019-06-26 14:57
 **/
public class UserCommand extends HystrixCommand<UserVO>{
    private RestTemplate restTemplate;
    private long id;

    public UserCommand(RestTemplate restTemplate, long id) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected UserVO run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/user/{id}", UserVO.class, id);
    }

    /**
     * 启用缓存
     * @return
     */
   /* @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }*/


    /**
     * 服务降级的处理
     * @return
     */
    @Override
    protected UserVO getFallback(){
        System.out.println("here");
        return new UserVO();
    }
}
