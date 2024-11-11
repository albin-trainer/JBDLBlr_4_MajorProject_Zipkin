package com.example.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.constants.AppConstants;
import com.example.request.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class KafkaConsumerService {
	 @Autowired
	 private SimpleMailMessage simpleMailMsg;
	 @Autowired
	 private JavaMailSender javaMailSender;
@Autowired
private ObjectMapper mapper;
@KafkaListener( topics =  {AppConstants.NEW_USER},groupId = "group-id")
	public void consumeMessages(ConsumerRecord<String, String> consumer) {
		//cons
		 String key=consumer.key();
		 String json=consumer.value();
		 System.out.println("RECEIVED : "+json);

		try {
			UserDto user= mapper.readValue(json, UserDto.class);
			 simpleMailMsg.setTo(user.getEmail());
				simpleMailMsg.setSubject("Succesfully Registered .....");
				//simpleMailMsg.setFrom("albinxavier@gmail.com");
				simpleMailMsg.setText("Hi "+user.getUserName()+" Congrats u have created ur wallet account");
				javaMailSender.send(simpleMailMsg);
				System.out.println("SENd...");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
}
