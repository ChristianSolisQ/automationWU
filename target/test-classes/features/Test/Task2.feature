Feature: Task 2
  1.	Navigate to https://www.westernunion.com/lt/en/home.html
  2.	Expand Burger menu
  3.	Select Find Locations
  4.	Write the zip code
  5.	Get address details of the first location printed in console

  Scenario: Get address details
    Given Navigation to https://www.westernunion.com/lt/en/home.html
    When It expands Burger menu
    Then Select Find Locations
    And Write the zip code
    And Get address details of the first location printed in console