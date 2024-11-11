package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
private int userId;
private String userName;
@JsonIgnore
private String password;
@Column(unique = true)
private String email;
private float walletBal;


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public float getWalletBal() {
	return walletBal;
}
public void setWalletBal(float walletBal) {
	this.walletBal = walletBal;
}


}
