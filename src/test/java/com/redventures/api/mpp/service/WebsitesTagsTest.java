package com.redventures.api.mpp.service;

import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class WebsitesTagsTest {
	private static String strResponse;

	@Test(priority = 1)
	public void addAWebsiteTag() {
		strResponse = WebsitesTags.addAWebsiteTag("addWebsiteTagsPayload.json");

		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_links.self.href", "href");
	}

	@Test(priority = 2)
	public void getAWebsiteTag() {
		strResponse = WebsitesTags.getAWebsiteTag(2);

		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_links.self.href", "href");
	}

	@Test(priority = 3)
	public void listAllWebsiteTags() {
		strResponse = WebsitesTags.listAllWebsiteTags();

		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.websiteTagList[]",
				"websiteTagList");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.websiteTagList[].objectId",
				"objectId");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.websiteTagList[].name",
				"name");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse,
				"_embedded.websiteTagList[].description", "description");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse,
				"_embedded.websiteTagList[].description._links", "_links");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse,
				"_embedded.websiteTagList[].description._links.self.href", "href");
	}

	@Test(priority = 4)
	public void deleteAWebsiteTag() {
		strResponse = WebsitesTags.deleteAWebsiteTag(3);
	}
}
