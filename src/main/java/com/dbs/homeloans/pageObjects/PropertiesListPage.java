package com.dbs.homeloans.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PropertiesListPage {

	WebDriver driver;
	public PropertiesListPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='propertyTypeFilter']") 
	private WebElement drpPropertyType;
	
	@FindBy(id = "") 
	private WebElement drpMinBudjet;
	
	@FindBy(id = "") 
	private WebElement drpMaxBudjet;
	
	@FindBy(xpath = "//button[@id='prop_apply_btn_0']") 
	private WebElement btnViewAndApply;
	
	@FindBy(id = "localityFilter") 
	private WebElement txtLocality;
	
	@FindBy(xpath = "//span[contains(@id,'prop_type_')]") 
	private List<WebElement> propTypeValuesInTheList;
	
	@FindBy(xpath = "//span[contains(@id,'prop_locality_')]") 
	private List<WebElement> localityValuesInTheList;
	
	@FindBy(xpath = "//span[contains(@id,'prop_agent_price_')]") 
	private List<WebElement> priceValuesInTheList;
	
	@FindBy(xpath = "//li[@class='pagination-next']") 
	private WebElement lnkNextPropertyList;
	
	@FindBy(xpath = "//li[@class='pagination-next']") 
	private WebElement headerFileProperty;
	
	
	public void select_Property_Type(String propType){
		Select drpPropType = new Select(drpPropertyType);
		drpPropType.selectByVisibleText(propType);
	}
	public void select_Min_Budget(String minBudgetValue){
		Select drpMinBudj = new Select(drpMinBudjet);
		drpMinBudj.selectByVisibleText(minBudgetValue);
	}
	
	public void select_Max_Budget(String maxBudgetValue){
		Select drpMaxBudj = new Select(drpMaxBudjet);
		drpMaxBudj.selectByVisibleText(maxBudgetValue);
	}
	
	public void click_On_View_And_Apply_Button(){
		btnViewAndApply.click();
	}
	
	public void enter_Locality(String locality){
		txtLocality.clear();
		txtLocality.sendKeys(locality);
	}
	
	public boolean verify_Locality_Values_From_Properties_List(String locality){
		boolean result = true;
		for(int i=0;i<localityValuesInTheList.size();i++){
			if(!(localityValuesInTheList.get(i).getText().toString().trim().equalsIgnoreCase(locality.trim()))){
				result = false;
				break;
			}
			if(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='pagination-next']")) != null){
				lnkNextPropertyList.click();
				i=0;
			}
		}
		
		return result;
	}
	
	public boolean verify_PropertyType_Values_From_Properties_List(String propertyType){
		boolean result = true;
		for(int i=0;i<propTypeValuesInTheList.size();i++){
			if(!(propTypeValuesInTheList.get(i).getText().toString().trim().equalsIgnoreCase(propertyType.trim()))){
				result = false;
				break;
			}
			
			if(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='pagination-next']")) != null){
				lnkNextPropertyList.click();
				i=0;
			}
		}
		
		return result;
	}
}
