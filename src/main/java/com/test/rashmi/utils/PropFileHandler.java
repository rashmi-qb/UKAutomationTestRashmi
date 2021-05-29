package com.test.rashmi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import org.testng.Reporter;

public class PropFileHandler {

	private InputStream inPropFile = null;
	private OutputStream outPropFile = null;

	public PropFileHandler() {
		// TODO Auto-generated constructor stub
	}

	static Properties properties = new Properties();
	String filePath = "";

	/**
	 * This method is used to read the value of the given property from the
	 * properties file.
	 *
	 * @param property
	 *            : the property whose value is to be fetched.
	 * @return the value of the given property.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	// static String propertyFilePathForTest =
	// "\\src\\test\\resources\\testdata\\Data.properties";

	static String propertyFilePathForTest =System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "testdata" + File.separator + "Data.properties";

	public static void pickPropertyfile(String propertyFileForTest) throws FileNotFoundException {
		if (propertyFileForTest.equalsIgnoreCase("coursepackProperties")) {
			propertyFilePathForTest = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "test" + File.separator + "resources"
					+ File.separator + "testdata" + File.separator + "coursepackData.properties";
		} else if (propertyFileForTest.equalsIgnoreCase("usersProperties")) {
			propertyFilePathForTest = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "test" + File.separator + "resources"
					+ File.separator + "testdata" + File.separator + "users.properties";

		} else if (propertyFileForTest.equalsIgnoreCase("dataProperties")) {
			propertyFilePathForTest = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "test" + File.separator + "resources"
					+ File.separator + "testdata" + File.separator + "Data.properties";
		}

		else {
			System.out.println("data");
			propertyFilePathForTest = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources"
					+ File.separator + "testdata" + File.separator + "Data.properties";
		}
	}

	public static String readProperty(String property) {
		InputStream inPropFile = null;
		Reporter.log("Reading token value "+property+ " from file"+propertyFilePathForTest,true);
		try {
			inPropFile = new FileInputStream(propertyFilePathForTest);
			// System.out.println(System.getProperty("user.dir") + propertyFilePathForTest);
			// inPropFile = new
			// FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata"+File.separator+"Data.properties");
			properties.load(inPropFile);
			return properties.getProperty(property);

		} catch (Exception e) {
			try {
				if(inPropFile!=null)
					inPropFile.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("There was Exception reading the Test data"
					+ propertyFilePathForTest);
		}

		return null;
	}

	public PropFileHandler(File file) {
		properties = new Properties();
		if (file.exists())
			file.delete();
		try {
			file.createNewFile();
			filePath = file.getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToFile(Map<String, String> storedData) {
		try {
			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			outPropFile = new FileOutputStream(filePath);
			properties.putAll(storedData);
			properties.store(outPropFile, null);

		} catch (Exception e) {
//			System.out.println("Unable to write data in property file :- " + storedData);
			e.printStackTrace();
		} finally {
			try {
				if(inPropFile!=null)
					inPropFile.close();
				if(outPropFile!=null)
					outPropFile.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to write data in property file :- " + storedData+" from "+filePath);
				e.printStackTrace();
			}
		}
	}

	public static void writeProperty(String property, String value) {
		OutputStream outPropFile = null;
		InputStream inPropFile = null;
		try {
			// properties = new Properties();
			properties.clear();
			inPropFile = new FileInputStream( propertyFilePathForTest);
			properties.load(inPropFile);
			outPropFile = new FileOutputStream(propertyFilePathForTest);
			properties.setProperty(property, value);
			properties.store(outPropFile, null);
//			Reporter.log(
//					"*******************Data Saved in file " +propertyFilePathForTest,
//					true);
		} catch (IOException e) {
//			Reporter.log("******************* n Error in saving data in file " 
//					+ propertyFilePathForTest, true);
		} finally {
			try {
				inPropFile.close();
				outPropFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Reporter.log("*******************Error in  closing file "
						+ propertyFilePathForTest, true);
			}
		}
	}

	/*
	 * public static String readProperty(String property) { InputStream inPropFile =
	 * null; try { inPropFile = new FileInputStream(System.getProperty("user.dir")+
	 * "\\src\\test\\resources\\testdata\\Data.properties");
	 * properties.load(inPropFile); } catch (IOException e) {
	 * System.out.println("There was Exception reading the Test data"); } String
	 * value = properties.getProperty(property); return value; }
	 */

	/**
	 * This method is used to store a new property in the properties file.
	 *
	 * @param property
	 *            : name for the new property.
	 * @param value
	 *            : value for the new property.
	 * @throws IOException
	 */
	/*
	 * public static void writeProperty(String property, String value) { // Write
	 * properties file. //OutputStream outPropFile = null;
	 * 
	 * try { InputStream inPropFile = new
	 * FileInputStream(System.getProperty("user.dir")+
	 * "\\src\\test\\resources\\testdata\\Data.properties");
	 * properties.load(inPropFile); inPropFile.close(); OutputStream outPropFile =
	 * new FileOutputStream(System.getProperty("user.dir")+
	 * "\\src\\test\\resources\\testdata\\Data.properties");
	 * //System.getProperty("user.dir")+"\\AnswerKeys\\"+top+".properties"
	 * 
	 * properties.setProperty(property, value); properties.store(outPropFile, null);
	 * outPropFile.close(); } catch (IOException e) { } }
	 */

	public static void clearProperty() {
		OutputStream outPropFile = null;
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
							+ "resources" + File.separator + "testdata" + File.separator + "Data.properties");
			properties.load(inPropFile);
			outPropFile = new FileOutputStream(
					System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
							+ "resources" + File.separator + "testdata" + File.separator + "Data.properties");
			properties.clear();

		} catch (IOException e) {
		} finally {
			try {
				if(inPropFile!=null) inPropFile.close();
				if(outPropFile!=null) outPropFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Reporter.log("*******************Error in  clear in  file "
						+ propertyFilePathForTest, true);
				e.printStackTrace();
			}

		}
	}

	public static void clearProperty(String property) {
		OutputStream outPropFile = null;
		InputStream inPropFile = null;
		try {
//			System.out.println(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
//					+ "resources" + File.separator + "testdata" + File.separator + "Data.properties");
			inPropFile = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "Data.properties");
			properties.load(inPropFile);
			outPropFile = new FileOutputStream(
					System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata" + File.separator + "Data.properties");
			// properties.clear();
			Object obj = properties.remove(property);
			
			properties.store(outPropFile, null);
		} catch (IOException e) {
		} finally {
			try {
				if(inPropFile!=null)inPropFile.close();
				if(outPropFile!=null) outPropFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
