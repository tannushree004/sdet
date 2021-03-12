@orangehrm
Feature: Title of your feature
  I want to use this template for my feature file

  @orangeactivity_1
  Scenario: create vacancy
    Given open chromeBrowser
    Given User navigates to orange hrm site
    And login with userid and pwd
    And Navigate to Recruitment page
    And Navigate to vacancies page
    And Click on Add vacancy button
    Then Fill necessary details and click save
    And click back button
    Then Enter vacancy details in textboxes and click searchbtn
    Then Verify the vacancy has been created
    And close browser

    
    @orangeactuvity_2
     Scenario: Add Candidate
     Given open chromeBrowser
     Given User navigates to orange hrm site
     And login with userid and pwd
     And Navigate to Recruitment page
     And Click Add Button
     And fill the candidate details and upload Resume
     Then click Save
     Then Click Back
     And Verify Candidate entry
     And close browser
     
     
     @orangeactivity_3
     Scenario Outline: Add multiple employess
    Given open chromeBrowser
    Given User navigates to orange hrm site
    And login with userid and pwd
    And Navigate to PIM option
   Then Click Add button
   Then Enter following details "<firstnames>" and "<lastnames>" and "<Usernames>" and "<Passwords>" and "<confirmpasswords>" 
   Then click save button
   And verify employee and print it to console
   And close browser
 Examples: 
      |firstnames |lastnames | Usernames | Passwords | confirmpasswords |
      | sravya    |   Gotti  | sravs     | abc12345  |  abc12345        |
      |  mounika  |     Sai  | mouni     | mnksai123  |  mnksai123      |
      
      
    @orangeactivity_4
  Scenario Outline: create vacancies
    Given open chromeBrowser
    Given User navigates to orange hrm site
    And login with userid and pwd
    And Navigate to Recruitment page
    And Navigate to vacancies page
    And Click on Add vacancy button
    Then Fill "<jobtitle>" and "<vacancyname>" and "<hiremanager>" and "<positions>" and "<Description>" 
    And click back button
    Then Enter vacancy details in textboxes and click searchbtn "<title>" and "<vacancyName>"
    Then Verify the vacancy has been created
    And close browser
    
     Examples: 
     
    | jobtitle                  |vacancyname  |hiremanager | positions | Description | title| vacancyName|
    | DevOps Engineer           | DevsecOps   |   IBM 05   | 3         |Require 4+ years experience in Devsecops  |DevOps Engineer| DevsecOps |  
    | Automation Test Engineer  |  BDDTester |   IBM 06   | 9         |Require 4+ years experience in BDD    | Automation Test Engineer  |  BDDTester |    
      
     
    