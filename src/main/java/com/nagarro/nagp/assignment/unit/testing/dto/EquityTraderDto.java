package com.nagarro.nagp.assignment.unit.testing.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EQUITY_TRADER")
public class EquityTraderDto {
	
	private Long id;
	private Long equityId;
	private Long traderId;
	private Integer quantity;


	@Id
	@Column(name="EQUITY_TRADER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "EQUITY_ID", nullable = false)
	public Long getEquityId() {
		return equityId;
	}

	public void setEquityId(Long equityId) {
		this.equityId = equityId;
	}

	@Column(name = "TRADER_ID", nullable = false)
	public Long getTraderId() {
		return traderId;
	}
	
	public void setTraderId(Long traderId) {
		this.traderId = traderId;
	}
	
	@Column(name = "QUANTITY", nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
