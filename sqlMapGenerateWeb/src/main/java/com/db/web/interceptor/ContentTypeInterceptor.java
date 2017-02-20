package com.db.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ContentTypeInterceptor implements HandlerInterceptor{
    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
       /* if(response.getContentType()==null){
           response.setContentType(DEFAULT_CONTENT_TYPE);
        }*/
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
       
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
       
    }

}
