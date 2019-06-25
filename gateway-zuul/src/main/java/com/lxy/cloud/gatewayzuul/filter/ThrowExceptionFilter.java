package com.lxy.cloud.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author lxy
 * @time 2019-06-16 14:53
 *
 **/
//@Component
public class ThrowExceptionFilter  extends ZuulFilter{
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        doSomthing();
        return null;
    }

    private void doSomthing() {
        throw new RuntimeException("runtime Exception！");
    }
}
