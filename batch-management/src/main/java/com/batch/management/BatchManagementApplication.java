package com.batch.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class BatchManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchManagementApplication.class, args);
	}

}
