
@tag
Feature: Purchase the order from Ecart application.
  I want to use this template for my feature file

 Background:
 Given I landed on the application

  @tag2
  Scenario Outline: Positive tet of puchasing the ZARA Coat Product.
    Given Login with the username <name> and password <password>
    When I added the <productName> to Cart
   And Checkout <productName> to Cart
    Then "Thankyou for the order." message is diplayed on ConfirmationPage

    Examples: 
      | name                   | password | productName |
      | nikhil.kharb@ymail.com | Test@123 | ZARA COAT 3 |
     
