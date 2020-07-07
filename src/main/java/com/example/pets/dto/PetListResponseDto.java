package com.example.pets.dto;

import java.util.List;

public class PetListResponseDto {
private String message;
private Integer statusCode;
public List<PetResponseDto> getPetResponseDto() {
	return petResponseDto;
}
public void setPetResponseDto(List<PetResponseDto> petResponseDto) {
	this.petResponseDto = petResponseDto;
}
List<PetResponseDto> petResponseDto;
	public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
