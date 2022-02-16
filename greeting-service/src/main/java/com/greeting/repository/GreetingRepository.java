package com.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greeting.entity.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long>{

	//debe ser la clase Greeting
	@Query("From Greeting where type=:type")
	Greeting getByGreetingType(@Param("type") String type);
}
