package com.c3.lsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = { //
		"classpath:application.properties", //
		"response-message.properties" }, //
		ignoreResourceNotFound = false)
@SpringBootApplication
@EnableAutoConfiguration
public class LifeSuccessGroup extends SpringBootServletInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.web.servlet.support.SpringBootServletInitializer#
	 * configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LifeSuccessGroup.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LifeSuccessGroup.class, args);
	}
}
