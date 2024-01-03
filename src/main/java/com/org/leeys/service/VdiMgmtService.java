package com.org.leeys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface VdiMgmtService {

    public List<Map<String, String>> getAdPolicyList(HashMap<String, Object> params) throws Exception;

    public int setAdPolicy(HashMap<String, Object> params);
    
}
