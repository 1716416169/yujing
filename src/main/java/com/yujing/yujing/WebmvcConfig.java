package com.yujing.yujing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebmvcConfig extends WebMvcConfigurationSupport {

    @Value("${web.Allpath}")
    private String Allpath ;
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/","classpath:/static/images/upload/");
        registry.addResourceHandler("/lay/**").addResourceLocations("classpath:/static/js/lay/");
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/static/font/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/File/**").addResourceLocations("file:"+"File/");
        registry.addResourceHandler("/qianduan/**").addResourceLocations("classpath:/static/qianduan/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/qianduan/img/");
        registry.addResourceHandler("/Main/**").addResourceLocations("classpath:/static/qianduan/Main/");
        registry.addResourceHandler("/index_media.css").addResourceLocations("classpath:/static/qianduan/");
       /* registry.addResourceHandler("/soltion/**").addResourceLocations("classpath:/static/qianduan/Main/soltion/");*/
    }
        @Override
        protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        }
    }