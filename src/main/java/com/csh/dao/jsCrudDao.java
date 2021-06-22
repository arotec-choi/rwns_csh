package com.csh.dao;



import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.stereotype.Repository;

import com.csh.vo.jsCrudVo;



@Repository
public interface jsCrudDao {
	
	public List<jsCrudVo> getAllSelect();
	public String jsUpdateSet(jsCrudVo jsVo);
	public String jsAdd(jsCrudVo jsVo);
	public String jsDel(jsCrudVo jsVo);
	

}
