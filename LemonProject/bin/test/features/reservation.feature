@Test
Feature: Test space reservation 

Background: I go to Space Page and Login with my user 
    Given As a Test Engineer I am on Space Advisor page 
    And I login with my user 

Scenario Outline: Make a space reservation 
    Given I select the date of departure and return
    When I select number of <adults> and <childrens>
    And I choose my favorite <planet>
    And I complete checkout information with Name: <name> and Email: <email> and Security Number: <securityNumber> and Phone Number: <phoneNumber>
    And I accept terms and conditions and pay my reservation
    Then the total price was calculated correctly

 Examples: 
|adults|    |childrens|    |planet   |      |name     |    |email              |    |securityNumber |     |phoneNumber |
|2     |    |2        |    |Tongli   |      |Lemon    |    |lemon@lemon.com    |    |123-12-1234    |     |932329429   |
|3     |    |0        |    |Cuozhou  |      |Lemon    |    |lemon@bitcoin.com  |    |111-22-3333    |     |931213141   |
|1     |    |1        |    |Tayabamba|      |Lemon    |    |lemon@etherium.com |    |222-33-4444    |     |931291216   |



