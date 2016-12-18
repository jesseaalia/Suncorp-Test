package com.cashman.exception;

public class DenominationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	private final int smartphoneId;
	
	public DenominationNotFoundException(int id) {
		smartphoneId = id;
	}
	
	public int getSmartphoneId() {
		return smartphoneId;
	}

}
