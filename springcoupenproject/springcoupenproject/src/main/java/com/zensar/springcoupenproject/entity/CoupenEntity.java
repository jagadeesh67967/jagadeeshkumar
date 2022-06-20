package com.zensar.springcoupenproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "Coupen.test", query = "from Coupen c where c.coupenCode=?1")
//@NamedQuery(name = "Coupen.test1", query = "from Coupen c where c.coupenCode=?1 and c.expDate=?2")

//@NamedNativeQuery(name = "Coupen.test", query = "select * from coupen where coupen_code=?1",resultClass = Coupen.class)
//@NamedNativeQuery(name = "Coupen.test", query = "select * from coupen where coupen_code=?1 and exp_date=?2",resultClass = Coupen.class)
public class CoupenEntity {
	
	@Id
	private int coupenId;
	private String expDate;
	private String coupenCode;

	public CoupenEntity() {
		super();
	}
	
	public CoupenEntity(int coupenId, String expDate, String coupenCode) {
		super();
		this.coupenId = coupenId;
		this.expDate = expDate;
		this.coupenCode = coupenCode;
	}

	public int getCoupenId() {
		return coupenId;
	}

	public void setCoupenId(int coupenId) {
		this.coupenId = coupenId;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCoupenCode() {
		return coupenCode;
	}

	public void setCoupenCode(String coupenCode) {
		this.coupenCode = coupenCode;
	}

	@Override
	public String toString() {
		return "CoupenEntity [coupenId=" + coupenId + ", expDate=" + expDate + ", coupenCode=" + coupenCode + "]";
	}
	
	

}
