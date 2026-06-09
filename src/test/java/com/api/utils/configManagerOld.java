package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configManagerOld {
	private static Properties p=new Properties();
	private configManagerOld() {
		
	}
	static {
		//pointing to config file
		File configFile=new File(System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
		
		FileReader fileReader = null;
		try {
			//reading the config file
			fileReader = new FileReader(configFile);
			//load the properties file with load()
			p.load(fileReader);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (IOException e) {
		  e.printStackTrace();
		}
	}
	public static String getProperty(String key) throws IOException {
		
	 return p.getProperty(key);
		
	}

}
