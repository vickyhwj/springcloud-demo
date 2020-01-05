package com.dreamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamer.api.DcClient;

@RestController
public class DcController {
	@Autowired
	DcClient dcClient;
	
	@GetMapping("/consumer")
	public String dc() {
		return dcClient.consumer();
	}
}
