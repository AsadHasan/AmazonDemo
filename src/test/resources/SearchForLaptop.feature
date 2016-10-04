Feature: Search for laptop

  Background:
    Given I navigate to "https://www.amazon.com/"
    And I select "Computers" from the dropdown menu next to the search bar

    Scenario Outline:
      When I type "<text>" in the search bar
      And I select "<suggestions>" from auto-complete
      And submit search

Examples:
      |text|suggestions|
      |laptop|laptop in Computers|
      |camera|test|

