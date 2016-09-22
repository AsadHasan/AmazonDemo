Feature: Search for laptop

  Background:
    Given I navigate to "https://www.amazon.com/"
    And I select "Computers" from the dropdown menu next to the search bar

    Scenario Outline:
      When I type "<text>" in the search bar
      Then I should see "<suggestions>" appear in auto-complete

      Examples:
      |text|suggestions|
      |laptop|laptop in Computers|
