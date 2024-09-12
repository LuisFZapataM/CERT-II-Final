Feature: Login Sauce Demo Web App

  Background: Enter Sauce Demo Web App with valid credentials
    Given I am in Sauce Demo Web Page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    When I click on the login button


  Scenario: Verify that the products can be sorted in ascending order
    When The home page should be displayed
    And I select the "Price (low to high)" option in the combobox
    Then The products should be sorted in ascending order by price


  Scenario: Verify that the shopping cart counter increments when a product is added
    When The home page should be displayed
    And I click the Add product button in the products
      | Sauce Labs Backpack | Sauce Labs Bike Light |
    Then The shopping cart counter should be 2
    Then I click on the remove button of the product "Sauce Labs Backpack"
    Then The shopping cart counter should be 1


  Scenario: Verify that a shopping cart can't be purchased if it's empty
    When The home page should be displayed
    And I click on the shopping cart icon
    Then The checkout button should be disabled



  Scenario: Verify that the zipcode TextBox only should't be empty
    When The home page should be displayed
    And I click the Add product button in the products
      | Sauce Labs Backpack | Sauce Labs Bike Light |
    And I click on the shopping cart icon
    And I click on the checkout button
    Then I fill the data form with the values
      | Luis | Zapata  | null |
    And I click on the continue button
    Then The error message "Error: Postal Code is required" should be displayed


  @Run
  Scenario: Verify that the sum of products is correct when checkout
    When The home page should be displayed
    And I click the Add product button in the products
      | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Bolt T-Shirt | Sauce Labs Fleece Jacket |
    And I click on the shopping cart icon
    And I click on the checkout button
    Then I fill the data form with the values
      | Luis | Zapata | 45612 |
    And I click on the continue button
    Then The sum of the products should be correct


