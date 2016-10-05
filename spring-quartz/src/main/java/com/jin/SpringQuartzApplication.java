package com.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
public class SpringQuartzApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringQuartzApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringQuartzApplication.class);
    }

}
