package com.org.leeys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.org.leeys.service.VdiMgmtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class StartController{

    @Autowired
    private VdiMgmtService vdiMgmtService;

    @RequestMapping(value="/main.do", method=RequestMethod.GET)
    public String goMain() {
        return "main";
    }
    
    @RequestMapping(value = "/actor/actorList.do")
    public ModelAndView  adPolicyList (Model model, HttpSession session,HttpServletRequest req, HttpServletResponse res)throws Exception{

        log.info("/actor/actorList.do");
		ModelAndView mv = new ModelAndView("actorList");
		
		return mv;
	}


    @RequestMapping(value = "/actor/actorList.data")
    @ResponseBody
    public ModelAndView adPolicyListData(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> params)throws Exception{

        log.info("/actor/actorList.data");
		
		List<Map<String, String>> AdPolicyList  = vdiMgmtService.getAdPolicyList(params);
		

        log.info("AdPolicyList : "+AdPolicyList.size());

        // for (AdPolicyVo tmp : AdPolicyList) {
        //     log.info("First_name : "+tmp.getFirst_name());
        // }
        
        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("TB_USER1_LIST", AdPolicyList);

		return mav;
	}

}