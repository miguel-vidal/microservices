package com.userservice.responsedto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CompanyResponseDTO {

	private long id;
	private String company;
	private String address;
	private List<UserResponseDTO> users;
}
