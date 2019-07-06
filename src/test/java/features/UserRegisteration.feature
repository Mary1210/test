Feature: User Registeration 
  I want to check that user can register in our e-commerce website.

   Scenario Outline: User Registration
   Given the user in the home page
   When I click on register link
   And I entered "<firstname>", "<lastname>", "<email>", "<password>"
   Then The registeran page displayed successfully
   
   Examples:
   | firstname | lastname | email | password |
   | mary | alfons | mardfyoilhfdjp@mail.com | 123456789 |
   | mary | alfons | marfsyojdjihfp3@mail.com | 123456789 |