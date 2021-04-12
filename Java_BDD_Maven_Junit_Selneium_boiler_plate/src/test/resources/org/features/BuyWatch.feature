Feature: Buying a watch at xyz

  @payment @credit-card
  Scenario Outline: Order a watch by selecting credit card as the payment method
    Given I want to open the "XYZ" webpage to buy a pillow
    When I have clicked on the Buy now button from the home page
    Then a shopping cart screen is popped up
    Then I have looked into the default amount of watch
    Then I have looked into Customer details sections
    And I have entered "Name" in the name textbox
    ....
    .....
    Examples:
    |Name|Email|Phonenumber|City|Address|PostalCode|CardNumber|ExpiryDate|Cvv|OTPPIN|Status|


