Feature: Greeting Strategy

  The way the application greetings a user should depend on the selected mood

  Background: Setup the range of possible moods
    And "happy" is the default mood

    Scenario: user greeted using default mood
      Then the greeting should be "Howdy!"

    Scenario: user greeted using happy mood
      When the "happy" mood is chosen
      Then the greeting should be "Howdy!"

    Scenario: user greeted using sad mood
      When the "sad" mood is chosen
      Then the greeting should be "Please go away :-("