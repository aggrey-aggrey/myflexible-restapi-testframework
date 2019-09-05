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

public class Advertisers {
	private static Logger log = LogManager.getLogger(Advertisers.class.getName());
	private static final String advertiserEndPoint = PropertiesFile.getConfig("mpp_advertisers");
	static MediaPartnerRestCalls mediaCalls = new MediaPartnerRestCalls();

	public static String getAllAdvertisers() {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(advertiserEndPoint);
		response = mediaCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 200);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		@SuppressWarnings("unused")
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;

	}

	public String getAPublisher(int publisherId) {

		Response response;

		String endPointURI = ApplicationUrl.getEndPoint(advertiserEndPoint + "/" + publisherId);
		response = mediaCalls.GETRequest(endPointURI);

		TestUtils.getStatusMessage(response);

		log.info(response.getBody().asString());

		String strResponse = TestUtils.getResposeString(response);
		@SuppressWarnings("unused")
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		return strResponse;
	}

}
