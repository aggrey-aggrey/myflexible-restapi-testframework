package com.redventures.api.mpp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.redventures.api.mpp.base.BaseAssertions;
import com.redventures.api.mpp.base.RestCalls;
import com.redventures.api.mpp.config.PropertiesFile;
import com.redventures.api.mpp.utils.ApplicationUrl;
import com.redventures.api.mpp.utils.TestUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Products {
	private static Logger log = LogManager.getLogger(Products.class.getName());
	private static final String productsEndPoint = PropertiesFile.getConfig("mpp_products");

	public static String getAllProducts() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(productsEndPoint);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;

	}

	public String getAPublisher(int publisherId) {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(productsEndPoint + "/" + publisherId);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

}
