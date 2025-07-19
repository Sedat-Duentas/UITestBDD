# language: en

Feature: User Registration - Negative Scenario
  As a new user
  I want to try registering with invalid or conflicting data
  So that I can see the appropriate error messages and understand why registration failed.

  Scenario: Registration with an already registered email
    Given a user is successfully registered with a new email and then logged out
    When the user navigates to the registration page for a re-registration attempt
    And attempts to register again with the same user data
    And attempts to register by clicking the button
    Then an error message "The specified email already exists" should be displayed