package com.quizendpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class QuizendpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizendpointApplication.class, args);
	}

}
