package com.userservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.userservice.entity.User;
import com.userservice.requestdto.UserRequestDTO;
import com.userservice.responsedto.UserResponseDTO;

@Component
public class UserMapper {
	
	public UserResponseDTO entityToDto(User user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setAddress(user.getAddress());
		dto.setAge(user.getAge());
		dto.setCompany( user.getCompany() );
		
		return dto;
	}
	
	public User dtoToEntity(UserRequestDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setAddress(dto.getAddress());
		user.setAge(dto.getAge());
		return user;
	}
	
	public List<UserResponseDTO> listOfDto(List<User> users){
		List<UserResponseDTO> dto = new ArrayList<>();
		users.stream().forEach(user-> dto.add( entityToDto(user) ) );
		return dto;
	}
}
