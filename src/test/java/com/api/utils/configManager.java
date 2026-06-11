package com.api.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configManager {
	private static Properties p=new Properties();
	private static  String path="config/config.properties";
	private static String env;
	private configManager() {
		
	}
	static {
		env=System.getProperty("env","qa");
		env=env.toLowerCase().trim();
		switch(env) {
		case "dev" -> path="config/configdev.properties";
		
		case "qa" -> path="config/configqa.properties";
			
		case "uat" -> path="config/configuat.properties";
			
		default -> path="config/config.properties";
		}
		//pointing to config file
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		if(input==null)
			throw new RuntimeException("there is no file " + path);
		try {
			//reading the config file
			
			//load the properties file with load()
			p.load(input);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (IOException e) {
		  e.printStackTrace();
		}
	}
	public static String getProperty(String key) {
		
	 return p.getProperty(key);
		
	}

}
