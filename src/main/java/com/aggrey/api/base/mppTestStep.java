package com.aggrey.api.base;

import io.restassured.path.json.JsonPath;

public abstract class mppTestStep {
	protected String strResponse;
	protected JsonPath jsonRes;
	protected String element;

	public mppTestStep(String strResponse, JsonPath jsonRes, String element) {
		this.strResponse = strResponse;
		this.jsonRes = jsonRes;
		this.element = element;
	}

	public String getStrResponse() {
		return strResponse;
	}

	public void setStrResponse(String strResponse) {
		this.strResponse = strResponse;
	}

	public JsonPath getJsonRes() {
		return jsonRes;
	}

	public void setJsonRes(JsonPath jsonRes) {
		this.jsonRes = jsonRes;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public abstract void assertResponseContainsExpectedListOfElements(String strResponse, String path, String element);

	public abstract void assertResponseContainsExpectedElement(String strResponse, String path, String element);

	public abstract void assertResponseContainsExpectedArrayOfElements(String strResponse, String path,
			String attribute);

}
