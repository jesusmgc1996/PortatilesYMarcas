package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JDBCProperties {

	private static Properties properties = null;

	public JDBCProperties () {
		super();
	}
	
	/**
	 * @return
	 */
	private static Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				File file = new File("./src/main/java/controller/jdbc.properties");
				properties.load(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}

	/**
	 * @param propertyName
	 * @return
	 */
	public static String getProperty(String propertyName) {
		return getProperties().getProperty(propertyName);
	}

	/**
	 * @param propertyName
	 * @return
	 */
	public static int getIntProperty (String propertyName) {
		return Integer.parseInt(getProperties().getProperty(propertyName));
	}
	
	/**
	 * @param propertyName
	 * @return
	 */
	public static Float getFloatProperty (String propertyName) {
		return Float.parseFloat(getProperties().getProperty(propertyName));
	}
	
}
