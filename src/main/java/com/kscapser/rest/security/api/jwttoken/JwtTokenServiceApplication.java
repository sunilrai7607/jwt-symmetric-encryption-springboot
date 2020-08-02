package com.kscapser.rest.security.api.jwttoken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtTokenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenServiceApplication.class, args);
	}

	@Bean
	public JacksonJsonParser jsonParser(){
		return new JacksonJsonParser();
	}

}
