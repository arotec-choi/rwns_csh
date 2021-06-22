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
public class jqGridController {

	@Inject
	jqDao jqDao;

	
	@RequestMapping(value = "/jqgView", method = RequestMethod.GET)
	public String jqgView(Locale locale, Model model){
		  
		return "/jqgView";
	}
	
	@RequestMapping(value = "/jqgViewData", method = RequestMethod.POST)
	@ResponseBody //데이터만 받아옴
	public ResponseEntity<String> jqgView(HttpServletRequest req, HttpServletResponse res){
				
		
		List<jqVO> list = jqDao.getAllSelect(); // dao에서 VO로 리스트 데이터 넣어줌  
		
	
		System.out.println("jqgViewData+++++"+list);
		
		//Gson gson = new Gson(); 
		Gson gson = new GsonBuilder().setDateFormat( "yyyy-MM-dd").create(); //date형식 포맷

		String result  = gson.toJson(list); // json형식으로 받아온 list를 String으로 받음 
		System.out.println("gsontojson==========="+gson.toJson(list));
	    
		HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	    return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);	    
	}
	
	@RequestMapping(value="/jqDataSet",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> jqDataSet(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse res){

		Gson gson = new Gson();
	
		//ArrayList setList = gson.fromJson(param, ArrayList.class);
		System.out.println("param====="+param);
		param.remove("oper");
		String result = null;
		Map<String, Object> parmaMap=new HashMap();
		String key = null;
		Object val = null;
		Iterator<String> keys = param.keySet().iterator();
		String col = "";
		Object pkKey = param.get("id");
		System.out.println("pkKEy============"+pkKey);
		Object val1=param.get("jfac_code");
		
		while (keys.hasNext()){
			
             key = keys.next();
             val = param.get(key);
             //System.out.println("key : "+key+" val : "+val);
         
            
 /*           if (!col.equals(""))col += ", ";
            if((key.equals("input_de")&&val=="")||(key.equals("compet_de")&&val=="")||(key.equals("updt_de")&&val=="")){
            	col += key + " = null"; // ${COL}자리는 key=value데이터로 넘어감
            }else{
            	col += key + " = '" + val + "'";
				 parmaMap.put("COL",col); 
				 parmaMap.put("sngid", pkKey);
				 System.out.println("몇개야+++"+param.size()+"key===="+key+"value==="+val);
				 System.out.println(pkKey+"pkkey");               
				 System.out.println("자료형==="+key.getClass().getName());
				 System.out.println("parmaMap = "+parmaMap);
				 result= jqDao.dataSet(parmaMap);
            }*/
             //if(!val.equals("")) 
            	 //key + " = '" + val + "'";
         
        
        	   if((key.equals("input_de")&&val=="")||(key.equals("compet_de")&&val=="")||(key.equals("updt_de")&&val=="")){
              	 val ="null";
              	
               }else{          	 
            	   val = "'"+val+"'";
            	   
            	  
               }      
        	   parmaMap.put(key,val);  
        	   parmaMap.put("sngid","'"+pkKey+"'");
        	   result= jqDao.dataSet(parmaMap);   
        	   parmaMap.put("jfac_code","'"+val1+"'");
     	  
			/* System.out.println("몇개야+++"+param.size()+"key===="+key+"value==="+val);
			 System.out.println(pkKey+"pkkey");               
			 System.out.println("자료형==="+key.getClass().getName());
			 System.out.println("parmaMap = "+parmaMap);*/
			
				

		}
		
		
		
	    HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	
		return new ResponseEntity<String>(result,responseHeaders, HttpStatus.CREATED);
	}
	@RequestMapping(value="/jqCellDataSet",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> jqCellDataSet(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse res){

		Gson gson = new Gson();
	
		//ArrayList setList = gson.fromJson(param, ArrayList.class);
		System.out.println("param====="+param);
		param.remove("oper");
		String result = null;
		Map<String, Object> parmaMap=new HashMap();
		String key = null;
		Object val = null;
		Iterator<String> keys = param.keySet().iterator();
		String col = "";
		
		Object pkKey = param.get("id");
		System.out.println("pkKEy============"+pkKey);
		
		while (keys.hasNext()){
			
             key = keys.next();
             val = param.get(key);
             //System.out.println("key : "+key+" val : "+val);
         
            
           // if (!col.equals(""))col += ", ";
            if((key.equals("input_de")&&val=="")||(key.equals("compet_de")&&val=="")||(key.equals("updt_de")&&val=="")){
            	col += key + " = null"; // ${COL}자리는 key=value데이터로 넘어감
            }else if(key.equals("id")){
            	parmaMap.remove("id");
            }
            else{
            	col += key + " = '" + val + "'";
			
            }
         System.out.println("col값: "+col);    
       	 parmaMap.put("COL",col); 
		 parmaMap.put("sngid", "'"+pkKey+"'");
		 System.out.println("몇개야+++"+param.size()+"key===="+key+"value==="+val);
		 System.out.println(pkKey+"pkkey");               
		 System.out.println("자료형==="+key.getClass().getName());
		 System.out.println("parmaMap = "+parmaMap);
		 result= jqDao.dataCellSet(parmaMap);

		}
		
		
		
	    HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	
		return new ResponseEntity<String>(result,responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/dateDel",method=RequestMethod.POST)
	@ResponseBody
	public void dateDel(@RequestParam Map<String,Object> param, HttpServletRequest req, HttpServletResponse res){

		System.out.println("삭제다!");
		param.remove("oper");
		
		Map<String, Object> paramMap=new HashMap();
		String key = null;
		Object val = null;
		System.out.println("param=="+param);
		String str = param.get("id").toString();
		
		StringTokenizer tokens = new StringTokenizer(str,",");
		
		for( int i = 0; i<tokens.countTokens(); i++ ){ 
		    System.out.println(tokens.countTokens() ); 
		   // val = tokens.nextToken();
		    while (tokens.hasMoreElements()) {
		    	System.out.println("aaaa="+tokens.hasMoreElements());
				 val = (Object) tokens.nextElement();
				System.out.println("object==="+val);
				 paramMap.put("id","'"+val+"'");
				  System.out.println("paramMap"+paramMap);
				    jqDao.dateDel(paramMap);	 
			}
		    
		    		   
		}
		  		
	}
	
	
}
