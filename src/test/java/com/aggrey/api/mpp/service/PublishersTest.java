package com.aggrey.api.mpp.service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aggrey.api.project.teststeps.MediaPartnerTestSteps;

public class PublishersTest {
	private static String strResponse;
	Publishers publishers = new Publishers();
	@SuppressWarnings("rawtypes")
	MediaPartnerTestSteps mppTestStep = new MediaPartnerTestSteps(null, null, null);

	@BeforeMethod
	@BeforeClass
	public void setUp() {

	}

	@Test(groups = { "PublisherTest", "working" }, priority = 1)
	public void createAPublisher() {
		strResponse = publishers.addPublisher("addPublisherPayload.json");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "", "Object");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "ein", "ein");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "contact", "contact");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "billing", "billing");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "termsOfUseId", "termsOfUseId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "websites", "websites");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "_links");
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 3)
	public void listAllPublishers() {
		strResponse = publishers.getAllPublishers();
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.publisherList[]",
				"publisherList[]");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].objectId",
				"objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].externalId",
				"externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].ein", "ein");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].contact", "contact");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].billing", "billing");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].termsOfUseId",
				"termsOfUseId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].active", "active");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].websites",
				"websites");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.publisherList[].websites[]",
				"websites[]");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[]._links", "_links");

	}

	@Test(groups = { "PublisherTest", "working" }, priority = 1)
	public void returnASinglePublisher() {

		strResponse = publishers.getAPublisher(3);
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "", "Object");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");

		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "ein", "ein");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "contact", "contact");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "billing", "billing");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "termsOfUseId", "termsOfUseId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "websites[]", "websites");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "_links");

	}

	@Test(groups = { "PublisherTest", "broken" })
	public void updateAPublisher() {
		publishers.putPublisher("updatePublishersPayload.json", 3);
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 4)
	public void addAWebsiteForPublisher() {

		strResponse = Websites.addWebsite(4, "addwebsitePayload.json");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 5)
	public void listAPublisherWebsite() {
		strResponse = publishers.listAwebsiteForPublisher(4, 36);

		mppTestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		mppTestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 6)
	public void listAllPublisherWebsites() {
		strResponse = publishers.listAllWebsitesForPublisher(4);

		mppTestStep.assertResponseContainsExpectedListOfElements(strResponse, "_embedded", "_embedded");
		mppTestStep.assertResponseContainsExpectedArrayOfElements(strResponse, "_embedded.websiteList[]",
				"websiteList");

	}

	@Test(groups = { "PublisherTest", "blocked" })
	public void deleteAPublisher() {
		strResponse = publishers.deletePublisher(7);

	}

}
