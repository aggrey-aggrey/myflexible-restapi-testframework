package com.aggrey.api.mpp.service;

import org.testng.annotations.Test;

import com.aggrey.api.project.teststeps.MediaPartnerTestSteps;

public class ApplicationTest {
	private static String strResponse;
	MediaPartnerTestSteps mppTestStep = new MediaPartnerTestSteps(null, null, null);

	@Test
	public void applyAsAdvertiser() {

		strResponse = Application.applyForAdvertiser("applyAdvertiserPayload.json");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.cardPresentationMapList[]",
				"cardPresentationMapList[]");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].objectId",
				"objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse,
				"_embedded.cardPresentationMapList[].cardPresentationCccomId", "cardPresentationCccomId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse,
				"_embedded.cardPresentationMapList[].cardPresentationId", "cardPresentationId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.cardPresentationMapList[].status",
				"status");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse,
				"_embedded.cardPresentationMapList[]._links", "links");

	}
}
