package com.cashman.model;

import java.math.BigDecimal;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "denomination")
public class Denomination {

	@Id
	@GeneratedValue
	private Integer id = 0;

	private int hundredNotes;

	private int fiftyNotes = 0;
	private int twentyNotes = 0;

	BigDecimal availablecash = BigDecimal.ZERO;

	BigDecimal withdrawcash = BigDecimal.ZERO;

	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getAvailablecash() {
		return availablecash;
	}

	public void setAvailablecash(BigDecimal availablecash) {
		this.availablecash = availablecash;
	}

	public BigDecimal getWithdrawcash() {
		return withdrawcash;
	}

	public void setWithdrawcash(BigDecimal withdrawcash) {
		this.withdrawcash = withdrawcash;
	}

	public Denomination update(Denomination sPhone) {
		this.availablecash = sPhone.availablecash;
		this.twentyNotes = sPhone.twentyNotes;
		this.fiftyNotes = sPhone.fiftyNotes;
		this.hundredNotes = sPhone.hundredNotes;
		this.withdrawcash = sPhone.withdrawcash;
		return this;
	}

//	@Override
//	public String toString() {
//		return "Smartphone [id=" + id + ", hundredNotes=" + hundredNotes
//				+ ", fiftyNotes=" + fiftyNotes + ", twentyNotes=" + twentyNotes
//				+ ", availablecash=" + availablecash + ", withdrawcash="
//				+ withdrawcash + "]";
//	}

}
