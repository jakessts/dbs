package com.dbs.homeloans.stepDefinitions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dbs.homeloans.common.Managers.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	WebDriver driver;
	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); 
		}
		testContext.getWebDriverManager().closeDriver();
		if(driver!=null){
			driver.quit();
		}
	}
}
