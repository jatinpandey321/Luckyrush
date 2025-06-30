Feature: User Registration

  As a new user
  I want to register an account
  So that I can log in and use the system

  Background:
    Given User is on registeration page

  Scenario: Successful registration with valid details
    When User is on register page
    And User enter Username 
    And User enter Email
    And User enter Phone Number
    And User enter Password
    And User select robot checkbox
    And User select condition checkbox
    And User select age checkbox
    And User clicks on Signup button
    Then User registration is successful