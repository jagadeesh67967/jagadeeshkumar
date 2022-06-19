package com.zensar.springcoupenproject.service;

import java.util.List;

import com.zensar.springcoupenproject.dto.CoupenDto;
import com.zensar.springcoupenproject.entity.CoupenEntity;

public interface CoupenService {

	public CoupenDto getCoupen(int coupenId);

	public List<CoupenDto> getAllCoupens();

	public CoupenDto insertCoupen(CoupenDto coupen);

	public void updatedCoupen(int coupenId, CoupenDto coupenDto);

	public void deleteCoupen(int coupenId);

	List<CoupenEntity> getByCoupenCode(String CoupenCode);

}
