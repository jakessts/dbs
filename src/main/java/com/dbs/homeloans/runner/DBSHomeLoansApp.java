package com.dbs.homeloans.runner;

import com.dbs.homeloans.common.Common;
import com.dbs.homeloans.testdata.FeatureOverright;

public class DBSHomeLoansApp {

	public static String browser;
	/**
	 * This is main method and will execute the selected test cases and provides the results
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {

		String testCasesToRun = args[0];
		browser = args[1];
		
		FeatureOverright.overrideFeatureFiles("./features");
		
		/**
		 * To execute the test cases based on the user input and the
		 * configuration
		 */
		 String[] arguments = new Common().getCucumberOptions(testCasesToRun);
		 new CucumberMain();
			CucumberMain.main(arguments);

		/**
		 * To generate the html reports by transforming the results in
		 * cucumber-report.json file
		 */
		new Common().generateHTMLReports();

	}
}
