package com.lxy.cloud.eurekaclient.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lxy
 * @time 2019-02-25 15:07
 **/
@Configuration
public class DruidConfiguration {
    @Bean("default-ds")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource(){
        DruidDataSource dds = new DruidDataSource();
        return dds;
    }

    /**
     * 注册statViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");


        //添加初始化参数
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        servletRegistrationBean.addInitParameter("deny","");
        //查看信息的用户名和密码
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");

        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");

        return  servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("default-ds")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);

        return ssfb.getObject();

    }

}
