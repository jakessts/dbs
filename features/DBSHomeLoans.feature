

@HomeLoan
Feature: Home - Loans 
Description: The purpose of this feature is to apply for home loan
@Apply
 Scenario Outline: Apply for home loan
 	Given User click on click here link in notification page
	Then  Select <Property_Type>
	Then  Enter locality <Locality>
	Then  Click on a property
	Then  Click on Apply button in property details page
	Examples:
	| Property_Type | Min_Budget | Max_Budget  | Locality |
	##@externaldata@GeneralTestCase
|2 BHK|0 L|40 L|Kukatpalli|
|3 BHK|0 L|40 L|Madhapur|

@Filter
 Scenario Outline: Verify Property type filter
 	 Given User click on click here link in notification page
 	 Then  Select <Property_Type>
	 Then  Verify that the list displayed belongs to property type <Property_Type>
	 Examples:
	| Property_Type | Min_Budget | Max_Budget  | Locality |
	##@externaldata@GeneralTestCase
|2 BHK|0 L|40 L|Kukatpalli|
|3 BHK|0 L|40 L|Madhapur|
    
    
  Scenario Outline: Verify locality filter
 	 Given User click on click here link in notification page
	 Then  Enter locality <Locality>
	 Then  Verify that the list displayed belongs to the locality <Locality>
	 Examples:
	| Property_Type | Min_Budget | Max_Budget  | Locality |
	##@externaldata@GeneralTestCase
|2 BHK|0 L|40 L|Kukatpalli|
|3 BHK|0 L|40 L|Madhapur|
    
 
