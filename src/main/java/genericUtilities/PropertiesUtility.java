package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    Properties property;
	//Initializing properties file
	public void propertiesInit(String filepath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//To get the properties file
	public String getDataFromProperties(String key) {
		return property.getProperty(key);
	}
}
