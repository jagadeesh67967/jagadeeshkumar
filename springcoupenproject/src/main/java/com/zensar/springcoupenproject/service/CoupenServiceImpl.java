package com.zensar.springcoupenproject.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.springcoupenproject.dto.CoupenDto;
import com.zensar.springcoupenproject.entity.CoupenEntity;
import com.zensar.springcoupenproject.exception.CoupenExistsException;
import com.zensar.springcoupenproject.exception.NoSuchCoupenExistsException;
import com.zensar.springcoupenproject.repository.CoupenRepository;


@Service
public class CoupenServiceImpl implements CoupenService {


	@Autowired
	private CoupenRepository coupenRepository;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public CoupenDto getCoupen(int coupenId) {
		//CoupenEntity coupenEntity = coupenRepository.findById(coupenId).get();

		// CoupenDto dto=mapToDto(coupenEntity);
		CoupenEntity getCoupen = coupenRepository.findById(coupenId).orElse(null);
		if(getCoupen == null) {
			throw new NoSuchCoupenExistsException("Coupen doesn't exists");
		}
		return modelMapper.map(getCoupen, CoupenDto.class);

		// return dto;
	}

	@Override
	public List<CoupenDto> getAllCoupens(int pageNumber,int pageSize) {
		//List<CoupenEntity> listOfCoupens = coupenRepository.findAll();
		List<CoupenDto> listOfCoupenDto = new ArrayList<CoupenDto>();
		
		Page<CoupenEntity> findAll = coupenRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"coupenCode")));
		List<CoupenEntity> content = findAll.getContent();

		for (CoupenEntity coupenEntity : content) {
			// listOfCoupenDto.add(mapToDto(CoupenEntity));
			listOfCoupenDto.add(modelMapper.map(coupenEntity, CoupenDto.class));
		}

		return listOfCoupenDto;
	}

	@Override
	public CoupenDto insertCoupen(CoupenDto coupenDto) {
		// CoupenEntity coupen = mapToEntity(coupenDto);

		CoupenEntity coupen = modelMapper.map(coupenDto, CoupenEntity.class);
		
		CoupenEntity getCoupen = coupenRepository.findById(coupen.getCoupenId()).get();
		if(getCoupen == null) {

		CoupenEntity insertedCoupen = coupenRepository.save(coupen);
		

		// CoupenDto mapToDto=mapToDto(insertedCoupen);
		return modelMapper.map(insertedCoupen, CoupenDto.class);
		}
		else
			throw new CoupenExistsException("Coupen already exists");

		// return mapToDto;
	}

	@Override
	public CoupenDto updatedCoupen(int coupenId, CoupenDto coupenDto) {
		// CoupenEntity coupen = mapToEntity(coupenDto);
		CoupenEntity getCoupen = coupenRepository.findById(coupenId).orElse(null);
		if(getCoupen == null) {
			throw new NoSuchCoupenExistsException("Student doesnt exists");
		}
		CoupenEntity coupen = modelMapper.map(coupenDto, CoupenEntity.class);
		
		CoupenEntity updatedCoupen = coupenRepository.save(coupen);
		return modelMapper.map(updatedCoupen, CoupenDto.class);

	}

	@Override
	public void deleteCoupen(int coupenId) {
		CoupenEntity getCoupen = coupenRepository.findById(coupenId).orElse(null);
		if(getCoupen == null) {
			throw new NoSuchCoupenExistsException("Student doesnt exists");
		}
		coupenRepository.deleteById(coupenId);

	}

	@Override
	public List<CoupenDto> findByCoupenCode(String coupenCode) {
		List<CoupenDto> coupenDto = new ArrayList<>();
		List<CoupenEntity> coupens =(List<CoupenEntity>) coupenRepository.findByCoupenCode(coupenCode);
		 for(CoupenEntity coupen:coupens) coupenDto.add(modelMapper.map(coupen,CoupenDto.class));
		 return coupenDto;
	}

	/*
	 * @Override public List<CoupenDto> test(String coupenCode) { List<CoupenDto>
	 * coupenDto = new ArrayList<>(); List<CoupenEntity> coupens =
	 * (List<CoupenEntity>) coupenRepository.test(coupenCode); for(CoupenEntity
	 * coupen:coupens) coupenDto.add(modelMapper.map(coupen,CoupenDto.class));
	 * return coupenDto; }
	 */

	@Override
	public List<CoupenDto> findByCoupenCodeAndExpDate(String coupenCode, String ExpDate) {
		 List<CoupenDto> coupenDto = new ArrayList<>();
		 List<CoupenEntity> coupens = (List<CoupenEntity>) coupenRepository.findByCoupenCodeAndExpDate(coupenCode,ExpDate);
		 for(CoupenEntity coupen:coupens)coupenDto.add(modelMapper.map(coupen,CoupenDto.class));
		 return coupenDto;
	}

	/*
	 * @Override public List<CoupenDto> test1(String coupenCode, String ExpDate) {
	 * List<CoupenDto> coupenDto = new ArrayList<>(); List<CoupenEntity> coupens =
	 * (List<CoupenEntity>) coupenRepository.test1(coupenCode,ExpDate);
	 * for(CoupenEntity coupen:coupens)
	 * coupenDto.add(modelMapper.map(coupen,CoupenDto.class)); return coupenDto; }
	 */

	/*
	 * public CoupenDto mapToDto(Coupen coupen) {
	 * 
	 * CoupenDto dto=new CoupenDto(); dto.setCoupenId(coupen.getCoupenId());
	 * dto.setexpDate(student.getexpDate());
	 * dto.setCoupenCode(coupen.getCoupenCode());
	 * 
	 * return dto;
	 * 
	 * }
	 * 
	 * public Coupen mapToEntity(CoupenDto coupenDto) {
	 * 
	 * Coupen coupen=new Coupen(); coupen.setCoupenId(coupenDto.getCoupenId());
	 * coupen.setexpDate(coupenDto.getexpDate());
	 * coupen.setCoupenCode(coupenDto.getCoupenCode());
	 * 
	 * return coupen;
	 * 
	 * 
	 * }
	 */

}
