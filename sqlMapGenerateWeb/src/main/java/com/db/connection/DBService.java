package com.db.connection;

import java.sql.Connection;

public interface DBService<T> {
	
	public T  execute(Connection conn);

}
