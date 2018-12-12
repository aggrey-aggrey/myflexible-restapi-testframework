package com.redventures.api.mpp.service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.redventures.api.mpp.base.TestStep;

public class PublishersTest {
	private static String strResponse;
	Publishers publishers = new Publishers();

	@BeforeClass
	public void setUp() {

	}

	@Test
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

	@Test
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

	@Test
	public void returnASinglePublisher() {

		strResponse = publishers.getAPublisher(2);
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

	// @Test
	public void updateAPublisher() {
		publishers.putPublisher("updatedPublishersPayload.json", 2);
	}

	@Test
	public void addAWebsiteForPublisher() {

		strResponse = Websites.addWebsite(2, "addwebsitePayload.json");
		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
	}

	@Test
	public void listAPublisherWebsite() {
		strResponse = publishers.listAwebsiteForPublisher(2, 3);

		TestStep.assertResponseContainsExpectedElement(strResponse, "objectId", "objectId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "externalId", "externalId");
		TestStep.assertResponseContainsExpectedElement(strResponse, "name", "name");
		TestStep.assertResponseContainsExpectedElement(strResponse, "url", "url");
		TestStep.assertResponseContainsExpectedElement(strResponse, "description", "description");
		TestStep.assertResponseContainsExpectedElement(strResponse, "active", "active");
		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_links", "links");
	}

	@Test
	public void listAllPublisherWebsites() {
		strResponse = publishers.listAllWebsitesForPublisher(2);

		TestStep.assertResponseContainsExpectedListOfElements(strResponse, "_embedded", "_embedded");
		TestStep.assertResponseContainsExpectedArrayListOfElements(strResponse, "_embedded.websiteList[]",
				"websiteList");

	}

	// @Test
	public void deleteAPublisher() {
		strResponse = publishers.deletePublisher(11);

	}

}
