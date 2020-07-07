package com.example.pets.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.pets.dao.PetsDao;
import com.example.pets.dto.PetListResponseDto;
import com.example.pets.dto.PetResponseDto;
import com.example.pets.exception.PetsNotFoundException;
import com.example.pets.model.Pets;
import com.example.pets.service.PetsService;
@ExtendWith(MockitoExtension.class)
public class PetsServiceImplTest {
	
		@Mock
		PetsDao petsDao;

		@InjectMocks
		PetsServiceImpl petsServiceImpl;

		Pets pets =new Pets();

		PetListResponseDto petListResponseDto;

		@Mock
		PetsService petsService;

		@BeforeEach
		public void setUp() {
			pets=new Pets();
		}

		@Test
		public void getPetsByPetName() {
			
			List<Pets> petsList = new ArrayList<>();
			PetResponseDto responseDto = new PetResponseDto();
			
			responseDto.setPetId(1);
			responseDto.setPetName("husky");
			responseDto.setCost("4000");
			
			
			when(petsDao.findByPetName("husky")).thenReturn(Optional.ofNullable(petsList));
			
			petsServiceImpl.getPetsByPetName("husky");
			
			verify(petsDao).findByPetName("husky");
		
		}
		@Test
		public void getPetsByPetName1() {
			
			List<Pets> petsList = new ArrayList<>();
			PetResponseDto responseDto = new PetResponseDto();
			
			responseDto.setPetId(1);
			responseDto.setPetName("husky");
			responseDto.setCost("4000");
			
			
			when(petsDao.findByPetName("husky")).thenReturn(Optional.of(petsList));
			
			petsServiceImpl.getPetsByPetName("husky");
			
			verify(petsDao).findByPetName("husky");
		
		}
		@Test
		public void getPetsByPetName2() throws PetsNotFoundException{
			
			PetResponseDto responseDto = new PetResponseDto();
			
			responseDto.setPetId(1);
			responseDto.setPetName("husky");
			responseDto.setCost("4000");
			PetsNotFoundException exception = assertThrows(PetsNotFoundException.class, () -> {
		        petsServiceImpl.getPetsByPetName("husky");
		    });
			 String expectedMessage = "pet is not found with the requested pet name";
			    String actualMessage = exception.getMessage();
			    assertTrue(actualMessage.contains(expectedMessage));
		}
		
}
