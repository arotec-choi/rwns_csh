package com.csh.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csh.dao.jqDao;
import com.csh.vo.jqVO;


@Repository
public class jqDaoImpl implements jqDao {
	@Autowired
	@Resource(name="sqlSessionPg")
	private SqlSession sqlSessionPg;	
	private static final String namespace = "com.arotec.mapper.jqMapper";
	@Override
	public List<jqVO> getAllSelect() {
		
		return sqlSessionPg.selectList(namespace+".getAllSelect");
	
	}
	@Override
	public String dataSet(Map<String, Object> map) {
		// TODO Auto-generated method stub
	String st = "true";
		
		try {
			
				sqlSessionPg.update(namespace + ".dataSet", map);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
			st = "false";
		}
			
		return st;
	}
	@Override
	public String dataCellSet(Map<String, Object> map) {
	String st = "true";
		
		try {
			
				sqlSessionPg.update(namespace + ".dataCellSet", map);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
			st = "false";
		}
			
		return st;
	}
	@Override
	public void dateDel(Map<String,Object> id) {
		sqlSessionPg.delete(namespace+".dateDel",id);
		
	}
	
	
	

	
	
}
