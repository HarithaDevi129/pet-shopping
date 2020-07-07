package com.example.pets.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.pets.dao.UserDao;
import com.example.pets.dto.LoginDto;
import com.example.pets.dto.LoginResponseDto;
import com.example.pets.exception.InvalidCredentialsException;
import com.example.pets.model.User;
import com.example.pets.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	

	LoginResponseDto loginResponseDto;

	@Mock
	UserService userService;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("haritha");
		loginDto.setPassword("123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("User logged in");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		user.setEmailId("haritha@gmail.com");
		user.setPassword("123");
		user.setUserId(1);
		user.setUserName("haritha");

		assertThat(!(loginDto.getUserName().isEmpty() && loginDto.getPassword().isEmpty())).isTrue();

		when(userDao.findByUserNameAndPassword("haritha", "123")).thenReturn(Optional.of(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByUserNameAndPassword("haritha", "123");

	}
	@Test
	public void loginUserTest2() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("haritha");
		loginDto.setPassword("123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("User logged in");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		user.setEmailId("haritha@gmail.com");
		user.setPassword("123");
		user.setUserId(1);
		user.setUserName("haritha");

		assertThat(!(loginDto.getUserName().isEmpty() && loginDto.getPassword().isEmpty())).isTrue();

		when(userDao.findByUserNameAndPassword("haritha", "123")).thenReturn(Optional.ofNullable(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByUserNameAndPassword("haritha", "123");

	}

	@Test
	public void loginUserTest3() throws InvalidCredentialsException{
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("haritha");
		loginDto.setPassword("123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("User logged in");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		user.setEmailId("haritha@gmail.com");
		user.setPassword("123");
		user.setUserId(1);
		user.setUserName("haritha");
		
		InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
	        userServiceImpl.loginUser(loginDto);
	    });
	 
	    String expectedMessage = "User not found";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	}
	

}