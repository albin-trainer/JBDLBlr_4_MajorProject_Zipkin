package com.example.service;

import com.example.entity.User;
import com.example.request.dto.UserDto;

public interface UserService {
 User registerUser(UserDto userDto);
 User findById(int id);
}
