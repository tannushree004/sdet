@activity2_5
Feature: Login test
  I want to use this template for my feature file

    Scenario Outline: Testing with Data
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the Browser

 Examples: 
      | Usernames | Passwords | 
      | admin     | password  | 
      | adminUser | Password  | 