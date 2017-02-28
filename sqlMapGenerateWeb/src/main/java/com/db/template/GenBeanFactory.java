package com.db.template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.db.db.table.ClassMeta;
import com.db.db.table.SqlMapMeta;

public class GenBeanFactory {
    
    static{
        Properties prop = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/default.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            //logger.error("", e);
        }
        
        Velocity.init(prop);
    }
    
    public static void genBean(ClassMeta meta,VelocityContext  context,String outPath){
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/bean.vm");
        //
       File file =   new File(outPath+meta.getPackageName().replace(".", "/"));
       System.out.println(file.getAbsolutePath());
       if(!file.exists()){
           file.mkdir();
       }
       OutputStream out = null;
    try {
        File beanFile =  new File(file.getAbsolutePath()+File.separator+meta.getClassName()+".java");
        if(!beanFile.exists()){
            beanFile.createNewFile();
        }
        out = new FileOutputStream(beanFile);
        Writer w =  new OutputStreamWriter(out);
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
       // logger.error("", e);
    }
      
    }
    
    public static void genSqlMap(SqlMapMeta meta,VelocityContext  context,String outPath){
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/sqlMap.vm");
        //
       File file =   new File(outPath+"sqlMap");
       System.out.println(file.getAbsolutePath());
       if(!file.exists()){
           file.mkdir();
       }
       OutputStream out = null;
    try {
        File beanFile =  new File(file.getAbsolutePath()+File.separator+meta.getBeanName()+"-sqlMap.xml");
        if(!beanFile.exists()){
            beanFile.createNewFile();
        }
        out = new FileOutputStream(beanFile);
        Writer w =  new OutputStreamWriter(out);
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
       // logger.error("", e);
    }
      
    }
    
    public static void genMapper(SqlMapMeta meta,VelocityContext  context,String outPath){
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/mapper.vm");
        //
       File file =   new File(outPath+meta.getMapper().replace(".", "/"));
       System.out.println(file.getAbsolutePath());
       if(!file.exists()){
           file.mkdir();
       }
       OutputStream out = null;
    try {
        File beanFile =  new File(file.getAbsolutePath()+File.separator+meta.getBeanName()+"Mapper.java");
        if(!beanFile.exists()){
            beanFile.createNewFile();
        }
        out = new FileOutputStream(beanFile);
        Writer w =  new OutputStreamWriter(out);
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
       // logger.error("", e);
    }
      
    }

}
