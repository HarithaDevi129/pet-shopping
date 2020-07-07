package com.example.pets.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pets.model.Confirmation;
/**
 * @author Haritha
 *
 */
@Repository
public interface ConfirmationDao extends CrudRepository<Confirmation, Integer>{
	Optional<List<Confirmation>> findAllByUserId(int userId);
	Optional<Confirmation> findByPetIdAndUserId(int petId, Integer userId);
	
}
