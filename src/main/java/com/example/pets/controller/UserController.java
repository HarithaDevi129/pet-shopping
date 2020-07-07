package com.example.pets.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pets.dto.LoginDto;
import com.example.pets.dto.LoginResponseDto;
import com.example.pets.service.UserService;

/**
 * @author haritha
 * This controller is used login from user 
 * and get a response based on the request
 *
 */
@RestController
public class UserController {
	static Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;
	/**
	 * This method is used for logging in User 
	 * @param loginDto
	 * @return LoginResponseDto with parameters message and statusCode
	 */
	@PostMapping("/users")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto loginDto)
	{
		return new ResponseEntity<>(userService.loginUser(loginDto),HttpStatus.OK);
	}
}
