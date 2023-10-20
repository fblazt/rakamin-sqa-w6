Feature: Login Page Swag Labs

  Scenario: Success Login
    Given Login page Swag Labs
    When  Input Username
    And Input Password
    And Click login button
    Then User logged in

  Scenario: Failed Login
    Given Login page Swag Labs
    When Input Username
    And Input Invalid Password
    And Click login button
    Then User get error message
