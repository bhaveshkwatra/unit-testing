package com.nagarro.nagp.assignment.unit.testing.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.nagp.assignment.unit.testing.dto.EquityTraderDto;

public interface EquityTraderRepository extends CrudRepository<EquityTraderDto, Long> {
	
	Optional<EquityTraderDto> findByTraderIdAndEquityId(Long traderId, Long EquityId);

}
