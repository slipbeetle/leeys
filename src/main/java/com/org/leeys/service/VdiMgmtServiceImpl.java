package com.org.leeys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.org.leeys.MysqlDbConnFactory;
import com.org.leeys.Dao.AdpolicyDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VdiMgmtServiceImpl implements VdiMgmtService{

    AdpolicyDao adpolicyDao = new  AdpolicyDao(MysqlDbConnFactory.getSqlSessionFactory());
    
    @Override
    public List<Map<String, String>>  getAdPolicyList(HashMap<String, Object> params)throws Exception{
        
        log.info("getAdPolicyList");
        List<Map<String, String>> AdPolicyList = adpolicyDao.sAdPolicyList(params);
        return AdPolicyList;
    }

    @Override
    public int setAdPolicy(HashMap<String, Object> params) {

        int result = adpolicyDao.iAdPolicy(params);

        return result;
    }
}
