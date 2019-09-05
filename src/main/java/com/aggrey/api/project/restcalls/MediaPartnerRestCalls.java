package com.aggrey.api.project.restcalls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aggrey.api.base.RestCalls;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MediaPartnerRestCalls extends RestCalls {
	private static final Logger log = LogManager.getLogger(MediaPartnerRestCalls.class.getName());

	@Override
	public Response GETRequest(String uRI) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;

	}

	@Override
	public Response GETRequest(String uRI, String resource) {
		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI + resource);
		log.debug(requestSpecification.log().all());
		return response;
	}

	@Override
	public Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		// requestSpecification.contentType("application/vnd.api+json");
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	@Override
	public Response POSTRequest(String uRI, String strJSON, String sessionID) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID + "");
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	@Override
	public Response PUTRequest(String uRI, String strJSON, int pathParam) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		// requestSpecification.header("cookie", "JSESSIONID=" + resultID + "");
		Response response = requestSpecification.post(uRI + pathParam);
		log.debug(requestSpecification.log().all());
		return response;
	}

	@Override
	public Response DELETERequest(String uRI, String strJSON) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	@Override
	public Response DELETERequest(String uRI, int ID) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	@Override
	public Response DELETERequest(String uRI) {
		// TODO Auto-generated method stub
		return null;
	}

}
