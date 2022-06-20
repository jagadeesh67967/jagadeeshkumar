package com.zensar.springcoupenproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.springcoupenproject.entity.CoupenEntity;

public interface CoupenRepository extends JpaRepository<CoupenEntity, Integer> {

	 List<CoupenEntity> findByCoupenCode(String CoupenCode);
	// @Query("from Coupen c where c.coupenCode=?1")
	//@Query(value = "select * from coupen where coupen_code=?1", nativeQuery = true)
	//List<CoupenEntity> test(String CoupenCode);

	 List<CoupenEntity> findByCoupenCodeAndExpDate(String CoupenCode,String ExpDate);
	// @Query("from Coupen c where c.coupenCode=?1 and c.expDate=?2")
	//@Query(value = "select * from coupen where coupen_code=?1 and exp_date=?2", nativeQuery = true)
	//List<CoupenEntity> test1(String CoupenCode, String ExpDate);

}
