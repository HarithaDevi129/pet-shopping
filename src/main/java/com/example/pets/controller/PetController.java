package com.example.pets.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pets.dto.PetListResponseDto;
import com.example.pets.service.PetsService;

/**
 * @author haritha
 * This controller is used search pets by petName
 *
 */
@RestController
public class PetController {
	static Log logger = LogFactory.getLog(PetController.class);
    @Autowired
    PetsService petsService;
    /**
	 * This method is used to get pets by petName
	 * @param petName
	 * @return PetListResponseDto
	 */
    @GetMapping("/pets")
    public ResponseEntity<PetListResponseDto> getPetsByPetName(@RequestParam("petName") String petName) {
       
            return new ResponseEntity<>(petsService.getPetsByPetName(petName),HttpStatus.OK);
    }
    

 

}
