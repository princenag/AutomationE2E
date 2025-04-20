#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@tag
Feature: Purchase the order from ecomm site

Background: 
Given i landed on Ecommerece site


@Regression
  Scenario Outline: Positive test of submitting the order
    Given login with username <name> and password <Password>
    When i add product <productname> to cart
    And checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

  #@tag2
   #Scenario: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    Examples: 
      | name  								| Password      |productname |
      | nagendrrks@gmail.com  |     Pursuit94 | ZARA COAT 3|
     