package com.cashman.test.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cashman.init.WebAppConfig;
import com.cashman.model.Denomination;
import com.cashman.service.DenominationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfig.class)
@TransactionConfiguration
@WebAppConfiguration
@ActiveProfiles("test")
public class DenominationCreationTest {
	
	@Autowired
	private DenominationService denominationService;
	
	@Test
	public void test() {
		
		Denomination sp = new Denomination();
		sp.setHundredNotes(0);
		sp.setFiftyNotes (2);
		sp.setTwentyNotes (3);
		
		Denomination newSmartphone = denominationService.create(sp);
		
		assertEquals(sp.getHundredNotes(), newSmartphone.getHundredNotes());
		assertEquals(sp.getFiftyNotes(), newSmartphone.getFiftyNotes());
		assertTrue(sp.getTwentyNotes() == newSmartphone.getTwentyNotes());
	}
	
	
	

}
