package com.aggrey.api.project.teststeps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import com.aggrey.api.base.mppTestStep;
import com.aggrey.api.base.utils.TestUtils;

import io.restassured.path.json.JsonPath;

public class MediaPartnerTestSteps<jsonRes> extends mppTestStep {

	public MediaPartnerTestSteps(String strResponse, JsonPath jsonRes, String element) {
		super(strResponse, jsonRes, element);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void assertResponseContainsExpectedListOfElements(String strResponse, String path, String element) {
		jsonRes = TestUtils.jsonParser(strResponse);
		LinkedHashMap<String, Object> elements = new LinkedHashMap<String, Object>();
		elements.putAll((Map<? extends String, ? extends Object>) jsonRes.get(path));
		Set set = elements.entrySet();

		@SuppressWarnings("rawtypes")
		Iterator iterator = set.iterator();
		System.out.print("--- Printing the key, value pairs ---" + "\n");
		System.out.printf("%-22s%-22s\n", "Key ", "Value");
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();

			System.out.printf("%-22s%-22s\n", me.getKey(), me.getValue());
			Assert.assertTrue(strResponse.contains((CharSequence) me.getKey()));

		}
	}

	@Override
	public void assertResponseContainsExpectedElement(String strResponse, String path, String element) {
		int count = 0;
		jsonRes = TestUtils.jsonParser(strResponse);

		element = String.valueOf(jsonRes.get(path));

		if (element == null) {
			element = "";
			Assert.assertTrue(strResponse.contains(element));
		} else {
			Assert.assertTrue(strResponse.contains(element));

		}

		if (!element.isEmpty()) {
			count++;

			System.out.println("The response contains : " + count + " " + element + " " + "element(s)");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void assertResponseContainsExpectedArrayOfElements(String strResponse, String path, String attribute) {
		List<String> list = new ArrayList<String>();
		@SuppressWarnings("unused")
		int count = 0;
		jsonRes = TestUtils.jsonParser(strResponse);
		list.addAll(((Collection<? extends String>) jsonRes.get(path)));

		for (int i = 0; i < list.size(); i++) {
			count++;

			System.out.println(list.get(i));
			Assert.assertTrue(strResponse.contains(String.valueOf(list.get(i))));

		}

	}

}
