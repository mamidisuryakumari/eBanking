Feature: Confirmation page functionality
@Pricevalidate
  Scenario Outline: User completes a purchase and validates price change after purchase
    Given The user on the product page
    When The page loads
    And select the category from menu
    Then The user should see list of products
    And Each product should display the name,price and image
    And The user notes the price of the product before purchase
    When User click on product link
    Then User navigated to the product details page
    When User click on add to cart button
    And User should see item added to the cart
    When User click on checkout button
    Then User should navigated to the checkout page
    When User enter address details "<YourName>"," <PhoneNumber>", "<StreetName>","<EmailAddress>","<Postcode>","<City>", "<State>","<Country>", "<OrderNotes>"
    And User click on Upi tranfer button
    And User click on confirm order button
    Then User should see place ored button enabled
    When User click on place order button
#    Then User navigated to order details page
    And The user should see the total price after purchase includes the product price and delivery charge
  Examples: 
      | YourName | PhoneNumber | StreetName | EmailAddress            | Postcode | City      | State | Country | OrderNotes |
      | Surya    |  9963563515 | ST colony  | Kumari.mudila@gmail.com |   521321 | Nandivada | AP    | India   | test       |
