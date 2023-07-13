package com.example.CuddleCare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.CuddleCare")
public class CuddleCareApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CuddleCareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hey This is Nareash");
	}
}
