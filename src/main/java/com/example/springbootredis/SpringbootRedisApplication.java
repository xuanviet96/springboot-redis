package com.example.springbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRedisApplication {

	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}

}
