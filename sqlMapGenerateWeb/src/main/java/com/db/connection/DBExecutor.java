package com.db.connection;

public interface DBExecutor {
	
	
	public <T>T    query(DBService<T> service);

}
