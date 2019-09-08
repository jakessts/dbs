package com.dbs.homeloans.common.Managers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.dbs.homeloans.common.ConfigFileReader;
import com.dbs.homeloans.runner.DBSHomeLoansApp;

public class WebDriverManager {
	WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	private static final String FIREFOX_BiNARY_PATH_PROPERTY = "webdriver.firefox.bin";
		
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		if(DBSHomeLoansApp.browser.equalsIgnoreCase("IE")){
			System.setProperty(IE_DRIVER_PROPERTY, new ConfigFileReader().getIEDriverPath());
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability("requireWindowFocus", true);
		    driver = new InternetExplorerDriver(options);
		} else if(DBSHomeLoansApp.browser.equalsIgnoreCase("CHROME")){
			System.setProperty(CHROME_DRIVER_PROPERTY, new ConfigFileReader().getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
		    options.setExperimentalOption("useAutomationExtension", false);
		    try{
		    driver = new ChromeDriver(options);
		    }catch(Exception e){
		    	if(driver!=null) driver.quit();
		    	driver = new ChromeDriver(options);
		    }
		} else if(DBSHomeLoansApp.browser.equalsIgnoreCase("FIREFOX")){
			System.setProperty(FIREFOX_DRIVER_PROPERTY, new ConfigFileReader().getGeckoDriverPath());
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile ffProfile = new FirefoxProfile();
			ffProfile.setAcceptUntrustedCertificates(true) ;
			ffProfile.setAssumeUntrustedCertificateIssuer(false);
			ffProfile.setPreference("network.cookie.cookieBehavior", 0);
			options.setProfile(ffProfile);
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(new ConfigFileReader().getApplicationUrl());
		
		return driver;
	}
	
	public void closeDriver(){
//		driver.close();
		driver.quit();
	}

}
