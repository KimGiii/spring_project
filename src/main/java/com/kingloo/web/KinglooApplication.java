package com.kingloo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KinglooApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinglooApplication.class, args);
	}
}
