package com.medway.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.medway.doc")
@EnableJpaRepositories(basePackages = "com.medway.doc.repository")
public class DocApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocApplication.class, args);
	}

}
