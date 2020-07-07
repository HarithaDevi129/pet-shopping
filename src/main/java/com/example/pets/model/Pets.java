package com.example.pets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pets {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
private int petId;
private String petName;
private String cost;
public int getPetId() {
	return petId;
}
public void setPetId(int petId) {
	this.petId = petId;
}
public String getPetName() {
	return petName;
}
public void setPetName(String petName) {
	this.petName = petName;
}
public String getCost() {
	return cost;
}
public void setCost(String cost) {
	this.cost = cost;
}

}
