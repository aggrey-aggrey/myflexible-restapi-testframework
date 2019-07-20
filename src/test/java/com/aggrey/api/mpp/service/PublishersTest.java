package com.redventures.api.mpp.service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class PublishersTest {
	private static String strResponse;
	Publishers publishers = new Publishers();

	@BeforeMethod
	@BeforeClass
	public void setUp() {

	}

	@Test(groups = { "PublisherTest", "working" }, priority = 1)
	public void createAPublisher() {
		strResponse = publishers.addPublisher("addPublisherPayload.json");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "", "Object");
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "ein", "ein");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "contact", "contact");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "billing", "billing");
		TestStep.assertResponseContainsExpectedElement(strResponse, "termsOfUseId", "termsOfUseId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedElement(strResponse, "websites", "websites");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "_links");
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 3)
	public void listAllPublishers() {
		strResponse = publishers.getAllPublishers();
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[]",
				"publisherList");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].externalId",
				"externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].ein", "ein");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[].contact",
				"contact");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[].billing",
				"billing");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].termsOfUseId",
				"termsOfUseId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "_embedded.publisherList[].active", "active");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[].websites",
				"websites");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.publisherList[]._links",
				"_links");

	}

	@Test(groups = { "PublisherTest", "working" }, priority = 2)
	public void returnASinglePublisher() {

		strResponse = publishers.getAPublisher(5);
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "", "Object");
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "ein", "ein");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "contact", "contact");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "billing", "billing");
		TestStep.assertResponseContainsExpectedElement(strResponse, "termsOfUseId", "termsOfUseId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "websites[]", "websites");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "_links");

	}

	@Test(groups = { "PublisherTest", "broken" })
	public void updateAPublisher() {
		publishers.putPublisher("updatedPublishersPayload.json", 5);
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 4)
	public void addAWebsiteForPublisher() {

		strResponse = Websites.addWebsite(2, "addwebsitePayload.json");
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 5)
	public void listAPublisherWebsite() {
		strResponse = publishers.listAwebsiteForPublisher(5, 5);

		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	@Test(groups = { "PublisherTest", "working" }, priority = 6)
	public void listAllPublisherWebsites() {
		strResponse = publishers.listAllWebsitesForPublisher(5);

		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_embedded", "_embedded");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.websiteList[]",
				"websiteList");

	}

	@Test(groups = { "PublisherTest", "blocked" })
	public void deleteAPublisher() {
		strResponse = publishers.deletePublisher(6);

	}

}
