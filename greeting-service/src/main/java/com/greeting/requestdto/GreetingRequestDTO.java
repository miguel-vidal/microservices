package com.greeting.requestdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingRequestDTO {
	
	private String type;
	private String greeting;
	
	public GreetingRequestDTO() {}
}
