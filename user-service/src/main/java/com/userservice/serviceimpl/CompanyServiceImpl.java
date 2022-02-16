package com.userservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.Company;
import com.userservice.exception.EmptyListException;
import com.userservice.repository.CompanyRepository;
import com.userservice.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getAll() {
		List<Company> companies = companyRepository.findAll();
		if(companies.isEmpty()) {
			throw new EmptyListException("the list is empty");
		}
		return companies;
	}
	
	
}
