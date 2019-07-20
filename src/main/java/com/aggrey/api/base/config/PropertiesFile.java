package com.aggrey.api.base.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesFile {
	private static Logger log = LogManager.getLogger(PropertiesFile.class.getName());
	public Properties properties;
	public File file;
	public FileInputStream fileinputstream;
	private static String configPath = "/src/main/java/com/aggrey/api/base/config/";

	public void loadPropertiesFile() throws IOException {
		properties = new Properties();
		try {
			file = new File(System.getProperty("user.dir") + configPath + "env.properties");
			fileinputstream = new FileInputStream(file);
			properties.load(fileinputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getConfig(String configKey) {
		String getEnv = null;
		PropertiesFile prop = new PropertiesFile();
		try {
			prop.loadPropertiesFile();
			log.info(prop.properties.getProperty(configKey));
			getEnv = prop.properties.getProperty(configKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getEnv;
	}

}
