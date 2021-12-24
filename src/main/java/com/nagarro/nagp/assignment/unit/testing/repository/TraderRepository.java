package com.nagarro.nagp.assignment.unit.testing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.assignment.unit.testing.dto.TraderDto;

@Repository
public interface TraderRepository extends CrudRepository<TraderDto, Long> {

}
