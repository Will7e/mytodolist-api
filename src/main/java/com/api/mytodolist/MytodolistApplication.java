package com.api.mytodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MytodolistApplication {

@GetMapping("/")
public String welcome(){
	return "Welcome! This is Azure - To do CRUD Api";
}
	public static void main(String[] args) {
		SpringApplication.run(MytodolistApplication.class, args);
	}

}
