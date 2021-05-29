package com.test.rashmi.utils;

import java.io.BufferedWriter;

/**
 *
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ResourceLoader {

	 private ResourceLoader() {
	    }

	 /**
     *
     * @param resourceName
     * @return
     * @throws IOException
     */
    public static URL getResourceUrl(String resourceName) throws IOException {
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();

        URL resourceUrl = null;

        if (classLoader != null) {
        	resourceUrl = classLoader.getResource(resourceName);
        }

        if (resourceUrl == null) {
            classLoader = ClassLoader.getSystemClassLoader();
            if (classLoader != null) {
            	resourceUrl = classLoader.getResource(resourceName);
            }
        }

        return resourceUrl;
    }//end loadResource

	    /**
	     * @param resourceName
	     * @return
	     * @throws IOException
	     */
	    public static InputStream loadResource(String resourceName) throws IOException {
	        ClassLoader classLoader = ResourceLoader.class.getClassLoader();

	        InputStream inputStream = null;

	        if (classLoader != null) {
	            inputStream = classLoader.getResourceAsStream(resourceName);
	        }

	        if (inputStream == null) {
	            classLoader = ClassLoader.getSystemClassLoader();
	            if (classLoader != null) {
	                inputStream = classLoader.getResourceAsStream(resourceName);
	            }
	        }

	        if (inputStream == null) {
	            File file = new File(resourceName);
	            if (file.exists()) {
	                inputStream = new FileInputStream(file);
	            }
	        }

	        return inputStream;
	    }//end loadResource

	    /**
	     *
	     * @param resourceName
	     * @return
	     * @throws IOException
	     */
	    public static Properties loadProperties(String resourceName) throws IOException {
	        Properties properties = null;
	        InputStream inputStream = null;
	        try {
	            inputStream = loadResource(resourceName);
	            if (inputStream != null) {
	                properties = new Properties();
	                properties.load(inputStream);
	            }
	        } finally {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	        }
	        return properties;
	    }
	    
		/**
		 * readDataFromFile
		 * @param Property
		 * @return text
		 */
		public static String readDataFromFile(String Property){
			try {
				Properties prop = ResourceLoader.loadProperties("src/test/resources/testdata/data.txt");
				return prop.getProperty(Property);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

		public static boolean writeDataToFile(String Property, String Data) {
			PrintWriter pw = null;
			boolean result = false;
			try 
			{
				URL url = getResourceUrl("data");
				String path = "src/test/resources/testdata";
				String dataFolderPath = URLDecoder.decode(path, "UTF-8");
				String outFilePath = dataFolderPath + File.separator + "data.txt";
				pw = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath , true)));
				pw.println(Property + "=" + Data);
				result = true;
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			} 
			finally {
				if (pw != null) {
					pw.close();
				}

			}

			return result;
		}
		
		public static String readValueFromXLS(String fileName,String sheetName,int row,int cell) throws IOException{
			//TODO, FIXME after Integrations
//			String environment=getData();
			FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"/"+fileName));
//			if(StringUtils.containsIgnoreCase(environment, "prod")){
				file = new FileInputStream(new File(System.getProperty("user.dir")+"/"+fileName));
//			}
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			Row r=sheet.getRow(row);
			return r.getCell(cell).getStringCellValue();
		}
}
