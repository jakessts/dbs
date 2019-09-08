package com.dbs.homeloans.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage {
	
	WebDriver driver;
	public PropertyDetailsPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "applyLoanBtn_20") 
	private WebElement btnApply;
	
	public void click_On_Apply_Button(){
		btnApply.click();
	}

}
