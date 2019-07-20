package com.aggrey.api.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.aggrey.api.base.utils.TestUtils;

import io.restassured.response.Response;

public class BaseAssertions {
	private static Logger log = LogManager.getLogger(BaseAssertions.class.getName());

	public static void verifyTrue(boolean flag) {
		Assert.assertTrue(flag);
	}

	public static void verifyFalse(boolean flag) {
		Assert.assertFalse(flag);
	}

	public static void verifyStatusCode(Response response, int status) {
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}

	public static void verifyStatusMessage(Response response, String status) {

		try {
			Assert.assertEquals(TestUtils.getStatusCode(response), status);
			log.trace("assertEquals : PASSED : " + status);
		} catch (Exception e) {
			log.trace("assertEquals : FAILED :  " + status);
			e.printStackTrace();
		}

	}

	public static void assertEquals(String actualString, String expectedString) {
		try {
			Assert.assertEquals(actualString, expectedString);
			log.info("assertEquals : PASSSED");
		} catch (AssertionError e) {
			log.info("assertEquals : FAILED");
			throw e;
		}
	}

	public static void assertEquals(int actualInt, int expectedInt) {
		try {
			Assert.assertEquals(actualInt, expectedInt);
			log.info(" assertEquals : PASSED");
		} catch (AssertionError e) {
			log.info(" assertEquals : FAILED");
			throw e;
		}
	}

}
