Feature: Buying a Pillow at midtrans

  @payment @credit-card
  Scenario Outline: Order a pillow by selecting credit card as the payment method
    Given I want to open the midtrans webpage to buy a pillow
    When I have clicked on the Buy now button from the home page
    Then a shopping cart screen is popped up
    Then I have looked into the default amount of pillow
    Then I have looked into Customer details sections
    And I have entered "Name" in the name textbox
    And I have entered "Email" in the email textbox
    And I have entered "Phonenumber" in the phonenumber textbox
    And I have entered "City" in the city textbox
    And I have entered "Address" in the address textbox
    And I hve entered "PostalCode" in the postalcode textbox
    When I have clicked on Checkout button
    And I can see a order summary popup
    Then I can verify the order-id
    Then I can verify order details
    Then I can verify shipping details
    When I have clicked on Continue button
    Then I can see Select Payment popup
    When I have selected Credit/Debit card
    Then I can verify the amount value
    Then I can verify the order-id
    And I have entered "CardNumber" in the cardnumber textbox
    And I have entered "ExpiryDate" in the expirydate textbox
    And I have entered "Cvv" in the cvv textbox
    When I have clicked on Pay Now
    Then I was redirected to OTP page
    And I have entered "OTPPIN" in the OTP textbox
    When I have clicked on OK button
    Then I should redirect to payment status page with status as "Status"
    Examples:
    |Name|Email|Phonenumber|City|Address|PostalCode|CardNumber|ExpiryDate|Cvv|OTPPIN|Status|
    |Uday|venkata.uday24@gmail.com|92721549|Singapore|Singapore|507008|4811 1111 1111 1114|04/23|123|112233|SUCCESS|
    |Uday|venkata.uday24@gmail.com|92721549|Singapore|Singapore|507008|4911 1111 1111 1113|04/23|123|112233|REJECT|

