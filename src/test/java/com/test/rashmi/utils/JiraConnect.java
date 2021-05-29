package com.test.rashmi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class JiraConnect {

//	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
//	int recordCount;
//
//	public static Map<String, Integer> mapA = new HashMap<String, Integer>();
//	List<String> rStep_result;
//	static List<String> rStep_summary;
//	Boolean Examples = false;
//	static Response response = null;
//	String FeatureBasePath = "src//test//resources//feature";
//	String DataSheetBasePath = "src/test/resources/testdata";
//	DataFormatter formatter = new DataFormatter(Locale.US);
//	String jiraUrl = variables.getProperty("jira.url");
//
//	String cucumberTags = variables.getProperty("cucumber.options");
//	String product = variables.getProperty("product");
//	String cycleName = null;
//
//	public int test_cycle_id;
//	String test_cycle_name = null;
//
//	List<Integer> issue_id;
//	static List<Integer> rStep_id;
//	List<String> issue_key;
//	List<String> step_Test;
//	List<String> step_Expected;
//	List<String> step_Data;
//	static List<String> summary = null;
//	List<String> description = null;
//	List<String> label;
//	List<String> component;
//
//	TestUtils testUtils = new TestUtils();
//	int dataTagColumnIndex;
//	int dataRowIndex;
//	PrintWriter pw;
//
//	public int getTestCycleDetails(int projectId, int versionId) {
//
//		/* Fetching test cycle name passed in form of cucumber tags */
//		String[] tags = cucumberTags.split("--tags");
//		for (String tag : tags) {
//			if (!tag.contains("DAR")) {
//				cycleName = tag.trim().replace("@", "").replace("_", " ");
//			}
//		}
//
//		response = testUtils.getTestCyleAPIData(projectId, versionId);
//		JsonPath jsonPathEvaluator = response.jsonPath();
//
//		/*
//		 * Fetching the valid cycleIDs from the JSON response and storing them in a Set
//		 */
//		String responseBody = response.getBody().asString();
//		JSONObject jObj = new JSONObject(responseBody);
//
//		Set<String> keys = jObj.keySet();
//		keys.remove("-1");
//		keys.remove("recordsCount");
//
//		/* Storing the required cycleID through the selected test cycle */
//		for (String key : keys) {
//			if (cycleName.equalsIgnoreCase(jsonPathEvaluator.getString(key + ".name"))) {
//				test_cycle_name = jsonPathEvaluator.getString(key + ".name");
//				test_cycle_id = Integer.parseInt(key);
//			}
//		}
//		System.out.println("----------------------------------");
//		System.out.println("TEST CYCLE SELECTED FOR EXECUTION: " + test_cycle_name);
//		System.out.println("TEST CYCLE ID: " + test_cycle_id);
//		System.out.println("----------------------------------");
//		return test_cycle_id;
//	}
//
//	public List<Integer> getTestIssueDetails(int testCycleID) {
//
//		response = testUtils.getTestIssueAPIData(testCycleID);
//		JsonPath jsonPathEvaluator = response.jsonPath();
//
//		issue_id = jsonPathEvaluator.getList("executions.issueId");
//		rStep_id = jsonPathEvaluator.getList("executions.id");
//		issue_key = jsonPathEvaluator.getList("executions.issueKey");
//		summary = jsonPathEvaluator.getList("executions.summary");
//		description = jsonPathEvaluator.getList("executions.issueDescription");
//		recordCount = jsonPathEvaluator.getInt("recordsCount");
//		label = jsonPathEvaluator.getList("executions.label");
//		component = jsonPathEvaluator.getList("executions.component");
//		return issue_id;
//	}
//
////	public  static Map<String, Integer> stepInfo() {
////		
////		for(int i=0;i<rStep_id.size();i++) {
////		mapA.put(summary.get(i).trim(), rStep_id.get(i));
////		System.out.println(summary.get(i));
////		System.out.println(rStep_id.get(i));
////		}
////		return mapA;
////	}
//
////public ValidatableResponse getStepId(int executionId){
////	
////	RestUtil.setBaseURI(jiraUrl+"zapi/latest/stepResult");
//////	JSONObject requestParams = new JSONObject();
//////	requestParams.put("status", status); 
////
////	
////	return	RestAssured.given()
////			.spec(ReuseableSpecifications.getGenericJiraRequestSpec())//.log().all()
////			.queryParam("executionId", executionId)
////			.get()
////			.then();
////			//.log().all();
////			
////}
//
//	public void getFeatureDetails(List<Integer> issueID) throws IOException {
//		JsonPath jsonPathEvaluator;
//		for (int id = 0; id < issue_id.size(); id++) {
//
//			response = testUtils.getTestStepAPIData(issueID, id);
//			jsonPathEvaluator = response.jsonPath();
//
//			step_Test = jsonPathEvaluator.getList("stepBeanCollection.step");
//			step_Expected = jsonPathEvaluator.getList("stepBeanCollection.result");
//			step_Data = jsonPathEvaluator.getList("stepBeanCollection.data");
//
//			String testCaseId = issue_key.get(id).toString().trim();
//
//			/* Fetching the scenario field data from a test case */
//			response = testUtils.getTestFieldAPIData(testCaseId);
//			jsonPathEvaluator = response.jsonPath();
//			String scenarioType = jsonPathEvaluator.get("fields.customfield_13040.value");
//
//			/* Setting the name of the feature file */
//			String featureFileName = testCaseId + "_" + test_cycle_name + ".feature";
//
//			/* Creating a new feature file even if it already exists */
//			File file = new File(FeatureBasePath + "//" + product.toLowerCase() + "//" + featureFileName);
//
//			/* Delete the feature file if it already exists and create a new one */
//			if (file.exists() && file.isFile()) {
//				file.delete();
//			}
//			file.getParentFile().mkdirs();
//			FileWriter fw = new FileWriter(file, false);
//
//			/* Creating instance of Print writer */
//			pw = new PrintWriter(fw, true);
//
//			/*Creation of new feature file*/
//			pw.write("@issue:" + testCaseId);
//			pw.println();
//			pw.write("@" + test_cycle_name.toLowerCase().replace(" ", "_"));
//			pw.print(" ");
//			pw.write("@" + testCaseId);
//			pw.println();
//			pw.write("Feature: " + getFeatureName(label.get(id).toString()));
//			pw.println();
//			pw.println();
//			pw.write(description.get(id));
//			pw.println();
//			pw.println();
//			//Adding scenario type as per the value in JIRA field
//			if (scenarioType.toLowerCase().contains("outline")) {
//				pw.print("Scenario Outline: " + summary.get(id));
//			} else {
//				pw.print("Scenario: " + summary.get(id));
//			}
//			pw.println();
//
//			//Adding the test steps and expected steps
//			for (int i = 0; i < step_Test.size(); i++) {
//				pw.write(step_Test.get(i).trim());
//				if (step_Data.get(i) != "") {
//					pw.println();
//					pw.write(step_Data.get(i).trim());
//				}
//				if (step_Expected.get(i) != "") {
//					pw.println();
//					pw.write(step_Expected.get(i).trim());
//				}
//				pw.println();
//			}
//
//			//Adding Examples table in case the scenario is of type Outline
//			if (scenarioType.toLowerCase().contains("outline")) {
//				Examples = true;
//				pw.println();
//				pw.write("Examples:");
//				List<String> values = getDataComponentAndTagValues(description.get(id).trim().toString());
//				String dataComponent = values.get(0).toString();
//				String dataTag = values.get(1);
//				addTestDataFromExcelSheetInFeatureFile(dataComponent, dataTag);
//			} else {
//				Examples = false;
//			}
//			// Flush the output to the file
//			pw.flush();
//			// Close the Print Writer
//			pw.close();
//			// Close the File Writer
//			fw.close();
//		}
//	}
//
//	public String getFeatureName(String testLabel) {
//		/*Feature name set as per concatenation of the test label(s)*/
//		String featureName = testLabel.toLowerCase();
//		featureName = featureName.replace(" ","-").replace(",","");
//		featureName = featureName.replaceAll("[\\[\\]]", "");
//		return featureName.toString();
//	}
//
//	public List<String> getDataComponentAndTagValues(String description) {
//		/*Setting the name of the data component mentioned in the description*/
//		if (description.contains("DataTag")) {
//			String[] desc = description.split("!");
//			String componentValue = desc[0].split("=")[1].replaceAll("\\<[^>]*>", "").trim();
//			String tagValue = desc[1].split("=")[1].replaceAll("\\<[^>]*>", "").trim();
//			return Arrays.asList(componentValue, tagValue);
//		} else {
//			String[] desc = description.split("=");
//			String componentValue = desc[1].replaceAll("\\<[^>]*>", "").trim();
//			return Arrays.asList(componentValue, null);
//		}
//	}
//
//	public void addTestDataFromExcelSheetInFeatureFile(String dataComponent, String dataTag) throws IOException {
//		/*
//		 * Initializing the test sheet from which examples data is to be fetched
//		 * */
//		File testDataFile = new File(DataSheetBasePath + "//" + product.toLowerCase() + "//test_data.xlsx");
//		FileInputStream fileInputStream = new FileInputStream(testDataFile);
//		XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
//		XSSFSheet workSheet = workBook.getSheet(dataComponent);
//		Row dataHeaderRow = workSheet.getRow(0);
//		/*
//		 * Fetching test data in case Data Tag Index is not zero/ Data Tag is mentioned
//		 * in the test description
//		 */
//		if (getDataTagColumnIndexIfThere(dataHeaderRow) != 0) {
//			/* Writing all the data headers in the feature file except 'dataTag'*/
//			pw.println();
//			pw.write("    |");
//			writeDataInExamplesTable(dataHeaderRow, dataHeaderRow.getLastCellNum()-1);
//			pw.println();
//			pw.write("    |");
//			/* Writing all the test data values corresponding to the specified Data tag in the feature file */
//			dataRowIndex = getRowIndexForDesiredDataTag(workSheet, dataTag);
//			Row desiredDataRow = workSheet.getRow(dataRowIndex);
//			writeDataInExamplesTable(desiredDataRow, desiredDataRow.getLastCellNum()-1);
//		} else {
//			/*Writing the test data headers and corresponding values in the feature file*/
//			writeDataRowInExamplesTable(workSheet);
//		}
//		workBook.close();
//	}
//
//	public Integer getDataTagColumnIndexIfThere(Row row) {
//		for (int k = 0; k < row.getLastCellNum(); k++) {
//			Cell cell = row.getCell(k);
//			if (cell.toString().equals("DataTag")) {
//				dataTagColumnIndex = cell.getColumnIndex();
//			} else {
//				dataTagColumnIndex = 0;
//			}
//		}
//		return dataTagColumnIndex;
//	}
//
//	public void writeDataInExamplesTable(Row row, int cellCount) {
//		String timeStamp = new SimpleDateFormat("MMddsSSS").format(new Date());
//		for (int j = 0; j < cellCount; j++) {
//			Cell desiredCell = row.getCell(j);
//			if (desiredCell == null) {
//				pw.write("|");
//			} else {
//				formatter.formatCellValue(desiredCell);
//				pw.write(formatter.formatCellValue(desiredCell).replace("^TS^", timeStamp) + "|");
//			}
//		}
//	}
//
//	public Integer getRowIndexForDesiredDataTag(XSSFSheet worksheet, String dataTagValue) {
//		for (int i = 0; i < worksheet.getLastRowNum(); i++) {
//			Row dataRow = worksheet.getRow(i + 1);
//			Cell dataCell = dataRow.getCell(dataTagColumnIndex);
//			if (dataCell.getStringCellValue().toString().equalsIgnoreCase(dataTagValue)) {
//				dataRowIndex = dataCell.getRowIndex();
//				break;
//			}
//		}
//		return dataRowIndex;
//	}
//
//	public void writeDataRowInExamplesTable(XSSFSheet worksheet) {
//		for (int i = 0; i <= worksheet.getLastRowNum(); i++) {
//			Row row = worksheet.getRow(i);
//			pw.println();
//			pw.write("    |");
//			if (row == null) {
//				pw.write("|");
//			} else {
//				writeDataInExamplesTable(row, row.getLastCellNum());
//			}
//		}
//	}
}