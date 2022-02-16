package com.userservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.mapper.UserMapper;
import com.userservice.requestdto.UserRequestDTO;
import com.userservice.responsedto.ResponseDTO;
import com.userservice.responsedto.UserResponseDTO;
import com.userservice.service.UserService;
import com.userservice.utils.GreetingTemplate;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private GreetingTemplate greeting;
	
	Logger logger =LoggerFactory.getLogger(GreetingTemplate .class);
	
	
	@GetMapping("/")
	public ResponseEntity<ResponseDTO<List<UserResponseDTO>>> getAllUsers(){
		List<UserResponseDTO> list = userMapper.listOfDto(userService.getAll());
		logger.info(list.toString());
		ResponseDTO<List<UserResponseDTO>> response = new ResponseDTO<>("all users in the DB",list);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<ResponseDTO<UserResponseDTO>> getUserByName(@PathVariable("name") String name){
		UserResponseDTO userByName = userMapper.entityToDto(userService.getByName(name));
		ResponseDTO<UserResponseDTO> response = new ResponseDTO<>("the user by the name is:",userByName);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseDTO<Object>> saveUser(
			@RequestBody UserRequestDTO user
			){
		UserResponseDTO userDto = userMapper.entityToDto(userService.save( userMapper.dtoToEntity(user) ));
		Map<String, Object> responseTemplate = new HashMap<>();
		responseTemplate.put("saludo", greeting.getGreeting());
		responseTemplate.put("user", userDto);
		ResponseDTO<Object> response = new ResponseDTO<Object>("the user was saved successfully", responseTemplate);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}/company/{companyId}")
	public ResponseEntity<ResponseDTO<UserResponseDTO>> assignCompanyToUser(
			@PathVariable("userId") long userId,
			@PathVariable("companyId") long companyId
			){
		UserResponseDTO userDto = userMapper.entityToDto(userService.assignCompanyToUser(userId, companyId));
		ResponseDTO<UserResponseDTO> response = new ResponseDTO<UserResponseDTO>("the company was added to the user", userDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
}
