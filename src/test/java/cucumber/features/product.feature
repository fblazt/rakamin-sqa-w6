Feature: Product Feature

  Scenario: Add product to cart
    Given Login page Swag Labs
    When  Input Username
    And Input Password
    And Click login button
    And User logged in
    And Click add to cart
    Then Added to the cart