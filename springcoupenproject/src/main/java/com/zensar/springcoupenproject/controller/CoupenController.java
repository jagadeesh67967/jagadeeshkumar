package com.zensar.springcoupenproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springcoupenproject.dto.CoupenDto;
import com.zensar.springcoupenproject.entity.CoupenEntity;
import com.zensar.springcoupenproject.service.CoupenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/coupen-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class CoupenController {

	@Autowired
	private CoupenService CoupenService;

	// @RequestMapping("/coupen/{coupenId}")
	@Operation(summary = "This is to fetch record by coupenId")
	@GetMapping(value = "/coupens/{coupenId}")
	public ResponseEntity<CoupenDto> getCoupen(@PathVariable("coupenId") int coupenId) {
		return new ResponseEntity<CoupenDto>(CoupenService.getCoupen(coupenId), HttpStatus.OK);

	}

	@GetMapping(value = "/coupens/coupencode/{coupenCode}")
	public ResponseEntity<List<CoupenDto>> findByCoupenCode(@PathVariable("coupenCode") String coupenCode) {
		return new ResponseEntity<List<CoupenDto>>(CoupenService.findByCoupenCode(coupenCode), HttpStatus.FOUND);
	}

	/*
	 * @GetMapping(value = "/coupens/coupencode/{coupenCode}") public
	 * ResponseEntity<List<CoupenDto>> test(@PathVariable("coupenCode") String
	 * coupenCode) { return new
	 * ResponseEntity<List<CoupenDto>>(CoupenService.test(coupenCode),
	 * HttpStatus.FOUND); }
	 */

	@GetMapping(value = "/coupens/{coupenCode}/{expDate}")
	public ResponseEntity<List<CoupenDto>> findByCoupenCodeAndExpDate(@PathVariable("coupenCode") String coupenCode,
			@PathVariable("expDate") String ExpDate) {
		return new ResponseEntity<List<CoupenDto>>(CoupenService.findByCoupenCodeAndExpDate(coupenCode, ExpDate),
				HttpStatus.FOUND);

	}

	/*
	 * @GetMapping(value = "/coupens/{coupenCode}/{expDate}") public
	 * ResponseEntity<List<CoupenDto>> test1(@PathVariable("coupenCode") String
	 * coupenCode,
	 * 
	 * @PathVariable("expDate") String ExpDate) { return new
	 * ResponseEntity<List<CoupenDto>>(CoupenService.test1(coupenCode, ExpDate),
	 * HttpStatus.FOUND);
	 * 
	 * }
	 */

	// @RequestMapping(value = "/coupens",method = RequestMethod.GET)
	@Operation(summary = "This is to get all the coupen records from database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched all records from database", content = {
					@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }) })
	@GetMapping(value = "/coupens")
	public ResponseEntity<List<CoupenDto>> getAllCoupens(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize,
			@RequestParam(value = "sortby", required = false, defaultValue = "coupenCode") String coupenCode,
			@RequestParam(value = "direction", required = false, defaultValue = "DESC") String coupen) {
		return new ResponseEntity<List<CoupenDto>>(CoupenService.getAllCoupens(pageNumber, pageSize), HttpStatus.FOUND);
	}

	// @RequestMapping(value="/coupens",method = RequestMethod.POST)
	@Operation(summary = "to insert the record into database")
	@PostMapping(value = "/coupens")
	public ResponseEntity<CoupenDto> insertCoupen(@RequestBody CoupenDto coupenDto) {
		return new ResponseEntity<CoupenDto>(CoupenService.insertCoupen(coupenDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/coupens/{coupenId}",method = RequestMethod.PUT)
	@Operation(summary = "This is to update record by coupenId")
	@PutMapping(value = "/coupens/{coupenId}")
	public ResponseEntity<String> updatedCoupen(@PathVariable("coupenId") int coupenId,
			@RequestBody CoupenDto coupenDto) {

		CoupenService.updatedCoupen(coupenId, coupenDto);

		return new ResponseEntity<String>("Sucessfully UPDATED", HttpStatus.OK);

	}

	// @RequestMapping(value = "/coupens/{coupenId}",method = RequestMethod.DELETE)
	@Operation(summary = "This is to delete record by coupenId from database")
	@DeleteMapping(value = "/coupens/{coupenId}")
	public ResponseEntity<String> deleteCoupen(@PathVariable("coupenId") int coupenId) {

		CoupenService.deleteCoupen(coupenId);

		return new ResponseEntity<String>("Sucessfully Deleted", HttpStatus.OK);

	}

}
