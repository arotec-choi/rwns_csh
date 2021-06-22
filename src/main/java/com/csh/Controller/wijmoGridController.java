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

import org.apache.ibatis.javassist.expr.NewArray;
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
public class wijmoGridController {

	@Inject
	jsCrudDao jsDao;
	
	@RequestMapping(value = "/jsCrud", method = RequestMethod.GET)
	public String jsCrud(Locale locale, Model model){
		
		return "/jsCrud";
	}
	
	@RequestMapping(value = "/jsCrudViwe", method = RequestMethod.GET)
	@ResponseBody //데이터만 받아옴
	public ResponseEntity<String> jsCrudViwe(HttpServletRequest request, HttpServletResponse response, Model model){
				
		System.out.println("야호~~~~");
		
		List<jsCrudVo> list = jsDao.getAllSelect(); // dao에서 VO로 리스트 데이터 넣어줌  
		
	
		System.out.println("jsCrudViwe+++++"+list);
		
		Gson gson = new GsonBuilder().setDateFormat( "yyyy-MM-dd").create(); //date형식 포맷
		//Gson gson = new GsonBuilder().setDateFormat( "yyyy-MM-dd").create(); //date형식 포맷

		String result  = gson.toJson(list); // json형식으로 받아온 list를 String으로 받음 
		System.out.println("gsontojson==========="+gson.toJson(list));
		
		
		
	    
		HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	    return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);	    
	}
	
	@RequestMapping(value = "/jsCrudDetail", method = RequestMethod.GET)
	public String jsCrudDetail(Locale locale, Model model){
		
		return "/jsCrudDetail";
	}
	
	@RequestMapping(value="/jsCrudUdate",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> jsCrudUdate(String list, HttpServletRequest req, HttpServletResponse res){

			System.out.println("업데이트~~~");
			System.out.println("업데이트리스트"+list);
			Gson gson = new GsonBuilder().setDateFormat("yy/MM/dd").create(); //date형식 포맷
			jsCrudVo jsVo= gson.fromJson(list, jsCrudVo.class);
			System.out.println("vo====="+jsVo);
					
			String result = jsDao.jsUpdateSet(jsVo);
	
		
		
	    HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	
		return new ResponseEntity<String>(result,responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/jsCrudAdd",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> jsCrudAdd(String list, HttpServletRequest req, HttpServletResponse res){

			System.out.println("추가~~~");
			System.out.println("추가~"+list);
			Gson gson = new GsonBuilder().setDateFormat("yy/MM/dd").create(); //date형식 포맷
			jsCrudVo jsVo= gson.fromJson(list, jsCrudVo.class);
			//System.out.println("vo====="+jsVo);
					
			String result = jsDao.jsAdd(jsVo);
	
		
		
	    HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
	    
	
		return new ResponseEntity<String>(result,responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/jsCrudDel",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> jsCrudDel(String list, HttpServletRequest req, HttpServletResponse res){

		System.out.println("삭제다!");
		System.out.println("삭제=="+list);
		Gson gson = new GsonBuilder().setDateFormat("yy/MM/dd").create();
		
		jsCrudVo jsVo = gson.fromJson(list, jsCrudVo.class);
		
		
		System.out.println(jsVo);
		
		
		String result = jsDao.jsDel(jsVo);
		
		  HttpHeaders responseHeaders = new HttpHeaders(); //HttpHeaders의 content-type을 html -> json으로 변환
		    
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		    responseHeaders.add("Access-Control-Allow-Origin", "*"); //임의의 origin으로부터의 요청을 허용
		    
		
			return new ResponseEntity<String>(result,responseHeaders, HttpStatus.CREATED);

		  		
	}
	
	@RequestMapping(value = "/reactCrud", method = RequestMethod.GET)
	public String reactCrud(Locale locale, Model model){
		
		return "/reactCrud";
	}
	
}
