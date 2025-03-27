package com.example.mbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbsApplication.class, args);
	}
}
