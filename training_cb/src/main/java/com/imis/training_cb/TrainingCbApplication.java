package com.imis.training_cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TrainingCbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCbApplication.class, args);
	}

}
