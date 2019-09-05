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

public class Application {
	private static Logger log = LogManager.getLogger(Application.class.getName());
	private static final String applicationEndPoint = PropertiesFile.getConfig("mpp_application");
	static MediaPartnerRestCalls mediaCalls = new MediaPartnerRestCalls();

	public static String applyForAdvertiser(String payLoadName) {
		Response response;

		String publishersPayload = PayLoadGenerator.generatePayLoadString(payLoadName);

		String endPointURI = ApplicationUrl.getEndPoint(applicationEndPoint);
		response = mediaCalls.POSTRequest(endPointURI, publishersPayload);

		TestUtils.getStatusMessage(response);
		BaseAssertions.verifyStatusCode(response, 201);

		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);

		log.info("Actual response after posting " + strResponse);

		return strResponse;
	}

}
