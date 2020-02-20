Feature: Application Home

  The application should provide an application home from users start their journey
  and can access basic information.

  Scenario: A new user starts using the application
    Given a new user
    When the user starts using the application
    Then the user should be greeted
