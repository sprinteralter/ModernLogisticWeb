package com.rosteach.entities;

import javax.persistence.Entity;


public class NovusXML_insert {
	//EPRORDERSOUTINV_INSERT
	
		private java.sql.Date DOCDATE;
	    private Integer CLIENTID;
	    private Integer STOREID;
	    private String OUTCOMEINVOICEIDSSET;
	    private String comment;
	    private Integer BEEPRESLINKID;
	    private Integer BEEPRESSTOREID;
	    private java.sql.Date TERMDATE;
	    private Integer PAYTYPEID;
	    private String COMMENT1;
	    private String COMMENT2;
	    private Integer PRICETYPEID;
	    private Integer AGENTID;
	    private Integer AID;
	    private Float DISCOUNT;
	    private Float SPECDISCOUNT;
	    private Integer OK_PASSED;
	    
	    
		public java.sql.Date getDOCDATE() {
			return DOCDATE;
		}
		public void setDOCDATE(java.sql.Date dOCDATE) {
			DOCDATE = dOCDATE;
		}
		public Integer getCLIENTID() {
			return CLIENTID;
		}
		public void setCLIENTID(Integer cLIENTID) {
			CLIENTID = cLIENTID;
		}
		public Integer getSTOREID() {
			return STOREID;
		}
		public void setSTOREID(Integer sTOREID) {
			STOREID = sTOREID;
		}
		public String getOUTCOMEINVOICEIDSSET() {
			return OUTCOMEINVOICEIDSSET;
		}
		public void setOUTCOMEINVOICEIDSSET(String oUTCOMEINVOICEIDSSET) {
			OUTCOMEINVOICEIDSSET = oUTCOMEINVOICEIDSSET;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public Integer getBEEPRESLINKID() {
			return BEEPRESLINKID;
		}
		public void setBEEPRESLINKID(Integer bEEPRESLINKID) {
			BEEPRESLINKID = bEEPRESLINKID;
		}
		public Integer getBEEPRESSTOREID() {
			return BEEPRESSTOREID;
		}
		public void setBEEPRESSTOREID(Integer bEEPRESSTOREID) {
			BEEPRESSTOREID = bEEPRESSTOREID;
		}
		public java.sql.Date getTERMDATE() {
			return TERMDATE;
		}
		public void setTERMDATE(java.sql.Date tERMDATE) {
			TERMDATE = tERMDATE;
		}
		public Integer getPAYTYPEID() {
			return PAYTYPEID;
		}
		public void setPAYTYPEID(Integer pAYTYPEID) {
			PAYTYPEID = pAYTYPEID;
		}
		public String getCOMMENT1() {
			return COMMENT1;
		}
		public void setCOMMENT1(String cOMMENT1) {
			COMMENT1 = cOMMENT1;
		}
		public String getCOMMENT2() {
			return COMMENT2;
		}
		public void setCOMMENT2(String cOMMENT2) {
			COMMENT2 = cOMMENT2;
		}
		public Integer getPRICETYPEID() {
			return PRICETYPEID;
		}
		public void setPRICETYPEID(Integer pRICETYPEID) {
			PRICETYPEID = pRICETYPEID;
		}
		public Integer getAGENTID() {
			return AGENTID;
		}
		public void setAGENTID(Integer aGENTID) {
			AGENTID = aGENTID;
		}
		public Integer getAID() {
			return AID;
		}
		public void setAID(Integer aID) {
			AID = aID;
		}
		public Float getDISCOUNT() {
			return DISCOUNT;
		}
		public void setDISCOUNT(Float dISCOUNT) {
			DISCOUNT = dISCOUNT;
		}
		public Float getSPECDISCOUNT() {
			return SPECDISCOUNT;
		}
		public void setSPECDISCOUNT(Float sPECDISCOUNT) {
			SPECDISCOUNT = sPECDISCOUNT;
		}
		public Integer getOK_PASSED() {
			return OK_PASSED;
		}
		public void setOK_PASSED(Integer oK_PASSED) {
			OK_PASSED = oK_PASSED;
		}
}
