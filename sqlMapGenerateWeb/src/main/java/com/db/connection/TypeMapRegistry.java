package com.db.connection;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;

import com.mysql.fabric.xmlrpc.base.Array;

public class TypeMapRegistry {

    private final static Map<String, Type> TYPE_HANDLER_MAP = new HashMap<String,Type>();
    
    static{
      
        TYPE_HANDLER_MAP.put(JdbcType.BOOLEAN.name(), Boolean.class);
        TYPE_HANDLER_MAP.put(JdbcType.BIT.name(),Boolean.class);
        TYPE_HANDLER_MAP.put(JdbcType.TINYINT.name(), Byte.class);
        TYPE_HANDLER_MAP.put(JdbcType.SMALLINT.name(), Short.class);
        TYPE_HANDLER_MAP.put(JdbcType.INTEGER.name(), Integer.class);

        TYPE_HANDLER_MAP.put(JdbcType.FLOAT.name(), Float.class);

        TYPE_HANDLER_MAP.put(JdbcType.DOUBLE.name(), Double.class);

        TYPE_HANDLER_MAP.put(JdbcType.CHAR.name(), String.class);
        TYPE_HANDLER_MAP.put(JdbcType.VARCHAR.name(), String.class);
        TYPE_HANDLER_MAP.put(JdbcType.CLOB.name(), String.class);
        TYPE_HANDLER_MAP.put(JdbcType.LONGVARCHAR.name(), String.class);
        TYPE_HANDLER_MAP.put(JdbcType.NVARCHAR.name(),  String.class);
        TYPE_HANDLER_MAP.put(JdbcType.NCHAR.name(),  String.class);
        TYPE_HANDLER_MAP.put(JdbcType.NCLOB.name(),  String.class);
        TYPE_HANDLER_MAP.put(JdbcType.ARRAY.name(), Array.class);

        
        TYPE_HANDLER_MAP.put(JdbcType.BIGINT.name(), Long.class);

        
        TYPE_HANDLER_MAP.put(JdbcType.REAL.name(), BigDecimal.class);
        TYPE_HANDLER_MAP.put(JdbcType.DECIMAL.name(), BigDecimal.class);
        TYPE_HANDLER_MAP.put(JdbcType.NUMERIC.name(), BigDecimal.class);
        TYPE_HANDLER_MAP.put(JdbcType.LONGVARBINARY.name(), byte[].class);
        TYPE_HANDLER_MAP.put(JdbcType.BLOB.name(), byte[].class);
      
        TYPE_HANDLER_MAP.put(JdbcType.TIMESTAMP.name(), Date.class);
        TYPE_HANDLER_MAP.put(JdbcType.DATE.name(), Date.class);
        TYPE_HANDLER_MAP.put(JdbcType.TIME.name(), Date.class);

      
        
        
    }
    
    public static String getTypeByJdbcType(String type){
       Type t =  TYPE_HANDLER_MAP.get(type.toUpperCase()); 
       if(t==null){
           return type;
       }
       return ((Class<?>)t).getSimpleName();
    }
    
    
}
