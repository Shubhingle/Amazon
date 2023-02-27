Feature: Search a product feature

  Scenario:Verify that the user can able to  search a product
    Given When the user navigates to the home page
    When the user enters the product name
    Then the product results should be displayed

    Scenario: Verify that user gets any any product suggestions if invalid data is entered
      Given the user navigates to the home page
      When the user enters invalid name
      Then the user should get random result

    Scenario: Verify that user is able to access Today's Deal Tab
      Given user navigates to the home page
      When the user should access today's deal page
      Then the Today's deal tab will be displayed

      Scenario: Verify if user is able to access Best sellers tab
        Given When user navigates to amazon homepage
        When the user should be able to access Best sellers tab
        Then the Best Sellers tab will be displayed

#      Scenario Outline: Verify that the user is able to search multiple products
#       Given When the user navigates to the home page of amazon
#       When  the user should click on the search bar and enters "<Product>"
#       Then the product gets displayed
#       Examples:
#        | Product |
#        | Jeans   |
#        | Bags    |

      Scenario: Verify that user is able to select amazon fashion category and search product
        Given the user navigated to amazon homepage
        When user clicks on dropdown and selects a category
        And  the user enters name of product
        Then the product gets displayed for category







