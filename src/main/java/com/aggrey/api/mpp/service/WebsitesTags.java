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

public class WebsitesTags {
	private static Logger log = LogManager.getLogger(WebsitesTags.class.getName());
	private static final String websiteTagsEndPoint = PropertiesFile.getConfig("mpp_websiteTags");
	static MediaPartnerRestCalls mediaCalls = new MediaPartnerRestCalls();

	public static String getAWebsiteTag(int websiteTagId) {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(websiteTagsEndPoint + "/" + websiteTagId);
		response = mediaCalls.GETRequest(endPointURI);

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
		response = mediaCalls.POSTRequest(endPointURI, websitesPayload);

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
		response = mediaCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

	public String putWebsiteTag(int publisherId, int websiteTagId, String payloadName) {
		Response response;

		String websitesPayload = PayLoadGenerator.generatePayLoadString(payloadName);

		String endPointURI = ApplicationUrl
				.getEndPoint(websiteTagsEndPoint + "/" + publisherId + "/" + "websites" + "/" + websiteTagId);
		response = mediaCalls.PUTRequest(endPointURI, websitesPayload, websiteTagId);

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
		response = mediaCalls.DELETERequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 204);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Response after DELETE :  " + strResponse);

		return strResponse;
	}

}
