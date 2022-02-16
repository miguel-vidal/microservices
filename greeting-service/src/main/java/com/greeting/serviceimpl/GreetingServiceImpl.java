package com.greeting.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeting.entity.Greeting;
import com.greeting.exception.EmptyListException;
import com.greeting.repository.GreetingRepository;
import com.greeting.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{

	@Autowired
	private GreetingRepository greetingRepository;
	
	@Override
	public Greeting save(Greeting greeting) {
		return greetingRepository.save(greeting);
	}

	@Override
	public List<Greeting> getAll() {
		List<Greeting> greetings = greetingRepository.findAll();
		if(greetings.isEmpty()) {
			throw new EmptyListException("There is no data");
		}
		return greetings;
	}

	
	@Override
	public Greeting getByType(String type) {
		return greetingRepository.getByGreetingType(type);
	}

}
