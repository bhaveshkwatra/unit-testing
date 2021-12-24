package com.nagarro.nagp.assignment.unit.testing.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRADER")
public class TraderDto {
	
	private Long id;
	private String traderName;
	private BigDecimal funds;
	
	@Id
	@Column(name="TRADER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME", nullable = false)
	public String getTraderName() {
		return traderName;
	}
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}
	
	@Column(name = "FUNDS", precision=4, scale=2, nullable = false)
	public BigDecimal getFunds() {
		return funds;
	}
	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}
	

}
