package com.rosteach.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientRequest {
		
		@Id
		private int id;
		
		private java.sql.Date docdate;
		private int clientid;
		private String clientsname;
		private String clientname;
		private int storeid;
		private String storesname;
		private String storename;
		private String outcomeinvoiceidsset;
		private double endsumm;
		private double endsummwithoverh;
		private String comment;
		private double overhsumm;
		private Integer beepreslinkid;
	    private String beepresstore;
	    private java.sql.Timestamp beepressendtime;
	    private java.sql.Date termdate;
	    private Integer paytypeid;
	    private String paytypesname;
	    private String comment1;
	    private String comment2;
	    private String pricetypeid;
	    private String pricetypesname;
	    private String useredit;
	    private java.sql.Timestamp timeedit;
	    private int agentid;
	    private String agentsname;
	    private double itemssumm;
	    private Float discount;
	    private Float specdiscount;
	    private int ok_passed;
	    private String clientadresslocation;
	    private String profilesname;
	    
	    public ClientRequest(){
	    	
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public java.sql.Date getDocdate() {
			return docdate;
		}

		public void setDocdate(java.sql.Date docdate) {
			this.docdate = docdate;
		}

		public int getClientid() {
			return clientid;
		}

		public void setClientid(int clientid) {
			this.clientid = clientid;
		}

		public String getClientsname() {
			return clientsname;
		}

		public void setClientsname(String clientsname) {
			this.clientsname = clientsname;
		}

		public String getClientname() {
			return clientname;
		}

		public void setClientname(String clientname) {
			this.clientname = clientname;
		}

		public int getStoreid() {
			return storeid;
		}

		public void setStoreid(int storeid) {
			this.storeid = storeid;
		}

		public String getStoresname() {
			return storesname;
		}

		public void setStoresname(String storesname) {
			this.storesname = storesname;
		}

		public String getStorename() {
			return storename;
		}

		public void setStorename(String storename) {
			this.storename = storename;
		}

		public String getOutcomeinvoiceidsset() {
			return outcomeinvoiceidsset;
		}

		public void setOutcomeinvoiceidsset(String outcomeinvoiceidsset) {
			this.outcomeinvoiceidsset = outcomeinvoiceidsset;
		}

		public double getEndsumm() {
			return endsumm;
		}

		public void setEndsumm(double endsumm) {
			this.endsumm = endsumm;
		}

		public double getEndsummwithoverh() {
			return endsummwithoverh;
		}

		public void setEndsummwithoverh(double endsummwithoverh) {
			this.endsummwithoverh = endsummwithoverh;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public double getOverhsumm() {
			return overhsumm;
		}

		public void setOverhsumm(double overhsumm) {
			this.overhsumm = overhsumm;
		}

		public Integer getBeepreslinkid() {
			return beepreslinkid;
		}

		public void setBeepreslinkid(Integer beepreslinkid) {
			this.beepreslinkid = beepreslinkid;
		}

		public String getBeepresstore() {
			return beepresstore;
		}

		public void setBeepresstore(String beepresstore) {
			this.beepresstore = beepresstore;
		}

		public java.sql.Timestamp getBeepressendtime() {
			return beepressendtime;
		}

		public void setBeepressendtime(java.sql.Timestamp beepressendtime) {
			this.beepressendtime = beepressendtime;
		}

		public java.sql.Date getTermdate() {
			return termdate;
		}

		public void setTermdate(java.sql.Date termdate) {
			this.termdate = termdate;
		}

		public Integer getPaytypeid() {
			return paytypeid;
		}

		public void setPaytypeid(Integer paytypeid) {
			this.paytypeid = paytypeid;
		}

		public String getPaytypesname() {
			return paytypesname;
		}

		public void setPaytypesname(String paytypesname) {
			this.paytypesname = paytypesname;
		}

		public String getComment1() {
			return comment1;
		}

		public void setComment1(String comment1) {
			this.comment1 = comment1;
		}

		public String getComment2() {
			return comment2;
		}

		public void setComment2(String comment2) {
			this.comment2 = comment2;
		}

		public String getPricetypeid() {
			return pricetypeid;
		}

		public void setPricetypeid(String pricetypeid) {
			this.pricetypeid = pricetypeid;
		}

		public String getPricetypesname() {
			return pricetypesname;
		}

		public void setPricetypesname(String pricetypesname) {
			this.pricetypesname = pricetypesname;
		}

		public String getUseredit() {
			return useredit;
		}

		public void setUseredit(String useredit) {
			this.useredit = useredit;
		}

		public java.sql.Timestamp getTimeedit() {
			return timeedit;
		}

		public void setTimeedit(java.sql.Timestamp timeedit) {
			this.timeedit = timeedit;
		}

		public int getAgentid() {
			return agentid;
		}

		public void setAgentid(int agentid) {
			this.agentid = agentid;
		}

		public String getAgentsname() {
			return agentsname;
		}

		public void setAgentsname(String agentsname) {
			this.agentsname = agentsname;
		}

		public double getItemssumm() {
			return itemssumm;
		}

		public void setItemssumm(double itemssumm) {
			this.itemssumm = itemssumm;
		}

		public Float getDiscount() {
			return discount;
		}

		public void setDiscount(Float discount) {
			this.discount = discount;
		}

		public Float getSpecdiscount() {
			return specdiscount;
		}

		public void setSpecdiscount(Float specdiscount) {
			this.specdiscount = specdiscount;
		}

		public int getOk_passed() {
			return ok_passed;
		}

		public void setOk_passed(int ok_passed) {
			this.ok_passed = ok_passed;
		}

		public String getClientadresslocation() {
			return clientadresslocation;
		}

		public void setClientadresslocation(String clientadresslocation) {
			this.clientadresslocation = clientadresslocation;
		}

		public String getProfilesname() {
			return profilesname;
		}

		public void setProfilesname(String profilesname) {
			this.profilesname = profilesname;
		}
}
