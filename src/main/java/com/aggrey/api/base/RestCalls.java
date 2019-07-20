package com.aggrey.api.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {
	private static final Logger log = LogManager.getLogger(RestCalls.class.getName());

	public static Response GETRequest(String uRI) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response GETRequest(String uRI, String resource) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uRI + resource);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		// requestSpecification.contentType("application/vnd.api+json");
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String uRI, String strJSON, String resultID) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + resultID + "");
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response PUTRequest(String uRI, String strJSON) {
		log.info("Inside PUTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String uRI, String strJSON) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String uRI) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	/**
	 * public static Response POSTRequest(String uRI, String strJSON, String
	 * sessionID) { log.info("Inside POSTRequest call"); RequestSpecification
	 * requestSpecification = RestAssured.given().body(strJSON);
	 * requestSpecification.contentType(ContentType.JSON);
	 * requestSpecification.header("cookie", "JSESSIONID=" + sessionID+""); Response
	 * response = requestSpecification.post(uRI);
	 * log.debug(requestSpecification.log().all()); return response; }
	 **/

}
