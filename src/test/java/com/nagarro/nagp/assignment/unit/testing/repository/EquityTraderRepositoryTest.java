package com.nagarro.nagp.assignment.unit.testing.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.nagarro.nagp.assignment.unit.testing.dto.EquityDto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EquityTraderRepositoryTest {
	
//	@Autowired
//	private EquityTraderRepository;
//	
//	public void testSaveEquity() {
//		EquityDto equity = new EquityDto();
//		equity.setId(1L);
//		equity.setName("Share1");
//		equity.setPrice(BigDecimal.valueOf(10.23));
//		equity.setQuantity(1);
//		
//		
//	}

}
