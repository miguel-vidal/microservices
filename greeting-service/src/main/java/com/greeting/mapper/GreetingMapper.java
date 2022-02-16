package com.greeting.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.greeting.entity.Greeting;
import com.greeting.requestdto.GreetingRequestDTO;
import com.greeting.responsedto.GreetingResponseDTO;

@Component
public class GreetingMapper {

	public Greeting dtoToEntity(GreetingRequestDTO dto) {
		Greeting greeting = new Greeting();
		greeting.setType(dto.getType());
		greeting.setGreeting(dto.getGreeting());
		return greeting;
	}
	
	public GreetingResponseDTO entityToDto(Greeting greeting) {
		GreetingResponseDTO dto = new GreetingResponseDTO();
		dto.setId(greeting.getId());
		dto.setType(greeting.getType());
		dto.setGreeting(greeting.getGreeting());
		return dto;
	}
	
	public List<GreetingResponseDTO> listOfDto(List<Greeting> greetings){
		List<GreetingResponseDTO> dto = new ArrayList<>();
		greetings.forEach(greeting -> dto.add(entityToDto(greeting) ) );
		return dto;
	}
}
