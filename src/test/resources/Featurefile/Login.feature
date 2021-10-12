Feature: Login Feature.
  As a Modulr customer user
  I want to be able to login successfully to the Modulr Customer Portal So that I can manage my Modulr accounts

  Scenario: Successful sign in
    Given login page is launched
    When user enters username
    And user enters password
    And click on sign in button
    Then account overview page should display

  Scenario: unsuccessful sign in with password being empty
    Given login page is launched
    When user enters username
    And click on sign in button
    Then inline error message should displayed

  Scenario: unsuccessful sign in with username being empty
    Given login page is launched
    When user enters password
    And click on sign in button
    Then inline error message should displayed