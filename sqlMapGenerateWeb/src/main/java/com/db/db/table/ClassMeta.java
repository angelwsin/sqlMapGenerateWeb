package com.db.db.table;

import java.util.ArrayList;
import java.util.List;

public class ClassMeta {

    
    private String packageName;
    private List<String> importList = new ArrayList<String>();
    private String       className;
    private String       supserName;
    private List<String>       implemtList = new ArrayList<String>();
    private List<TableColum>   fieldList = new ArrayList<TableColum>();
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public List<String> getImportList() {
        return importList;
    }
    public void setImportList(List<String> importList) {
        this.importList = importList;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getSupserName() {
        return supserName;
    }
    public void setSupserName(String supserName) {
        this.supserName = supserName;
    }
    public List<String> getImplemtList() {
        return implemtList;
    }
    public void setImplemtList(List<String> implemtList) {
        this.implemtList = implemtList;
    }
    public List<TableColum> getFieldList() {
        return fieldList;
    }
    public void setFieldList(List<TableColum> fieldList) {
        this.fieldList = fieldList;
    }
    
    public List<String> addImport(String pak) {
          importList.add(pak);
        return importList;
    }
    
    
}
