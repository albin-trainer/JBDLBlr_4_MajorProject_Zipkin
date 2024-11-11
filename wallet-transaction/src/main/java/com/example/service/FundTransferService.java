package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.FundTransactionDto;
import com.example.entity.Transaction;
import com.example.entity.User;
import com.example.repo.TransactionRep;

@Service
public class FundTransferService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private TransactionRep transRep;
public void fundTransfer(FundTransactionDto dto) {
	  ResponseEntity<User> userEntity=
			  restTemplate.getForEntity("http://wallet-user/user/"+dto.getAccId(), User.class);
	   User user= userEntity.getBody();
	   if(user.getWalletBal()>=dto.getAmt()) {
		   System.out.println("s can do .....");
		 Transaction t=new Transaction();
		 t.setAccId(dto.getAccId());
		 t.setAnotherAcc(dto.getAnotherAcc());
		 t.setDate(LocalDateTime.now());
		 //repository call ....
		 System.out.println("sss");
		 transRep.save(t);
	   }
	   else {
		   //throw exception ....
	   }
}
}
