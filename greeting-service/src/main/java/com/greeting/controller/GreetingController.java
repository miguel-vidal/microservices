package com.greeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.mapper.GreetingMapper;
import com.greeting.requestdto.GreetingRequestDTO;
import com.greeting.responsedto.GreetingResponseDTO;
import com.greeting.responsedto.ResponseDTO;
import com.greeting.service.GreetingService;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private GreetingMapper greetingMapper;
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<GreetingResponseDTO>>> getAllGreetings(){
		List<GreetingResponseDTO> dto = greetingMapper.listOfDto( greetingService.getAll() );
		ResponseDTO<List<GreetingResponseDTO>> response = new ResponseDTO<List<GreetingResponseDTO>>("All the greetings", dto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseDTO<GreetingResponseDTO>> saveGreeting(
			@RequestBody GreetingRequestDTO greeting
			){
		GreetingResponseDTO dto = greetingMapper
				.entityToDto( greetingService
						.save(greetingMapper
								.dtoToEntity(greeting)));
		ResponseDTO<GreetingResponseDTO> response = new ResponseDTO<GreetingResponseDTO>("Greeting saved!", dto);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/{type}")
	public ResponseEntity<ResponseDTO<GreetingResponseDTO>> getGreetingById(
			@PathVariable("type") String type
			){
		GreetingResponseDTO dto = greetingMapper
				.entityToDto( greetingService
						.getByType(type));
		ResponseDTO<GreetingResponseDTO> response = new ResponseDTO<GreetingResponseDTO>("Greeting founded!", dto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
