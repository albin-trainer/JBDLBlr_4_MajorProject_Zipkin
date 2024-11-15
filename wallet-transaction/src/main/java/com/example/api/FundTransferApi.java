package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.FundTransactionDto;
import com.example.service.FundTransferService;

@RestController
public class FundTransferApi {
	@Autowired
	private FundTransferService fundTransferService;
	@Value("${promo.amt}")
	private String msg;
	@Value("${spring.datasource.driver-class-name}")
	String driver;
	Logger log=LoggerFactory.getLogger(FundTransferApi.class);
@PutMapping("fundTransfer")
	public String fundTransfer( @RequestHeader("loggedInUser")  int userId,
			@RequestBody FundTransactionDto dto) {
	log.info("fund transfering from {} ",userId);
		dto.setAccId(userId);
		fundTransferService.fundTransfer(dto);
		return "Success";
	}
@GetMapping("/test")
public String test() {
	System.out.println(driver);
	log.info("testing log "+msg);
	return "TEST "+msg;
}
}
