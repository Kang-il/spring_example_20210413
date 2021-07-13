package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



//com 하위의 모든 패키지를 조회하여 Controller찾을 것 
@ComponentScan(basePackages = "com.*")

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //DB설정을 안보겠다 (임시)
//Spring 기본 흐름의 시작
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
		
	}
}
