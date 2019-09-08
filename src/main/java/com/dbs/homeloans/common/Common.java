package com.dbs.homeloans.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

/**
 * Description: <It will contain the common methods which can be reusable in step definition>
 * @author 1571470
 *
 */
public class Common {

	/**
	 * This method is to create cucumber options based on the user input
	 * 
	 * @param testCasesToExecute
	 * @return cucumberOptions
	 */
	public String[] getCucumberOptions(String testCasesToExecute) {
		
		ConfigFileReader config = new ConfigFileReader();
		
			if(testCasesToExecute.contains(",")){
				
				String[] tags=testCasesToExecute.split(",");
				String finalTag="";
				for(int i=0;i<tags.length;i++){
					finalTag=finalTag + "@" + tags [i];
					if(!(i==tags.length-1))
						finalTag=finalTag + ",";
				}
				
				String[] cucumberOptions = { "--tags", finalTag, "--glue",config.getStepDefinitionsPath(),
						 "--plugin", config.getCucumberReportsJsonFilePath(),
						config.getFeatureFilePath() };
				return cucumberOptions;
			}
			else{
			String[] cucumberOptions = { "--tags", "@" + testCasesToExecute, 
					"--glue",config.getStepDefinitionsPath(),
					"--plugin",config.getCucumberReportsJsonFilePath(),
					config.getFeatureFilePath() };
			return cucumberOptions;
			}
	}

	/**
	 * To generate the html reports by transforming the results in
	 * cucumber-report.json file
	 */
	public void generateHTMLReports() {
		ConfigFileReader config = new ConfigFileReader();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
		Date date = new Date();
		String dateTime = dateFormat.format(date);

		File reportOutputDirectory = new File(config.getReportPath() + dateTime);
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(config.getReportPath() + "/cucumber-report.json");

		Configuration configuration = new Configuration(reportOutputDirectory, "dbs-homeloans");
		configuration.getTagsToExcludeFromChart();
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		result.getFeatures();
		result.getPassedScenarios();
		result.getFailedScenarios();
	}

}
