package com.example.pets.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.pets.dao.UserDao;
import com.example.pets.dto.LoginDto;
import com.example.pets.dto.LoginResponseDto;
import com.example.pets.exception.InvalidCredentialsException;
import com.example.pets.model.User;
import com.example.pets.service.UserService;

/**
 * @author Haritha
 *
 */
@Service
public class UserServiceImpl implements UserService {
	static Log logger = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	UserDao userDao;

	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		logger.info("Inside loginUser method ");
		LoginResponseDto loginResponseDto = new LoginResponseDto();

		Optional<User> userOptional = userDao.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());

		if (!userOptional.isPresent()) {
			throw new InvalidCredentialsException("User not found ");
		}
		loginResponseDto.setMessage("User logged in successfully");
		loginResponseDto.setStatusCode(HttpStatus.OK.value());
		return loginResponseDto;

	}

}