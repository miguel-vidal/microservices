package com.userservice.responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TemplateResponseDTO {

	private String message;
	private GreetingResponseDTO response;
	
	public TemplateResponseDTO() {}
}
