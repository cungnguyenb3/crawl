package com.example.crawl.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {
	String getClientIp(HttpServletRequest request);
}
