package com.aggrey.api.mpp.service;

import org.testng.annotations.Test;

import com.aggrey.api.project.teststeps.MediaPartnerTestSteps;

public class WebsitesTest {
	private static String strResponse;
	@SuppressWarnings("rawtypes")
	MediaPartnerTestSteps mppTestStep = new MediaPartnerTestSteps(null, null, null);

	@Test(priority = 2)
	public void getAWebsite() {

		strResponse = Websites.getAWebsite(1);
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	@Test(priority = 3)
	public void getAllWebsite() {

		strResponse = Websites.getAllWebsites();

		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");

	}

	@Test(priority = 1)
	public void addWebsite() {

		strResponse = Websites.addWebsite(2, "addwebsitePayload.json");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	// @Test(priority = 4)
	public void updateWebsite() {
		strResponse = Websites.putWebsite(2, 4, "updateWebsitePayload.json");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");

	}

	// @Test(priority = 5)
	public void deleteAWebsite() {

		Websites.deleteWebsite(2, 3);
	}

}
