package com.csh.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csh.dao.jqDao;
import com.csh.dao.jsCrudDao;
import com.csh.dao.testDAO;
import com.csh.vo.jqVO;
import com.csh.vo.jsCrudVo;
import com.csh.vo.testVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.sf.json.JSONArray;

/**
 * Handles requests for the application home page.
 */
@Controller
public class W2GridController {
	@Inject
	testDAO tdao;
	
	
	@RequestMapping(value = "/wuiView", method = RequestMethod.GET)
	public String wuiView(Locale locale, Model model){
		  
		return "/wuiView";
	}

	@RequestMapping(value = "/wuiViewdata", method = RequestMethod.POST)
	@ResponseBody //데이터만 받아옴
	public ResponseEntity<String> wuiView(HttpServletRequest req, HttpServletResponse res){
				
		List<testVO> list = tdao.getList(); // dao에서 VO로 리스트 데이터 넣어줌  
		
		Gson gson = new Gson(); 

		String result  = gson.toJson(list); // json형식으로 받아온 list를 String으로 받음 
	    
		HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	    return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);	    
	}
	
	
	@RequestMapping(value="/wuiEdit",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> wuiEdit(String list, HttpServletRequest req, HttpServletResponse res){

		Gson gson = new Gson();
		Map<String, Object> values = new HashMap<String, Object>(); 
		String map="야호";
		System.out.println("list ======="+list);
		try{
			ArrayList updatelist = gson.fromJson(list, ArrayList.class);
			
			System.out.println("updatelist :"+updatelist);
			System.out.println("size :"+updatelist.size());

			Map userMap = null;
			String recid = null;
			for (Object item : updatelist) { // 작업을 요청한 만큼 반복 작업(시작)
				userMap = (Map)item;
				System.out.println(userMap.get("FLOWMTR_ID") + "," + userMap.get("FMETE_FORM"));	
				recid = userMap.get("FLOWMTR_ID").toString();
				
		
			
			
			System.out.println("FLOWMTR_ID recid : "+recid);
						
			String col = "";
					
		
			
			String key = null;
			Object val = null;
			

			
			Iterator<String> keys = userMap.keySet().iterator();
            
			while (keys.hasNext()){
                 key = keys.next();
                 val = userMap.get(key);
                 if (!col.equals(""))col += ", ";
    					col += key + " = '" + val + "'";
               
                 
                 System.out.println("몇개야+++"+userMap.size()+"key===="+key+"value==="+val);
			}

			 values.put("COL", col);
			 values.put("FLOWMTR_ID", recid);
			
			
			System.out.println(values);
			
			map = tdao.updateList(values);
			System.out.println("values size========"+values.size());
			System.out.println("map to string===="+map.toString());
			}// 작업을 요청한 만큼 반복 작업(끝)
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String result  = gson.toJson(map);
		System.out.println("result==============="+result.toString());
	
	    HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	    return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);
	}
	

}
