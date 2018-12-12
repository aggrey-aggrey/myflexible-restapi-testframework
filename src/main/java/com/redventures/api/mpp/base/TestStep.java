package com.redventures.api.mpp.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import com.redventures.api.mpp.utils.TestUtils;

import io.restassured.path.json.JsonPath;

public class TestStep {
	private static String strResponse;
	private static JsonPath jsonRes;
	private static String element;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void assertResponseContainsExpectedListOfElements(String strResponse, String path, String element) {

		jsonRes = TestUtils.jsonParser(strResponse);
		LinkedHashMap<String, Object> elements = new LinkedHashMap<String, Object>();
		elements.putAll((Map<? extends String, ? extends Object>) jsonRes.get(path));
		Set set = elements.entrySet();
		Iterator iterator = set.iterator();
		System.out.print("--- Printing the key, value pairs ---" + "\n");
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.print("Key is : " + me.getKey() + " & Value is: " + me.getValue() + "\n");
			Assert.assertTrue(strResponse.contains((CharSequence) me.getKey()));

		}

	}

	public static void assertResponseContainsExpectedElement(String strResponse, String path, String object) {
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
	public static void assertResponseContainsExpectedArrayListOfElements(String strResponse, String path,
			String attribute) {
		List<String> list = new ArrayList<String>();
		int count = 0;
		jsonRes = TestUtils.jsonParser(strResponse);
		list.addAll(((Collection<? extends String>) jsonRes.get(path)));

		for (int i = 0; i < list.size(); i++) {
			count++;

			System.out.println(list.get(i));
			Assert.assertTrue(strResponse.contains(String.valueOf(list.get(i))));

		}

		// System.out.println("The response has : " + count + " " + attribute + " " +
		// "objects");
		// Assert.assertEquals(count, list.size());

	}

}
