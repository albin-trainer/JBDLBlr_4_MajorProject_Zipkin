package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Transaction;

public interface TransactionRep  extends JpaRepository<Transaction, Integer> {

}
