/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.rashmi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.yaml.snakeyaml.Yaml;

@SuppressWarnings("unchecked")
public class YamlReader {

	public static Map<String, Object> yamlData = new HashMap<String,Object>();

	public static String yamlFilePath = "src/test/resources/testdata/QA_TestData.yml";

	public static String tier = System.getProperty("tierName");

	public static String setYamlFilePath() {

		if ((tier == null) || tier.isEmpty()) {
			tier = ConfigPropertyReader.getProperty("serenity.properties", "tier").trim();
		}
		if (tier.equalsIgnoreCase("dev")) {
			yamlFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "testdata" + File.separator + "DEV_TestData.yml";
		} else if (tier.equalsIgnoreCase("qa")) {
			yamlFilePath = "src/test/resources/testdata/QA_TestData.yml";
		} else if (tier.equalsIgnoreCase("pr") || tier.equalsIgnoreCase("pristine")) {
			yamlFilePath = "/KPlus-Test-Automation/src/test/resources/testdata/PR_TestData.yml";
		} else if (tier.equalsIgnoreCase("prod") || tier.equalsIgnoreCase("production")) {
			yamlFilePath = "/KPlus-Test-Automation/src/test/resources/testdata/PROD_TestData.yml";
		} else if (tier.equalsIgnoreCase("RC") || tier.equalsIgnoreCase("rc")) {
			System.out.println("" + tier);
			yamlFilePath = "/KPlus-Test-Automation/src/test/resources/testdata/RC_TestData.yml";
		} else if (tier.equalsIgnoreCase("Test") || tier.equalsIgnoreCase("test")) {
			yamlFilePath = "/KPlus-Test-Automation/src/test/resources/testdata/Test_TestData.yml";
		}

		else {
			Reporter.log("YOU HAVE PROVIDED WRONG TIER IN CONFIG!!! using dev test data", true);
		}
		if(yamlData.size()==0)
			yamlData = readAndInitiliazeData();
	//	System.out.println("****************** "+yamlData);
		return yamlFilePath;
	}

	public static String getYamlValue(String token) {
		setYamlFilePath();
		return getValue(token);
	}

	public static String getData(String token) {
		setYamlFilePath();
		return getYamlValue(token);
	}

	public static Map<String, Object> getYamlValues(String token) {
		setYamlFilePath();
		return parseMap(yamlData, token + ".");
	}

	private static String getValue(String token) {
	//	System.out.println("Yaml Values is "+yamlData);
		return getMapValue(yamlData, token);
	}

	public static String getMapValue(Map<String, Object> object, String token) {
		// TODO: check for proper yaml token string based on presence of '.'
		String[] st = token.split("\\.");
		return parseMap(object, token).get(st[st.length - 1]).toString();
	}

	private static Map<String, Object> parseMap(Map<String, Object> object, String token) {
		if (token.contains(".")) {
			String[] st = token.split("\\.");
			object = parseMap((Map<String, Object>) object.get(st[0]), token.replace(st[0] + ".", ""));
		}
		return object;
	}

	public static int generateRandomNumber(int MinRange, int MaxRange) {
		int randomNumber = MinRange + (int) (Math.random() * ((MaxRange - MinRange) + 1));
		return randomNumber;
	}

	private static Map<String, Object> readAndInitiliazeData() {
		FileInputStream inputStream = null;
		try {
			System.out.println("Reading*****from file***" + yamlFilePath);
			inputStream = new FileInputStream(yamlFilePath);

			// doc = new FileReader(yamlFilePath);
			Yaml yaml = new Yaml();
			yamlData =  (Map<String, Object>) yaml.load(inputStream);
			inputStream.close();
			return yamlData;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
