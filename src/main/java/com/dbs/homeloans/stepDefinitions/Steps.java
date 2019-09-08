package com.dbs.homeloans.stepDefinitions;

import org.junit.Assert;

import com.dbs.homeloans.common.Managers.*;
import com.dbs.homeloans.pageObjects.NotificationPage;
import com.dbs.homeloans.pageObjects.PropertiesListPage;
import com.dbs.homeloans.pageObjects.PropertyDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {
	
	TestContext testContext;
	NotificationPage notificationPage;
	PropertiesListPage propertiesListPage;
	PropertyDetailsPage propertyDetailsPage;
	
	public Steps(TestContext context) {
		testContext = context;
		
	}
	
	@Given("^User click on click here link in notification page$")
	public void ClickOnThelinkInPreapprovedLoanNotification() {
		notificationPage = testContext.getPageObjectManager().getNotificationPage();
		notificationPage.click_On_The_clickHere_link();
	}
	
	@Then("^Select (.*)$")
	public void selectPropertyType(String propertyType ) {
		propertiesListPage = testContext.getPageObjectManager().getPropertiesListPage();
		propertiesListPage.select_Property_Type(propertyType);
	}
	
	@Then("^Select (.*) and (.*) to filter$")
	public void selectBudget(String minBudget,String maxBudget ) {
		propertiesListPage = testContext.getPageObjectManager().getPropertiesListPage();
		propertiesListPage.select_Max_Budget(minBudget);
		propertiesListPage.select_Max_Budget(maxBudget);
	}
	
	@Then("^Enter locality (.*)$")
	public void enterLoality(String locality) {
		propertiesListPage = testContext.getPageObjectManager().getPropertiesListPage();
		propertiesListPage.enter_Locality(locality);
	}
	
	@Then("^Click on a property$")
	public void navigateToPropertyDetailsPage(){
		propertiesListPage = testContext.getPageObjectManager().getPropertiesListPage();
		propertiesListPage.click_On_View_And_Apply_Button();
	}
	
	@Then("^Click on Apply button in property details page$")
	public void clickOnApplyButton(){
		propertyDetailsPage = testContext.getPageObjectManager().getPropertyDetailsPage();
		propertyDetailsPage.click_On_Apply_Button();
	}
	
	@Then("^Verify that the list displayed belongs to the locality (.*)$")
	public void searchLocality(String locality) {
		propertiesListPage = testContext.getPageObjectManager().getPropertiesListPage();
		if(propertiesListPage.verify_Locality_Values_From_Properties_List(locality))
			Assert.assertTrue("Locality filter is working as expected.", true);
		else
			Assert.assertTrue("Locality filter is not working as expected.", false);
		
	}
	
	@Then("^Verify that the list displayed belongs to property type (.*)$")
	public void searchPropertyType(String propType) {
		propertiesListPage = testContext.getPageObjectManager().getPropertiesListPage();
		if(propertiesListPage.verify_PropertyType_Values_From_Properties_List(propType))
			Assert.assertTrue("Property type filter is working as expected.", true);
		else
			Assert.assertTrue("Property filter is not working as expected.", false);
		
	}
	

}
