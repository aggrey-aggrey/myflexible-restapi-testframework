package com.aggrey.api.mpp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aggrey.api.base.BaseAssertions;
import com.aggrey.api.base.config.PropertiesFile;
import com.aggrey.api.base.utils.ApplicationUrl;
import com.aggrey.api.base.utils.PayLoadGenerator;
import com.aggrey.api.base.utils.TestUtils;
import com.aggrey.api.project.restcalls.MediaPartnerRestCalls;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Websites {
	private static Logger log = LogManager.getLogger(Websites.class.getName());
	private static final String websitesEndPoint = PropertiesFile.getConfig("mpp_websites");
	private static final String publishersEndPoint = PropertiesFile.getConfig("mpp_publishers");
	private static String resource;
	static MediaPartnerRestCalls mediaCalls = new MediaPartnerRestCalls();

	public static String getAWebsite(int websiteId) {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websitesEndPoint + "/" + websiteId);
		response = mediaCalls.GETRequest(endPointURI);

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
		response = mediaCalls.POSTRequest(endPointURI, websitesPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Actual response after posting " + strResponse);

		return strResponse;
	}

	public String listAllWebsites() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websitesEndPoint);
		response = mediaCalls.GETRequest(endPointURI);

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
		response = mediaCalls.PUTRequest(endPointURI, websitesPayload, websiteId);

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
		response = mediaCalls.DELETERequest(endPointURI);

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
		response = mediaCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

}
