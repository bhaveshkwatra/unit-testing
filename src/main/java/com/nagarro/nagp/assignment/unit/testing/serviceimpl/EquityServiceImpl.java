package com.nagarro.nagp.assignment.unit.testing.serviceimpl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.assignment.unit.testing.dto.EquityDto;
import com.nagarro.nagp.assignment.unit.testing.dto.EquityTraderDto;
import com.nagarro.nagp.assignment.unit.testing.dto.TraderDto;
import com.nagarro.nagp.assignment.unit.testing.repository.EquityRepository;
import com.nagarro.nagp.assignment.unit.testing.repository.EquityTraderRepository;
import com.nagarro.nagp.assignment.unit.testing.repository.TraderRepository;
import com.nagarro.nagp.assignment.unit.testing.service.EquityService;
import com.nagarro.nagp.assignment.unit.testing.utils.HelperUtils;

@Service
public class EquityServiceImpl implements EquityService {
	
	@Autowired
	private EquityRepository equityRepository;
	
	@Autowired
	private TraderRepository traderRepository;
	
	@Autowired
	private EquityTraderRepository equityTraderRepository;

	@Override
	public void buyEquity(Long equityId, Long traderId,Integer quantity) {
		if (HelperUtils.isBuySellValid()) {
			TraderDto trader = getTraderIfExist(traderId);
			
			EquityDto equity = getEquityIfPresent(equityId);
			
			if (equity.getQuantity() <= quantity) {
				throw new RuntimeException(String.format("Due to unavaiablity of equity funds for id: %s, you can't buy right now", equityId));
			}
			
			if (trader.getFunds().compareTo(equity.getPrice()) == 1) {
				BigDecimal updatedFunds = trader.getFunds().subtract((equity.getPrice()));
				trader.setFunds(updatedFunds);
				equity.setQuantity(equity.getQuantity() - quantity);
				traderRepository.save(trader);
			} else {
				throw new RuntimeException(String.format("Trader : %s does not have enough funds for buy equity: %s", traderId, equityId));
			}
		} else {
			throw new RuntimeException("Equity can be buy on Weekdays between 9 to 5 only");
		}
		
	}

	@Override
	public void sellEquity(Long equityId, Long traderId, Integer quantity) {
		if (HelperUtils.isBuySellValid()) {
			EquityDto equity = getEquityIfPresent(equityId);
			Optional<EquityTraderDto> equityTrader = equityTraderRepository.findByTraderIdAndEquityId(traderId,equityId);
			EquityTraderDto equityTraderDto = equityTrader.get();
			if (equityTrader.isEmpty()) {
				throw new RuntimeException(String.format("Equity Cannot be sell by traderid: %s"));
			}
			
			if (equityTraderDto.getQuantity() <= quantity) {
				throw new RuntimeException(String.format("Trader Id: %d cannot sell the equity id: %d for quantity %d", traderId, equityId, quantity));
			}
			
			equityTraderDto.setQuantity(equityTraderDto.getQuantity() - quantity);
			
			TraderDto trader = getTraderIfExist(traderId);
			trader.setFunds(trader.getFunds().add(equity.getPrice()));
			equity.setQuantity(equity.getQuantity() + quantity);
			
			equityRepository.save(equity);
			traderRepository.save(trader);
			equityTraderRepository.save(equityTraderDto);
		} else {
			throw new RuntimeException("Equity can be Sell on Weekdays between 9 to 5 only");
		}
		
	}
	
	private EquityDto getEquityIfPresent(Long equityId) {
		Optional<EquityDto> equity = equityRepository.findById(equityId);
		if (equity.isEmpty()) {
			throw new RuntimeException(String.format("Equity does not exist with id:%s", equityId));
		}
		return equity.get();	
	}
	
	private TraderDto getTraderIfExist(Long traderId) {
		Optional<TraderDto> trader = traderRepository.findById(traderId);
		if (trader.isEmpty()) {
			throw new RuntimeException(String.format("Trader does not exist with id:%s", traderId));
		}
		
		return trader.get();
	}

}
