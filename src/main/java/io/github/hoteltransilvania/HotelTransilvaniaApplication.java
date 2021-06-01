package io.github.hoteltransilvania;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HotelTransilvaniaApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HotelTransilvaniaApplication.class, args);
	}
}
