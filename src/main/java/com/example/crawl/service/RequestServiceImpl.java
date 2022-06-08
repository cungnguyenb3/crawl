package com.example.crawl.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

	private final String LOCALHOST_IPV4 = "127.0.0.1";
	private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
	
	@Override
	public String getClientIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Forwarded-For");
		System.out.println("ip1: " +ipAddress);
		if(!ipAddress.isEmpty() || ipAddress.equalsIgnoreCase("unknown")) {
			System.out.println("ip2: " +ipAddress);
			ipAddress = request.getHeader("Proxy-Client-IP");
		}

		if(!ipAddress.isEmpty() || ipAddress.equalsIgnoreCase("unknown")) {
			System.out.println("ip3: " +ipAddress);
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}

		if(!ipAddress.isEmpty() || ipAddress.equalsIgnoreCase("unknown")) {
			System.out.println("ip4: " +ipAddress);
			ipAddress = request.getRemoteAddr();
			if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
				try {
					System.out.println("ip1: " +ipAddress);
					InetAddress inetAddress = InetAddress.getLocalHost();
					ipAddress = inetAddress.getHostAddress();
				} catch (UnknownHostException e) {
					logger.error("Could not get ip from InetAddress" + e.getMessage());
				}
			}
		}

		if(!ipAddress.isEmpty()
				&& ipAddress.length() > 15
				&& ipAddress.indexOf(",") > 0) {
			System.out.println("ip5: " +ipAddress);
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}
		
		System.out.println("ip6: " +ipAddress);
		return ipAddress;
	}
	
}
 
