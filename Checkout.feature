#Author: vishal.prajapati@capgemini.com
Feature: checkout module of SwagLabs

  Background: user is on checkout page

  Scenario Outline: Checkout functionality
    Given the user is on checkout page
    When user enter first name as "<FirstName>"
    And user enter last name as "<LastName>"
    And user enter zip/postal cade as "<zip>"
    And click on continue
    And user navigate to checkout overview page
    And user click on finish
    Then user navigate to checkout complete page
    And user click on back home to come in home page
    And user click on close the window

    Examples: 
      | FirstName | LastName  | zip    |
      | Vishal    | Prajapati | 700006 |
      