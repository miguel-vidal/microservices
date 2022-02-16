package com.userservice.service;

import java.util.List;

import com.userservice.entity.User;

public interface UserService {

	List<User> getAll();
	
	User getByName(String name);
	
	User save(User user);
	
	User assignCompanyToUser(long userId, long companyId);
	
	User getById(long id);
}
