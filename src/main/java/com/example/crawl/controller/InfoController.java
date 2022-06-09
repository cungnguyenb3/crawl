package com.example.crawl.controller;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crawl.service.RequestService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import dto.GeoIpDTO;

@RestController
public class InfoController {
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping("/")
	public String getClientId(HttpServletRequest request)  {
		String ip = requestService.getClientIp(request);
		return ip;
	}
}
