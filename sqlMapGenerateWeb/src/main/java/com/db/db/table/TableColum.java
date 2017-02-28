package com.db.db.table;

public class TableColum {
	           /**
	            *   字段名COLUMN_NAME
	            */
	             private String   columnName;
	             /**
	              * 字段的类型DATA_TYPE
	              */
	             
	             private String    dataType;
	             
	             /**
	              * 字段的描述COLUMN_COMMENT
	              */
	             private String  columnComment;
	             
	             private boolean isBool;
	             
	             private String methodName;
	             
	             private String tabDataType;
	             
	             private String column_key;

				public String getColumnName() {
					return columnName;
				}

				public void setColumnName(String columnName) {
					this.columnName = columnName;
				}

				public String getDataType() {
					return dataType;
				}

				public void setDataType(String dataType) {
					this.dataType = dataType;
				}

				public String getColumnComment() {
					return columnComment;
				}

				public void setColumnComment(String columnComment) {
					this.columnComment = columnComment;
				}

                public boolean isBool() {
                    return isBool;
                }

                public void setBool(boolean isBool) {
                    this.isBool = isBool;
                }

                public String getMethodName() {
                    return methodName;
                }

                public void setMethodName(String methodName) {
                    this.methodName = methodName;
                }

                public String getTabDataType() {
                    return tabDataType;
                }

                public void setTabDataType(String tabDataType) {
                    this.tabDataType = tabDataType;
                }

                public String getColumn_key() {
                    return column_key;
                }

                public void setColumn_key(String column_key) {
                    this.column_key = column_key;
                }
				
				
	             
	             
	      
	             

}
