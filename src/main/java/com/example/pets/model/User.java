package com.example.pets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Generates User table with userId,password , userName and emailId
 * 
 * @author haritha
 *
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	private String userName;
	private String password;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
