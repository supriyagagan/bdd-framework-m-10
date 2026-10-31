
Feature: SauceDemo Add Products to Cart

  Background:
    Given user is logged in to SauceDemo

  @smoke @cart
  Scenario: Add a product to the cart
    When user adds "Sauce Labs Backpack" to the cart
    Then the cart badge should display "1"

  @cart
  Scenario: Add multiple products to the cart
    When user adds "Sauce Labs Backpack" to the cart
    And user adds "Sauce Labs Bike Light" to the cart
    Then the cart badge should display "2"

  @cart
  Scenario: Remove a product from the inventory page
    When user adds "Sauce Labs Backpack" to the cart
    And user removes "Sauce Labs Backpack" from the cart
    Then the cart badge should not be displayed
