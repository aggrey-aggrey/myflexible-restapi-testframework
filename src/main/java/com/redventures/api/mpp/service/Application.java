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

public class Application {
	private static Logger log = LogManager.getLogger(Application.class.getName());
	private static final String applicationEndPoint = PropertiesFile.getConfig("mpp_application");

	public String applyAsAdvertiser(String payLoadName) {
		Response response;

		String publishersPayload = PayLoadGenerator.generatePayLoadString(payLoadName);

		String endPointURI = ApplicationUrl.getEndPoint(applicationEndPoint);
		response = RestCalls.POSTRequest(endPointURI, publishersPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Actual response after posting " + strResponse);

		return strResponse;
	}

}
