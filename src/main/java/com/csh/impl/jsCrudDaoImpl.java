package com.csh.impl;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csh.dao.jsCrudDao;
import com.csh.exception.emptyException;
import com.csh.exception.outOfRangeException;
import com.csh.exception.typeException4;
import com.csh.exception.userException3;
import com.csh.vo.jsCrudVo;



@Repository
public class jsCrudDaoImpl implements jsCrudDao{
	
	@Autowired
	@Resource(name="sqlSession")
	SqlSession sqlsession;
	private static final String namespace = "com.arotec.mapper.jsCrudMapper";
	
	@Override
	public List<jsCrudVo> getAllSelect() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".getAllSelect");
	}

	@Override
	public String jsUpdateSet(jsCrudVo jsVo) {
		String str= "true";
		String msg ="";
		String pattern = "^[0-9]*$"; //숫자만
		String numberOne = Integer.toString(jsVo.getNUMBERONE());
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
		
/*		if(jsVo.getTEXTONE().isEmpty() || jsVo.getTEXTONE().length()>=21){
			
			throw new userException("다시 입력해주세요");
			//return str;
		}else if(jsVo.getTEXTTWO().isEmpty() || jsVo.getTEXTTWO().length()>11){
			throw new userException("다시 입력해주세요");
		}else if(jsVo.getNUMBERONE()<20 || jsVo.getNUMBERONE() ==0.0 || jsVo.getNUMBERONE()<0){
			throw new userException("다시 입력해주세요");
		}else if(jsVo.getNUMBERTWO()<10 || jsVo.getNUMBERTWO()<0){
			throw new userException("다시 입력해주세요");
		}else if(jsVo.getDATEONE()==null || jsVo.getDATEONE().equals(format1)){
			throw new userException("다시 입력해주세요");
		}*/
		
	try {
			if(jsVo.getTEXTONE().isEmpty()){	
				if(jsVo.getTEXTONE().length()>=21){
					throw new outOfRangeException("값의 범위를 초과");
				}				
				throw new emptyException("공백이 있음");

			}else if(jsVo.getTEXTTWO().isEmpty()){
				if(jsVo.getTEXTTWO().length()>11){
					throw new outOfRangeException("값의 범위를 초과");
				}
				throw new emptyException("공백이 있음");
			}else if(jsVo.getNUMBERONE()<20 ||  jsVo.getNUMBERONE()<0){
				if(jsVo.getNUMBERONE() ==0.0){
					throw new userException3("소수점 입력됨");
				}
				throw new emptyException("입력값 오류");
			}else if(jsVo.getNUMBERTWO()<10 || jsVo.getNUMBERTWO()<0){
				throw new outOfRangeException("입력값 범위 오류");
			}else if(jsVo.getDATEONE()==null){
				if(jsVo.getDATEONE().equals(format1)){
					throw new typeException4("타입이 다릅니다.");
				}
				throw new emptyException("공백이 있음");
			}else{
				// sqlsession.update(namespace+".jsUpdateSet", jsVo);
			}
			
		}catch(emptyException e){
			e.printStackTrace();
			System.out.println("emptyException 처리 루틴 : ");
			System.out.println(e+"발생");
			str ="false";
		}catch(outOfRangeException e){
			e.printStackTrace();
			System.out.println("outOfRangeException 처리 루틴 : ");
			System.out.println(e+"발생");
			str ="false";
		}catch(typeException4 e){
			e.printStackTrace();
			System.out.println("typeException4 처리 루틴 : ");
			System.out.println(e+"발생");
			str ="false";
		}catch(userException3 e){
			e.printStackTrace();
			System.out.println("userException3 처리 루틴 : ");
			System.out.println(e+"발생");
			str ="false";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("모든 예외 처리 루틴 : ");
			System.out.println(e+"발생");
			e.printStackTrace();
			str ="false";
		}
		
		
		return str;
	}

	@Override
	public String jsAdd(jsCrudVo jsVo) {
		// TODO Auto-generated method stub
	
		String str= "true";
		try {
			sqlsession.insert(namespace+".jsAdd", jsVo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			str ="false";
		}
		
		
		return str;
		
	}

	@Override
	public String jsDel(jsCrudVo jsVo) {
		// TODO Auto-generated method stub
	
		
		String str= "true";
		try {
			sqlsession.delete(namespace+".jsDel", jsVo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			str ="false";
		}
				
		return str;
	}
	
	
		
	

	
	
}
