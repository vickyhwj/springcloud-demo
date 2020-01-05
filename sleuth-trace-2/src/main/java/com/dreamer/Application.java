package com.dreamer;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	private final Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String trace() {
		logger.info("call sleuth-trace-2");
		return "Trace-Test-2";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
