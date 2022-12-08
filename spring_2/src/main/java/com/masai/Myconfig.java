package com.masai;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("city.properties")
@ComponentScan(basePackages = { "com.masai" })
public class Myconfig {

	@Bean("cities")
	public List<String> cities() {

		return Arrays.asList("talala", "rajkot", "delhi", "mumbai", "veraval");

	}

	@PostConstruct
	public void start() {
		System.out.println("welcome to india...");
	}

	@PreDestroy
	public void end() {
		System.out.println("we'll miss you...");
	}

}
