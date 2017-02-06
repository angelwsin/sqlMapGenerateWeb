package com.db.db.table;

import java.util.List;

public class MapperConfig {
    
    
    private String beanPackage;
    
    private String mapperPackage;
    
    private String sqlMapPath;
    
    private String table;
    
    private List<TableColum>  tableColums;
    

    public String getBeanPackage() {
        return beanPackage;
    }

    public void setBeanPackage(String beanPackage) {
        this.beanPackage = beanPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getSqlMapPath() {
        return sqlMapPath;
    }

    public void setSqlMapPath(String sqlMapPath) {
        this.sqlMapPath = sqlMapPath;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<TableColum> getTableColums() {
        return tableColums;
    }

    public void setTableColums(List<TableColum> tableColums) {
        this.tableColums = tableColums;
    }
    
    

}
