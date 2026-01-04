package com.javacodex.unittesting;

//import com.javacodex.unittesting.business.SomeBusinessWithDataService;
import com.javacodex.unittesting.business.SomeBusinessMockImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestingApplication {

	public static void main(String[] args) {

		SpringApplication.run(UnitTestingApplication.class, args);
		System.out.println("hello unit testing....");

		SomeBusinessMockImpl test= new SomeBusinessMockImpl();
		System.out.println(test.calculateSumUsingDataService());
	}

}
