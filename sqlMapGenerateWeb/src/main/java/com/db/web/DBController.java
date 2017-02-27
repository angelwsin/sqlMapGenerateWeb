package com.db.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.db.connection.ClassMeatFactory;
import com.db.connection.Const;
import com.db.connection.DBExecutorImp;
import com.db.connection.MySqlSearchTableMetaAdpter;
import com.db.connection.SearchTableMetaAdpter;
import com.db.db.table.ClassMeta;
import com.db.db.table.TableColum;
import com.db.template.GenBeanFactory;
import com.db.utils.StringUtils;
import com.db.web.vo.ColInfo;
import com.db.web.vo.DBConfig;
import com.db.web.vo.GenBean;


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
    
    @RequestMapping(value="/db/searchTable",method={RequestMethod.POST,RequestMethod.GET})
    public String   searchTable(HttpServletRequest request,ModelMap map){
        log.info("table "+request.getParameter("table"));
        List<TableColum> tables = searchTableMetaAdpter.getTableMeta(request.getParameter("table"), DBExecutorImp.prop);
        map.put("tables", tables);
        map.put("table", request.getParameter("table"));
        return "searchTable";
    }
   
    @RequestMapping(value="/db/javaBean.json",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String  javaBean(HttpServletRequest request){
        String colNames = request.getParameter("colNames");
        String tableName = request.getParameter("tableName");
        log.info("colNames "+colNames);
        GenBean beans = new GenBean();
        beans.setTableName(tableName);
        beans.setColInfos(JSONObject.parseArray(colNames, ColInfo.class));
        List<TableColum> tables = searchTableMetaAdpter.getTableMeta(beans.getTableName(), DBExecutorImp.prop);
        for(TableColum col :tables){
            for(ColInfo info :beans.getColInfos()){
                if(col.getColumnName().equals(info.getColName())){
                   //填充其他信息
                }
            }
        }
        ClassMeta  meta = new ClassMeta();
        meta.setClassName(StringUtils.getTableNameClass(beans.getTableName()));
        meta.setFieldList(tables);
        meta.setPackageName("com.db.bean");
        VelocityContext  context = new VelocityContext();
        context.put("classMeta", meta);
        GenBeanFactory.genBean(meta, context, "d://bean//");
        return "";
    }

}
