package com.example.pets.service;

import com.example.pets.dto.PetListResponseDto;

/**
 * @author Haritha
 *
 */
public interface PetsService {

	/**
	 * This method is used to get pets by petname
	 * @param petName
	 * @return PetListResponseDto
	 */
	public PetListResponseDto getPetsByPetName(String petName);

}
