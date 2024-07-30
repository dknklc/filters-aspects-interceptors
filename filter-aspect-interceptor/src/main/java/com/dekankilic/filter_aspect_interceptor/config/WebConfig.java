package com.dekankilic.filter_aspect_interceptor.config;

import com.dekankilic.filter_aspect_interceptor.interceptor.BasicAuthHandlerInterceptor;
import com.dekankilic.filter_aspect_interceptor.interceptor.LogHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor())
                .order(2);
        registry.addInterceptor(new BasicAuthHandlerInterceptor())
                .order(1); // We are specifying with order(1) that this interceptor is executed before LogHandlerInterceptor.
    }
}
