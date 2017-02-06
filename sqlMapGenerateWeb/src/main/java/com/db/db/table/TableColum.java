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
				
				
	             
	             
	      
	             

}
