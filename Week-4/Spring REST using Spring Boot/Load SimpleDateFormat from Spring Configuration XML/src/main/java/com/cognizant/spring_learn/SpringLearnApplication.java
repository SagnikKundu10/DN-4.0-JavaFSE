package com.cognizant.spring_learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}

	public static void displayDate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

		// Get the SimpleDateFormat bean
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			// Parse and print the date
			Date date = format.parse("31/12/2018");
			System.out.println("Parsed Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

