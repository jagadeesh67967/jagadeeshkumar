package com.zensar.springcoupenproject.service;

import java.util.List;

import com.zensar.springcoupenproject.dto.CoupenDto;
import com.zensar.springcoupenproject.entity.CoupenEntity;

public interface CoupenService {

	public CoupenDto getCoupen(int coupenId);

	public List<CoupenDto> getAllCoupens(int pageNumber,int pageSize);

	public CoupenDto insertCoupen(CoupenDto coupen);

	public CoupenDto updatedCoupen(int coupenId, CoupenDto coupenDto);

	public void deleteCoupen(int coupenId);

	List<CoupenDto> findByCoupenCode(String CoupenCode);
	//List<CoupenDto> test(String CoupenCode);
	
	List<CoupenDto> findByCoupenCodeAndExpDate(String CoupenCode,String ExpDate);
	//List<CoupenDto> test1(String CoupenCode,String ExpDate);



}
