#Author Dimas Wisnu S
#Date 12 April 2023
#Description Logout functionality test
@SmokeScenario
Feature: feature to test logout functionality

  @SmokeTest
  Scenario: User successfully logout from the system
    Given browser is on metadata page
    When user clicks on logout button
    Then user is navigated to the login page
