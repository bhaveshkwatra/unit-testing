package com.nagarro.nagp.assignment.unit.testing.representation;

import javax.validation.constraints.NotEmpty;

public class EquityRto {
	
	@NotEmpty(message="Please provide the Equity ID")
	private Long equityId;
	@NotEmpty(message="Please provide the Trader ID")
	private Long traderId;
	@NotEmpty(message="Please provide the Qunatity")
	private Integer quantity;
	
	public EquityRto(Long equityId, Long traderId, Integer quantity) {
		this.equityId = equityId;
		this.traderId = traderId;
		this.quantity = quantity;
	}

	public Long getEquityId() {
		return equityId;
	}
	public void setEquityId(Long equityId) {
		this.equityId = equityId;
	}
	public Long getTraderId() {
		return traderId;
	}
	public void setTraderId(Long traderId) {
		this.traderId = traderId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
