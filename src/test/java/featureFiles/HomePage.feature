Feature: Login Feature Scenario


  Background: 
    Given I have launched the application
    And I enter the correct username and password
    And Click on Login Button
    Then I should land on the home page
    
	@regression
  Scenario: Add product to card
    When I click on Add to card for product "Sauce Labs Backpack"
    Then cart bucket count should be one
