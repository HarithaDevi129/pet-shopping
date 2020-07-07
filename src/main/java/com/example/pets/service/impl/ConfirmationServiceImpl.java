package com.example.pets.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pets.dao.ConfirmationDao;
import com.example.pets.dao.PetsDao;
import com.example.pets.dao.UserDao;
import com.example.pets.dto.BookingResponseDto;
import com.example.pets.dto.ConfirmationListResponseDto;
import com.example.pets.dto.OrderRequestDto;
import com.example.pets.dto.PurchaseListDto;
import com.example.pets.exception.InvalidPetIdException;
import com.example.pets.exception.InvalidUserIdException;
import com.example.pets.exception.UserIdNotFoundException;
import com.example.pets.model.Confirmation;
import com.example.pets.model.Pets;
import com.example.pets.model.User;
import com.example.pets.service.ConfirmationService;

/**
 * @author Haritha
 *
 */
@Service
public class ConfirmationServiceImpl implements ConfirmationService {
	static Log logger = LogFactory.getLog(ConfirmationServiceImpl.class);
	@Autowired
	ConfirmationDao confirmationDao;
	@Autowired
	PetsDao petsDao;
	@Autowired
	UserDao userDao;
	/**
	 * this method is used to get the pets by userId
	 */
	@Override
	public ConfirmationListResponseDto getPetsByUserId(Integer userId) {
		logger.info("Inside getPetsByUserId method ");
		ConfirmationListResponseDto confirmationListResponseDto = new ConfirmationListResponseDto();

		Optional<List<Confirmation>> confirmations = confirmationDao.findAllByUserId(userId);
		if (!confirmations.isPresent()) {
			throw new InvalidUserIdException("no pets are purchased by this userId.");
		}

		List<PurchaseListDto> purchaseListDto = confirmations.get().stream()
				.map(confirmation -> getPurchaseListDto(confirmation)).collect(Collectors.toList());
		confirmationListResponseDto.setPurchaseListDto(purchaseListDto);
		confirmationListResponseDto.setMessage("Please find the pet details");
		confirmationListResponseDto.setStatusCode(200);
		return confirmationListResponseDto;
	}

	private PurchaseListDto getPurchaseListDto(Confirmation confirmation) {
		logger.info("Inside getPurchaseListDto method ");
		PurchaseListDto purchaseListDto = new PurchaseListDto();

		Optional<Pets> pets = petsDao.findById(confirmation.getPetId());
		if (!pets.isPresent())
			return null;
		purchaseListDto.setPetName(pets.get().getPetName());
		purchaseListDto.setCost(pets.get().getCost());

		BeanUtils.copyProperties(confirmation, purchaseListDto);
		return purchaseListDto;
	}
	/**
	 * this method is used to purchase pets
	 */
	@Override
	public BookingResponseDto purchasePet(OrderRequestDto orderRequestDto, Integer userId) {
		logger.info("Inside purchasePet method ");
		Confirmation confirmation = new Confirmation();

		Optional<User> user = userDao.findByUserId(userId);

		if (!user.isPresent()) {
			throw new UserIdNotFoundException("User with this user Id is not found ");
		}
		Optional<Pets> pet1 = petsDao.findByPetId(orderRequestDto.getPetId());
		if (!pet1.isPresent()) {
			throw new InvalidPetIdException("pet with this pet Id is not found ");
		}

		confirmation.setDate(LocalDate.now());
		confirmation.setPetId(orderRequestDto.getPetId());
		confirmation.setUserId(userId);
		confirmationDao.save(confirmation);

		BookingResponseDto bookingResponseDto = new BookingResponseDto();
		Optional<Pets> pets = petsDao.findById(confirmation.getPetId());
		bookingResponseDto.setPetName(pets.get().getPetName());
		bookingResponseDto.setCost(pets.get().getCost());
		bookingResponseDto.setStatusCode(200);
		bookingResponseDto.setMessage("please find youor details");
		BeanUtils.copyProperties(confirmation, bookingResponseDto);
		return bookingResponseDto;

	}
}