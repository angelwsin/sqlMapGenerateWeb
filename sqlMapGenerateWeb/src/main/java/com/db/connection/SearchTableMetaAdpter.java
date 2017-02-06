package com.db.connection;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.type.TypeHandlerRegistry;

import com.db.db.table.TableColum;

public  abstract class SearchTableMetaAdpter {
	
	          protected  static DBExecutor  executor = new DBExecutorImp();
	          protected  static TypeHandlerRegistry typeHandlerReg = new TypeHandlerRegistry();
	
	        public abstract List<TableColum>      getTableMeta(String tableName,Properties prop);
	  
}
