package com.nagarro.nagp.assignment.unit.testing.serviceimpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.nagp.assignment.unit.testing.service.EquityService;

@SpringBootTest
public class EquityServiceTestImpl {
	
	@Autowired
	private EquityService equityService;
	
	@Test
	public void testService() {
		equityService.sellEquity(11L, 11L, 11);
	}

}
