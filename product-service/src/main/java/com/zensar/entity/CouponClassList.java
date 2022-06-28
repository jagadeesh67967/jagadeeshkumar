package com.zensar.entity;

import java.util.ArrayList;
import java.util.List;

public class CouponClassList {
	private List<Coupon> coupons;

	public CouponClassList() {
		super();
	}

	public CouponClassList(List<Coupon> coupons) {
		super();
		this.coupons = coupons;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "CouponClassList [coupons=" + coupons + "]";
	}

	
	

}
