@activity2_1
Feature: Login test
  I want to use this template for my feature file

  @tag1
  Scenario: Testing Login
    Given User is on Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message
    And Close the Browser