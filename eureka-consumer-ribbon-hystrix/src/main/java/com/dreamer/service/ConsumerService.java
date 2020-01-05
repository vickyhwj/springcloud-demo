package com.dreamer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.concurrent.Future;

@Service("consumerService")
public class ConsumerService {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback",
			commandProperties ={
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value="3000000")
			} )
	public Future< String> consumer() {
		return new AsyncResult<String>() {
			@Override
			public String invoke() {
				return restTemplate.getForObject("http://eureka-client/dc", String.class);
			}
		} ;
//		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}

	@HystrixCommand(fallbackMethod = "fallback",
			commandProperties ={
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value="3000000")
			} )
	public String consumer1() {

		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}
	
	public String fallback() {
		return "fallback";
	}
}
