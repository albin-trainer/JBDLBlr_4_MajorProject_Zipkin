package com.example.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Transaction {
	@Id
	@GeneratedValue
  private int id;
	private int accId;
  private int anotherAcc;
  private float amt;
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;
  private LocalDateTime date;
  
  
public int getAccId() {
	return accId;
}
public void setAccId(int accId) {
	this.accId = accId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
  
}
