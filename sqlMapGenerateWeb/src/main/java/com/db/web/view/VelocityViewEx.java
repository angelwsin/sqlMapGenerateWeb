package com.db.web.view;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.velocity.VelocityView;

public class VelocityViewEx extends VelocityView{
    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";
    
    protected void applyContentType(HttpServletResponse response)   {
        if (response.getContentType() == null) {
            response.setContentType(DEFAULT_CONTENT_TYPE);
        }
    }
    
    

}
