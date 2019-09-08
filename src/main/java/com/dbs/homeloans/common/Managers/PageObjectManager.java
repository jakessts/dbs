package com.dbs.homeloans.common.Managers;

import org.openqa.selenium.WebDriver;

import com.dbs.homeloans.pageObjects.NotificationPage;
import com.dbs.homeloans.pageObjects.PropertiesListPage;
import com.dbs.homeloans.pageObjects.PropertyDetailsPage;

public class PageObjectManager {

	private WebDriver driver;
	private NotificationPage notificationPage;
	private PropertiesListPage propertiesListPage;
	private PropertyDetailsPage propertyDetailsPage ;
	

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public NotificationPage getNotificationPage(){
		return (notificationPage == null) ? notificationPage = new NotificationPage(driver) : notificationPage;
	}
	
	public PropertiesListPage getPropertiesListPage(){
		return (propertiesListPage == null) ? propertiesListPage = new PropertiesListPage(driver) : propertiesListPage;
	}
	
	public PropertyDetailsPage getPropertyDetailsPage(){
		return (propertyDetailsPage == null) ? propertyDetailsPage = new PropertyDetailsPage(driver) : propertyDetailsPage;
	}

}
