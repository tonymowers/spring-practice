Feature: Application Home

  The application should provide an application home from which users begin their journey.
  The application home should provide access to some basic information.

  Scenario: A new user starts using the application
    Given a new user
    When the user starts using the application
    Then the user should be greeted with 'Hello World!'
