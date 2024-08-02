Feature: Open Site

  Scenario: Open website
    Given user has access to site url
    When search site url
    Then displays expected page