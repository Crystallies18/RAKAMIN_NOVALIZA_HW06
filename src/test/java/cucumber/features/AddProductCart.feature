Feature: Add Product Functionality

           @cart
  Scenario: User add product to cart

    Given user is on logged in using standard_user
     Then User in  dashboard page
        And user click the Add To Cart button
        And user click another product
        And user click product two
        And user click product three
        And user click product four
        And user click product five
        And user click checkout logo
        Then user in on checkout page
 
        
            @Checkout
   Scenario: Checkout with items in cart
        Given user is on logged in using standard_user
        Then User in  dashboard page
        And user click checkout logo
        Then user in on checkout page
        And user click checkout button
        Then user in on checkout info page
        And input first name
        And input last name
        And input zip code
        And user click continue button
        Then user in on overview page
        And user click finish button
        Then user in on complete page 
        
