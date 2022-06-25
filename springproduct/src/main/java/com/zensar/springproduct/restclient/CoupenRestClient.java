package com.zensar.springproduct.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.springproduct.dto.CoupenDto;

@FeignClient("COUPEN-SERVICE")
public interface CoupenRestClient {
	
	@GetMapping("/coupens/{coupenCode}")
	CoupenDto getCoupen(@PathVariable("coupenCode")String coupenCode);

}
