package com.dreamer;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	private final Logger logger = Logger.getLogger(getClass());
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String trace() {
		logger.info("call sleuth-trace-1");
		return restTemplate().getForEntity("http://sleuth-trace-2/api", String.class).getBody();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
