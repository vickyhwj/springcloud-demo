package com.dreamer.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/dc")
	public String dc() throws InterruptedException {
		// 测试Hystrix服务降级
		// Thread.sleep(5000L);
		
		String services = "Register Services=" + discoveryClient.getServices().stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(services);
		Thread.sleep(1000);
		return services;
	}
}