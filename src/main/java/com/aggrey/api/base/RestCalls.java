package com.aggrey.api.base;

import io.restassured.response.Response;

public abstract class RestCalls {
	public abstract Response GETRequest(String uRI);

	public abstract Response GETRequest(String uRI, String resource);

	public abstract Response POSTRequest(String uRI, String strJSON);

	public abstract Response POSTRequest(String uRI, String strJSON, String sessionID);

	public abstract Response PUTRequest(String uRI, String strJSON, int pathParam);

	public abstract Response DELETERequest(String uRI, String strJSON);

	public abstract Response DELETERequest(String uRI, int ID);

	public abstract Response DELETERequest(String uRI);

}
