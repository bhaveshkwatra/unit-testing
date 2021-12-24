package com.nagarro.nagp.assignment.unit.testing.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.nagarro.nagp.assignment.unit.testing.dto.EquityDto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EquityRepositoryTest {

	@Autowired
	private EquityRepository equityRepository;
	
	@Test
	@DisplayName("Test for saving the equity entity")
	public void testSaveEquity() {
		EquityDto equity = new EquityDto();
		equity.setId(1L);
		equity.setName("Share1");
		equity.setPrice(BigDecimal.valueOf(10.23));
		equity.setQuantity(1);
		
		equityRepository.save(equity);
		
		Optional<EquityDto> equityDto = equityRepository.findById(equity.getId());
		
		assertFalse(equityDto.isEmpty());
		assertEquals(equity.getId(), equityDto.get().getId());
		assertEquals(equity.getName(), equityDto.get().getName());
		assertEquals(equity.getPrice(), equityDto.get().getPrice());
		assertEquals(equity.getQuantity(), equityDto.get().getQuantity());
	}
	
	@Test
	@DisplayName("Test for deleting te equity entity")
	public void testDeleteEntity() {
		EquityDto equity = new EquityDto();
		equity.setId(1L);
		equity.setName("Share1");
		equity.setPrice(BigDecimal.valueOf(10.23));
		equity.setQuantity(1);
		
		equityRepository.save(equity);
		
		// Deleting the entity
		equityRepository.delete(equity);
		
		Optional<EquityDto> equityDto = equityRepository.findById(equity.getId());
		
		assertTrue(equityDto.isEmpty());
	}
	
	@Test
	@DisplayName("Test for deleting the updating entity")
	public void testUpdateEntity() {
		EquityDto equity = new EquityDto();
		equity.setId(1L);
		equity.setName("Share1");
		equity.setPrice(BigDecimal.valueOf(10.23));
		equity.setQuantity(1);
		
		equityRepository.save(equity);
		
		Optional<EquityDto> equityDto = equityRepository.findById(equity.getId());
		
		assertFalse(equityDto.isEmpty());
		assertEquals(equity.getId(), equityDto.get().getId());
		assertEquals(equity.getName(), equityDto.get().getName());
		assertEquals(equity.getQuantity(), equityDto.get().getQuantity());
		
		//updating the entity
		EquityDto updatedDto = equityDto.get();
		updatedDto.setName("Share2");
		updatedDto.setQuantity(2);
		
		equityRepository.save(updatedDto);
		
		equityDto = equityRepository.findById(equity.getId());
		
		assertFalse(equityDto.isEmpty());
		assertEquals(updatedDto.getName(), equityDto.get().getName());
		assertEquals(updatedDto.getId(), equityDto.get().getId());
		assertEquals(updatedDto.getQuantity(), equityDto.get().getQuantity());
		
	}
	
	
}
