package com.db.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CommController {
    
    
    @RequestMapping(value="/{name}",method={RequestMethod.GET})
    public String  dispatcher(@PathVariable("name")String name){
        
        return name;
    }

}
