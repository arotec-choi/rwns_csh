package com.csh.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csh.dao.testDAO;
import com.csh.vo.testVO;

@Repository
public class testDaoImpl implements testDAO {

	@Autowired
	@Resource(name="sqlSession")
	SqlSession sqlsession;
	
	private static final String namespace = "com.arotec.mapper.testMapper";
	
	@Override
	public List<testVO> getList(){
		return sqlsession.selectList(namespace + ".selectTest");
	}

	@Override
	public String updateList(Map<String, Object> map) {
		
		String st = "true";
		
		try {
			
				sqlsession.update(namespace + ".updateTest", map);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
			st = "false";
		}
			
		return st;
	}

}
