Feature: Reset password

  Scenario: Verify forgot password link
    Given login page is launched
    And click on reset password link
    When navigate to ‘Reset access’
    And enters username
    Then click ‘reset password link’
    And reset password confirmation message should be displayed


