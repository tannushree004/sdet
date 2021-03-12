@activity1_2
Feature: Login test
  I want to use this template for my feature file

  @tag1
  Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    Then Read the page title and confirmation message
    And Close the Browser