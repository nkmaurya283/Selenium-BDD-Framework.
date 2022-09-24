@scenario3
Feature: Order Placement

  Scenario: Buy item from from magento portal
    Given User call the Get API endpoint "https://randomuser.me" to fetch FirstName, LastName, Email, and Password.
    Given User launch the Application url "https://magento.softwaretestingboard.com/"
    And User click on Create an Account link on the page
    And User Enter the FName , LName , Email , Password , and ConfirmPassword values in respective field
    And User click on Create account button at the bottom of the page
    And User Mouse hover on Gear in Header Menu and Click on Watches
    And User clicks on first item on the watches page and Add the Items In the Cart
    And User click on proceed to checkout button on the cart icon
    And User enter the shipping address on shipping page
    And User select value from state at index 1 and country at index 1 from dropdown
    And User enter the Zip code "12345" in the field
    And User clicks on Next button on the page
    And User click on place order button on the page
    Then User verify the order has been placed with "Thank you for your purchase!" message