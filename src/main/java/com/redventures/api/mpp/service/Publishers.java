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

public class Publishers {
	private static Logger log = LogManager.getLogger(Publishers.class.getName());
	private static final String publishersEndPoint = PropertiesFile.getConfig("mpp_publishers");
	private static String resource;

	public String getAllPublishers() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint);
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

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint + "/" + publisherId);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

	public String addPublisher(String payLoadName) {
		Response response;

		String publishersPayload = PayLoadGenerator.generatePayLoadString(payLoadName);

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint);
		response = RestCalls.POSTRequest(endPointURI, publishersPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Actual response after posting " + strResponse);

		return strResponse;
	}

	public String putPublisher(String payLoadName, int publisherId) {
		Response response;

		String publishersPayload = PayLoadGenerator.generatePayLoadString(payLoadName);

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint + "/" + publisherId);
		response = RestCalls.PUTRequest(endPointURI, publishersPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after PUT :  " + strResponse);

		return strResponse;
	}

	public String deletePublisher(int publisherId) {
		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint + "/" + publisherId);
		response = RestCalls.DELETERequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 204);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after DELETE :  " + strResponse);

		return strResponse;
	}

	public String listAwebsiteForPublisher(int publisherId, int websiteId) {
		Response response;

		String endPointURI = ApplicationUrl
				.getEndPoint(publishersEndPoint + "/" + publisherId + "/" + "websites" + "/" + websiteId);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after GET :  " + strResponse);

		return strResponse;
	}

	public String listAllWebsitesForPublisher(int publisherId) {
		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(publishersEndPoint + "/" + publisherId + "/" + "websites");
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after GET :  " + strResponse);

		return strResponse;
	}
}
