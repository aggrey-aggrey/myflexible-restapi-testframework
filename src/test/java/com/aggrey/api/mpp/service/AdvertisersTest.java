package com.aggrey.api.mpp.service;

import org.testng.annotations.Test;

import com.aggrey.api.project.teststeps.MediaPartnerTestSteps;

public class AdvertisersTest {
	private static String strResponse;
	@SuppressWarnings("rawtypes")
	MediaPartnerTestSteps mppTestStep = new MediaPartnerTestSteps(null, null, null);

	@Test
	public void getAllAdvertisers() {
		strResponse = Advertisers.getAllAdvertisers();

		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.advertiserList[]",
				"advertiserList");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].objectId",
				"objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].externalId",
				"externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].image", "image");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.advertiserList[].active", "active");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.advertiserList[]._links",
				"_links");
	}
}
