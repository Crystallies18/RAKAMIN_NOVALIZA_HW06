Feature: Inventory Functionality

  Scenario Outline: Ensure Inventory Page Images Loaded Correctly
     Given User on saucedemo login page
    When User input <username> as username
    And User input <password> as password
    And click login button
    Then User verify <status> login result
    And user can view <is_image> images
    Examples:
      | username | password | status | is_image |
      | standard_user | secret_sauce | success | correct |
      | problem_user | secret_sauce | success | wrong  |