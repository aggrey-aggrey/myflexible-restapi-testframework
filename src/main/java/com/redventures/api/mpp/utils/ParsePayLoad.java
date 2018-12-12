package com.redventures.api.mpp.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsePayLoad {

	@SuppressWarnings("unchecked")
	public static void parseJsonFile(String payload) {
		{
			JSONParser jsonParser = new JSONParser();

			try {
				String filePath = System.getProperty("user.dir") + "/Payloads/" + payload;
				Object object = jsonParser.parse(new FileReader(filePath));
				JSONObject jsonObject = (JSONObject) object;

				String data = (String) jsonObject.get("data").toString();
				System.out.println(data);
				String attributes = (String) jsonObject.get(data).toString();
				System.out.println(attributes);

				/**
				 * String payloadData =
				 * PayLoadGenerator.generatePayLoadString("publisherPayload.Json"); JSONParser
				 * jsonParser = new JSONParser(); try { JSONObject jsonObject = (JSONObject)
				 * jsonParser.parse(payloadData); String data =
				 * jsonObject.get("data").toString(); System.out.println(data); JSONArray
				 * attributes = (JSONArray) jsonObject.get(data);
				 * System.out.println(attributes.size());
				 * 
				 * }
				 * 
				 * catch (
				 * 
				 * ParseException e) {
				 * 
				 * e.printStackTrace(); }
				 **/

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
