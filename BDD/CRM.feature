@crm_activities
Feature: Title of your feature
  I want to use this template for my feature file

  
  
  
 @crm_activity_1
 Scenario: dashlet count
    Given open chromeBrowser
    And open CRM and id and pwd
    And count the dashlets and print to console
     And close browser
  
 @crm_activity_2
  Scenario: create leads 
    Given open chromeBrowser
    And open CRM and id and pwd
    And  navigate to sales and click on leads option
    Then click on create leads
    And Give the lead values "Mr." and "sundeep" and "Pogula" and "8989000786"
    And click on save button
    Then navigate to view leads page
    And verify the created lead
    And close browser
    
   @crm_activity_3
  Scenario Outline: schedule meeting
    Given open chromeBrowser
    And open CRM and id and pwd
    And  navigate to activities and click on meetings option
    Then click on schedule meeting
    And Give the meeting details "<user1>" and "<user2>"
    And click the save button
    Then navigate to view meetings page
    And verify the created meeting
    And close browser
    
    Examples:
    |user1  |user2 |
    |sundeep|Monika|
    
    
  @crm_activity_4
  Scenario Outline: create a product  
    Given open chromeBrowser
    And open CRM and id and pwd
    And  navigate to All option and click on products
    Then click create a product
    And Give the product details "<productname>" and "<partnumber>" and "<price>"
    And click on save Button
    Then navigate to view products page
    And verify the created product
    And close browser
    
    Examples:
    |productname     |partnumber|price|
    |oneplusphone    |2900      |90000|
    
   
        