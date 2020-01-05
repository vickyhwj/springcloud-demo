package com.dreamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamer.service.ConsumerService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class DcController {
	@Autowired
	ConsumerService consumerService;
	
	@GetMapping("/consumer")
	public String dc() throws ExecutionException, InterruptedException {
		long start=System.currentTimeMillis();
	 	Future<String> str1= consumerService.consumer();
		Future<String> str2=consumerService.consumer();;
		System.out.println(str1.get());
		System.out.println(str2.get());
		System.out.println(System.currentTimeMillis()-start);
		return str1.get();
	}

	@GetMapping("/consumer1")
	public String dc1() throws ExecutionException, InterruptedException {
		long start=System.currentTimeMillis();

		System.out.println(consumerService.consumer1());
		System.out.println(consumerService.consumer1());
		System.out.println(System.currentTimeMillis()-start);
		return consumerService.consumer1();
	}
}
