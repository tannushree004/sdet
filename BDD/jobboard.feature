#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@jbexample_activity
Feature: Posting a job 
  I want to use this template for my feature file


   @jbactivity_4
 Scenario Outline: Posting a job with examples
  Given open the browser
  When user is on jobs page
  Then Goto postjobs page and login
  And Enter "<jobtitle>" and "<location>" and "<Description>" and "<company>"
  Then Click on Preview and then submit
  And Goto Jobs page
  Then Search for posted job
  And Verify the posted job
  And close browser
  

    Examples: 
      | jobtitle | location | Description | company|
      | Cucumber_Tester| Banglore| Requires person having 4yrs experience  |Alchemy|
      