package com.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.db.db.table.TableColum;
import com.db.utils.StringUtils;

public class DBExecutorImp implements DBExecutor{
	
	       public    static Properties prop = new Properties();
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
	

	public <T>T query(DBService<T> service) {
		                  Connection   connection   =null;
		                  try {	  
		  connection =  DriverManager.getConnection(prop.getProperty(Const.DBURL), prop.getProperty(Const.USERNAME), prop.getProperty(Const.PASSWORD));
		                         connection.setAutoCommit(false);
		                   T   result =  service.execute(connection);
		                        connection.commit();
		                        return result;
						} catch (RuntimeException  e) {
							e.printStackTrace();
							try {
								connection.rollback();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}catch (Exception e) {
							e.printStackTrace();
							try {
								connection.rollback();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}catch (Throwable e) {
							try {
								connection.rollback();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}finally {
							try {
								connection.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
		                  return null;
		                   
	}
	
	
	
	public static void  replaceProps(String key,Object value){
	    prop.put(key, value);
	}
	


	 public static void main(String[] args) {
		 SearchTableMetaAdpter sear = new MySqlSearchTableMetaAdpter();
		 System.out.println(StringUtils.getTableNameClass("user_user"));
		 List<TableColum> colums =  sear.getTableMeta("user", prop);
		
		 
	}
	

}
