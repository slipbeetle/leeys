package com.org.leeys;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MysqlDbConnFactory {
    
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try{
            String resource = "MysqlMapClientManager.xml";
            Reader reader = Resources.getResourceAsReader(resource); 
			if(sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
            
            log.info("create my sql gogo~~~~~");
                
            reader.close();

        }catch (Exception e){
           e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
