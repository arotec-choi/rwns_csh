package com.csh.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.csh.vo.*;;
@Repository
public interface testDAO {

	public List<testVO> getList();
	public String updateList(Map<String, Object> map); 
}
