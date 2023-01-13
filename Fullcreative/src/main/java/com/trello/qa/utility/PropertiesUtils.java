package com.trello.qa.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.trello.qa.base.TestBase;

public class PropertiesUtils extends TestBase {
public 	static FileInputStream fis;
	
	public static String  readProperty(String key) {
		log.info("reading property file for a key");
		
		Properties prop = new Properties();
		try {
			fis =new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			log.info("value not found in config file");
			e.printStackTrace();
		}
		log.info("Key value found is"+prop.getProperty(key));
		return prop.getProperty(key);
}
}
