package com.greeting.responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingResponseDTO {
	private Long id;
	private String type;
	private String greeting;
	
	public GreetingResponseDTO() {}
}
