Feature: Greeting Strategy

  The way the application greetings a user should depend on the selected mood

  Background: Setup the range of possible moods
    Given the following possible moods:
      | id  | name   |
      | 0   | happy  |
      | 1   | sad    |
    And "happy" is the default mood

    Scenario: user greeted using default mood
      Then the greeting should be "Howdy!"