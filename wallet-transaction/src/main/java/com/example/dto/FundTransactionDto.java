package com.example.dto;

import com.example.entity.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class FundTransactionDto {
	private int accId;
	  private int anotherAcc;
	  private float amt;
	  @Enumerated(EnumType.STRING)
	  private TransactionType transactionType;
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getAnotherAcc() {
		return anotherAcc;
	}
	public void setAnotherAcc(int anotherAcc) {
		this.anotherAcc = anotherAcc;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	  
	  
}
