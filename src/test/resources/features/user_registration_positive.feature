# language: en

Feature: User Registration - Positive Scenario
  As a new user
  I want to create a user account successfully
  So that I can later order and view my purchases.

  Scenario: Successful registration of a new user
    Given the user is on the home page
    When the user navigates to the registration page for positive test
    And fills out the registration form with new user data
    And clicks the register button
    Then the registration should be successful
    And the user clicks the continue button
    And the user should be logged in