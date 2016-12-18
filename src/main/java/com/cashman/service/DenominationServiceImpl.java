package com.cashman.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cashman.enumeration.Note;
import com.cashman.exception.DenominationNotFoundException;
import com.cashman.interfaces.Money.Money;
import com.cashman.model.Denomination;
import com.cashman.repository.DenominationRepository;
import com.cashman.util.DenominationUtil;

@Service
@Transactional(rollbackFor = { DenominationNotFoundException.class })
public class DenominationServiceImpl implements DenominationService {

	@Autowired
	private DenominationRepository denominationRepository;

	@Override
	public Denomination create(Denomination denom) {
		Map<Money, Integer> count = new HashMap<Money, Integer>();
		count.put(Note.HUNDRED, denom.getHundredNotes());
		count.put(Note.FIFTY, denom.getFiftyNotes());
		count.put(Note.TWENTY, denom.getTwentyNotes());
		denom.setAvailablecash(DenominationUtil.getTotal(count));
		Denomination denomination =get(1);
		denomination.setHundredNotes(denom.getHundredNotes());
		denomination.setFiftyNotes(denom.getFiftyNotes());
		denomination.setTwentyNotes(denom.getTwentyNotes());
		denomination.setAvailablecash(DenominationUtil.getTotal(count));
		return denominationRepository.saveAndFlush(denomination);
	}

	@Override
	public Denomination get(Integer id) {
		Denomination denom = null;
		if (id instanceof Integer)
			denom = denominationRepository.findOne(1);
		if (denom != null)
			return denom;
		throw new DenominationNotFoundException(id);
	}

	@Override
	public List<Denomination> getAll() {
		return denominationRepository.findAll();
	}

	@Override
	public String update(Denomination denom) {
		String result = "";
		Denomination denomination = get(1);
		Map<Money, Integer> count = new HashMap<Money, Integer>();
		count.put(Note.HUNDRED, denomination.getHundredNotes());
		count.put(Note.FIFTY, denomination.getFiftyNotes());
		count.put(Note.TWENTY, denomination.getTwentyNotes());
		try {
			Map<Money, Integer> toWithdraw = DenominationUtil
					.calculateWithdraw(denom.getWithdrawcash(), count);

			 
			if (!DenominationUtil.fundsAvailable(toWithdraw, count)|| DenominationUtil.getTotalCount(count) < 1) {
				return "Insufficient funds to make withdrawal ";

			} else if (DenominationUtil.getTotal(toWithdraw).compareTo(
					denom.getWithdrawcash()) != 0) {
				return "Cannot WithDraw amount with available denominations";

			}
			Map<Money, Integer> countbalance = deduct(toWithdraw, count);
			Denomination denomination1 = get(1);

			int hundredNoteCount = countbalance.get(Note.HUNDRED);
			int fiftyNoteCount = countbalance.get(Note.FIFTY);
			int twentyNoteCount = countbalance.get(Note.TWENTY);
			if (hundredNoteCount < 0) {
				hundredNoteCount = -1 * hundredNoteCount;
			} else if (fiftyNoteCount < 0) {
				fiftyNoteCount = -1 * fiftyNoteCount;
			} else if (twentyNoteCount < 0) {
				twentyNoteCount = -1 * twentyNoteCount;
			}

			denomination1.setAvailablecash(DenominationUtil.getTotal(count)
					.abs());
			denomination1.setHundredNotes(hundredNoteCount);
			denomination1.setFiftyNotes(fiftyNoteCount);
			denomination1.setTwentyNotes(twentyNoteCount);
			denominationRepository.saveAndFlush(denomination1);
			result = "Withdraw is done";
		} catch (Exception e) {
			result = "Exception " + e.getMessage();
		}
		return result;
	}


	@SuppressWarnings("unused")
	private Map<Money, Integer> deduct(Map<Money, Integer> toWithdraw,
			Map<Money, Integer> count) {
		for (Entry<Money, Integer> st : toWithdraw.entrySet()) {
			Integer deduction = count.get(st.getKey()) - st.getValue();
			count.put(st.getKey(), deduction);
		}
		return count;
	}

	@Override
	public Denomination delete(Integer id) {
		Denomination denomination = get(id);
		denominationRepository.delete(id);
		return denomination;
	}

}
