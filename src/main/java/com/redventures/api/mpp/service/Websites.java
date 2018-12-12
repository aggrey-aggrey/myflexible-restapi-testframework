package com.redventures.api.mpp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.redventures.api.mpp.base.BaseAssertions;
import com.redventures.api.mpp.base.RestCalls;
import com.redventures.api.mpp.config.PropertiesFile;
import com.redventures.api.mpp.utils.ApplicationUrl;
import com.redventures.api.mpp.utils.PayLoadGenerator;
import com.redventures.api.mpp.utils.TestUtils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Websites {
	private static Logger log = LogManager.getLogger(Websites.class.getName());
	private static final String websitesEndPoint = PropertiesFile.getConfig("mpp_websites");
	private static final String publishersEndPoint = PropertiesFile.getConfig("mpp_publishers");
	private static String resource;

	public static String getAWebsite(int websiteId) {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websitesEndPoint + "/" + websiteId);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

	public static String addWebsite(int publisherId, String payloadName) {
		Response response;

		String websitesPayload = PayLoadGenerator.generatePayLoadString(payloadName);

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint + "/" + publisherId + "/" + "websites");
		response = RestCalls.POSTRequest(endPointURI, websitesPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Actual response after posting " + strResponse);

		return strResponse;
	}

	public static String listAllWebsites() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websitesEndPoint);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

	public static String putWebsite(int publisherId, int websiteId, String payloadName) {
		Response response;

		String websitesPayload = PayLoadGenerator.generatePayLoadString(payloadName);

		String endPointURI = ApplicationUrl
				.getEndPoint(publishersEndPoint + "/" + publisherId + "/" + "websites" + "/" + websiteId);
		response = RestCalls.PUTRequest(endPointURI, websitesPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after PUT :  " + strResponse);

		return strResponse;
	}

	public static String deleteWebsite(int publisherId, int websiteId) {
		Response response;

		String endPointURI = ApplicationUrl
				.getEndPoint(publishersEndPoint + "/" + publisherId + "/" + "websites" + "/" + websiteId);
		response = RestCalls.DELETERequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 204);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after DELETE :  " + strResponse);

		return strResponse;
	}

	public static String getAllWebsites() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websitesEndPoint);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

}
