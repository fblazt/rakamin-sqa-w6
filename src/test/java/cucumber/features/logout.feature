Feature: Logout flow

  Scenario: Success Login
    Given Login page Swag Labs
    When  Input Username
    And Input Password
    And Click login button
    And User logged in
    And User click logout button
    Then User on login page