package com.redventures.api.mpp.service;

import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class AdvertisersTest {
	private static String strResponse;

	@Test
	public void getAllAdvertisers() {
		strResponse = Advertisers.getAllAdvertisers();

		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.advertiserList[]",
				"advertiserList");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].externalId",
				"externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].image", "image");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].active", "active");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.advertiserList[]._links",
				"_links");
	}
}
