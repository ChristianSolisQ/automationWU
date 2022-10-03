Feature: Task 1
  1.	Navigate to https://www.westernunion.com/lt/en/home.html
  2.	Expand Burger menu
  3.	Select Settings page
  4.	Change WU.com Country to United States
  5.	Assert that correct country page was loaded.

  Scenario: Verify the correct country
    Given Navigate to https://www.westernunion.com/lt/en/home.html
    When Expand Burger menu
    Then Select settings page
    And Change WU.com Country to United States
    And Assert that correct country page was loaded.