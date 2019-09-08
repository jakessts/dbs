package com.dbs.homeloans.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

	WebDriver driver;
	public NotificationPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "navigateToList") 
	private WebElement lnkClickHere;
	
	@FindBy(xpath = "//div[@class='notification-panel-content']") 
	private WebElement msgNotificationMessage;
	
	public boolean check_For_The_Notification_Message(){
		boolean result = false;
		if(msgNotificationMessage.getText().toString().trim().equalsIgnoreCase(" You are eligible for pre-approved home loan with interest rate @ 9%. "))
			result = true;
		return result;
	}
	public void click_On_The_clickHere_link(){
		lnkClickHere.click();
	}
	
}
