package com.db.db.table;

import java.util.ArrayList;
import java.util.List;

public class SqlMapMeta {
    
    private String mapper;
    
    
    private String beanName;
    
    private String beanClazz;
    
    private String tableName;
    
    private String parameter;
    
    private List<String> importList = new ArrayList<String>();

    public String getMapper() {
        return mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanClazz() {
        return beanClazz;
    }

    public void setBeanClazz(String beanClazz) {
        this.beanClazz = beanClazz;
    }

    public List<String> getImportList() {
        return importList;
    }

    public void setImportList(List<String> importList) {
        this.importList = importList;
    }
    
    public List<String> addImport(String pak) {
        importList.add(pak);
      return importList;
  }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    

}
