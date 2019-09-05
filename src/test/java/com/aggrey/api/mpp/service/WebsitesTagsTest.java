package com.aggrey.api.mpp.service;

import org.testng.annotations.Test;

import com.aggrey.api.project.teststeps.MediaPartnerTestSteps;

public class WebsitesTagsTest {
	private static String strResponse;

	@SuppressWarnings("rawtypes")
	static MediaPartnerTestSteps mppTestStep = new MediaPartnerTestSteps(null, null, null);

	@Test(priority = 1)

	public void addAWebsiteTag() {
		strResponse = WebsitesTags.addAWebsiteTag("addWebsiteTagsPayload.json");

		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_links.self.href", "href");
	}

	@Test(priority = 2)
	public void getAWebsiteTag() {
		strResponse = WebsitesTags.getAWebsiteTag(2);

		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_links.self.href", "href");
	}

	@Test(priority = 3)
	public void listAllWebsiteTags() {
		strResponse = WebsitesTags.listAllWebsiteTags();

		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.websiteTagList[]",
				"websiteTagList");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.websiteTagList[].objectId",
				"objectId");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.websiteTagList[].name",
				"name");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.websiteTagList[].description",
				"description");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse,
				"_embedded.websiteTagList[].description._links", "_links");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse,
				"_embedded.websiteTagList[].description._links.self.href", "href");
	}

	@Test(priority = 4)
	public void deleteAWebsiteTag() {
		strResponse = WebsitesTags.deleteAWebsiteTag(3);
	}
}
