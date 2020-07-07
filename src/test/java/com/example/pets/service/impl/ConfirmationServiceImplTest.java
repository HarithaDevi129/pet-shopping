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

import com.example.pets.dao.ConfirmationDao;
import com.example.pets.dto.ConfirmationListResponseDto;
import com.example.pets.dto.PurchaseListDto;
import com.example.pets.exception.InvalidUserIdException;
import com.example.pets.model.Confirmation;
import com.example.pets.service.PetsService;

@ExtendWith(MockitoExtension.class)
public class ConfirmationServiceImplTest {
	@Mock
	ConfirmationDao confirmationDao;

	@InjectMocks
	ConfirmationServiceImpl confirmationServiceImpl;

	Confirmation confirmation =new Confirmation();

	ConfirmationListResponseDto confirmationListResponseDto;

	@Mock
	PetsService petsService;

	@BeforeEach
	public void setUp() {
		confirmationListResponseDto=new ConfirmationListResponseDto();
	}
	@Test
	public void getPetsByUserId() {
		
		List<Confirmation> confirmation = new ArrayList<>();
		PurchaseListDto responseDto = new PurchaseListDto();
		responseDto.setCost("4000");
		responseDto.setPetName("husky");
		
		when(confirmationDao.findAllByUserId(1)).thenReturn(Optional.of(confirmation));
		
		confirmationServiceImpl.getPetsByUserId(1);
		
		verify(confirmationDao).findAllByUserId(1);
	}
	@Test
	public void getPetsByUserId1() {
		
		List<Confirmation> confirmation = new ArrayList<>();
		PurchaseListDto responseDto = new PurchaseListDto();
		responseDto.setCost("4000");
		responseDto.setPetName("husky");
		
		when(confirmationDao.findAllByUserId(1)).thenReturn(Optional.ofNullable(confirmation));
		
		confirmationServiceImpl.getPetsByUserId(1);
		
		verify(confirmationDao).findAllByUserId(1);
	}
	@Test
	public void getPetsByUserId2() throws InvalidUserIdException {
		PurchaseListDto responseDto = new PurchaseListDto();
		responseDto.setCost("4000");
		responseDto.setPetName("husky");
		
		InvalidUserIdException exception = assertThrows(InvalidUserIdException.class, () -> {
	        confirmationServiceImpl.getPetsByUserId(1);
	    });
		 String expectedMessage = "no pets are purchased by this userId.";
		    String actualMessage = exception.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage));
	}
}
