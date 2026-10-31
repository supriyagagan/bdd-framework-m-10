Feature: SauceDemo Login

  @smoke @login @positive
  Scenario: Login with valid credentials
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks on the login button
    Then user should be redirected to the inventory page

  @negative @login
  Scenario: Login with invalid credentials
    When user enters username "invalid_user"
    And user enters password "invalid_password"
    And user clicks on the login button
    Then an error message should be displayed

  @negative @login
  Scenario: Login with empty credentials
    When user clicks on the login button
    Then an error message should be displayed

  @login @positive @dataprovider
  Scenario Outline: Login with different credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on the login button
    Then user should get "<expectedResult>"

    Examples: 
      | username                | password     | expectedResult |
      | standard_user           | secret_sauce | success        |
      | locked_out_user         | secret_sauce | failure        |
      | problem_user            | secret_sauce | success        |
      | performance_glitch_user | secret_sauce | success        |
      | error_user              | secret_sauce | success        |
      | visual_user             | secret_sauce | success        |
