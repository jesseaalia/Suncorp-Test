package com.cashman.enumeration;

import java.math.BigDecimal;

public class Currencydto {

	int hundredNotes=0;
	int fiftyNotes=0;
	int twentyNotes=0;
	int tenNotes=0;
	int fiveNotes=0;
	int twentyCoins=0;
	int fiftyCoins=0;
	int fiveCoins=0;
	int tebCoins=0;
	int twoCoins=0;
	
	BigDecimal availablecash=BigDecimal.ZERO;
	
	BigDecimal withdrawcash=BigDecimal.ZERO;
	
	
	
	public BigDecimal getWithdrawcash() {
		return withdrawcash;
	}
	public void setWithdrawcash(BigDecimal withdrawcash) {
		this.withdrawcash = withdrawcash;
	}
	public BigDecimal getAvailablecash() {
		return availablecash;
	}
	public void setAvailablecash(BigDecimal availablecash) {
		this.availablecash = availablecash;
	}
	public int getHundredNotes() {
		return hundredNotes;
	}
	public void setHundredNotes(int hundredNotes) {
		this.hundredNotes = hundredNotes;
	}
	public int getFiftyNotes() {
		return fiftyNotes;
	}
	public void setFiftyNotes(int fiftyNotes) {
		this.fiftyNotes = fiftyNotes;
	}
	public int getTwentyNotes() {
		return twentyNotes;
	}
	public void setTwentyNotes(int twentyNotes) {
		this.twentyNotes = twentyNotes;
	}
	public int getTenNotes() {
		return tenNotes;
	}
	public void setTenNotes(int tenNotes) {
		this.tenNotes = tenNotes;
	}
	public int getFiveNotes() {
		return fiveNotes;
	}
	public void setFiveNotes(int fiveNotes) {
		this.fiveNotes = fiveNotes;
	}
	public int getTwentyCoins() {
		return twentyCoins;
	}
	public void setTwentyCoins(int twentyCoins) {
		this.twentyCoins = twentyCoins;
	}
	public int getFiftyCoins() {
		return fiftyCoins;
	}
	public void setFiftyCoins(int fiftyCoins) {
		this.fiftyCoins = fiftyCoins;
	}
	public int getFiveCoins() {
		return fiveCoins;
	}
	public void setFiveCoins(int fiveCoins) {
		this.fiveCoins = fiveCoins;
	}
	public int getTebCoins() {
		return tebCoins;
	}
	public void setTebCoins(int tebCoins) {
		this.tebCoins = tebCoins;
	}
	public int getTwoCoins() {
		return twoCoins;
	}
	public void setTwoCoins(int twoCoins) {
		this.twoCoins = twoCoins;
	}
	@Override
	public String toString() {
		return "Currencydto [hundredNotes=" + hundredNotes + ", fiftyNotes="
				+ fiftyNotes + ", twentyNotes=" + twentyNotes + ", tenNotes="
				+ tenNotes + ", fiveNotes=" + fiveNotes + ", twentyCoins="
				+ twentyCoins + ", fiftyCoins=" + fiftyCoins + ", fiveCoins="
				+ fiveCoins + ", tebCoins=" + tebCoins + ", twoCoins="
				+ twoCoins + "]";
	}

	// TWENTY(AUD, 0.20),
	// FIFTY(AUD, 0.50),
	// FIVE(AUD, 0.05),
	// TEN(AUD, 0.10),
	// ONE(AUD, 1),
	// TWO(AUD, 2);

	
}
