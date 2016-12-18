package com.cashman.service;

import java.util.List;

import com.cashman.exception.DenominationNotFoundException;
import com.cashman.model.Denomination;

public interface DenominationService {
	
	public Denomination create(Denomination sp);
	public Denomination get(Integer id) throws DenominationNotFoundException;
	public List<Denomination> getAll();
	public String update(Denomination sp);
	public Denomination delete(Integer id);

}
