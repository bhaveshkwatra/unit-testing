package com.nagarro.nagp.assignment.unit.testing.service;

public interface EquityService {
	
	public void buyEquity(Long equityId, Long traderId, Integer quantity);
	public void sellEquity(Long equity, Long traderId, Integer quantity);

}
