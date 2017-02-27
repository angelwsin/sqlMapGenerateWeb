package com.db.web.vo;

import java.util.List;

public class GenBean {
    
    
    private String        tableName;
    
    private List<ColInfo> colInfos;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColInfo> getColInfos() {
        return colInfos;
    }

    public void setColInfos(List<ColInfo> colInfos) {
        this.colInfos = colInfos;
    }
    
    
    
    

}
