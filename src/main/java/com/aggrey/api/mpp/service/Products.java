package com.aggrey.api.mpp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aggrey.api.base.BaseAssertions;
import com.aggrey.api.base.config.PropertiesFile;
import com.aggrey.api.base.utils.ApplicationUrl;
import com.aggrey.api.base.utils.TestUtils;
import com.aggrey.api.project.restcalls.MediaPartnerRestCalls;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Products {
	private static Logger log = LogManager.getLogger(Products.class.getName());
	private static final String productsEndPoint = PropertiesFile.getConfig("mpp_products");
	MediaPartnerRestCalls mediaCalls = new MediaPartnerRestCalls();

	public String getAllProducts() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(productsEndPoint);
		response = mediaCalls.GETRequest(endPointURI);

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
		response = mediaCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

}
