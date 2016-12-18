package com.cashman.test.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cashman.enumeration.Note;
import com.cashman.interfaces.Money.Money;
import com.cashman.util.DenominationUtil;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DenominationUtilTest {

	Map<Money, Integer> denomination = null;

	@Before
	public void setUp() {
		System.out.println("Setup");
		denomination = new HashMap<Money, Integer>();
		denomination.put(Note.HUNDRED, 0);
		denomination.put(Note.FIFTY, 2);
		denomination.put(Note.TWENTY, 3);
	}

	@Test
	public void totalCurrencyCount() {

		Assert.assertEquals(5, DenominationUtil.getTotalCount(denomination));
	}

	@Test
	public void totalFundsAvailableTest() {
		Map<Money, Integer> towithdraw = new HashMap<Money, Integer>();
		towithdraw.put(Note.TWENTY, 2);
		Assert.assertEquals(true,
				DenominationUtil.fundsAvailable(towithdraw, denomination));
	}

	@Test
	public void totalFundsAvailableFailureTest() {
		Map<Money, Integer> towithdraw = new HashMap<Money, Integer>();
		towithdraw.put(Note.FIFTY, 3);
		Assert.assertEquals(false,
				DenominationUtil.fundsAvailable(towithdraw, denomination));
	}

	@Test
	public void getTotalCashAvailableTest() {
		Assert.assertEquals(new BigDecimal(160), DenominationUtil.getTotal(denomination));
	}
	
	
//	@Test
//	public void totalFundsAvailableTest2() {
//		BigDecimal withdrawAmount=new BigDecimal(160);
//		Map<Money, Integer> towithdraw = new HashMap<Money, Integer>();
//		towithdraw.put(Note.FIFTY, 1);
//		System.out.println(";;;;"+DenominationUtil.fundsAvailable(DenominationUtil.calculateWithdraw(withdrawAmount, denomination), towithdraw));
//		Assert.assertEquals(100,
//				DenominationUtil.fundsAvailable(DenominationUtil.calculateWithdraw(withdrawAmount, denomination), towithdraw));
//	}

}
