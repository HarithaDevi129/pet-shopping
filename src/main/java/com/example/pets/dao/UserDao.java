package com.example.pets.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.pets.model.User;
/**
 * @author Haritha
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer>{

	/**
	 * this method is used to login by user
	 * @param userName
	 * @param password
	 * @return User
	 */
	Optional<User> findByUserNameAndPassword(String userName, String password);

	/**
	 * this method is used to find the user
	 * @param userId
	 * @return user
	 */
	Optional<User> findByUserId(Integer userId);

}
