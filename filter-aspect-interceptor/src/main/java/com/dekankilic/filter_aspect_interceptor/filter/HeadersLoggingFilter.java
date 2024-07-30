package com.dekankilic.filter_aspect_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
@Slf4j
public class HeadersLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)  servletRequest;
        Collections.list(request.getHeaderNames())
                .forEach(header -> log.info("Header: {}={}", header, request.getHeader(header)));

        filterChain.doFilter(servletRequest, servletResponse); // To delegate the next filter, or controller action
    }
}
