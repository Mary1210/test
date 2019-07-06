Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

   Scenario Outline: Customer place an order by Purchasing an item from search
   Given user is on home page
   When he search for "<productName>"
   And choose two buy new items
   And move to checkout and enter personal details on checkout page and place the order
   Then he can view the order and download the invoice
   
   Examples:
   | productName |
   | Asus N551JK-XO076H Laptop |