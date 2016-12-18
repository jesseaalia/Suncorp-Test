package com.cashman.model;

public class ATMResponse {

	String msg="";

	
	
	public ATMResponse(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ATMResponse [msg=" + msg + "]";
	}
	
	
	
	
	
}
