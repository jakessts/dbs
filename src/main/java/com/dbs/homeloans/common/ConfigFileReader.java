package com.dbs.homeloans.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs/Configuration.properties";
 
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("URL");
		if(url != null) return url;
		else throw new RuntimeException("URL is not specified in the Configuration.properties file.");
	}
	
	public String getStepDefinitionsPath() {
		String glue = properties.getProperty("glue");
		if(glue != null) return glue;
		else throw new RuntimeException("Step definitions path(glue) is not specified in the Configuration.properties file.");
	}
	
	public String getCucumberReportsJsonFilePath() {
		String plugin = properties.getProperty("plugin");
		if(plugin != null) return plugin;
		else throw new RuntimeException("cucumber-report.json(plugin) is not specified in the Configuration.properties file.");
	}
	
	public String getFeatureFilePath() {
		String featureFilePath = properties.getProperty("featureFilePath");
		if(featureFilePath != null) return featureFilePath;
		else throw new RuntimeException("Feature file path is not specified in the Configuration.properties file.");
	}
	
	public String getChromeDriverPath(){
		String driverPath = properties.getProperty("chromeDriverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Chrome driverPath is not specified in the Configuration.properties file.");		
	}
	
	public String getIEDriverPath(){
		String driverPath = properties.getProperty("ieDriverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("IE driverPath is not specified in the Configuration.properties file.");		
	}
	
	public String getGeckoDriverPath(){
		String driverPath = properties.getProperty("geckoDriverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Gecko driverPath is not specified in the Configuration.properties file.");		
	}
	
	public String getfireFoxBinaryPath(){
		String firefoxBinaryPath = properties.getProperty("firefoxBinaryPath");
		if(firefoxBinaryPath!= null) return firefoxBinaryPath;
		else throw new RuntimeException("Firefox Binary Path is not specified in the Configuration.properties file.");		
	}
	
	public String getReportPath(){
		String reportPath = properties.getProperty("reportPath");
		if(reportPath!= null) return reportPath;
		else throw new RuntimeException("Report path is not specified in the Configuration.properties file.");		
	}
	
	public String getTestDataExcelPath(){
		String testDataExcelPath = properties.getProperty("testDataExcelPath");
		if(testDataExcelPath!= null) return testDataExcelPath;
		else throw new RuntimeException("Test Data Excel Path is not specified in the Configuration.properties file.");		
	}

}
