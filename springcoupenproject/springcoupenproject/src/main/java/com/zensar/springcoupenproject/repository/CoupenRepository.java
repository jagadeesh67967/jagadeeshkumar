package com.zensar.springcoupenproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.springcoupenproject.entity.CoupenEntity;

public interface CoupenRepository extends JpaRepository<CoupenEntity, Integer>{
	
	List<CoupenEntity> getByCoupenCode(String CoupenCode);

}
