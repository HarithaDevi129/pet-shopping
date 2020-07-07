package com.example.pets.service;

import com.example.pets.dto.LoginDto;
import com.example.pets.dto.LoginResponseDto;

/**
 * @author Haritha
 *
 */
public interface UserService {

	/**
	 * this method is used to login
	 * @param loginDto
	 * @return LoginResponseDto
	 */
	LoginResponseDto loginUser(LoginDto loginDto);

}
