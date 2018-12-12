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

public class WebsitesTags {
	private static Logger log = LogManager.getLogger(WebsitesTags.class.getName());
	private static final String websiteTagsEndPoint = PropertiesFile.getConfig("mpp_websiteTags");

	public static String getAWebsiteTag(int websiteTagId) {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websiteTagsEndPoint + "/" + websiteTagId);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

	public static String addAWebsiteTag(String payloadName) {
		Response response;

		String websitesPayload = PayLoadGenerator.generatePayLoadString(payloadName);

		String endPointURI = ApplicationUrl.getEndPoint(websiteTagsEndPoint);
		response = RestCalls.POSTRequest(endPointURI, websitesPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Actual response after posting " + strResponse);

		return strResponse;
	}

	public static String listAllWebsiteTags() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websiteTagsEndPoint);
		response = RestCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

	public static String putWebsiteTag(int publisherId, int websiteTagId, String payloadName) {
		Response response;

		String websitesPayload = PayLoadGenerator.generatePayLoadString(payloadName);

		String endPointURI = ApplicationUrl
				.getEndPoint(websiteTagsEndPoint + "/" + publisherId + "/" + "websites" + "/" + websiteTagId);
		response = RestCalls.PUTRequest(endPointURI, websitesPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after PUT :  " + strResponse);

		return strResponse;
	}

	public static String deleteAWebsiteTag(int websiteTagId) {
		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websiteTagsEndPoint + "/" + websiteTagId);
		response = RestCalls.DELETERequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 204);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after DELETE :  " + strResponse);

		return strResponse;
	}

}
