package io.github.hoteltransilvania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class HotelTransilvaniaApplication {
	
	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(HotelTransilvaniaApplication.class, args);
	}

}
