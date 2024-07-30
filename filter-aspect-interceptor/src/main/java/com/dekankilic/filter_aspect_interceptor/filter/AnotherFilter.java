package com.dekankilic.filter_aspect_interceptor.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@Slf4j
public class AnotherFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Collections.list(request.getHeaderNames())
                .forEach(header -> log.info("Header: {}-{}", header, request.getHeader(header)));

        filterChain.doFilter(request, response);
    }
}

/*
* There may be a case where you have a multiple servlets in the application, which means if you have multiple copies
* of the same filter for each servlet, there is a chance that the filter will be executed multiple times.
* Mostly, we do not want this. For that reason, Spring has its own class called OncePerRequestFilter
*
* */