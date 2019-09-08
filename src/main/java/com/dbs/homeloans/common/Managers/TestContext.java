package com.dbs.homeloans.common.Managers;

import com.dbs.homeloans.common.ConfigFileReader;

public class TestContext {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ConfigFileReader configFileReader;
	
	public TestContext(){
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		configFileReader = new ConfigFileReader();
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ConfigFileReader getConfig() {
		return configFileReader;
	}

}
