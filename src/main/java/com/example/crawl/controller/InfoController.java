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

		try {
			String ip = requestService.getClientIp(request);
			
		    String dbLocation = "your-path-to-mmdb";
		        
		    File database = new File(dbLocation);
		    DatabaseReader dbReader = new DatabaseReader.Builder(database)
		      .build();

		    InetAddress ipAddress = InetAddress.getByName(ip);
		    CityResponse response;
			response = dbReader.city(ipAddress);
		    String countryName = response.getCountry().getName();
		    String cityName = response.getCity().getName();
		    String postal = response.getPostal().getCode();
		    String state = response.getLeastSpecificSubdivision().getName();
		    String latitude = 
		            response.getLocation().getLatitude().toString();
		    String longitude = 
		            response.getLocation().getLongitude().toString();

		    GeoIpDTO geoIpDto = new GeoIpDTO(ip, countryName, cityName, postal, state, latitude, longitude);
		    return geoIpDto.toString();

		} catch (IOException | GeoIp2Exception e) {
			return e.toString();
		}
	}
}
