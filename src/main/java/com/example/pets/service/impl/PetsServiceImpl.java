package com.example.pets.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pets.dao.PetsDao;
import com.example.pets.dto.PetListResponseDto;
import com.example.pets.dto.PetResponseDto;
import com.example.pets.exception.PetsNotFoundException;
import com.example.pets.model.Pets;
import com.example.pets.service.PetsService;

/**
 * @author Haritha
 *
 */
@Service
public class PetsServiceImpl implements PetsService {
	static Log logger = LogFactory.getLog(PetsServiceImpl.class);
	@Autowired
	PetsDao petDao;

	@Override
	public PetListResponseDto getPetsByPetName(String petName) {
		logger.info("Inside getPetsByPetName method ");
		PetListResponseDto petListResponseDto = new PetListResponseDto();

		Optional<List<Pets>> petsOptional = petDao.findByPetName(petName);
		if (!petsOptional.isPresent()) {
			throw new PetsNotFoundException("pet is not found with the requested pet name");
		}
		List<PetResponseDto> petResponseDto = petsOptional.get().stream().map(pets -> getPetResponseDto(pets))
				.collect(Collectors.toList());
		petListResponseDto.setPetResponseDto(petResponseDto);
		petListResponseDto.setMessage("list of pets");
		petListResponseDto.setStatusCode(200);
		return petListResponseDto;
	}

	private PetResponseDto getPetResponseDto(Pets pets) {
		logger.info("Inside getPetResponseDto method ");
		PetResponseDto petResponseDto = new PetResponseDto();
		BeanUtils.copyProperties(pets, petResponseDto);

		return petResponseDto;
	}
}