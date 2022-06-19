package com.zensar.springcoupenproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
