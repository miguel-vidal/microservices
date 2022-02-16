package com.userservice.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class GreetingResponseDTO {
	private String type;
	private String greeting;
	
	public GreetingResponseDTO() {}
	
}
