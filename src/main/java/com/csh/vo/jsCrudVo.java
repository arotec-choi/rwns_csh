
package com.csh.vo;

import java.sql.Date;

public class jsCrudVo {
	
	private int NMB;
	private String TEXTONE;
	private String TEXTTWO;
	private int NUMBERONE;
	private double NUMBERTWO;
	private Date DATEONE;
	private String DATETWO;
	private String BOOLONE;
	private String BOOLTWO;
	
	
	
	
	@Override
	public String toString() {
		return "jsCrudVo [NMB=" + NMB + ", TEXTONE=" + TEXTONE + ", TEXTTWO=" + TEXTTWO + ", NUMBERONE=" + NUMBERONE
				+ ", NUMBERTWO=" + NUMBERTWO + ", DATEONE=" + DATEONE + ", DATETWO=" + DATETWO + ", BOOLONE=" + BOOLONE
				+ ", BOOLTWO=" + BOOLTWO + "]";
	}
	
	public int getNMB() {
		return NMB;
	}
	public void setNMB(int nMB) {
		NMB = nMB;
	}
	public String getTEXTONE() {
		return TEXTONE;
	}
	public void setTEXTONE(String tEXTONE) {
		TEXTONE = tEXTONE;
	}
	public String getTEXTTWO() {
		return TEXTTWO;
	}
	public void setTEXTTWO(String tEXTTWO) {
		TEXTTWO = tEXTTWO;
	}
	public int getNUMBERONE() {
		return NUMBERONE;
	}
	public void setNUMBERONE(int nUMBERONE) {
		NUMBERONE = nUMBERONE;
	}
	public double getNUMBERTWO() {
		return NUMBERTWO;
	}
	public void setNUMBERTWO(double nUMBERTWO) {
		NUMBERTWO = nUMBERTWO;
	}
	public Date getDATEONE() {
		return DATEONE;
	}
	public void setDATEONE(Date dATEONE) {
		DATEONE = dATEONE;
	}
	public String getDATETWO() {
		return DATETWO;
	}
	public void setDATETWO(String dATETWO) {
		DATETWO = dATETWO;
	}
	public String getBOOLONE() {
		return BOOLONE;
	}
	public void setBOOLONE(String bOOLONE) {
		BOOLONE = bOOLONE;
	}
	public String getBOOLTWO() {
		return BOOLTWO;
	}
	public void setBOOLTWO(String bOOLTWO) {
		BOOLTWO = bOOLTWO;
	}
	
	

	
	
	

}
