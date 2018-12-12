package com.redventures.api.mpp.service;

import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class ApplicationTest {
	private static String strResponse;

	@Test
	public void applyAsAdvertiser() {
		strResponse = Websites.addWebsite(2, "addwebsitePayload.json");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.cardPresentationMapList[]",
				"publisherList");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].objectId",
				"objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].externalId",
				"externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].ein", "ein");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse,
				"_embedded.cardPresentationMapList[].contact", "contact");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse,
				"_embedded.cardPresentationMapList[].billing", "billing");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].termsOfUseId",
				"termsOfUseId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].active",
				"active");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[].websites",
				"websites");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[]._links",
				"_links");

	}
}
