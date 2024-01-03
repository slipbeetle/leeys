package com.org.leeys.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdpolicyDao {

     private SqlSessionFactory sqlSessionFactory = null;

     public AdpolicyDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
     }
     
     public List<Map<String, String>> sAdPolicyList(HashMap<String, Object> params) throws Exception{

        log.info("sAdPolicyList dao");
		SqlSession session = sqlSessionFactory.openSession(true);
        List<Map<String, String>> result = null;

        try {
            log.info("1 size : ");
            result = session.selectList("AdPolicyMapper.sAdPolicyList",params);
            log.info("2 size : "+result.size());
        } catch (Exception e) {

        } finally {
            session.close();;
        }

        return result;
    }

    public int iAdPolicy(HashMap<String, Object> params){
        SqlSession session = sqlSessionFactory.openSession(true);
        
        int result = 0;
        try {
            result = session.update("AdPolicyMapper.iAdPolicy",params);
        } catch (Exception e) {

        } finally {
            session.close();;
        }

        return result;
    }
}
