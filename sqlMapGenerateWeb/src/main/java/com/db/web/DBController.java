package com.db.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.connection.Const;
import com.db.connection.DBExecutorImp;
import com.db.connection.SearchTableMetaAdpter;
import com.db.db.table.TableColum;
import com.db.web.vo.DBConfig;


@Controller
public class DBController {
    
    private static Logger log = LoggerFactory.getLogger(DBController.class); 
    
    @Autowired
    private SearchTableMetaAdpter searchTableMetaAdpter;
    
    @RequestMapping(value="/db/Config",method={RequestMethod.POST})
    public String   dbConfig(HttpServletRequest request,DBConfig dbConfig){
        log.info(dbConfig.getUrl());
        DBExecutorImp.replaceProps(Const.USERNAME, dbConfig.getUsername());
        DBExecutorImp.replaceProps(Const.PASSWORD, dbConfig.getPassword());
        DBExecutorImp.replaceProps(Const.DBURL, dbConfig.getUrl());
        
        return "searchTable";
    }
    
    @RequestMapping(value="/db/searchTable.json",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public void   searchTable(HttpServletRequest request,ModelMap model){
        log.info("table "+request.getParameter("table"));
        List<TableColum> tables = searchTableMetaAdpter.getTableMeta(request.getParameter("table"), DBExecutorImp.prop);
        model.put("tables", tables);
    }

}
