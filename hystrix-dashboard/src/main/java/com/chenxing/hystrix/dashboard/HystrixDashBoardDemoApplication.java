package com.chenxing.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashBoardDemoApplication.class, args);
	}

}
