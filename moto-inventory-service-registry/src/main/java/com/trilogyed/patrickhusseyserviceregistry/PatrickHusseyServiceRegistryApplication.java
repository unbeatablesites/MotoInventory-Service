package com.trilogyed.patrickhusseyserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PatrickHusseyServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatrickHusseyServiceRegistryApplication.class, args);
	}

}
