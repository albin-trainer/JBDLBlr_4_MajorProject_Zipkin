package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.request.dto.UserDto;
import com.example.service.UserService;

@RestController
public class UserApi {
	@Autowired
  private UserService userService;
	
	Logger log=LoggerFactory.getLogger(UserApi.class);
	@PostMapping("/register")
	public ResponseEntity<User> register( @RequestBody UserDto userDto){
		User u=userService.registerUser(userDto);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserInfo( @PathVariable int userId){
		log.info("Fetching user info from {}",userId);
		User u=userService.findById(userId);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
}
