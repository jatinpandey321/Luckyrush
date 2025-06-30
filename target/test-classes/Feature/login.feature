Feature: Login Functionality for luckyrush

  Background:
    Given user is on the login page
    
  Scenario: Successful login with valid credentials for lucky rush
    When  user enters valid username and password
    And user clicks the login button
    Then user should be redirected to the homepage


