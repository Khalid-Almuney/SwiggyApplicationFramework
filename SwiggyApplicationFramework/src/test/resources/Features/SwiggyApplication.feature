@smoketest
Feature: feature to test swiggyApp search places functionality

  Scenario: validate search for restaurants in spicify place is working fine
    Given browser is open
    And user on swiggApplication
    When user enter name of place 
    And hits enter
    Then user is navigated to search results
 