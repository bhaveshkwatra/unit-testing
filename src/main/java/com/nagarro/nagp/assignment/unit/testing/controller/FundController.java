package com.nagarro.nagp.assignment.unit.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.assignment.unit.testing.representation.FundRto;
import com.nagarro.nagp.assignment.unit.testing.service.TraderService;

@RestController
@RequestMapping("/funds")
public class FundController {
	
	@Autowired
	private TraderService traderService;
	
	@PostMapping("/add")
	public ResponseEntity<FundRto> addFunds(@RequestBody FundRto funds) {
		traderService.addFunds(funds.getTraderId(), funds.getFunds());
		return ResponseEntity.ok(funds); 
	}

}
