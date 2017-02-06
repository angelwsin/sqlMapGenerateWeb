package com.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.db.db.table.ClassMeta;
import com.db.utils.StringUtils;

public class ClassMeatFactory {

    
    public   static Properties prop = new Properties();
    static{
            InputStream is =    null;
            try {
              is =   Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/db.properties");
              prop.load(is);
              Class.forName(prop.getProperty(Const.DRIVER));
         } catch (Exception e) {
             throw new RuntimeException("配置错误");
         }finally {
             if(null!=is){
                 try {
                     is.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
    }
    
    private SearchTableMetaAdpter searchTableMetaAdpter;

    public ClassMeatFactory(SearchTableMetaAdpter searchTableMetaAdpter) {
        this.searchTableMetaAdpter = searchTableMetaAdpter;
    }
    
    public  ClassMeta  getClassMeta(String tableName){
        ClassMeta  meta = new ClassMeta();
        meta.setClassName(StringUtils.getTableNameClass(tableName));
        meta.setFieldList(searchTableMetaAdpter.getTableMeta(tableName, prop));
        meta.setPackageName("com.db.bean");
        return meta;
    }
    
    
}
