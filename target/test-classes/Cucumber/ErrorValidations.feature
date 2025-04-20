Feature: Error validation check for login and incorrect product

Background: 
Given user landed on Ecommerece site

  @tag1
  Scenario Outline: Negative validation of login functionality
    Given login with usernae <name> and password <Password>
	  Then "Incorrect email or password." error message is displayed correctly
  
    Examples: 
      | name              | Password    |
      | manasa9@gmail.com |     Pursuit |
     
