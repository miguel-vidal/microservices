package com.userservice.responsedto;

import com.userservice.entity.Company;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDTO {

	private long id;
	private String name;
	private int age;
	private String address;	
	private Company company;
}
