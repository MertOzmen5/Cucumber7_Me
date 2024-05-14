Feature: CitizenShip functionality

  @SmokeTest @Regression
  Scenario: Create a citizenShip
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to CitizenShip
    When Create a CitizenShip
    Then Success message should be displayed