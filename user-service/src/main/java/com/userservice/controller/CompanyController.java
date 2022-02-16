package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.mapper.CompanyMapper;
import com.userservice.requestdto.CompanyRequestDTO;
import com.userservice.responsedto.CompanyResponseDTO;
import com.userservice.responsedto.ResponseDTO;
import com.userservice.service.CompanyService;


@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@GetMapping("/")
	public ResponseEntity<ResponseDTO<List<CompanyResponseDTO>>> getAllUsers(){
		List<CompanyResponseDTO> list = companyMapper.listOfDto(companyService.getAll());
		ResponseDTO<List<CompanyResponseDTO>> response = new ResponseDTO<>("all the companies in the DB",list);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//get by name
	//save
	@PostMapping("/")
	public ResponseEntity<ResponseDTO<CompanyResponseDTO>> saveUser(
			@RequestBody CompanyRequestDTO user
			){
	
		CompanyResponseDTO userDto = companyMapper.entityToDto(companyService.save( companyMapper.dtoToEntity(user) ));
		ResponseDTO<CompanyResponseDTO> response = new ResponseDTO<CompanyResponseDTO>("the user was saved successfully", userDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
