package com.userservice.service;

import java.util.List;

import com.userservice.entity.Company;

public interface CompanyService {

	Company save(Company company);
	
	List<Company> getAll();
}
