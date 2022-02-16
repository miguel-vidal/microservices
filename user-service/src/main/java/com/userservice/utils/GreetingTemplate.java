package com.userservice.utils;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.userservice.responsedto.GreetingResponseDTO;
import com.userservice.responsedto.TemplateResponseDTO;

@Component
public class GreetingTemplate {

	Logger logger =LoggerFactory.getLogger(GreetingTemplate .class);
	
	public GreetingResponseDTO getGreeting() {
		logger.info(Integer.toString(LocalDateTime.now().getHour()));
		int hour= LocalDateTime.now().getHour();
		String type="";
		
		if(hour >= 5 && hour < 12){
		    type="mañana";
		    
		}else if(hour >= 12 && hour <= 18){
		    type="tarde";
		    
		}else if(hour >= 19 || hour < 4){
			type="noche";
		}
		
		String uri = "http://localhost:8081/api/greetings/"+type;
		//String uri= "https://jsonplaceholder.typicode.com/users";
		RestTemplate rest = new RestTemplate();
		ResponseEntity<TemplateResponseDTO> result = rest.getForEntity(uri,TemplateResponseDTO.class);
		GreetingResponseDTO dtoResponse = new GreetingResponseDTO(
				result.getBody().getResponse().getType(),
				result.getBody().getResponse().getGreeting());
		return dtoResponse;
	}
}
