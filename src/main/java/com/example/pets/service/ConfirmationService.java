package com.example.pets.service;

import com.example.pets.dto.BookingResponseDto;
import com.example.pets.dto.ConfirmationListResponseDto;
import com.example.pets.dto.OrderRequestDto;


/**
 * @author Haritha
 *
 */
public interface ConfirmationService {
	

	/**
	 * this method is used to find the pets by userid
	 * @param userId
	 * @return ConfirmationListResponseDto
	 */
	ConfirmationListResponseDto getPetsByUserId(Integer userId);
	/**
	 * this method is used to find the purchase pets
	 * @param orderRequestDto
	 * @param userId
	 * @return BookingResponseDto
	 */
	BookingResponseDto purchasePet(OrderRequestDto orderRequestDto,Integer userId);

}
