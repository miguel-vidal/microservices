package com.userservice.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userservice.entity.Company;
import com.userservice.requestdto.CompanyRequestDTO;
import com.userservice.responsedto.CompanyResponseDTO;
import com.userservice.responsedto.UserResponseDTO;

@Component
public class CompanyMapper {

	@Autowired
	private UserMapper userMapper;
	
	public CompanyResponseDTO entityToDto(Company company) {
		CompanyResponseDTO dto = new CompanyResponseDTO();
		dto.setId(company.getId());
		dto.setCompany(company.getCompany());
		dto.setAddress(company.getAddresss());
		if(Objects.isNull(company.getUsers())) {
			List<UserResponseDTO> usersList = Arrays.asList(new UserResponseDTO());
			dto.setUsers(usersList);
		}else {
			dto.setUsers( userMapper.listOfDto(company.getUsers()) );
		}
		return dto;
	}
	
	public Company dtoToEntity(CompanyRequestDTO dto) {
		Company comp = new Company();
		comp.setCompany(dto.getCompany());
		comp.setAddresss(dto.getAddress());
		return comp;
	}
	
	public List<CompanyResponseDTO> listOfDto(List<Company> companies){
		List<CompanyResponseDTO> dto = new ArrayList<>();
		companies.stream().forEach(company-> dto.add( entityToDto(company) ) );
		return dto;
	}
}
