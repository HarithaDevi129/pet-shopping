package com.example.pets.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pets.dto.BookingResponseDto;
import com.example.pets.dto.ConfirmationListResponseDto;
import com.example.pets.dto.OrderRequestDto;
import com.example.pets.service.ConfirmationService;

/**
 * @author haritha This controller is used get history of pets purchased by user
 *
 */

@RestController
public class ConfirmationController {
	static Log logger = LogFactory.getLog(ConfirmationController.class);
	@Autowired
	ConfirmationService confirmationService;

	/**
	 * This method is used history of pets purchased by userId
	 * 
	 * @param userId
	 * @return ConfirmationListResponseDto
	 */
	@GetMapping("/users/{userId}/confirmation")
	public ResponseEntity<ConfirmationListResponseDto> purchasedPets(@PathVariable("userId") Integer userId) {
		logger.info("Inside purchasedPets method ");
		return new ResponseEntity<>(confirmationService.getPetsByUserId(userId), HttpStatus.OK);
	}

	@PostMapping("/users/{userId}/confirmation")
	public ResponseEntity<BookingResponseDto> purchasePet(@RequestBody OrderRequestDto orderRequestDto,
			@PathVariable("userId") Integer userId) {
		logger.info("Inside purchasePet method ");
		return new ResponseEntity<>(confirmationService.purchasePet(orderRequestDto, userId), HttpStatus.OK);
	}
}
