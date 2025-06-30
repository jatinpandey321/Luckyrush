Feature: Forgot Password functionality

  As a registered user
  I want to reset my password if I forget it
  So that I can regain access to my account

  Background:
    Given User is on the login page

  Scenario: User successfully resets password with valid email
    When user click on the forget password link
    And user enter a valid registered email address
    And user click on the Send Reset Link button
    And user enter the otp
    And user enter the new password 
    And user click on update password button 
    Then user should see a confirmation message 
   
    