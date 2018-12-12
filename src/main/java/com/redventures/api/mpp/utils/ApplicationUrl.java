package com.redventures.api.mpp.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationUrl {
	private static Logger log = LogManager.getLogger(ApplicationUrl.class.getName());

	public static String getEndPoint(String baseUrl) {
		log.info("Base URI : " + baseUrl);
		return baseUrl;
	}

	public static String getEndPoint(String baseUrl, String resource) {
		log.info("URI End Point : " + baseUrl + resource);
		return baseUrl + resource;
	}

}
