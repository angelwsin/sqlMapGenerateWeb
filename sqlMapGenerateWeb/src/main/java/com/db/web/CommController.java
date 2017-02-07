package com.db.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CommController {
    private static Logger log = LoggerFactory.getLogger(CommController.class); 
    
    @RequestMapping(value="/{name}",method={RequestMethod.GET})
    public String  dispatcher(@PathVariable("name")String name){
          String sp = name.replace('_', '/');
          log.info(" path :"+sp);
        return sp;
    }

}
