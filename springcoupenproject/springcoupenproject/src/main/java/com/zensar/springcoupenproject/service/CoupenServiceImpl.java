package com.zensar.springcoupenproject.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springcoupenproject.dto.CoupenDto;
import com.zensar.springcoupenproject.entity.CoupenEntity;
import com.zensar.springcoupenproject.repository.CoupenRepository;

@Service
public class CoupenServiceImpl implements CoupenService {

	@Autowired
	private CoupenRepository coupenRepository;

	@Autowired
	private ModelMapper modelMapper;

	
	public CoupenDto getCoupen(int coupenId) {
		CoupenEntity coupenEntity = coupenRepository.findById(coupenId).get();
		
		// CoupenDto dto=mapToDto(coupenEntity);
		return modelMapper.map(coupenEntity, CoupenDto.class);

		// return dto;
	}


	public List<CoupenDto> getAllCoupens() {
		List<CoupenEntity> listOfCoupens = coupenRepository.findAll();
		List<CoupenDto> listOfStudentDto = new ArrayList<CoupenDto>();

		for (CoupenEntity coupenEntity : listOfCoupens) {
			// listOfCoupenDto.add(mapToDto(CoupenEntity));
			//listOfCoupenDto.add(modelMapper.map(coupenEntity, CoupenDto.class));
		}

		return null;
	}
	
	public CoupenDto insertCoupen(CoupenDto coupenDto) {
		// CoupenEntity coupen = mapToEntity(coupenDto);
	
		CoupenEntity coupen = modelMapper.map(coupenDto, CoupenEntity.class);

		CoupenEntity insertedCoupen = coupenRepository.save(coupen);

		// CoupenDto mapToDto=mapToDto(insertedCoupen);
		return modelMapper.map(insertedCoupen, CoupenDto.class);

		// return mapToDto;
	}
	
	public void updatedCoupen(int coupenId, CoupenDto coupenDto) {
		// CoupenEntity coupen = mapToEntity(coupenDto);
		CoupenEntity coupen = modelMapper.map(coupenDto, CoupenEntity.class);

		coupenRepository.save(coupen);

	}

	public void deleteCoupen(int coupenId) {
		coupenRepository.deleteById(coupenId);

	}

	public List<CoupenEntity> getByCoupenCode(String coupenCode) {
		return coupenRepository.getByCoupenCode(coupenCode);
	}

	

}
