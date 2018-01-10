package com.gchr.miaosha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 17:20
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }
}
