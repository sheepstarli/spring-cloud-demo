package com.chenxing.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BookDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDemoApplication.class, args);
	}
}
