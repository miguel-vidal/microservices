package com.userservice.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.Company;
import com.userservice.entity.User;
import com.userservice.exception.EmptyListException;
import com.userservice.exception.NotFoundException;
import com.userservice.exception.NullException;
import com.userservice.repository.CompanyRepository;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<User> getAll() {
		List<User> users =userRepository.findAll();
		if(users.isEmpty()) {
			throw new EmptyListException("the list is empty");
		}
		return users;
	}

	@Override
	public User getByName(String name) {
		User getByName = userRepository.findByName(name);
		if(Objects.isNull(getByName)) {
			throw new NullException("the element doesnt exist");
		}
		return getByName;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(long id) {
		return userRepository.findById(id).orElseThrow( ()-> new NotFoundException("the id is incorrect") );
	}
	
	@Override
	public User assignCompanyToUser(long userId, long companyId) {
		User user = getById(userId);
		Company company = companyRepository.findById(companyId).orElseThrow(()->new NotFoundException("the id is incorrect"));
		user.setCompany(company);
		
		return userRepository.save(user);
	}

}
