package com.csh.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.csh.vo.jqVO;

@Repository
public interface jqDao  {
	
	public List<jqVO> getAllSelect();
	public String dataSet(Map<String, Object> map); 
	public String dataCellSet(Map<String, Object> map); 
	public void dateDel(Map<String,Object> id);

}
