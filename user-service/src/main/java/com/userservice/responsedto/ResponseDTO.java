package com.userservice.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ResponseDTO<T> {

	private String message;
	private T response;
	
}
