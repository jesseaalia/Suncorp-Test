package com.cashman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashman.model.Denomination;

public interface DenominationRepository extends JpaRepository<Denomination, Integer>{
	
	

}
