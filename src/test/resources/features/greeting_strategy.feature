Feature: Greeting Strategy

  The way the application greetings a user should depend on the selected mood

  Background: Setup the range of possible moods
    Given "happy" is the default mood

    Scenario: user greeted using default mood
      Then the greeting should be "Howdy!"