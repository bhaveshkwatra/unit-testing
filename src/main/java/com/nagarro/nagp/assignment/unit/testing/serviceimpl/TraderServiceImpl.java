package com.nagarro.nagp.assignment.unit.testing.serviceimpl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.assignment.unit.testing.dto.TraderDto;
import com.nagarro.nagp.assignment.unit.testing.repository.TraderRepository;
import com.nagarro.nagp.assignment.unit.testing.service.TraderService;

@Service
public class TraderServiceImpl implements TraderService {
	
	@Autowired
	private TraderRepository traderRepository;

	@Override
	public void addFunds(Long traderId, BigDecimal funds) {
		Optional<TraderDto> traderDto = traderRepository.findById(traderId);
		if (traderDto.isEmpty()) {
			throw new RuntimeException("Trader not found");
		}
		
		TraderDto dto = traderDto.get();
		dto.setFunds(dto.getFunds().add(funds));
		traderRepository.save(dto);
	}

}
