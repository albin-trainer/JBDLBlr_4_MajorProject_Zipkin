package com.example.service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.constants.AppConstants;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.request.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private UserRepository userRepo;
	@Value("${promo.amt}")
	private float promoAmt;
	public User registerUser(UserDto userDto) {
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		user.setWalletBal(promoAmt);
		User u=userRepo.save(user);
		//send the notification
		sendNotification(userDto);
		return u;
	}
	@Autowired
	private ObjectMapper mapper;
	private void sendNotification(UserDto userDto) {
	//	ObjectMapper mapper=new ObjectMapper();
		try {
		String json=mapper.writeValueAsString(userDto);
		System.out.println(json);
		kafkaTemplate.send(AppConstants.NEW_USER,userDto.getUserName(), json);
		System.out.println("Msg send ....");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElseThrow(()->  new RuntimeException("USer id not found"));
	}
}
