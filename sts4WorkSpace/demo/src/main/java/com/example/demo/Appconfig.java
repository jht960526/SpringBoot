package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Appconfig {
	
	Appconfig(){
		log.info("= = 생성 = =");
	}
	
	@Bean // 객체를 만든다.
	public SpringComponent1 makeBean() {
		return new SpringComponent1();
	}
}
