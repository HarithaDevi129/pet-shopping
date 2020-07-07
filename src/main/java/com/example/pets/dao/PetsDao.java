package com.example.pets.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.pets.model.Pets;

/**
 * @author Haritha
 *
 */

@Repository
public interface PetsDao extends CrudRepository<Pets, Integer>{
	
	    /**
	     * This method is used to find the pets by petName
	     * @param petName
	     * @return Pets
	     */
	    Optional<List<Pets>> findByPetName(String petName);
	    
	    @Query(value = "select * from pets p where p.pet_name like %:petName%", nativeQuery = true)
	    Optional<List<Pets>> getPetByPetName(@Param("petName") String petName);

		/**
		 * This method is used to find the petId
		 * @param petId
		 * @return Pets
		 */
		Optional<Pets> findByPetId(int petId);

	 


	
}
