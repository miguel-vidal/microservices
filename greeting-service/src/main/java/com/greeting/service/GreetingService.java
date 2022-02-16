package com.greeting.service;

import java.util.List;

import com.greeting.entity.Greeting;

public interface GreetingService {

	Greeting save(Greeting greeting);
	
	List<Greeting> getAll();
	
	Greeting getByType(String type);
}
