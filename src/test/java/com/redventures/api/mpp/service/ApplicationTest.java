package com.redventures.api.mpp.service;

import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class ApplicationTest {
	private static String strResponse;

	@Test
	public void applyAsAdvertiser() {

		strResponse = Application.applyForAdvertiser("applyAdvertiserPayload.json");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.cardPresentationMapList[]",
				"cardPresentationMapList[]");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].objectId",
				"objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse,
				"_embedded.cardPresentationMapList[].cardPresentationCccomId", "cardPresentationCccomId");
		TestStep.assertResponseContainsExpectedElement(strResponse,
				"_embedded.cardPresentationMapList[].cardPresentationId", "cardPresentationId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].status",
				"status");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse,
				"_embedded.cardPresentationMapList[]._links", "links");

	}
}
