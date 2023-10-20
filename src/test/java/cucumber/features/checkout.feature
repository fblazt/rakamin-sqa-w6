Feature: Checkout flow

  Scenario: Successful Checkout
    Given Login page Swag Labs
    When  Input Username
    And Input Password
    And Click login button
    And User logged in
    And Click add to cart
    And User open cart
    And User on cart page
    And User click checkout button
    And User on fill information page
    And Input first name
    And Input last name
    And Input zip code
    And User click continue
    And User on overview page
    And User click finish button
    Then Order completed