package com.example.restwithspringbootudemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestWithSpringBootUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringBootUdemyApplication.class, args);

		/*

		BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("admin123");

		 */
	}

}
