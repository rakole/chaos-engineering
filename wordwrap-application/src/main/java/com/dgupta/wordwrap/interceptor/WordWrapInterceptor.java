package com.dgupta.wordwrap.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class WordWrapInterceptor implements HandlerInterceptor {

    /**
     * This is a placeholder for a logger, which will
     * log every request as it reaches the REST end point.
     *
     * @param request  http request
     * @param response http response
     * @param handler  http interceptor request handler
     * @return will return
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {
        return true;
    }
}
