package com.example.crawl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crawl.service.RequestService;

@RestController
public class InfoController {
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/hello")
	public String getClientId(HttpServletRequest request) {
		return requestService.getClientIp(request);
	}
}
