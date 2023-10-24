
Feature: Login Functionality
    @Login @Positive
    Scenario: Success Login
        Given User on saucedemo login page
        When Input username
        And Input password
        And click login button
        Then User in on dashboard page

    @Login @Negative
    Scenario: Failed login
        Given User on saucedemo login page
        When Input username
        And Input invalid password
        And click login button
        Then User get error message
        
                
    @TDD
  Scenario Outline: Check Login Feature
    Given User on saucedemo login page
    When User input <username> as username
    And User input <password> as password
    And click login button
    Then User verify <status> login result
    Examples:
      | username | password | status |
      | standard_user | secret_sauce | success |
      | locke_out_user | secret_sauce | failed |
      | random_user | secret_sauce | failed |
      


       
      
      
  
      
