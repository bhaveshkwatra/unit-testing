package com.nagarro.nagp.assignment.unit.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.assignment.unit.testing.representation.EquityRto;
import com.nagarro.nagp.assignment.unit.testing.service.EquityService;

@RestController
@RequestMapping("/equity")
public class EquityController {
	
	@Autowired
	private EquityService equityService;
	
	@PostMapping("/buy")
	public ResponseEntity<EquityRto> buyEquity(@RequestBody EquityRto equityRto) {
		equityService.buyEquity(equityRto.getEquityId(), equityRto.getTraderId(), equityRto.getQuantity());
		return ResponseEntity.ok(equityRto);
	}
	
	@PostMapping("/sell")
	public ResponseEntity<EquityRto> sellEquity(@RequestBody EquityRto equityRto) {
		equityService.sellEquity(equityRto.getEquityId(), equityRto.getTraderId(), equityRto.getQuantity());
		return ResponseEntity.ok(equityRto);
	}

}
