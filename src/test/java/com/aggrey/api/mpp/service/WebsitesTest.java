package com.redventures.api.mpp.service;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class WebsitesTest {
	private static String strResponse;

	@Test(priority = 2)
	public void getAWebsite() {

		strResponse = Websites.getAWebsite(1);
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	@Test(priority = 3)
	public void getAllWebsite() {

		strResponse = Websites.getAllWebsites();
		/**
		 * TestStep.assertResponseContainsExpectedElement(strResponse, "objectId",
		 * "objectId"); TestStep.assertResponseContainsExpectedElement(strResponse,
		 * "externalId", "externalId");
		 * TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		 * TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		 * TestStep.assertResponseContainsExpectedElement(strResponse, "description",
		 * "description"); TestStep.assertResponseContainsExpectedElement(strResponse,
		 * "active", "active");
		 * TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links",
		 * "links");
		 **/
	}

	@Test(priority = 1)
	public void addWebsite() {

		strResponse = Websites.addWebsite(2, "addwebsitePayload.json");
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	// @Test(priority = 4)
	public void updateWebsite() {
		strResponse = Websites.putWebsite(2, 4, "updateWebsitePayload.json");
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");

	}

	// @Test(priority = 5)
	public void deleteAWebsite() {

		Websites.deleteWebsite(2, 3);
	}

}
