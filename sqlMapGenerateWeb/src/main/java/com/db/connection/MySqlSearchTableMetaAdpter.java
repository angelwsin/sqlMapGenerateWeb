package com.db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.db.db.table.TableColum;
import com.db.utils.StringUtils;
import com.google.common.collect.Lists;

public class MySqlSearchTableMetaAdpter extends SearchTableMetaAdpter{

	 private  final static String SELECT="select column_name ,data_type,column_comment  from information_schema.columns where table_name =?  and table_schema =?";
	public List<TableColum> getTableMeta(final String tableName,final Properties prop) {
		 return   executor.query(new DBService<List<TableColum>>() {

				public List<TableColum> execute(Connection conn) {
					try {
			      PreparedStatement st =  	conn.prepareStatement(SELECT);
			        st.setString(1,tableName);
			       String url = prop.getProperty(Const.DBURL);
			        int start =  url.lastIndexOf('/');
			        int end  =   url.indexOf('?');
			        String  table_schema = url.substring(start+1);
			        if(end>0){
			        	table_schema = url.substring(start+1, end);
			        }
			         st.setString(2,table_schema );
			         ResultSet result =  st.executeQuery();
			         List<TableColum> colums = Lists.newArrayList();
			         while(result.next()){
			             TableColum colum = new TableColum();
			             colum.setColumnName(StringUtils.getTableColField(String.valueOf(result.getObject("column_name"))));
			             colum.setDataType( TypeMapRegistry.getTypeByJdbcType(String.valueOf(result.getObject("data_type"))));
			             colum.setColumnComment(String.valueOf(result.getObject("column_comment")));
			             colum.setBool(Boolean.class.getSimpleName().equals(colum.getDataType()));
			             colum.setMethodName(StringUtils.getTableNameClass(String.valueOf(result.getObject("column_name"))));
			             colums.add(colum);
			         }
			        return colums;
					} catch (SQLException e) {
					    
						e.printStackTrace();
						
					}
					return null;
				}
			});
		
	}
	

}
